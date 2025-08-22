package com.solteq.liferay.site.initializer.override;

import java.util.Set;

import com.liferay.account.service.*;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.link.service.AssetLinkLocalService;
import com.liferay.asset.list.service.AssetListEntryLocalService;
import com.liferay.client.extension.service.ClientExtensionEntryLocalService;
import com.liferay.client.extension.type.manager.CETManager;
import com.liferay.data.engine.rest.resource.v2_0.DataDefinitionResource;
import com.liferay.depot.service.DepotEntryGroupRelLocalService;
import com.liferay.depot.service.DepotEntryLocalService;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalService;
import com.liferay.document.library.util.DLURLHelper;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.dynamic.data.mapping.util.DefaultDDMStructureHelper;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.fragment.importer.FragmentsImporter;
import com.liferay.fragment.service.FragmentEntryLinkLocalService;
import com.liferay.headless.admin.list.type.resource.v1_0.ListTypeDefinitionResource;
import com.liferay.headless.admin.list.type.resource.v1_0.ListTypeEntryResource;
import com.liferay.headless.admin.taxonomy.resource.v1_0.KeywordResource;
import com.liferay.headless.admin.taxonomy.resource.v1_0.TaxonomyCategoryResource;
import com.liferay.headless.admin.taxonomy.resource.v1_0.TaxonomyVocabularyResource;
import com.liferay.headless.admin.user.resource.v1_0.AccountResource;
import com.liferay.headless.admin.user.resource.v1_0.AccountRoleResource;
import com.liferay.headless.admin.user.resource.v1_0.OrganizationResource;
import com.liferay.headless.admin.user.resource.v1_0.UserAccountResource;
import com.liferay.headless.admin.workflow.resource.v1_0.WorkflowDefinitionResource;
import com.liferay.headless.delivery.resource.v1_0.*;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.layout.importer.LayoutsImporter;
import com.liferay.layout.page.template.service.LayoutPageTemplateEntryLocalService;
import com.liferay.layout.page.template.service.LayoutPageTemplateStructureLocalService;
import com.liferay.layout.page.template.service.LayoutPageTemplateStructureRelLocalService;
import com.liferay.layout.utility.page.service.LayoutUtilityPageEntryLocalService;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.notification.rest.resource.v1_0.NotificationTemplateResource;
import com.liferay.object.admin.rest.resource.v1_0.ObjectDefinitionResource;
import com.liferay.object.admin.rest.resource.v1_0.ObjectFieldResource;
import com.liferay.object.admin.rest.resource.v1_0.ObjectFolderResource;
import com.liferay.object.admin.rest.resource.v1_0.ObjectRelationshipResource;
import com.liferay.object.rest.manager.v1_0.ObjectEntryManager;
import com.liferay.object.service.*;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.settings.ArchivedSettingsFactory;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.zip.ZipWriterFactory;
import com.liferay.portal.language.override.service.PLOEntryLocalService;
import com.liferay.portal.security.service.access.policy.service.SAPEntryLocalService;
import com.liferay.portal.servlet.filters.threadlocal.ThreadLocalFilterThreadLocal;
import com.liferay.segments.service.SegmentsEntryLocalService;
import com.liferay.segments.service.SegmentsExperienceLocalService;
import com.liferay.site.configuration.manager.MenuAccessConfigurationManager;
import com.liferay.site.exception.InitializationException;
import com.liferay.site.navigation.service.SiteNavigationMenuItemLocalService;
import com.liferay.site.navigation.service.SiteNavigationMenuLocalService;
import com.liferay.site.navigation.type.SiteNavigationMenuItemTypeRegistry;
import com.liferay.style.book.zip.processor.StyleBookEntryZipProcessor;
import com.liferay.template.service.TemplateEntryLocalService;

import com.solteq.liferay.site.initializer.audit.service.SIAuditEntryLocalService;
import com.solteq.liferay.site.initializer.override.util.ExceptionUtil;

import org.osgi.framework.Bundle;

public class SolteqBundleSiteInitializer extends AbstractBundleSiteInitializer {

