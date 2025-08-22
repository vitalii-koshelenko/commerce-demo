/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.solteq.liferay.site.initializer.audit.exception.NoSuchSIAuditEntryException;
import com.solteq.liferay.site.initializer.audit.model.SIAuditEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the si audit entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Solteq
 * @see SIAuditEntryUtil
 * @generated
 */
@ProviderType
public interface SIAuditEntryPersistence extends BasePersistence<SIAuditEntry> {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SIAuditEntryUtil} to access the si audit entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
     * Returns all the si audit entries where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching si audit entries
     */
    public java.util.List<SIAuditEntry> findByGroupId(long groupId);

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
    public java.util.List<SIAuditEntry> findByGroupId(long groupId, int start, int end);

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
    public java.util.List<SIAuditEntry> findByGroupId(
            long groupId,
            int start,
            int end,
            com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator);

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
    public java.util.List<SIAuditEntry> findByGroupId(
            long groupId,
            int start,
            int end,
            com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator,
            boolean useFinderCache);

    /**
     * Returns the first si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching si audit entry
     * @throws NoSuchSIAuditEntryException if a matching si audit entry could not be found
     */
    public SIAuditEntry findByGroupId_First(
            long groupId, com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator)
            throws NoSuchSIAuditEntryException;

    /**
     * Returns the first si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching si audit entry, or <code>null</code> if a matching si audit entry could not be found
     */
    public SIAuditEntry fetchByGroupId_First(
            long groupId, com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator);

    /**
     * Returns the last si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching si audit entry
     * @throws NoSuchSIAuditEntryException if a matching si audit entry could not be found
     */
    public SIAuditEntry findByGroupId_Last(
            long groupId, com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator)
            throws NoSuchSIAuditEntryException;

    /**
     * Returns the last si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching si audit entry, or <code>null</code> if a matching si audit entry could not be found
     */
    public SIAuditEntry fetchByGroupId_Last(
            long groupId, com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator);

    /**
     * Returns the si audit entries before and after the current si audit entry in the ordered set where groupId = &#63;.
     *
     * @param siAuditEntryId the primary key of the current si audit entry
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next si audit entry
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    public SIAuditEntry[] findByGroupId_PrevAndNext(
            long siAuditEntryId,
            long groupId,
            com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator)
            throws NoSuchSIAuditEntryException;

    /**
     * Removes all the si audit entries where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     */
    public void removeByGroupId(long groupId);

    /**
     * Returns the number of si audit entries where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching si audit entries
     */
    public int countByGroupId(long groupId);

    /**
     * Caches the si audit entry in the entity cache if it is enabled.
     *
     * @param siAuditEntry the si audit entry
     */
    public void cacheResult(SIAuditEntry siAuditEntry);

    /**
     * Caches the si audit entries in the entity cache if it is enabled.
     *
     * @param siAuditEntries the si audit entries
     */
    public void cacheResult(java.util.List<SIAuditEntry> siAuditEntries);

    /**
     * Creates a new si audit entry with the primary key. Does not add the si audit entry to the database.
     *
     * @param siAuditEntryId the primary key for the new si audit entry
     * @return the new si audit entry
     */
    public SIAuditEntry create(long siAuditEntryId);

    /**
     * Removes the si audit entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry that was removed
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    public SIAuditEntry remove(long siAuditEntryId) throws NoSuchSIAuditEntryException;

    public SIAuditEntry updateImpl(SIAuditEntry siAuditEntry);

    /**
     * Returns the si audit entry with the primary key or throws a <code>NoSuchSIAuditEntryException</code> if it could not be found.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    public SIAuditEntry findByPrimaryKey(long siAuditEntryId) throws NoSuchSIAuditEntryException;

    /**
     * Returns the si audit entry with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry, or <code>null</code> if a si audit entry with the primary key could not be found
     */
    public SIAuditEntry fetchByPrimaryKey(long siAuditEntryId);

    /**
     * Returns all the si audit entries.
     *
     * @return the si audit entries
     */
    public java.util.List<SIAuditEntry> findAll();

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
    public java.util.List<SIAuditEntry> findAll(int start, int end);

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
    public java.util.List<SIAuditEntry> findAll(
            int start, int end, com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator);

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
    public java.util.List<SIAuditEntry> findAll(
            int start,
            int end,
            com.liferay.portal.kernel.util.OrderByComparator<SIAuditEntry> orderByComparator,
            boolean useFinderCache);

    /**
     * Removes all the si audit entries from the database.
     */
    public void removeAll();

    /**
     * Returns the number of si audit entries.
     *
     * @return the number of si audit entries
     */
    public int countAll();
}
