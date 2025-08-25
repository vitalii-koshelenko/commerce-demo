<%@include file="init.jsp" %>

<clay:container-fluid>
    <clay:sheet size="full">
        <clay:sheet-section>
            <div class="container-view lfr-search-container-wrapper">
                <div class="searchcontainer">
                    <div class="searchcontainer-content">
                        <div class="table-responsive">
                            <table class="show-quick-actions-on-hover table table-autofit table-head-bordered table-heading-nowrap table-hover table-list table-striped">
                                <thead>
                                    <tr>
                                        <th><liferay-ui:message key="si-site.id" /></th>
                                        <th><liferay-ui:message key="si-site.group-id" /></th>
                                        <th><liferay-ui:message key="si-site.site-name" /></th>
                                        <th><liferay-ui:message key="si-site.site-url" /></th>
                                        <th><liferay-ui:message key="si-site.si-key" /></th>
                                        <th><liferay-ui:message key="si-site.si-version" /></th>
                                        <th><liferay-ui:message key="si-site.deployed-version" /></th>
                                        <th><liferay-ui:message key="si-site.last-sync-date" /></th>
                                        <th><liferay-ui:message key="si-site.last-sync-status" /></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${siSites}" var="siSite">
                                        <tr>
                                            <td>${siSite.id}</td>
                                            <td>${siSite.groupId}</td>
                                            <td>${siSite.name}</td>
                                            <td>${siSite.friendlyURL}</td>
                                            <td>${siSite.siKey}</td>
                                            <td>${siSite.siteVersion}</td>
                                            <td>${siSite.siVersion}</td>
                                            <td>${siSite.lastSyncDate}</td>
                                            <td>
                                                <clay:badge label="${siSite.lastSyncStatus}" cssClass="si-manager-badge"
                                                            displayType="${siSite.lastSyncDisplayType}"
                                                />
                                                <liferay-ui:icon image="help" message="${siSite.lastSyncMessage}"  />
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </clay:sheet-section>
    </clay:sheet>
</clay:container-fluid>