    public SolteqBundleSiteInitializer(
            SIAuditEntryLocalService siAuditEntryLocalService,
            AccountEntryLocalService accountEntryLocalService,
            AccountEntryOrganizationRelLocalService accountEntryOrganizationRelLocalService,
            AccountGroupLocalService accountGroupLocalService,
            AccountGroupRelService accountGroupRelService,
            AccountResource.Factory accountResourceFactory,
            AccountRoleLocalService accountRoleLocalService,
            AccountRoleResource.Factory accountRoleResourceFactory,
            ArchivedSettingsFactory archivedSettingsFactory,
            AssetCategoryLocalService assetCategoryLocalService,
            AssetEntryLocalService assetEntryLocalService,
            AssetLinkLocalService assetLinkLocalService,
            AssetListEntryLocalService assetListEntryLocalService,
            BlogPostingResource.Factory blogPostingResourceFactory,
            CETManager cetManager,
            ClientExtensionEntryLocalService clientExtensionEntryLocalService,
            CompanyLocalService companyLocalService,
            ConfigurationProvider configurationProvider,
            DataDefinitionResource.Factory dataDefinitionResourceFactory,
            DDMStructureLocalService ddmStructureLocalService,
            DDMTemplateLocalService ddmTemplateLocalService,
            DefaultDDMStructureHelper defaultDDMStructureHelper,
            DepotEntryGroupRelLocalService depotEntryGroupRelLocalService,
            DepotEntryLocalService depotEntryLocalService,
            DLFileEntryTypeLocalService dlFileEntryTypeLocalService,
            DLURLHelper dlURLHelper,
            DocumentFolderResource.Factory documentFolderResourceFactory,
            DocumentResource.Factory documentResourceFactory,
            ExpandoValueLocalService expandoValueLocalService,
            FragmentEntryLinkLocalService fragmentEntryLinkLocalService,
            FragmentsImporter fragmentsImporter,
            GroupLocalService groupLocalService,
            JournalArticleLocalService journalArticleLocalService,
            JSONFactory jsonFactory,
            KeywordResource.Factory keywordResourceFactory,
            KnowledgeBaseArticleResource.Factory knowledgeBaseArticleResourceFactory,
            KnowledgeBaseFolderResource.Factory knowledgeBaseFolderResourceFactory,
            LayoutLocalService layoutLocalService,
            LayoutPageTemplateEntryLocalService layoutPageTemplateEntryLocalService,
            LayoutsImporter layoutsImporter,
            LayoutPageTemplateStructureLocalService layoutPageTemplateStructureLocalService,
            LayoutPageTemplateStructureRelLocalService layoutPageTemplateStructureRelLocalService,
            LayoutSetLocalService layoutSetLocalService,
            LayoutUtilityPageEntryLocalService layoutUtilityPageEntryLocalService,
            ListTypeDefinitionResource listTypeDefinitionResource,
            ListTypeDefinitionResource.Factory listTypeDefinitionResourceFactory,
            ListTypeEntryLocalService listTypeEntryLocalService,
            ListTypeEntryResource listTypeEntryResource,
            ListTypeEntryResource.Factory listTypeEntryResourceFactory,
            MenuAccessConfigurationManager menuAccessConfigurationManager,
            NotificationTemplateResource.Factory notificationTemplateResourceFactory,
            ObjectActionLocalService objectActionLocalService,
            ObjectDefinitionLocalService objectDefinitionLocalService,
            ObjectDefinitionResource.Factory objectDefinitionResourceFactory,
            ObjectEntryLocalService objectEntryLocalService,
            ObjectEntryManager objectEntryManager,
            ObjectFieldLocalService objectFieldLocalService,
            ObjectFieldResource.Factory objectFieldResourceFactory,
            ObjectFolderResource.Factory objectFolderResourceFactory,
            ObjectRelationshipLocalService objectRelationshipLocalService,
            ObjectRelationshipResource.Factory objectRelationshipResourceFactory,
            OrganizationLocalService organizationLocalService,
            OrganizationResource.Factory organizationResourceFactory,
            PLOEntryLocalService ploEntryLocalService,
            Portal portal,
            ResourceActionLocalService resourceActionLocalService,
            ResourcePermissionLocalService resourcePermissionLocalService,
            RoleLocalService roleLocalService,
            SAPEntryLocalService sapEntryLocalService,
            SegmentsEntryLocalService segmentsEntryLocalService,
            SegmentsExperienceLocalService segmentsExperienceLocalService,
            Bundle siteBundle,
            Bundle siteInitializerExtenderBundle,
            SiteNavigationMenuItemLocalService siteNavigationMenuItemLocalService,
            SiteNavigationMenuItemTypeRegistry siteNavigationMenuItemTypeRegistry,
            SiteNavigationMenuLocalService siteNavigationMenuLocalService,
            StructuredContentFolderResource.Factory structuredContentFolderResourceFactory,
            StyleBookEntryZipProcessor styleBookEntryZipProcessor,
            TaxonomyCategoryResource.Factory taxonomyCategoryResourceFactory,
            TaxonomyVocabularyResource.Factory taxonomyVocabularyResourceFactory,
            TemplateEntryLocalService templateEntryLocalService,
            ThemeLocalService themeLocalService,
            UserAccountResource.Factory userAccountResourceFactory,
            UserGroupLocalService userGroupLocalService,
            UserLocalService userLocalService,
            WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService,
            WorkflowDefinitionResource.Factory workflowDefinitionResourceFactory,
            ZipWriterFactory zipWriterFactory) {
        super(
                accountEntryLocalService,
                accountEntryOrganizationRelLocalService,
                accountGroupLocalService,
                accountGroupRelService,
                accountResourceFactory,
                accountRoleLocalService,
                accountRoleResourceFactory,
                archivedSettingsFactory,
                assetCategoryLocalService,
                assetEntryLocalService,
                assetLinkLocalService,
                assetListEntryLocalService,
                blogPostingResourceFactory,
                cetManager,
                clientExtensionEntryLocalService,
                companyLocalService,
                configurationProvider,
                dataDefinitionResourceFactory,
                ddmStructureLocalService,
                ddmTemplateLocalService,
                defaultDDMStructureHelper,
                depotEntryGroupRelLocalService,
                depotEntryLocalService,
                dlFileEntryTypeLocalService,
                dlURLHelper,
                documentFolderResourceFactory,
                documentResourceFactory,
                expandoValueLocalService,
                fragmentEntryLinkLocalService,
                fragmentsImporter,
                groupLocalService,
                journalArticleLocalService,
                jsonFactory,
                keywordResourceFactory,
                knowledgeBaseArticleResourceFactory,
                knowledgeBaseFolderResourceFactory,
                layoutLocalService,
                layoutPageTemplateEntryLocalService,
                layoutsImporter,
                layoutPageTemplateStructureLocalService,
                layoutPageTemplateStructureRelLocalService,
                layoutSetLocalService,
                layoutUtilityPageEntryLocalService,
                listTypeDefinitionResource,
                listTypeDefinitionResourceFactory,
                listTypeEntryLocalService,
                listTypeEntryResource,
                listTypeEntryResourceFactory,
                menuAccessConfigurationManager,
                notificationTemplateResourceFactory,
                objectActionLocalService,
                objectDefinitionLocalService,
                objectDefinitionResourceFactory,
                objectEntryLocalService,
                objectEntryManager,
                objectFieldLocalService,
                objectFieldResourceFactory,
                objectFolderResourceFactory,
                objectRelationshipLocalService,
                objectRelationshipResourceFactory,
                organizationLocalService,
                organizationResourceFactory,
                ploEntryLocalService,
                portal,
                resourceActionLocalService,
                resourcePermissionLocalService,
                roleLocalService,
                sapEntryLocalService,
                segmentsEntryLocalService,
                segmentsExperienceLocalService,
                siteBundle,
                siteInitializerExtenderBundle,
                siteNavigationMenuItemLocalService,
                siteNavigationMenuItemTypeRegistry,
                siteNavigationMenuLocalService,
                structuredContentFolderResourceFactory,
                styleBookEntryZipProcessor,
                taxonomyCategoryResourceFactory,
                taxonomyVocabularyResourceFactory,
                templateEntryLocalService,
                themeLocalService,
                userAccountResourceFactory,
                userGroupLocalService,
                userLocalService,
                workflowDefinitionLinkLocalService,
                workflowDefinitionResourceFactory,
                zipWriterFactory);
        this._siAuditEntryLocalService = siAuditEntryLocalService;
    }

