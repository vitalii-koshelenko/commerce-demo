/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.service;

import java.io.Serializable;
import java.util.List;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.solteq.liferay.site.initializer.audit.model.SIAuditEntry;

/**
 * Provides the local service utility for SIAuditEntry. This utility wraps
 * <code>com.solteq.liferay.site.initializer.audit.service.impl.SIAuditEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Solteq
 * @see SIAuditEntryLocalService
 * @generated
 */
public class SIAuditEntryLocalServiceUtil {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to <code>com.solteq.liferay.site.initializer.audit.service.impl.SIAuditEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * Adds the si audit entry to the database. Also notifies the appropriate model listeners.
     *
     * <p>
     * <strong>Important:</strong> Inspect SIAuditEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
     * </p>
     *
     * @param siAuditEntry the si audit entry
     * @return the si audit entry that was added
     */
    public static SIAuditEntry addSIAuditEntry(SIAuditEntry siAuditEntry) {
        return getService().addSIAuditEntry(siAuditEntry);
    }

    /**
     * @throws PortalException
     */
    public static PersistedModel createPersistedModel(Serializable primaryKeyObj) throws PortalException {

        return getService().createPersistedModel(primaryKeyObj);
    }

    /**
     * Creates a new si audit entry with the primary key. Does not add the si audit entry to the database.
     *
     * @param siAuditEntryId the primary key for the new si audit entry
     * @return the new si audit entry
     */
    public static SIAuditEntry createSIAuditEntry(long siAuditEntryId) {
        return getService().createSIAuditEntry(siAuditEntryId);
    }

    /**
     * @throws PortalException
     */
    public static PersistedModel deletePersistedModel(PersistedModel persistedModel) throws PortalException {

        return getService().deletePersistedModel(persistedModel);
    }

    /**
     * Deletes the si audit entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * <p>
     * <strong>Important:</strong> Inspect SIAuditEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
     * </p>
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry that was removed
     * @throws PortalException if a si audit entry with the primary key could not be found
     */
    public static SIAuditEntry deleteSIAuditEntry(long siAuditEntryId) throws PortalException {

        return getService().deleteSIAuditEntry(siAuditEntryId);
    }

    /**
     * Deletes the si audit entry from the database. Also notifies the appropriate model listeners.
     *
     * <p>
     * <strong>Important:</strong> Inspect SIAuditEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
     * </p>
     *
     * @param siAuditEntry the si audit entry
     * @return the si audit entry that was removed
     */
    public static SIAuditEntry deleteSIAuditEntry(SIAuditEntry siAuditEntry) {
        return getService().deleteSIAuditEntry(siAuditEntry);
    }

    public static <T> T dslQuery(DSLQuery dslQuery) {
        return getService().dslQuery(dslQuery);
    }

    public static int dslQueryCount(DSLQuery dslQuery) {
        return getService().dslQueryCount(dslQuery);
    }

    public static DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     */
    public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     */
    public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     */
    public static <T> List<T> dynamicQuery(
            DynamicQuery dynamicQuery, int start, int end, OrderByComparator<T> orderByComparator) {

        return getService().dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows matching the dynamic query
     */
    public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows matching the dynamic query
     */
    public static long dynamicQueryCount(
            DynamicQuery dynamicQuery, com.liferay.portal.kernel.dao.orm.Projection projection) {

        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static SIAuditEntry fetchSIAuditEntry(long siAuditEntryId) {
        return getService().fetchSIAuditEntry(siAuditEntryId);
    }

    public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {

        return getService().getActionableDynamicQuery();
    }

    public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
            getIndexableActionableDynamicQuery() {

        return getService().getIndexableActionableDynamicQuery();
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    public static String getOSGiServiceIdentifier() {
        return getService().getOSGiServiceIdentifier();
    }

    /**
     * @throws PortalException
     */
    public static PersistedModel getPersistedModel(Serializable primaryKeyObj) throws PortalException {

        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
     * Returns a range of all the si audit entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of si audit entries
     * @param end the upper bound of the range of si audit entries (not inclusive)
     * @return the range of si audit entries
     */
    public static List<SIAuditEntry> getSIAuditEntries(int start, int end) {
        return getService().getSIAuditEntries(start, end);
    }

    /**
     * Returns the number of si audit entries.
     *
     * @return the number of si audit entries
     */
    public static int getSIAuditEntriesCount() {
        return getService().getSIAuditEntriesCount();
    }

    /**
     * Returns the si audit entry with the primary key.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry
     * @throws PortalException if a si audit entry with the primary key could not be found
     */
    public static SIAuditEntry getSIAuditEntry(long siAuditEntryId) throws PortalException {

        return getService().getSIAuditEntry(siAuditEntryId);
    }

    public static List<SIAuditEntry> getSiteAuditEntries(long groupId) {
        return getService().getSiteAuditEntries(groupId);
    }

    public static SIAuditEntry saveFailedAuditEntry(long groupId, String siKey, long processingTime, String message) {

        return getService().saveFailedAuditEntry(groupId, siKey, processingTime, message);
    }

    public static SIAuditEntry saveSuccessAuditEntry(long groupId, String siKey, long processingTime, String message) {

        return getService().saveSuccessAuditEntry(groupId, siKey, processingTime, message);
    }

    /**
     * Updates the si audit entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * <p>
     * <strong>Important:</strong> Inspect SIAuditEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
     * </p>
     *
     * @param siAuditEntry the si audit entry
     * @return the si audit entry that was updated
     */
    public static SIAuditEntry updateSIAuditEntry(SIAuditEntry siAuditEntry) {
        return getService().updateSIAuditEntry(siAuditEntry);
    }

    public static SIAuditEntryLocalService getService() {
        return _serviceSnapshot.get();
    }

    private static final Snapshot<SIAuditEntryLocalService> _serviceSnapshot =
            new Snapshot<>(SIAuditEntryLocalServiceUtil.class, SIAuditEntryLocalService.class);
}
