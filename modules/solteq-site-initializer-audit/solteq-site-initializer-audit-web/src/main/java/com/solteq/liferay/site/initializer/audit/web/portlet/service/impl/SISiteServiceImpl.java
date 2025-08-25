package com.solteq.liferay.site.initializer.audit.web.portlet.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupTable;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.URLUtil;

import com.solteq.liferay.site.initializer.audit.model.SIAuditEntry;
import com.solteq.liferay.site.initializer.audit.service.SIAuditEntryLocalService;
import com.solteq.liferay.site.initializer.audit.web.portlet.model.CXSite;
import com.solteq.liferay.site.initializer.audit.web.portlet.model.SISite;
import com.solteq.liferay.site.initializer.audit.web.portlet.service.SISiteService;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = SISiteService.class)
public class SISiteServiceImpl implements SISiteService {

    public static final String SI_KEY = "siteInitializerKey";
    public static final String BUNDLE_TIMESTAMP = "bundleTimestamp";

    private BundleContext _bundleContext;

    @Activate
    protected void activate(BundleContext bundleContext) {
        _bundleContext = bundleContext;
    }

    @Override
    public List<SISite> getSISites() {
        List<SISite> siSites = new ArrayList<>();
        try {
            // Fetch sites initialized with Site Initializers
            DynamicQuery dynamicQuery = groupLocalService.dynamicQuery();
            dynamicQuery.add(
                    RestrictionsFactoryUtil.like(GroupTable.INSTANCE.typeSettings.getName(), "%" + SI_KEY + "%"));
            List<Group> siGroups = groupLocalService.dynamicQuery(dynamicQuery);
            // Convert to SISite models
            long siSiteId = 1;
            for (Group siGroup : siGroups) {
                long groupId = siGroup.getGroupId();
                String name = siGroup.getName();
                String friendlyURL = siGroup.getFriendlyURL();
                String siKey = siGroup.getTypeSettingsProperty(SI_KEY);
                String siteVersion = siGroup.getTypeSettingsProperty(BUNDLE_TIMESTAMP);
                String siVersion = getBundleVersion(siKey);
                String lastSyncDate = StringPool.BLANK;
                String lastSyncStatus = StringPool.BLANK;
                String lastSyncDisplayType = "info";
                String lastSyncMessage = StringPool.BLANK;
                SIAuditEntry siSyncAuditEntry = getSISyncAuditEntry(groupId);
                if (siSyncAuditEntry != null) {
                    lastSyncDate = siSyncAuditEntry.getSyncDateFormatted();
                    lastSyncStatus = siSyncAuditEntry.getStatusLabel();
                    lastSyncDisplayType = siSyncAuditEntry.getDisplayType();
                    lastSyncMessage = siSyncAuditEntry.getMessage();
                }
                SISite siSite = new SISite(
                        siSiteId++,
                        groupId,
                        name,
                        friendlyURL,
                        siKey,
                        siteVersion,
                        siVersion,
                        lastSyncDate,
                        lastSyncStatus,
                        lastSyncDisplayType,
                        lastSyncMessage);
                siSites.add(siSite);
            }
            siSites.sort((o1, o2) -> Long.compare(o2.getSiteVersionTimestamp(), o1.getSiteVersionTimestamp()));
        } catch (Exception e) {
            _log.error("Error while getting sites: " + e.getMessage());
        }
        return siSites;
    }

    private SIAuditEntry getSISyncAuditEntry(long groupId) {
        List<SIAuditEntry> siteAuditEntries = siAuditEntryLocalService.getSiteAuditEntries(groupId);
        return ListUtil.isNotEmpty(siteAuditEntries) ? siteAuditEntries.get(0) : null;
    }

    private String getBundleVersion(String siKey) {
        String bundleVersion = StringPool.BLANK;
        try {
            Bundle[] bundles = _bundleContext.getBundles();
            // Filter bundles by Symbolic Name
            Bundle targetBundle = Arrays.stream(bundles)
                    .filter(bnd -> siKey.equals(bnd.getSymbolicName()))
                    .findFirst()
                    .orElse(null);
            if (targetBundle == null) {
                // For CX Site Initializers we need to filter bundles by site name
                targetBundle = getCXBundle(bundles, siKey);
            }
            if (targetBundle != null) {
                bundleVersion = String.valueOf(targetBundle.getLastModified());
            }
        } catch (Exception e) {
            _log.error(
                    String.format("Failed to get bundle version for bundle '%s', cause: %s.", siKey, e.getMessage()));
        }
        return bundleVersion;
    }

    private Bundle getCXBundle(Bundle[] bundles, String siteName) {
        return Arrays.stream(bundles)
                .filter(bundle -> {
                    try {
                        String cxSiteJSON = URLUtil.toString(bundle.getEntry("site-initializer/site-initializer.json"));
                        CXSite siSite = JSONFactoryUtil.looseDeserialize(cxSiteJSON, CXSite.class);
                        String cxSiteName = siSite.getName();
                        return StringUtil.equals(cxSiteName, siteName);
                    } catch (Exception e) {
                        return false;
                    }
                })
                .findFirst()
                .orElse(null);
    }

    @Reference
    private GroupLocalService groupLocalService;

    @Reference
    private SIAuditEntryLocalService siAuditEntryLocalService;

    private static final Log _log = LogFactoryUtil.getLog(SISiteServiceImpl.class);
}
