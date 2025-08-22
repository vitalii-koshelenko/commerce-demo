/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.service.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.solteq.liferay.site.initializer.audit.model.SIAuditEntry;

/**
 * The persistence utility for the si audit entry service. This utility wraps <code>com.solteq.liferay.site.initializer.audit.service.persistence.impl.SIAuditEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Solteq
 * @see SIAuditEntryPersistence
 * @generated
 */
public class SIAuditEntryUtil {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
     */
    public static void clearCache(SIAuditEntry siAuditEntry) {
        getPersistence().clearCache(siAuditEntry);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
     */
    public static Map<Serializable, SIAuditEntry> fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

        return getPersistence().fetchByPrimaryKeys(primaryKeys);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<SIAuditEntry> findWithDynamicQuery(DynamicQuery dynamicQuery) {

        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SIAuditEntry> findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SIAuditEntry> findWithDynamicQuery(
            DynamicQuery dynamicQuery, int start, int end, OrderByComparator<SIAuditEntry> orderByComparator) {

        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
     */
    public static SIAuditEntry update(SIAuditEntry siAuditEntry) {
        return getPersistence().update(siAuditEntry);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
     */
    public static SIAuditEntry update(SIAuditEntry siAuditEntry, ServiceContext serviceContext) {

        return getPersistence().update(siAuditEntry, serviceContext);
    }

    /**
     * Returns all the si audit entries where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching si audit entries
     */
    public static List<SIAuditEntry> findByGroupId(long groupId) {
        return getPersistence().findByGroupId(groupId);
    }

    /**
     * Returns a range of all the si audit entries where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of si audit entries
     * @param end the upper bound of the range of si audit entries (not inclusive)
     * @return the range of matching si audit entries
     */
    public static List<SIAuditEntry> findByGroupId(long groupId, int start, int end) {

        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
     * Returns an ordered range of all the si audit entries where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of si audit entries
     * @param end the upper bound of the range of si audit entries (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching si audit entries
     */
    public static List<SIAuditEntry> findByGroupId(
            long groupId, int start, int end, OrderByComparator<SIAuditEntry> orderByComparator) {

        return getPersistence().findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
     * Returns an ordered range of all the si audit entries where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of si audit entries
     * @param end the upper bound of the range of si audit entries (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param useFinderCache whether to use the finder cache
     * @return the ordered range of matching si audit entries
     */
    public static List<SIAuditEntry> findByGroupId(
            long groupId,
            int start,
            int end,
            OrderByComparator<SIAuditEntry> orderByComparator,
            boolean useFinderCache) {

        return getPersistence().findByGroupId(groupId, start, end, orderByComparator, useFinderCache);
    }

    /**
     * Returns the first si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching si audit entry
     * @throws NoSuchSIAuditEntryException if a matching si audit entry could not be found
     */
    public static SIAuditEntry findByGroupId_First(long groupId, OrderByComparator<SIAuditEntry> orderByComparator)
            throws com.solteq.liferay.site.initializer.audit.exception.NoSuchSIAuditEntryException {

        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
     * Returns the first si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching si audit entry, or <code>null</code> if a matching si audit entry could not be found
     */
    public static SIAuditEntry fetchByGroupId_First(long groupId, OrderByComparator<SIAuditEntry> orderByComparator) {

        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
     * Returns the last si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching si audit entry
     * @throws NoSuchSIAuditEntryException if a matching si audit entry could not be found
     */
    public static SIAuditEntry findByGroupId_Last(long groupId, OrderByComparator<SIAuditEntry> orderByComparator)
            throws com.solteq.liferay.site.initializer.audit.exception.NoSuchSIAuditEntryException {

        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
     * Returns the last si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching si audit entry, or <code>null</code> if a matching si audit entry could not be found
     */
    public static SIAuditEntry fetchByGroupId_Last(long groupId, OrderByComparator<SIAuditEntry> orderByComparator) {

        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
     * Returns the si audit entries before and after the current si audit entry in the ordered set where groupId = &#63;.
     *
     * @param siAuditEntryId the primary key of the current si audit entry
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next si audit entry
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    public static SIAuditEntry[] findByGroupId_PrevAndNext(
            long siAuditEntryId, long groupId, OrderByComparator<SIAuditEntry> orderByComparator)
            throws com.solteq.liferay.site.initializer.audit.exception.NoSuchSIAuditEntryException {

        return getPersistence().findByGroupId_PrevAndNext(siAuditEntryId, groupId, orderByComparator);
    }

    /**
     * Removes all the si audit entries where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     */
    public static void removeByGroupId(long groupId) {
        getPersistence().removeByGroupId(groupId);
    }

    /**
     * Returns the number of si audit entries where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching si audit entries
     */
    public static int countByGroupId(long groupId) {
        return getPersistence().countByGroupId(groupId);
    }

    /**
     * Caches the si audit entry in the entity cache if it is enabled.
     *
     * @param siAuditEntry the si audit entry
     */
    public static void cacheResult(SIAuditEntry siAuditEntry) {
        getPersistence().cacheResult(siAuditEntry);
    }

    /**
     * Caches the si audit entries in the entity cache if it is enabled.
     *
     * @param siAuditEntries the si audit entries
     */
    public static void cacheResult(List<SIAuditEntry> siAuditEntries) {
        getPersistence().cacheResult(siAuditEntries);
    }

    /**
     * Creates a new si audit entry with the primary key. Does not add the si audit entry to the database.
     *
     * @param siAuditEntryId the primary key for the new si audit entry
     * @return the new si audit entry
     */
    public static SIAuditEntry create(long siAuditEntryId) {
        return getPersistence().create(siAuditEntryId);
    }

    /**
     * Removes the si audit entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry that was removed
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    public static SIAuditEntry remove(long siAuditEntryId)
            throws com.solteq.liferay.site.initializer.audit.exception.NoSuchSIAuditEntryException {

        return getPersistence().remove(siAuditEntryId);
    }

    public static SIAuditEntry updateImpl(SIAuditEntry siAuditEntry) {
        return getPersistence().updateImpl(siAuditEntry);
    }

    /**
     * Returns the si audit entry with the primary key or throws a <code>NoSuchSIAuditEntryException</code> if it could not be found.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    public static SIAuditEntry findByPrimaryKey(long siAuditEntryId)
            throws com.solteq.liferay.site.initializer.audit.exception.NoSuchSIAuditEntryException {

        return getPersistence().findByPrimaryKey(siAuditEntryId);
    }

    /**
     * Returns the si audit entry with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry, or <code>null</code> if a si audit entry with the primary key could not be found
     */
    public static SIAuditEntry fetchByPrimaryKey(long siAuditEntryId) {
        return getPersistence().fetchByPrimaryKey(siAuditEntryId);
    }

    /**
     * Returns all the si audit entries.
     *
     * @return the si audit entries
     */
    public static List<SIAuditEntry> findAll() {
        return getPersistence().findAll();
    }

    /**
     * Returns a range of all the si audit entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of si audit entries
     * @param end the upper bound of the range of si audit entries (not inclusive)
     * @return the range of si audit entries
     */
    public static List<SIAuditEntry> findAll(int start, int end) {
        return getPersistence().findAll(start, end);
    }

    /**
     * Returns an ordered range of all the si audit entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of si audit entries
     * @param end the upper bound of the range of si audit entries (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of si audit entries
     */
    public static List<SIAuditEntry> findAll(int start, int end, OrderByComparator<SIAuditEntry> orderByComparator) {

        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
     * Returns an ordered range of all the si audit entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SIAuditEntryModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of si audit entries
     * @param end the upper bound of the range of si audit entries (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param useFinderCache whether to use the finder cache
     * @return the ordered range of si audit entries
     */
    public static List<SIAuditEntry> findAll(
            int start, int end, OrderByComparator<SIAuditEntry> orderByComparator, boolean useFinderCache) {

        return getPersistence().findAll(start, end, orderByComparator, useFinderCache);
    }

    /**
     * Removes all the si audit entries from the database.
     */
    public static void removeAll() {
        getPersistence().removeAll();
    }

    /**
     * Returns the number of si audit entries.
     *
     * @return the number of si audit entries
     */
    public static int countAll() {
        return getPersistence().countAll();
    }

    public static SIAuditEntryPersistence getPersistence() {
        return _persistence;
    }

    public static void setPersistence(SIAuditEntryPersistence persistence) {
        _persistence = persistence;
    }

    private static volatile SIAuditEntryPersistence _persistence;
}
