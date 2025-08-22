/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.solteq.liferay.site.initializer.audit.service.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.sql.DataSource;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.solteq.liferay.site.initializer.audit.exception.NoSuchSIAuditEntryException;
import com.solteq.liferay.site.initializer.audit.model.SIAuditEntry;
import com.solteq.liferay.site.initializer.audit.model.SIAuditEntryTable;
import com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryImpl;
import com.solteq.liferay.site.initializer.audit.model.impl.SIAuditEntryModelImpl;
import com.solteq.liferay.site.initializer.audit.service.persistence.SIAuditEntryPersistence;
import com.solteq.liferay.site.initializer.audit.service.persistence.SIAuditEntryUtil;
import com.solteq.liferay.site.initializer.audit.service.persistence.impl.constants.sqPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the si audit entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Solteq
 * @generated
 */
@Component(service = SIAuditEntryPersistence.class)
public class SIAuditEntryPersistenceImpl extends BasePersistenceImpl<SIAuditEntry> implements SIAuditEntryPersistence {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use <code>SIAuditEntryUtil</code> to access the si audit entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SIAuditEntryImpl.class.getName();

    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY + ".List1";

    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY + ".List2";

    private FinderPath _finderPathWithPaginationFindAll;
    private FinderPath _finderPathWithoutPaginationFindAll;
    private FinderPath _finderPathCountAll;
    private FinderPath _finderPathWithPaginationFindByGroupId;
    private FinderPath _finderPathWithoutPaginationFindByGroupId;
    private FinderPath _finderPathCountByGroupId;

