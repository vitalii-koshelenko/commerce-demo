package com.solteq.liferay.site.initializer.audit.web.portlet.actions.manager;

import java.util.List;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import com.solteq.liferay.site.initializer.audit.web.constants.SIKeys;
import com.solteq.liferay.site.initializer.audit.web.constants.SIManagerPortletKeys;
import com.solteq.liferay.site.initializer.audit.web.portlet.model.SISite;
import com.solteq.liferay.site.initializer.audit.web.portlet.service.SISiteService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        property = {
            "javax.portlet.name=" + SIManagerPortletKeys.PORTLET_ID,
            "mvc.command.name=" + SIManagerPortletKeys.MVC_COMMAND_DEFAULT
        },
        service = MVCRenderCommand.class)
public class ViewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        List<SISite> siSites = siSiteService.getSISites();
        renderRequest.setAttribute(SIKeys.SI_SITES, siSites);
        return SIManagerPortletKeys.VIEW_JSP;
    }

    @Reference
    private SISiteService siSiteService;
}
