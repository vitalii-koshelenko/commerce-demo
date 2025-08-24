package com.solteq.liferay.site.initializer.audit.web.portlet.actions;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import com.solteq.liferay.site.initializer.audit.service.SIAuditEntryLocalService;
import com.solteq.liferay.site.initializer.audit.web.constants.SIAuditPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = {
            "javax.portlet.name=" + SIAuditPortletKeys.PORTLET_ID,
            "mvc.command.name=" + SIAuditPortletKeys.MVC_COMMAND_DEFAULT
        },
        service = MVCRenderCommand.class)
public class ViewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        renderRequest.setAttribute(SIAuditEntryLocalService.class.getName(), siAuditEntryLocalService);
        return SIAuditPortletKeys.VIEW_JSP;
    }

    @Reference
    private SIAuditEntryLocalService siAuditEntryLocalService;
}
