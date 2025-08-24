package com.solteq.liferay.site.initializer.audit.web.panelapp;

import java.util.Locale;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;

import com.solteq.liferay.site.initializer.audit.web.constants.SIConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = {"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL, "panel.category.order:Integer=800"},
        service = PanelCategory.class)
public class SICategory extends BasePanelCategory {

    @Override
    public String getKey() {
        return SIConstants.CATEGORY_SI;
    }

    @Override
    public String getLabel(Locale locale) {
        return _language.get(locale, "category.si");
    }

    @Override
    public boolean isShow(PermissionChecker permissionChecker, Group group) {
        return PortalPermissionUtil.contains(permissionChecker, ActionKeys.VIEW_CONTROL_PANEL);
    }

    @Reference
    private Language _language;
}
