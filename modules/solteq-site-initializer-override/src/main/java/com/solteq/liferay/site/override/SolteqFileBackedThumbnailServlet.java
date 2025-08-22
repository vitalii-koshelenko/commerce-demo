package com.solteq.liferay.site.override;

import java.io.*;
import java.util.Arrays;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.runtime.ServiceComponentRuntime;
import org.osgi.service.component.runtime.dto.ComponentDescriptionDTO;

@Component(
        property = {
            "osgi.http.whiteboard.servlet.name=com.solteq.liferay.site.override.SolteqFileBackedThumbnailServlet",
            "osgi.http.whiteboard.servlet.pattern=/file-backed-site-initializer/*",
            "servlet.init.httpMethods=GET"
        },
        service = Servlet.class)
public class SolteqFileBackedThumbnailServlet extends HttpServlet {

    // ------------------------------- <Components Blacklist> ----------------------------------------------------------
    private ComponentDescriptionDTO componentDescriptionDTO;

    public static final String BUNDLE_NAME = "com.liferay.site.initializer.extender";
    public static final String COMPONENT_NAME =
            "com.liferay.site.initializer.extender.internal.file.backed.servlet.FileBackedThumbnailServlet";

    @Activate
    public void activate(BundleContext bundleContext) {
        // Disable the original FileBackedThumbnailServlet when registering a custom one
        try {
            Bundle[] bundles = bundleContext.getBundles();
            Bundle targetBundle = Arrays.stream(bundles)
                    .filter(bnd -> BUNDLE_NAME.equals(bnd.getSymbolicName()))
                    .findFirst()
                    .orElse(null);
            componentDescriptionDTO = serviceComponentRuntime.getComponentDescriptionDTO(targetBundle, COMPONENT_NAME);
            serviceComponentRuntime.disableComponent(componentDescriptionDTO);
            _log.info(String.format("Component '%s' disabled", COMPONENT_NAME));
        } catch (Exception e) {
            _log.error(String.format("Unable to disable component %s, cause:  %s", COMPONENT_NAME, e.getMessage()));
        }
    }

    @Deactivate
    public void deactivate(BundleContext bundleContext) {
        // Enable the original FileBackedThumbnailServlet when unregistering a custom one
        try {
            serviceComponentRuntime.enableComponent(componentDescriptionDTO);
            _log.info(String.format("Component '%s' enabled", COMPONENT_NAME));
        } catch (Exception e) {
            _log.error(String.format("Unable to enable component %s, cause:  %s", COMPONENT_NAME, e.getMessage()));
        }
    }

    @Reference
    private ServiceComponentRuntime serviceComponentRuntime;
    // ------------------------------- </Components Blacklist> ---------------------------------------------------------

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {

        _log.info("SolteqFileBackedThumbnailServlet: doGet");

        String pathInfo = httpServletRequest.getPathInfo();

        if ((pathInfo == null) || (pathInfo.length() <= 1)) {
            return;
        }

        pathInfo = pathInfo.substring(1);

        int index = pathInfo.indexOf("/");

        if (index == -1) {
            return;
        }

        String fileKey = pathInfo.substring(0, index);

        File file = _siteInitializerExtender.getFile(fileKey);

        if (file == null) {
            return;
        }

        file = new File(file, "thumbnail.png");

        httpServletResponse.setContentLength((int) file.length());

        httpServletResponse.setContentType("image/png");

        try (InputStream inputStream = new FileInputStream(file);
                OutputStream outputStream = httpServletResponse.getOutputStream()) {

            byte[] buffer = new byte[8192];

            int length = 0;

            while ((length = inputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, length);
            }
        }
    }

    @Reference
    private SolteqSiteInitializerExtender _siteInitializerExtender;

    private static final Log _log = LogFactoryUtil.getLog(SolteqFileBackedThumbnailServlet.class);
}
