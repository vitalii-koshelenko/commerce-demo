package com.solteq.liferay.site.override;

import java.io.*;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = {
            "osgi.http.whiteboard.servlet.name=com.liferay.site.initializer.extender.internal.file.backed.servlet.FileBackedThumbnailServlet",
            "osgi.http.whiteboard.servlet.pattern=/file-backed-site-initializer/*",
            "servlet.init.httpMethods=GET"
        },
        service = Servlet.class)
public class SolteqFileBackedThumbnailServlet extends HttpServlet {

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
