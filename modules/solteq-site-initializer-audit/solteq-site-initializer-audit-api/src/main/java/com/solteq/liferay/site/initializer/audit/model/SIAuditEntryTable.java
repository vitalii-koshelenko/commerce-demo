/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.model;

import java.sql.Types;
import java.util.Date;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

/**
 * The table class for the &quot;sq_SIAuditEntry&quot; database table.
 *
 * @author Solteq
 * @see SIAuditEntry
 * @generated
 */
public class SIAuditEntryTable extends BaseTable<SIAuditEntryTable> {

    public static final SIAuditEntryTable INSTANCE = new SIAuditEntryTable();

    public final Column<SIAuditEntryTable, Long> siAuditEntryId =
            createColumn("siAuditEntryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
    public final Column<SIAuditEntryTable, Long> groupId =
            createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
    public final Column<SIAuditEntryTable, Long> companyId =
            createColumn("companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
    public final Column<SIAuditEntryTable, Long> userId =
            createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
    public final Column<SIAuditEntryTable, String> userName =
            createColumn("userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
    public final Column<SIAuditEntryTable, Date> createDate =
            createColumn("createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
    public final Column<SIAuditEntryTable, String> siKey =
            createColumn("siKey", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
    public final Column<SIAuditEntryTable, Long> processingTime =
            createColumn("processingTime", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
    public final Column<SIAuditEntryTable, Integer> status =
            createColumn("status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
    public final Column<SIAuditEntryTable, String> message =
            createColumn("message", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

    private SIAuditEntryTable() {
        super("sq_SIAuditEntry", SIAuditEntryTable::new);
    }
}
