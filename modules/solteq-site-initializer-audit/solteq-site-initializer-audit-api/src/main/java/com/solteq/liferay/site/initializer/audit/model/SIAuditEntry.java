/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SIAuditEntry service. Represents a row in the &quot;sq_SIAuditEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Solteq
 * @see SIAuditEntryModel
 * @generated
 */
@ImplementationClassName("com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryImpl")
@ProviderType
public interface SIAuditEntry extends PersistedModel, SIAuditEntryModel {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to <code>com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public static final Accessor<SIAuditEntry, Long> SI_AUDIT_ENTRY_ID_ACCESSOR = new Accessor<SIAuditEntry, Long>() {

        @Override
        public Long get(SIAuditEntry siAuditEntry) {
            return siAuditEntry.getSiAuditEntryId();
        }

        @Override
        public Class<Long> getAttributeClass() {
            return Long.class;
        }

        @Override
        public Class<SIAuditEntry> getTypeClass() {
            return SIAuditEntry.class;
        }
    };
}