    private final SIAuditEntryLocalService _siAuditEntryLocalService;

    @Override
    public void initialize(long groupId) throws InitializationException {
        if (_log.isDebugEnabled()) {
            _log.debug("Commerce site initializer " + _commerceSiteInitializerSnapshot.get());
            _log.debug("OSB site initializer " + _osbSiteInitializerSnapshot.get());
        }

        if (ThreadLocalFilterThreadLocal.isFilterInvoked()) {
            Set<String> initializedGroupIdAndKeys = _initializedGroupIdAndKeys.get();
            if (!initializedGroupIdAndKeys.add(StringBundler.concat(groupId, StringPool.POUND, getKey()))) {
                if (_log.isDebugEnabled()) {
                    _log.debug(StringBundler.concat("Skip already initialized ", getKey(), " for group ", groupId));
                }
                return;
            }
        }

        long startTime = System.currentTimeMillis();

        if (_log.isInfoEnabled()) {
            _log.info(StringBundler.concat("Initializing ", getKey(), " for group ", groupId));
        }

        try {
            _initialize(groupId);
            // Save Audit Entry
            long processingTime = System.currentTimeMillis() - startTime;
            String successMessage =
                    String.format("Initialized '%s' for group '%s' in %d ms", getKey(), groupId, processingTime);
            _siAuditEntryLocalService.saveSuccessAuditEntry(groupId, getKey(), processingTime, successMessage);
            _log.info(successMessage);
        } catch (Exception exception) {
            // Save Audit Entry
            long processingTime = System.currentTimeMillis() - startTime;
            String errorMsg = ExceptionUtil.parseException(exception);
            _siAuditEntryLocalService.saveFailedAuditEntry(groupId, getKey(), processingTime, errorMsg);
            _log.error(exception);
            throw new InitializationException(exception);
        } finally {
            ServiceContextThreadLocal.popServiceContext();
        }
    }

    protected static final Log _log = LogFactoryUtil.getLog(SolteqBundleSiteInitializer.class);
}
