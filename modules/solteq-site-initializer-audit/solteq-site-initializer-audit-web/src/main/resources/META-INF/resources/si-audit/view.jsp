<%@include file="init.jsp" %>

<%
    SIAuditEntryLocalService auditService = (SIAuditEntryLocalService) request.getAttribute(SIAuditEntryLocalService.class.getName());
%>

<clay:container-fluid>
    <clay:sheet size="full">
        <clay:sheet-section>
            <liferay-ui:search-container total="<%= auditService.getSIAuditEntriesCount() %>"
                                         delta="10" emptyResultsMessage="no-si-audit-entries-found">
                <liferay-ui:search-container-results
                        results="<%= auditService.getAuditEntries(searchContainer.getStart(), searchContainer.getEnd())  %>"/>
                <liferay-ui:search-container-row className="com.solteq.liferay.site.initializer.audit.model.SIAuditEntry"
                                                 modelVar="siAuditEntry" keyProperty="siAuditEntryId">
                    <liferay-ui:search-container-column-text name="si-audit-entry.id" value="${siAuditEntry.siAuditEntryId}" />
                    <liferay-ui:search-container-column-text name="si-audit-entry.sync-date" value="${siAuditEntry.syncDateFormatted}"
                                                             cssClass="si-col-md" />
                    <liferay-ui:search-container-column-text name="si-audit-entry.site-name" value="${siAuditEntry.siteName}" />
                    <liferay-ui:search-container-column-text name="si-audit-entry.si-key" value="${siAuditEntry.siKey}" />
                    <liferay-ui:search-container-column-text name="si-audit-entry.user" value="${siAuditEntry.user}"
                                                             cssClass="si-col-md" />
                    <liferay-ui:search-container-column-text name="si-audit-entry.processing-time" value="${siAuditEntry.procesingTimeLabel}" />
                    <liferay-ui:search-container-column-text name="si-audit-entry.status">
                        <clay:badge label="${siAuditEntry.statusLabel}" cssClass="si-audit-badge"
                                    displayType="${siAuditEntry.displayType}"
                        />
                    </liferay-ui:search-container-column-text>
                    <liferay-ui:search-container-column-text name="si-audit-entry.message" value="${siAuditEntry.message}" />
                </liferay-ui:search-container-row>
                <liferay-ui:search-iterator markupView="lexicon" />
            </liferay-ui:search-container>
        </clay:sheet-section>
    </clay:sheet>
</clay:container-fluid>