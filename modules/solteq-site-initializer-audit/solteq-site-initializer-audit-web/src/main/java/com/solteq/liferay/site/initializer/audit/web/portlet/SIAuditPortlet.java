package com.solteq.liferay.site.initializer.audit.web.portlet;

import javax.portlet.Portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.solteq.liferay.site.initializer.audit.web.constants.SIAuditPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
        property = {
            "com.liferay.portlet.display-category=" + SIAuditPortletKeys.CATEGORY_NAME,
            "com.liferay.portlet.icon=/icons/audit.png",
            "com.liferay.portlet.instanceable=false",
            "javax.portlet.display-name=" + SIAuditPortletKeys.DISPLAY_NAME,
            "javax.portlet.expiration-cache=0",
            "javax.portlet.init-param.view-template=" + SIAuditPortletKeys.VIEW_JSP,
            "javax.portlet.name=" + SIAuditPortletKeys.PORTLET_ID,
            "javax.portlet.portlet-mode=text/html;",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=administrator",
            "com.liferay.portlet.header-portlet-css=/si-audit/css/main.css",
            "com.liferay.portlet.header-portlet-javascript=/si-audit/js/main.js",
            "com.liferay.portlet.css-class-wrapper=" + SIAuditPortletKeys.CSS_CLASS_WRAPPER,
            "javax.portlet.version=3.0"
        },
        service = {Portlet.class})
public class SIAuditPortlet extends MVCPortlet {}
