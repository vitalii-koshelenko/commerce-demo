/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SIAuditEntryLocalService}.
 *
 * @author Solteq
 * @see SIAuditEntryLocalService
 * @generated
 */
public class SIAuditEntryLocalServiceWrapper
        implements ServiceWrapper<SIAuditEntryLocalService>, SIAuditEntryLocalService {

    public SIAuditEntryLocalServiceWrapper() {
        this(null);
    }

    public SIAuditEntryLocalServiceWrapper(SIAuditEntryLocalService siAuditEntryLocalService) {

        _siAuditEntryLocalService = siAuditEntryLocalService;
    }

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
    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry addSIAuditEntry(
            com.solteq.liferay.site.initializer.audit.model.SIAuditEntry siAuditEntry) {

        return _siAuditEntryLocalService.addSIAuditEntry(siAuditEntry);
    }

    /**
     * @throws PortalException
     */
    @Override
    public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(java.io.Serializable primaryKeyObj)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _siAuditEntryLocalService.createPersistedModel(primaryKeyObj);
    }

    /**
     * Creates a new si audit entry with the primary key. Does not add the si audit entry to the database.
     *
     * @param siAuditEntryId the primary key for the new si audit entry
     * @return the new si audit entry
     */
    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry createSIAuditEntry(long siAuditEntryId) {

        return _siAuditEntryLocalService.createSIAuditEntry(siAuditEntryId);
    }

    /**
     * @throws PortalException
     */
    @Override
    public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
            com.liferay.portal.kernel.model.PersistedModel persistedModel)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _siAuditEntryLocalService.deletePersistedModel(persistedModel);
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
    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry deleteSIAuditEntry(long siAuditEntryId)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _siAuditEntryLocalService.deleteSIAuditEntry(siAuditEntryId);
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
    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry deleteSIAuditEntry(
            com.solteq.liferay.site.initializer.audit.model.SIAuditEntry siAuditEntry) {

        return _siAuditEntryLocalService.deleteSIAuditEntry(siAuditEntry);
    }

    @Override
    public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
        return _siAuditEntryLocalService.dslQuery(dslQuery);
    }

    @Override
    public int dslQueryCount(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

        return _siAuditEntryLocalService.dslQueryCount(dslQuery);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _siAuditEntryLocalService.dynamicQuery();
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     */
    @Override
    public <T> java.util.List<T> dynamicQuery(com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

        return _siAuditEntryLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    public <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start, int end) {

        return _siAuditEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    public <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
            int start,
            int end,
            com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

        return _siAuditEntryLocalService.dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows matching the dynamic query
     */
    @Override
    public long dynamicQueryCount(com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

        return _siAuditEntryLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows matching the dynamic query
     */
    @Override
    public long dynamicQueryCount(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
            com.liferay.portal.kernel.dao.orm.Projection projection) {

        return _siAuditEntryLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry fetchSIAuditEntry(long siAuditEntryId) {

        return _siAuditEntryLocalService.fetchSIAuditEntry(siAuditEntryId);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {

        return _siAuditEntryLocalService.getActionableDynamicQuery();
    }

    @Override
    public java.util.List<com.solteq.liferay.site.initializer.audit.model.SIAuditEntry> getAuditEntries(
            int start, int end) {

        return _siAuditEntryLocalService.getAuditEntries(start, end);
    }

    @Override
    public int getAuditEntriesCount() {
        return _siAuditEntryLocalService.getAuditEntriesCount();
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {

        return _siAuditEntryLocalService.getIndexableActionableDynamicQuery();
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    @Override
    public String getOSGiServiceIdentifier() {
        return _siAuditEntryLocalService.getOSGiServiceIdentifier();
    }

    /**
     * @throws PortalException
     */
    @Override
    public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(java.io.Serializable primaryKeyObj)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _siAuditEntryLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.solteq.liferay.site.initializer.audit.model.SIAuditEntry> getSIAuditEntries(
            int start, int end) {

        return _siAuditEntryLocalService.getSIAuditEntries(start, end);
    }

    /**
     * Returns the number of si audit entries.
     *
     * @return the number of si audit entries
     */
    @Override
    public int getSIAuditEntriesCount() {
        return _siAuditEntryLocalService.getSIAuditEntriesCount();
    }

    /**
     * Returns the si audit entry with the primary key.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry
     * @throws PortalException if a si audit entry with the primary key could not be found
     */
    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry getSIAuditEntry(long siAuditEntryId)
            throws com.liferay.portal.kernel.exception.PortalException {

        return _siAuditEntryLocalService.getSIAuditEntry(siAuditEntryId);
    }

    @Override
    public java.util.List<com.solteq.liferay.site.initializer.audit.model.SIAuditEntry> getSiteAuditEntries(
            long groupId) {

        return _siAuditEntryLocalService.getSiteAuditEntries(groupId);
    }

    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry saveFailedAuditEntry(
            long groupId, String siKey, long processingTime, String message) {

        return _siAuditEntryLocalService.saveFailedAuditEntry(groupId, siKey, processingTime, message);
    }

    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry saveSuccessAuditEntry(
            long groupId, String siKey, long processingTime, String message) {

        return _siAuditEntryLocalService.saveSuccessAuditEntry(groupId, siKey, processingTime, message);
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
    @Override
    public com.solteq.liferay.site.initializer.audit.model.SIAuditEntry updateSIAuditEntry(
            com.solteq.liferay.site.initializer.audit.model.SIAuditEntry siAuditEntry) {

        return _siAuditEntryLocalService.updateSIAuditEntry(siAuditEntry);
    }

    @Override
    public BasePersistence<?> getBasePersistence() {
        return _siAuditEntryLocalService.getBasePersistence();
    }

    @Override
    public SIAuditEntryLocalService getWrappedService() {
        return _siAuditEntryLocalService;
    }

    @Override
    public void setWrappedService(SIAuditEntryLocalService siAuditEntryLocalService) {

        _siAuditEntryLocalService = siAuditEntryLocalService;
    }

    private SIAuditEntryLocalService _siAuditEntryLocalService;
}
