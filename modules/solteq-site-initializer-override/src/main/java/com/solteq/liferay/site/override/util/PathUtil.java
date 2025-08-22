package com.solteq.liferay.site.override.util;

public class PathUtil {

    public static String removePrefix(String path) {
        if (path.startsWith("/site-initializer/")) {
            path = path.substring("/site-initializer/".length());
        }
        return path;
    }
}
