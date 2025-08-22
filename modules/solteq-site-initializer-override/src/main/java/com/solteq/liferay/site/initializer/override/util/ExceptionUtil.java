package com.solteq.liferay.site.initializer.override.util;

import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;

public class ExceptionUtil {

    private static final String STR_CAUSED_BY = "Caused by: ";
    private static final String STR_AT = "at ";

    private static final String ERROR_MESSAGE = "Error: %s, cause: %s";

    public static String parseException(Exception e) {
        // Get Exception StackTrace
        String stackTrace = StackTraceUtil.getStackTrace(e);
        // Get the last "Caused by" Statement
        String errorMessage = e.getMessage();
        String causedBy = StringUtil.lastSubstringBetween(stackTrace, STR_CAUSED_BY, STR_AT);
        return Validator.isBlank(causedBy) ? errorMessage : String.format(ERROR_MESSAGE, errorMessage, causedBy);
    }
}
