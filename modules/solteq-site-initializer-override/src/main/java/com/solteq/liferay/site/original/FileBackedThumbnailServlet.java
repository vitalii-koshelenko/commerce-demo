/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.original;

import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */

// Placed here as a code reference
// Commented @Component annotation to disable component activation

/*@Component(
property = {
    "osgi.http.whiteboard.servlet.name=com.liferay.site.initializer.extender.internal.file.backed.servlet.FileBackedThumbnailServlet",
    "osgi.http.whiteboard.servlet.pattern=/file-backed-site-initializer/*",
    "servlet.init.httpMethods=GET"
},
service = Servlet.class)*/
public class FileBackedThumbnailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {

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
    private SiteInitializerExtender _siteInitializerExtender;
}