    /**
     * Returns all the si audit entries where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching si audit entries
     */
    @Override
    public List<SIAuditEntry> findByGroupId(long groupId) {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<SIAuditEntry> findByGroupId(long groupId, int start, int end) {
        return findByGroupId(groupId, start, end, null);
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
    @Override
    public List<SIAuditEntry> findByGroupId(
            long groupId, int start, int end, OrderByComparator<SIAuditEntry> orderByComparator) {

        return findByGroupId(groupId, start, end, orderByComparator, true);
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
    @Override
    public List<SIAuditEntry> findByGroupId(
            long groupId,
            int start,
            int end,
            OrderByComparator<SIAuditEntry> orderByComparator,
            boolean useFinderCache) {

        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) && (orderByComparator == null)) {

            if (useFinderCache) {
                finderPath = _finderPathWithoutPaginationFindByGroupId;
                finderArgs = new Object[] {groupId};
            }
        } else if (useFinderCache) {
            finderPath = _finderPathWithPaginationFindByGroupId;
            finderArgs = new Object[] {groupId, start, end, orderByComparator};
        }

        List<SIAuditEntry> list = null;

        if (useFinderCache) {
            list = (List<SIAuditEntry>) finderCache.getResult(finderPath, finderArgs, this);

            if ((list != null) && !list.isEmpty()) {
                for (SIAuditEntry siAuditEntry : list) {
                    if (groupId != siAuditEntry.getGroupId()) {
                        list = null;

                        break;
                    }
                }
            }
        }

        if (list == null) {
            StringBundler sb = null;

            if (orderByComparator != null) {
                sb = new StringBundler(3 + (orderByComparator.getOrderByFields().length * 2));
            } else {
                sb = new StringBundler(3);
            }

            sb.append(_SQL_SELECT_SIAUDITENTRY_WHERE);

            sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
            } else {
                sb.append(SIAuditEntryModelImpl.ORDER_BY_JPQL);
            }

            String sql = sb.toString();

            Session session = null;

            try {
                session = openSession();

                Query query = session.createQuery(sql);

                QueryPos queryPos = QueryPos.getInstance(query);

                queryPos.add(groupId);

                list = (List<SIAuditEntry>) QueryUtil.list(query, getDialect(), start, end);

                cacheResult(list);

                if (useFinderCache) {
                    finderCache.putResult(finderPath, finderArgs, list);
                }
            } catch (Exception exception) {
                throw processException(exception);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching si audit entry
     * @throws NoSuchSIAuditEntryException if a matching si audit entry could not be found
     */
    @Override
    public SIAuditEntry findByGroupId_First(long groupId, OrderByComparator<SIAuditEntry> orderByComparator)
            throws NoSuchSIAuditEntryException {

        SIAuditEntry siAuditEntry = fetchByGroupId_First(groupId, orderByComparator);

        if (siAuditEntry != null) {
            return siAuditEntry;
        }

        StringBundler sb = new StringBundler(4);

        sb.append(_NO_SUCH_ENTITY_WITH_KEY);

        sb.append("groupId=");
        sb.append(groupId);

        sb.append("}");

        throw new NoSuchSIAuditEntryException(sb.toString());
    }

    /**
     * Returns the first si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching si audit entry, or <code>null</code> if a matching si audit entry could not be found
     */
    @Override
    public SIAuditEntry fetchByGroupId_First(long groupId, OrderByComparator<SIAuditEntry> orderByComparator) {

        List<SIAuditEntry> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching si audit entry
     * @throws NoSuchSIAuditEntryException if a matching si audit entry could not be found
     */
    @Override
    public SIAuditEntry findByGroupId_Last(long groupId, OrderByComparator<SIAuditEntry> orderByComparator)
            throws NoSuchSIAuditEntryException {

        SIAuditEntry siAuditEntry = fetchByGroupId_Last(groupId, orderByComparator);

        if (siAuditEntry != null) {
            return siAuditEntry;
        }

        StringBundler sb = new StringBundler(4);

        sb.append(_NO_SUCH_ENTITY_WITH_KEY);

        sb.append("groupId=");
        sb.append(groupId);

        sb.append("}");

        throw new NoSuchSIAuditEntryException(sb.toString());
    }

    /**
     * Returns the last si audit entry in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching si audit entry, or <code>null</code> if a matching si audit entry could not be found
     */
    @Override
    public SIAuditEntry fetchByGroupId_Last(long groupId, OrderByComparator<SIAuditEntry> orderByComparator) {

        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<SIAuditEntry> list = findByGroupId(groupId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public SIAuditEntry[] findByGroupId_PrevAndNext(
            long siAuditEntryId, long groupId, OrderByComparator<SIAuditEntry> orderByComparator)
            throws NoSuchSIAuditEntryException {

        SIAuditEntry siAuditEntry = findByPrimaryKey(siAuditEntryId);

        Session session = null;

        try {
            session = openSession();

            SIAuditEntry[] array = new SIAuditEntryImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, siAuditEntry, groupId, orderByComparator, true);

            array[1] = siAuditEntry;

            array[2] = getByGroupId_PrevAndNext(session, siAuditEntry, groupId, orderByComparator, false);

            return array;
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }
    }

    protected SIAuditEntry getByGroupId_PrevAndNext(
            Session session,
            SIAuditEntry siAuditEntry,
            long groupId,
            OrderByComparator<SIAuditEntry> orderByComparator,
            boolean previous) {

        StringBundler sb = null;

        if (orderByComparator != null) {
            sb = new StringBundler(4
                    + (orderByComparator.getOrderByConditionFields().length * 3)
                    + (orderByComparator.getOrderByFields().length * 3));
        } else {
            sb = new StringBundler(3);
        }

        sb.append(_SQL_SELECT_SIAUDITENTRY_WHERE);

        sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                sb.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                sb.append(_ORDER_BY_ENTITY_ALIAS);
                sb.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        sb.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        sb.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        sb.append(WHERE_GREATER_THAN);
                    } else {
                        sb.append(WHERE_LESSER_THAN);
                    }
                }
            }

            sb.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                sb.append(_ORDER_BY_ENTITY_ALIAS);
                sb.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        sb.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        sb.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        sb.append(ORDER_BY_ASC);
                    } else {
                        sb.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            sb.append(SIAuditEntryModelImpl.ORDER_BY_JPQL);
        }

        String sql = sb.toString();

        Query query = session.createQuery(sql);

        query.setFirstResult(0);
        query.setMaxResults(2);

        QueryPos queryPos = QueryPos.getInstance(query);

        queryPos.add(groupId);

        if (orderByComparator != null) {
            for (Object orderByConditionValue : orderByComparator.getOrderByConditionValues(siAuditEntry)) {

                queryPos.add(orderByConditionValue);
            }
        }

        List<SIAuditEntry> list = query.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the si audit entries where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     */
    @Override
    public void removeByGroupId(long groupId) {
        for (SIAuditEntry siAuditEntry : findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

            remove(siAuditEntry);
        }
    }

    /**
     * Returns the number of si audit entries where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching si audit entries
     */
    @Override
    public int countByGroupId(long groupId) {
        FinderPath finderPath = _finderPathCountByGroupId;

        Object[] finderArgs = new Object[] {groupId};

        Long count = (Long) finderCache.getResult(finderPath, finderArgs, this);

        if (count == null) {
            StringBundler sb = new StringBundler(2);

            sb.append(_SQL_COUNT_SIAUDITENTRY_WHERE);

            sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = sb.toString();

            Session session = null;

            try {
                session = openSession();

                Query query = session.createQuery(sql);

                QueryPos queryPos = QueryPos.getInstance(query);

                queryPos.add(groupId);

                count = (Long) query.uniqueResult();

                finderCache.putResult(finderPath, finderArgs, count);
            } catch (Exception exception) {
                throw processException(exception);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "siAuditEntry.groupId = ?";

    public SIAuditEntryPersistenceImpl() {
        setModelClass(SIAuditEntry.class);

        setModelImplClass(SIAuditEntryImpl.class);
        setModelPKClass(long.class);

        setTable(SIAuditEntryTable.INSTANCE);
    }

    /**
     * Caches the si audit entry in the entity cache if it is enabled.
     *
     * @param siAuditEntry the si audit entry
     */
    @Override
    public void cacheResult(SIAuditEntry siAuditEntry) {
        entityCache.putResult(SIAuditEntryImpl.class, siAuditEntry.getPrimaryKey(), siAuditEntry);
    }

    private int _valueObjectFinderCacheListThreshold;

    /**
     * Caches the si audit entries in the entity cache if it is enabled.
     *
     * @param siAuditEntries the si audit entries
     */
    @Override
    public void cacheResult(List<SIAuditEntry> siAuditEntries) {
        if ((_valueObjectFinderCacheListThreshold == 0)
                || ((_valueObjectFinderCacheListThreshold > 0)
                        && (siAuditEntries.size() > _valueObjectFinderCacheListThreshold))) {

            return;
        }

        for (SIAuditEntry siAuditEntry : siAuditEntries) {
            if (entityCache.getResult(SIAuditEntryImpl.class, siAuditEntry.getPrimaryKey()) == null) {

                cacheResult(siAuditEntry);
            }
        }
    }

    /**
     * Clears the cache for all si audit entries.
     *
     * <p>
     * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        entityCache.clearCache(SIAuditEntryImpl.class);

        finderCache.clearCache(SIAuditEntryImpl.class);
    }

    /**
     * Clears the cache for the si audit entry.
     *
     * <p>
     * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SIAuditEntry siAuditEntry) {
        entityCache.removeResult(SIAuditEntryImpl.class, siAuditEntry);
    }

    @Override
    public void clearCache(List<SIAuditEntry> siAuditEntries) {
        for (SIAuditEntry siAuditEntry : siAuditEntries) {
            entityCache.removeResult(SIAuditEntryImpl.class, siAuditEntry);
        }
    }

    @Override
    public void clearCache(Set<Serializable> primaryKeys) {
        finderCache.clearCache(SIAuditEntryImpl.class);

        for (Serializable primaryKey : primaryKeys) {
            entityCache.removeResult(SIAuditEntryImpl.class, primaryKey);
        }
    }

    /**
     * Creates a new si audit entry with the primary key. Does not add the si audit entry to the database.
     *
     * @param siAuditEntryId the primary key for the new si audit entry
     * @return the new si audit entry
     */
    @Override
    public SIAuditEntry create(long siAuditEntryId) {
        SIAuditEntry siAuditEntry = new SIAuditEntryImpl();

        siAuditEntry.setNew(true);
        siAuditEntry.setPrimaryKey(siAuditEntryId);

        siAuditEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

        return siAuditEntry;
    }

    /**
     * Removes the si audit entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry that was removed
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    @Override
    public SIAuditEntry remove(long siAuditEntryId) throws NoSuchSIAuditEntryException {

        return remove((Serializable) siAuditEntryId);
    }

    /**
     * Removes the si audit entry with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the si audit entry
     * @return the si audit entry that was removed
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    @Override
    public SIAuditEntry remove(Serializable primaryKey) throws NoSuchSIAuditEntryException {

        Session session = null;

        try {
            session = openSession();

            SIAuditEntry siAuditEntry = (SIAuditEntry) session.get(SIAuditEntryImpl.class, primaryKey);

            if (siAuditEntry == null) {
                if (_log.isDebugEnabled()) {
                    _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSIAuditEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            return remove(siAuditEntry);
        } catch (NoSuchSIAuditEntryException noSuchEntityException) {
            throw noSuchEntityException;
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SIAuditEntry removeImpl(SIAuditEntry siAuditEntry) {
        Session session = null;

        try {
            session = openSession();

            if (!session.contains(siAuditEntry)) {
                siAuditEntry = (SIAuditEntry) session.get(SIAuditEntryImpl.class, siAuditEntry.getPrimaryKeyObj());
            }

            if (siAuditEntry != null) {
                session.delete(siAuditEntry);
            }
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }

        if (siAuditEntry != null) {
            clearCache(siAuditEntry);
        }

        return siAuditEntry;
    }

    @Override
    public SIAuditEntry updateImpl(SIAuditEntry siAuditEntry) {
        boolean isNew = siAuditEntry.isNew();

        if (!(siAuditEntry instanceof SIAuditEntryModelImpl)) {
            InvocationHandler invocationHandler = null;

            if (ProxyUtil.isProxyClass(siAuditEntry.getClass())) {
                invocationHandler = ProxyUtil.getInvocationHandler(siAuditEntry);

                throw new IllegalArgumentException(
                        "Implement ModelWrapper in siAuditEntry proxy " + invocationHandler.getClass());
            }

            throw new IllegalArgumentException(
                    "Implement ModelWrapper in custom SIAuditEntry implementation " + siAuditEntry.getClass());
        }

        SIAuditEntryModelImpl siAuditEntryModelImpl = (SIAuditEntryModelImpl) siAuditEntry;

        if (isNew && (siAuditEntry.getCreateDate() == null)) {
            ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

            Date date = new Date();

            if (serviceContext == null) {
                siAuditEntry.setCreateDate(date);
            } else {
                siAuditEntry.setCreateDate(serviceContext.getCreateDate(date));
            }
        }

        Session session = null;

        try {
            session = openSession();

            if (isNew) {
                session.save(siAuditEntry);
            } else {
                siAuditEntry = (SIAuditEntry) session.merge(siAuditEntry);
            }
        } catch (Exception exception) {
            throw processException(exception);
        } finally {
            closeSession(session);
        }

        entityCache.putResult(SIAuditEntryImpl.class, siAuditEntryModelImpl, false, true);

        if (isNew) {
            siAuditEntry.setNew(false);
        }

        siAuditEntry.resetOriginalValues();

        return siAuditEntry;
    }

    /**
     * Returns the si audit entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
     *
     * @param primaryKey the primary key of the si audit entry
     * @return the si audit entry
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    @Override
    public SIAuditEntry findByPrimaryKey(Serializable primaryKey) throws NoSuchSIAuditEntryException {

        SIAuditEntry siAuditEntry = fetchByPrimaryKey(primaryKey);

        if (siAuditEntry == null) {
            if (_log.isDebugEnabled()) {
                _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchSIAuditEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
        }

        return siAuditEntry;
    }

    /**
     * Returns the si audit entry with the primary key or throws a <code>NoSuchSIAuditEntryException</code> if it could not be found.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry
     * @throws NoSuchSIAuditEntryException if a si audit entry with the primary key could not be found
     */
    @Override
    public SIAuditEntry findByPrimaryKey(long siAuditEntryId) throws NoSuchSIAuditEntryException {

        return findByPrimaryKey((Serializable) siAuditEntryId);
    }

    /**
     * Returns the si audit entry with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param siAuditEntryId the primary key of the si audit entry
     * @return the si audit entry, or <code>null</code> if a si audit entry with the primary key could not be found
     */
    @Override
    public SIAuditEntry fetchByPrimaryKey(long siAuditEntryId) {
        return fetchByPrimaryKey((Serializable) siAuditEntryId);
    }

    /**
     * Returns all the si audit entries.
     *
     * @return the si audit entries
     */
    @Override
    public List<SIAuditEntry> findAll() {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<SIAuditEntry> findAll(int start, int end) {
        return findAll(start, end, null);
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
    @Override
    public List<SIAuditEntry> findAll(int start, int end, OrderByComparator<SIAuditEntry> orderByComparator) {

        return findAll(start, end, orderByComparator, true);
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
    @Override
    public List<SIAuditEntry> findAll(
            int start, int end, OrderByComparator<SIAuditEntry> orderByComparator, boolean useFinderCache) {

        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) && (orderByComparator == null)) {

            if (useFinderCache) {
                finderPath = _finderPathWithoutPaginationFindAll;
                finderArgs = FINDER_ARGS_EMPTY;
            }
        } else if (useFinderCache) {
            finderPath = _finderPathWithPaginationFindAll;
            finderArgs = new Object[] {start, end, orderByComparator};
        }

        List<SIAuditEntry> list = null;

        if (useFinderCache) {
            list = (List<SIAuditEntry>) finderCache.getResult(finderPath, finderArgs, this);
        }

        if (list == null) {
            StringBundler sb = null;
            String sql = null;

            if (orderByComparator != null) {
                sb = new StringBundler(2 + (orderByComparator.getOrderByFields().length * 2));

                sb.append(_SQL_SELECT_SIAUDITENTRY);

                appendOrderByComparator(sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

                sql = sb.toString();
            } else {
                sql = _SQL_SELECT_SIAUDITENTRY;

                sql = sql.concat(SIAuditEntryModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query query = session.createQuery(sql);

                list = (List<SIAuditEntry>) QueryUtil.list(query, getDialect(), start, end);

                cacheResult(list);

                if (useFinderCache) {
                    finderCache.putResult(finderPath, finderArgs, list);
                }
            } catch (Exception exception) {
                throw processException(exception);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the si audit entries from the database.
     *
     */
    @Override
    public void removeAll() {
        for (SIAuditEntry siAuditEntry : findAll()) {
            remove(siAuditEntry);
        }
    }

    /**
     * Returns the number of si audit entries.
     *
     * @return the number of si audit entries
     */
    @Override
    public int countAll() {
        Long count = (Long) finderCache.getResult(_finderPathCountAll, FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query query = session.createQuery(_SQL_COUNT_SIAUDITENTRY);

                count = (Long) query.uniqueResult();

                finderCache.putResult(_finderPathCountAll, FINDER_ARGS_EMPTY, count);
            } catch (Exception exception) {
                throw processException(exception);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected EntityCache getEntityCache() {
        return entityCache;
    }

    @Override
    protected String getPKDBName() {
        return "siAuditEntryId";
    }

    @Override
    protected String getSelectSQL() {
        return _SQL_SELECT_SIAUDITENTRY;
    }

    @Override
    protected Map<String, Integer> getTableColumnsMap() {
        return SIAuditEntryModelImpl.TABLE_COLUMNS_MAP;
    }

    /**
     * Initializes the si audit entry persistence.
     */
    @Activate
    public void activate() {
        _valueObjectFinderCacheListThreshold =
                GetterUtil.getInteger(PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

        _finderPathWithPaginationFindAll =
                new FinderPath(FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0], new String[0], true);

        _finderPathWithoutPaginationFindAll = new FinderPath(
                FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0], new String[0], true);

        _finderPathCountAll = new FinderPath(
                FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0], new String[0], false);

        _finderPathWithPaginationFindByGroupId = new FinderPath(
                FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
                "findByGroupId",
                new String[] {
                    Long.class.getName(), Integer.class.getName(),
                    Integer.class.getName(), OrderByComparator.class.getName()
                },
                new String[] {"groupId"},
                true);

        _finderPathWithoutPaginationFindByGroupId = new FinderPath(
                FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
                "findByGroupId",
                new String[] {Long.class.getName()},
                new String[] {"groupId"},
                true);

        _finderPathCountByGroupId = new FinderPath(
                FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
                "countByGroupId",
                new String[] {Long.class.getName()},
                new String[] {"groupId"},
                false);

        SIAuditEntryUtil.setPersistence(this);
    }

    @Deactivate
    public void deactivate() {
        SIAuditEntryUtil.setPersistence(null);

        entityCache.removeCache(SIAuditEntryImpl.class.getName());
    }

    @Override
    @Reference(target = sqPersistenceConstants.SERVICE_CONFIGURATION_FILTER, unbind = "-")
    public void setConfiguration(Configuration configuration) {}

    @Override
    @Reference(target = sqPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER, unbind = "-")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    @Reference(target = sqPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER, unbind = "-")
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Reference
    protected EntityCache entityCache;

    @Reference
    protected FinderCache finderCache;

    private static final String _SQL_SELECT_SIAUDITENTRY = "SELECT siAuditEntry FROM SIAuditEntry siAuditEntry";

    private static final String _SQL_SELECT_SIAUDITENTRY_WHERE =
            "SELECT siAuditEntry FROM SIAuditEntry siAuditEntry WHERE ";

    private static final String _SQL_COUNT_SIAUDITENTRY = "SELECT COUNT(siAuditEntry) FROM SIAuditEntry siAuditEntry";

    private static final String _SQL_COUNT_SIAUDITENTRY_WHERE =
            "SELECT COUNT(siAuditEntry) FROM SIAuditEntry siAuditEntry WHERE ";

    private static final String _ORDER_BY_ENTITY_ALIAS = "siAuditEntry.";

    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SIAuditEntry exists with the primary key ";

    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SIAuditEntry exists with the key {";

    private static final Log _log = LogFactoryUtil.getLog(SIAuditEntryPersistenceImpl.class);

    @Override
    protected FinderCache getFinderCache() {
        return finderCache;
    }
}
