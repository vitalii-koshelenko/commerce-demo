/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.model.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;

import com.solteq.liferay.site.initializer.audit.constants.SIAuditStatus;

/**
 * @author Solteq
 */
public class SIAuditEntryImpl extends SIAuditEntryBaseImpl {

    private static final String DATE_FORMAT = "dd-MMM-yyyy HH:mm";

    @Override
    public String getSyncDateFormatted() {
        Date syncDate = getCreateDate();
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(syncDate);
    }

    @Override
    public String getSiteName() {
        Group group = GroupLocalServiceUtil.fetchGroup(getGroupId());
        return group != null ? group.getName() : StringPool.BLANK;
    }

    @Override
    public String getUser() {
        User user = UserLocalServiceUtil.fetchUser(getUserId());
        return user != null ? user.getFullName() : StringPool.BLANK;
    }

    @Override
    public String getProcesingTimeLabel() {
        long processingTime = getProcessingTime();
        long totalSeconds = processingTime / 1000;
        if (totalSeconds < 60) {
            return totalSeconds + " sec";
        }
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        return minutes + " min" + (seconds > 0 ? " " + seconds + " sec" : "");
    }

    @Override
    public String getStatusLabel() {
        String labelKey = getStatus() == SIAuditStatus.SUCCESS ? "status-success" : "status-failed";
        return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), labelKey);
    }

    @Override
    public String getDisplayType() {
        return getStatus() == SIAuditStatus.SUCCESS ? "info" : "warning";
    }
}
