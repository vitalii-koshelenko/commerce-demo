package com.solteq.liferay.site.initializer.override.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class StringUtil {

    public static final int INDEX_NOT_FOUND = -1;

    public static String substringBetween(final String str, final String open, final String close) {
        if (Validator.isBlank(str) || Validator.isBlank(open) || Validator.isBlank(close)) {
            return StringPool.BLANK;
        }
        final int start = str.indexOf(open);
        return getSubstring(str, start, open, close);
    }

    public static String lastSubstringBetween(final String str, final String open, final String close) {
        if (Validator.isBlank(str) || Validator.isBlank(open) || Validator.isBlank(close)) {
            return StringPool.BLANK;
        }
        final int start = str.lastIndexOf(open);
        return getSubstring(str, start, open, close);
    }

    private static String getSubstring(String str, int start, String open, String close) {
        if (start != INDEX_NOT_FOUND) {
            final int end = str.indexOf(close, start + open.length());
            if (end != INDEX_NOT_FOUND) {
                return str.substring(start + open.length(), end);
            }
        }
        return StringPool.BLANK;
    }
}
