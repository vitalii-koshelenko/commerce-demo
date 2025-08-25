package com.solteq.liferay.site.initializer.audit.web.panelapp;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import com.solteq.liferay.site.initializer.audit.web.constants.SIConstants;
import com.solteq.liferay.site.initializer.audit.web.constants.SIManagerPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
            "panel.app.order:Integer=100",
            "panel.category.key=" + SIConstants.CATEGORY_SI,
            "service.ranking:Integer=1"
        },
        service = {PanelApp.class})
public class SIManagerPanelApp extends BasePanelApp {

    @Override
    public Portlet getPortlet() {
        return portlet;
    }

    @Override
    public String getPortletId() {
        return SIManagerPortletKeys.PORTLET_ID;
    }

    @Reference(target = "(javax.portlet.name=" + SIManagerPortletKeys.PORTLET_ID + ")")
    private Portlet portlet;
}
