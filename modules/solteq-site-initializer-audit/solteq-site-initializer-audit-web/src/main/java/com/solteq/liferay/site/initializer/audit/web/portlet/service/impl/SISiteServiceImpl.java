package com.solteq.liferay.site.initializer.audit.web.portlet.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupTable;
import com.liferay.portal.kernel.service.GroupLocalService;

import com.solteq.liferay.site.initializer.audit.web.portlet.model.SISite;
import com.solteq.liferay.site.initializer.audit.web.portlet.service.SISiteService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = SISiteService.class)
public class SISiteServiceImpl implements SISiteService {

    public static final String SI_KEY = "siteInitializerKey";

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
                String siteVersion = "1.0.0"; // todo:
                String siVersion = "1.0.0"; // todo:
                SISite siSite = new SISite(siSiteId++, groupId, name, friendlyURL, siKey, siteVersion, siVersion);
                siSites.add(siSite);
            }
        } catch (Exception e) {
            _log.error("Error while getting sites: " + e.getMessage());
        }
        return siSites;
    }

    @Reference
    private GroupLocalService groupLocalService;

    private static final Log _log = LogFactoryUtil.getLog(SISiteServiceImpl.class);
}
