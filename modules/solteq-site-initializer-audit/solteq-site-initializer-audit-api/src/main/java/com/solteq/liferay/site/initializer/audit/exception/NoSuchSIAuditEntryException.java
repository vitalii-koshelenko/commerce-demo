/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Solteq
 */
public class NoSuchSIAuditEntryException extends NoSuchModelException {

    public NoSuchSIAuditEntryException() {}

    public NoSuchSIAuditEntryException(String msg) {
        super(msg);
    }

    public NoSuchSIAuditEntryException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public NoSuchSIAuditEntryException(Throwable throwable) {
        super(throwable);
    }
}
