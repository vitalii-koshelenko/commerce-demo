/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.service.impl;

import java.util.List;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.solteq.liferay.site.initializer.audit.constants.SIAuditStatus;
import com.solteq.liferay.site.initializer.audit.model.SIAuditEntry;
import com.solteq.liferay.site.initializer.audit.service.base.SIAuditEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Solteq
 */
@Component(
        property = "model.class.name=com.solteq.liferay.site.initializer.audit.model.SIAuditEntry",
        service = AopService.class)
public class SIAuditEntryLocalServiceImpl extends SIAuditEntryLocalServiceBaseImpl {

    @Override
    public List<SIAuditEntry> getSiteAuditEntries(long groupId) {
        return siAuditEntryPersistence.findByGroupId(groupId);
    }

    @Override
    public List<SIAuditEntry> getAuditEntries(int start, int end) {
        return siAuditEntryLocalService.getSIAuditEntries(start, end);
    }

    @Override
    public int getAuditEntriesCount() {
        return siAuditEntryLocalService.getSIAuditEntriesCount();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SIAuditEntry saveSuccessAuditEntry(long groupId, String siKey, long processingTime, String message) {
        return saveAuditEntry(groupId, siKey, processingTime, message, SIAuditStatus.SUCCESS);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SIAuditEntry saveFailedAuditEntry(long groupId, String siKey, long processingTime, String message) {
        return saveAuditEntry(groupId, siKey, processingTime, message, SIAuditStatus.FAILED);
    }

    private SIAuditEntry saveAuditEntry(long groupId, String siKey, long processingTime, String message, int status) {
        long siAuditEntryId = counterLocalService.increment(SIAuditEntry.class.getName());
        SIAuditEntry siAuditEntry = siAuditEntryPersistence.create(siAuditEntryId);
        siAuditEntry.setStatus(status);
        siAuditEntry.setGroupId(groupId);
        siAuditEntry.setSiKey(siKey);
        siAuditEntry.setProcessingTime(processingTime);
        siAuditEntry.setMessage(message);
        siAuditEntry.setUserId(PrincipalThreadLocal.getUserId());
        return updateSIAuditEntry(siAuditEntry);
    }
}
