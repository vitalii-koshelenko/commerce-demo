/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.model.impl;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.solteq.liferay.site.initializer.audit.model.SIAuditEntry;

/**
 * The cache model class for representing SIAuditEntry in entity cache.
 *
 * @author Solteq
 * @generated
 */
public class SIAuditEntryCacheModel implements CacheModel<SIAuditEntry>, Externalizable {

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof SIAuditEntryCacheModel)) {
            return false;
        }

        SIAuditEntryCacheModel siAuditEntryCacheModel = (SIAuditEntryCacheModel) object;

        if (siAuditEntryId == siAuditEntryCacheModel.siAuditEntryId) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return HashUtil.hash(0, siAuditEntryId);
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{siAuditEntryId=");
        sb.append(siAuditEntryId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", siKey=");
        sb.append(siKey);
        sb.append(", processingTime=");
        sb.append(processingTime);
        sb.append(", status=");
        sb.append(status);
        sb.append(", message=");
        sb.append(message);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public SIAuditEntry toEntityModel() {
        SIAuditEntryImpl siAuditEntryImpl = new SIAuditEntryImpl();

        siAuditEntryImpl.setSiAuditEntryId(siAuditEntryId);
        siAuditEntryImpl.setGroupId(groupId);
        siAuditEntryImpl.setCompanyId(companyId);
        siAuditEntryImpl.setUserId(userId);

        if (userName == null) {
            siAuditEntryImpl.setUserName("");
        } else {
            siAuditEntryImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            siAuditEntryImpl.setCreateDate(null);
        } else {
            siAuditEntryImpl.setCreateDate(new Date(createDate));
        }

        if (siKey == null) {
            siAuditEntryImpl.setSiKey("");
        } else {
            siAuditEntryImpl.setSiKey(siKey);
        }

        siAuditEntryImpl.setProcessingTime(processingTime);
        siAuditEntryImpl.setStatus(status);

        if (message == null) {
            siAuditEntryImpl.setMessage("");
        } else {
            siAuditEntryImpl.setMessage(message);
        }

        siAuditEntryImpl.resetOriginalValues();

        return siAuditEntryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        siAuditEntryId = objectInput.readLong();

        groupId = objectInput.readLong();

        companyId = objectInput.readLong();

        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        siKey = objectInput.readUTF();

        processingTime = objectInput.readLong();

        status = objectInput.readInt();
        message = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(siAuditEntryId);

        objectOutput.writeLong(groupId);

        objectOutput.writeLong(companyId);

        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF("");
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);

        if (siKey == null) {
            objectOutput.writeUTF("");
        } else {
            objectOutput.writeUTF(siKey);
        }

        objectOutput.writeLong(processingTime);

        objectOutput.writeInt(status);

        if (message == null) {
            objectOutput.writeUTF("");
        } else {
            objectOutput.writeUTF(message);
        }
    }

    public long siAuditEntryId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public String siKey;
    public long processingTime;
    public int status;
    public String message;
}
