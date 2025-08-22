/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.service.persistence.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import com.solteq.liferay.site.initializer.audit.model.SIAuditEntryTable;
import com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryImpl;
import com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryModelImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from SIAuditEntry.
 *
 * @author Solteq
 * @generated
 */
@Component(
        property = {
            "class.name=com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryImpl",
            "table.name=sq_SIAuditEntry"
        },
        service = ArgumentsResolver.class)
public class SIAuditEntryModelArgumentsResolver implements ArgumentsResolver {

    @Override
    public Object[] getArguments(FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn, boolean original) {

        String[] columnNames = finderPath.getColumnNames();

        if ((columnNames == null) || (columnNames.length == 0)) {
            if (baseModel.isNew()) {
                return new Object[0];
            }

            return null;
        }

        SIAuditEntryModelImpl siAuditEntryModelImpl = (SIAuditEntryModelImpl) baseModel;

        long columnBitmask = siAuditEntryModelImpl.getColumnBitmask();

        if (!checkColumn || (columnBitmask == 0)) {
            return _getValue(siAuditEntryModelImpl, columnNames, original);
        }

        Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(finderPath);

        if (finderPathColumnBitmask == null) {
            finderPathColumnBitmask = 0L;

            for (String columnName : columnNames) {
                finderPathColumnBitmask |= siAuditEntryModelImpl.getColumnBitmask(columnName);
            }

            if (finderPath.isBaseModelResult()
                    && (SIAuditEntryPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION
                            == finderPath.getCacheName())) {

                finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
            }

            _finderPathColumnBitmasksCache.put(finderPath, finderPathColumnBitmask);
        }

        if ((columnBitmask & finderPathColumnBitmask) != 0) {
            return _getValue(siAuditEntryModelImpl, columnNames, original);
        }

        return null;
    }

    @Override
    public String getClassName() {
        return SIAuditEntryImpl.class.getName();
    }

    @Override
    public String getTableName() {
        return SIAuditEntryTable.INSTANCE.getTableName();
    }

    private static Object[] _getValue(
            SIAuditEntryModelImpl siAuditEntryModelImpl, String[] columnNames, boolean original) {

        Object[] arguments = new Object[columnNames.length];

        for (int i = 0; i < arguments.length; i++) {
            String columnName = columnNames[i];

            if (original) {
                arguments[i] = siAuditEntryModelImpl.getColumnOriginalValue(columnName);
            } else {
                arguments[i] = siAuditEntryModelImpl.getColumnValue(columnName);
            }
        }

        return arguments;
    }

    private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

    private static final long _ORDER_BY_COLUMNS_BITMASK;

    static {
        long orderByColumnsBitmask = 0;

        orderByColumnsBitmask |= SIAuditEntryModelImpl.getColumnBitmask("createDate");

        _ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
    }
}
