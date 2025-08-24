/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SIAuditEntry}.
 * </p>
 *
 * @author Solteq
 * @see SIAuditEntry
 * @generated
 */
public class SIAuditEntryWrapper extends BaseModelWrapper<SIAuditEntry>
        implements ModelWrapper<SIAuditEntry>, SIAuditEntry {

    public SIAuditEntryWrapper(SIAuditEntry siAuditEntry) {
        super(siAuditEntry);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("siAuditEntryId", getSiAuditEntryId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("siKey", getSiKey());
        attributes.put("processingTime", getProcessingTime());
        attributes.put("status", getStatus());
        attributes.put("message", getMessage());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long siAuditEntryId = (Long) attributes.get("siAuditEntryId");

        if (siAuditEntryId != null) {
            setSiAuditEntryId(siAuditEntryId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        String siKey = (String) attributes.get("siKey");

        if (siKey != null) {
            setSiKey(siKey);
        }

        Long processingTime = (Long) attributes.get("processingTime");

        if (processingTime != null) {
            setProcessingTime(processingTime);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String message = (String) attributes.get("message");

        if (message != null) {
            setMessage(message);
        }
    }

    @Override
    public SIAuditEntry cloneWithOriginalValues() {
        return wrap(model.cloneWithOriginalValues());
    }

    /**
     * Returns the company ID of this si audit entry.
     *
     * @return the company ID of this si audit entry
     */
    @Override
    public long getCompanyId() {
        return model.getCompanyId();
    }

    /**
     * Returns the create date of this si audit entry.
     *
     * @return the create date of this si audit entry
     */
    @Override
    public Date getCreateDate() {
        return model.getCreateDate();
    }

    @Override
    public String getDisplayType() {
        return model.getDisplayType();
    }

    /**
     * Returns the group ID of this si audit entry.
     *
     * @return the group ID of this si audit entry
     */
    @Override
    public long getGroupId() {
        return model.getGroupId();
    }

    /**
     * Returns the message of this si audit entry.
     *
     * @return the message of this si audit entry
     */
    @Override
    public String getMessage() {
        return model.getMessage();
    }

    /**
     * Returns the primary key of this si audit entry.
     *
     * @return the primary key of this si audit entry
     */
    @Override
    public long getPrimaryKey() {
        return model.getPrimaryKey();
    }

    @Override
    public String getProcesingTimeLabel() {
        return model.getProcesingTimeLabel();
    }

    /**
     * Returns the processing time of this si audit entry.
     *
     * @return the processing time of this si audit entry
     */
    @Override
    public long getProcessingTime() {
        return model.getProcessingTime();
    }

    /**
     * Returns the si audit entry ID of this si audit entry.
     *
     * @return the si audit entry ID of this si audit entry
     */
    @Override
    public long getSiAuditEntryId() {
        return model.getSiAuditEntryId();
    }

    /**
     * Returns the si key of this si audit entry.
     *
     * @return the si key of this si audit entry
     */
    @Override
    public String getSiKey() {
        return model.getSiKey();
    }

    @Override
    public String getSiteName() {
        return model.getSiteName();
    }

    /**
     * Returns the status of this si audit entry.
     *
     * @return the status of this si audit entry
     */
    @Override
    public int getStatus() {
        return model.getStatus();
    }

    @Override
    public String getStatusLabel() {
        return model.getStatusLabel();
    }

    @Override
    public String getSyncDateFormatted() {
        return model.getSyncDateFormatted();
    }

    @Override
    public String getUser() {
        return model.getUser();
    }

    /**
     * Returns the user ID of this si audit entry.
     *
     * @return the user ID of this si audit entry
     */
    @Override
    public long getUserId() {
        return model.getUserId();
    }

    /**
     * Returns the user uuid of this si audit entry.
     *
     * @return the user uuid of this si audit entry
     */
    @Override
    public String getUserUuid() {
        return model.getUserUuid();
    }

    @Override
    public void persist() {
        model.persist();
    }

    /**
     * Sets the company ID of this si audit entry.
     *
     * @param companyId the company ID of this si audit entry
     */
    @Override
    public void setCompanyId(long companyId) {
        model.setCompanyId(companyId);
    }

    /**
     * Sets the create date of this si audit entry.
     *
     * @param createDate the create date of this si audit entry
     */
    @Override
    public void setCreateDate(Date createDate) {
        model.setCreateDate(createDate);
    }

    /**
     * Sets the group ID of this si audit entry.
     *
     * @param groupId the group ID of this si audit entry
     */
    @Override
    public void setGroupId(long groupId) {
        model.setGroupId(groupId);
    }

    /**
     * Sets the message of this si audit entry.
     *
     * @param message the message of this si audit entry
     */
    @Override
    public void setMessage(String message) {
        model.setMessage(message);
    }

    /**
     * Sets the primary key of this si audit entry.
     *
     * @param primaryKey the primary key of this si audit entry
     */
    @Override
    public void setPrimaryKey(long primaryKey) {
        model.setPrimaryKey(primaryKey);
    }

    /**
     * Sets the processing time of this si audit entry.
     *
     * @param processingTime the processing time of this si audit entry
     */
    @Override
    public void setProcessingTime(long processingTime) {
        model.setProcessingTime(processingTime);
    }

    /**
     * Sets the si audit entry ID of this si audit entry.
     *
     * @param siAuditEntryId the si audit entry ID of this si audit entry
     */
    @Override
    public void setSiAuditEntryId(long siAuditEntryId) {
        model.setSiAuditEntryId(siAuditEntryId);
    }

    /**
     * Sets the si key of this si audit entry.
     *
     * @param siKey the si key of this si audit entry
     */
    @Override
    public void setSiKey(String siKey) {
        model.setSiKey(siKey);
    }

    /**
     * Sets the status of this si audit entry.
     *
     * @param status the status of this si audit entry
     */
    @Override
    public void setStatus(int status) {
        model.setStatus(status);
    }

    /**
     * Sets the user ID of this si audit entry.
     *
     * @param userId the user ID of this si audit entry
     */
    @Override
    public void setUserId(long userId) {
        model.setUserId(userId);
    }

    /**
     * Sets the user uuid of this si audit entry.
     *
     * @param userUuid the user uuid of this si audit entry
     */
    @Override
    public void setUserUuid(String userUuid) {
        model.setUserUuid(userUuid);
    }

    @Override
    public String toXmlString() {
        return model.toXmlString();
    }

    @Override
    protected SIAuditEntryWrapper wrap(SIAuditEntry siAuditEntry) {
        return new SIAuditEntryWrapper(siAuditEntry);
    }
}
