package com.solteq.liferay.site.initializer.override.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StackTraceUtil;

public class ExceptionUtil {

    public static String parseException(Exception e) {
        // Get Exception StackTrace
        String stackTrace = StackTraceUtil.getStackTrace(e);
        // Return the first two lines of stacktrace
        String[] lines = stackTrace.split(StringPool.NEW_LINE);
        if (lines.length > 1) {
            return lines[0] + lines[1];
        } else if (lines.length == 1) {
            return lines[0];
        } else {
            return stackTrace;
        }
    }
}
