package com.solteq.liferay.site.initializer.override;

import java.io.File;
import java.util.Arrays;
import javax.servlet.ServletContext;

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
import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.settings.ArchivedSettingsFactory;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.zip.ZipWriterFactory;
import com.liferay.portal.language.override.service.PLOEntryLocalService;
import com.liferay.portal.security.service.access.policy.service.SAPEntryLocalService;
import com.liferay.segments.service.SegmentsEntryLocalService;
import com.liferay.segments.service.SegmentsExperienceLocalService;
import com.liferay.site.configuration.manager.MenuAccessConfigurationManager;
import com.liferay.site.initializer.SiteInitializer;
import com.liferay.site.initializer.SiteInitializerFactory;
import com.liferay.site.navigation.service.SiteNavigationMenuItemLocalService;
import com.liferay.site.navigation.service.SiteNavigationMenuLocalService;
import com.liferay.site.navigation.type.SiteNavigationMenuItemTypeRegistry;
import com.liferay.style.book.zip.processor.StyleBookEntryZipProcessor;
import com.liferay.template.service.TemplateEntryLocalService;

import com.solteq.liferay.site.initializer.audit.service.SIAuditEntryLocalService;
import com.solteq.liferay.site.initializer.override.util.FileBackedBundleDelegate;
import com.solteq.liferay.site.initializer.override.util.FileBackedServletContextDelegate;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.runtime.ServiceComponentRuntime;
import org.osgi.service.component.runtime.dto.ComponentDescriptionDTO;

@Component(service = SiteInitializerFactory.class)
public class SolteqSiteInitializerFactoryImpl implements SiteInitializerFactory {

    // ------------------------------- <Components Blacklist> ----------------------------------------------------------
    private ComponentDescriptionDTO componentDescriptionDTO;

    public static final String BUNDLE_NAME = "com.liferay.site.initializer.extender";
    public static final String COMPONENT_NAME =
            "com.liferay.site.initializer.extender.internal.SiteInitializerFactoryImpl";

    @Activate
    public void activate(BundleContext bundleContext) {
        _bundleContext = bundleContext;
        // Disable the original FileBackedThumbnailServlet when registering a custom one
        try {
            Bundle[] bundles = bundleContext.getBundles();
            Bundle targetBundle = Arrays.stream(bundles)
                    .filter(bnd -> BUNDLE_NAME.equals(bnd.getSymbolicName()))
                    .findFirst()
                    .orElse(null);
            componentDescriptionDTO = serviceComponentRuntime.getComponentDescriptionDTO(targetBundle, COMPONENT_NAME);
            serviceComponentRuntime.disableComponent(componentDescriptionDTO);
            _log.info(String.format("Component '%s' disabled", COMPONENT_NAME));
        } catch (Exception e) {
            _log.error(String.format("Unable to disable component %s, cause:  %s", COMPONENT_NAME, e.getMessage()));
        }
    }

    @Deactivate
    public void deactivate(BundleContext bundleContext) {
        // Enable the original FileBackedThumbnailServlet when unregistering a custom one
        try {
            serviceComponentRuntime.enableComponent(componentDescriptionDTO);
            _log.info(String.format("Component '%s' enabled", COMPONENT_NAME));
        } catch (Exception e) {
            _log.error(String.format("Unable to enable component %s, cause:  %s", COMPONENT_NAME, e.getMessage()));
        }
    }

    @Reference
    private ServiceComponentRuntime serviceComponentRuntime;
    // ------------------------------- </Components Blacklist> ---------------------------------------------------------

    @Override
    public SiteInitializer create(File file, String symbolicName) throws Exception {

        _log.info("SolteqSiteInitializerFactoryImpl: creating site initializer for bundle: " + symbolicName);

        String fileKey = StringUtil.randomString(16);

        if (symbolicName == null) {
            symbolicName = "Liferay Site Initializer - File - " + fileKey;
        }

        Bundle siteBundle = ProxyUtil.newDelegateProxyInstance(
                Bundle.class.getClassLoader(),
                Bundle.class,
                new FileBackedBundleDelegate(_bundleContext, file, _jsonFactory, symbolicName),
                null);

        SolteqBundleSiteInitializer bundleSiteInitializer = new SolteqBundleSiteInitializer(
                siAuditEntryLocalService,
                _accountEntryLocalService,
                _accountEntryOrganizationRelLocalService,
                _accountGroupLocalService,
                _accountGroupRelService,
                _accountResourceFactory,
                _accountRoleLocalService,
                _accountRoleResourceFactory,
                _archivedSettingsFactory,
                _assetCategoryLocalService,
                _assetEntryLocalService,
                _assetLinkLocalService,
                _assetListEntryLocalService,
                _blogPostingResourceFactory,
                _cetManager,
                _clientExtensionEntryLocalService,
                _companyLocalService,
                _configurationProvider,
                _dataDefinitionResourceFactory,
                _ddmStructureLocalService,
                _ddmTemplateLocalService,
                _defaultDDMStructureHelper,
                _depotEntryGroupRelLocalService,
                _depotEntryLocalService,
                _dlFileEntryTypeLocalService,
                _dlURLHelper,
                _documentFolderResourceFactory,
                _documentResourceFactory,
                _expandoValueLocalService,
                _fragmentEntryLinkLocalService,
                _fragmentsImporter,
                _groupLocalService,
                _journalArticleLocalService,
                _jsonFactory,
                _keywordResourceFactory,
                _knowledgeBaseArticleResourceFactory,
                _knowledgeBaseFolderResourceFactory,
                _layoutLocalService,
                _layoutPageTemplateEntryLocalService,
                _layoutsImporter,
                _layoutPageTemplateStructureLocalService,
                _layoutPageTemplateStructureRelLocalService,
                _layoutSetLocalService,
                _layoutUtilityPageEntryLocalService,
                _listTypeDefinitionResource,
                _listTypeDefinitionResourceFactory,
                _listTypeEntryLocalService,
                _listTypeEntryResource,
                _listTypeEntryResourceFactory,
                _menuAccessConfigurationManager,
                _notificationTemplateResourceFactory,
                _objectActionLocalService,
                _objectDefinitionLocalService,
                _objectDefinitionResourceFactory,
                _objectEntryLocalService,
                _objectEntryManager,
                _objectFieldLocalService,
                _objectFieldResourceFactory,
                _objectfolderResourceFactory,
                _objectRelationshipLocalService,
                _objectRelationshipResourceFactory,
                _organizationLocalService,
                _organizationResourceFactory,
                _ploEntryLocalService,
                _portal,
                _resourceActionLocalService,
                _resourcePermissionLocalService,
                _roleLocalService,
                _sapEntryLocalService,
                _segmentsEntryLocalService,
                _segmentsExperienceLocalService,
                siteBundle,
                _bundleContext.getBundle(),
                _siteNavigationMenuItemLocalService,
                _siteNavigationMenuItemTypeRegistry,
                _siteNavigationMenuLocalService,
                _structuredContentFolderResourceFactory,
                _styleBookEntryZipProcessor,
                _taxonomyCategoryResourceFactory,
                _taxonomyVocabularyResourceFactory,
                _templateEntryLocalService,
                _themeLocalService,
                _userAccountResourceFactory,
                _userGroupLocalService,
                _userLocalService,
                _workflowDefinitionLinkLocalService,
                _workflowDefinitionResourceFactory,
                _zipWriterFactory);

        bundleSiteInitializer.setServletContext(ProxyUtil.newDelegateProxyInstance(
                ServletContext.class.getClassLoader(),
                ServletContext.class,
                new FileBackedServletContextDelegate(file, fileKey, symbolicName),
                null));

        return bundleSiteInitializer;
    }

    @Reference
    private SIAuditEntryLocalService siAuditEntryLocalService;

    @Reference
    private AccountEntryLocalService _accountEntryLocalService;

    @Reference
    private AccountEntryOrganizationRelLocalService _accountEntryOrganizationRelLocalService;

    @Reference
    private AccountGroupLocalService _accountGroupLocalService;

    @Reference
    private AccountGroupRelService _accountGroupRelService;

    @Reference
    private AccountResource.Factory _accountResourceFactory;

    @Reference
    private AccountRoleLocalService _accountRoleLocalService;

    @Reference
    private AccountRoleResource.Factory _accountRoleResourceFactory;

    @Reference
    private ArchivedSettingsFactory _archivedSettingsFactory;

    @Reference
    private AssetCategoryLocalService _assetCategoryLocalService;

    @Reference
    private AssetEntryLocalService _assetEntryLocalService;

    @Reference
    private AssetLinkLocalService _assetLinkLocalService;

    @Reference
    private AssetListEntryLocalService _assetListEntryLocalService;

    @Reference
    private BlogPostingResource.Factory _blogPostingResourceFactory;

    private BundleContext _bundleContext;

    @Reference
    private CETManager _cetManager;

    @Reference
    private ClientExtensionEntryLocalService _clientExtensionEntryLocalService;

    @Reference
    private CompanyLocalService _companyLocalService;

    @Reference
    private ConfigurationProvider _configurationProvider;

    @Reference
    private DataDefinitionResource.Factory _dataDefinitionResourceFactory;

    @Reference
    private DDMStructureLocalService _ddmStructureLocalService;

    @Reference
    private DDMTemplateLocalService _ddmTemplateLocalService;

    @Reference
    private DefaultDDMStructureHelper _defaultDDMStructureHelper;

    @Reference
    private DepotEntryGroupRelLocalService _depotEntryGroupRelLocalService;

    @Reference
    private DepotEntryLocalService _depotEntryLocalService;

    @Reference
    private DLFileEntryTypeLocalService _dlFileEntryTypeLocalService;

    @Reference
    private DLURLHelper _dlURLHelper;

    @Reference
    private DocumentFolderResource.Factory _documentFolderResourceFactory;

    @Reference
    private DocumentResource.Factory _documentResourceFactory;

    @Reference
    private ExpandoValueLocalService _expandoValueLocalService;

    @Reference
    private FragmentEntryLinkLocalService _fragmentEntryLinkLocalService;

    @Reference
    private FragmentsImporter _fragmentsImporter;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;

    @Reference
    private JSONFactory _jsonFactory;

    @Reference
    private KeywordResource.Factory _keywordResourceFactory;

    @Reference
    private KnowledgeBaseArticleResource.Factory _knowledgeBaseArticleResourceFactory;

    @Reference
    private KnowledgeBaseFolderResource.Factory _knowledgeBaseFolderResourceFactory;

    @Reference
    private LayoutLocalService _layoutLocalService;

    @Reference
    private LayoutPageTemplateEntryLocalService _layoutPageTemplateEntryLocalService;

    @Reference
    private LayoutPageTemplateStructureLocalService _layoutPageTemplateStructureLocalService;

    @Reference
    private LayoutPageTemplateStructureRelLocalService _layoutPageTemplateStructureRelLocalService;

    @Reference
    private LayoutSetLocalService _layoutSetLocalService;

    @Reference
    private LayoutsImporter _layoutsImporter;

    @Reference
    private LayoutUtilityPageEntryLocalService _layoutUtilityPageEntryLocalService;

    @Reference
    private ListTypeDefinitionResource _listTypeDefinitionResource;

    @Reference
    private ListTypeDefinitionResource.Factory _listTypeDefinitionResourceFactory;

    @Reference
    private ListTypeEntryLocalService _listTypeEntryLocalService;

    @Reference
    private ListTypeEntryResource _listTypeEntryResource;

    @Reference
    private ListTypeEntryResource.Factory _listTypeEntryResourceFactory;

    @Reference
    private MenuAccessConfigurationManager _menuAccessConfigurationManager;

    @Reference
    private NotificationTemplateResource.Factory _notificationTemplateResourceFactory;

    @Reference
    private ObjectActionLocalService _objectActionLocalService;

    @Reference
    private ObjectDefinitionLocalService _objectDefinitionLocalService;

    @Reference
    private ObjectDefinitionResource.Factory _objectDefinitionResourceFactory;

    @Reference
    private ObjectEntryLocalService _objectEntryLocalService;

    @Reference(target = "(object.entry.manager.storage.type=default)")
    private ObjectEntryManager _objectEntryManager;

    @Reference
    private ObjectFieldLocalService _objectFieldLocalService;

    @Reference
    private ObjectFieldResource.Factory _objectFieldResourceFactory;

    @Reference
    private ObjectFolderResource.Factory _objectfolderResourceFactory;

    @Reference
    private ObjectRelationshipLocalService _objectRelationshipLocalService;

    @Reference
    private ObjectRelationshipResource.Factory _objectRelationshipResourceFactory;

    @Reference
    private OrganizationLocalService _organizationLocalService;

    @Reference
    private OrganizationResource.Factory _organizationResourceFactory;

    @Reference
    private PLOEntryLocalService _ploEntryLocalService;

    @Reference
    private Portal _portal;

    @Reference
    private ResourceActionLocalService _resourceActionLocalService;

    @Reference
    private ResourcePermissionLocalService _resourcePermissionLocalService;

    @Reference
    private RoleLocalService _roleLocalService;

    @Reference
    private SAPEntryLocalService _sapEntryLocalService;

    @Reference
    private SegmentsEntryLocalService _segmentsEntryLocalService;

    @Reference
    private SegmentsExperienceLocalService _segmentsExperienceLocalService;

    @Reference
    private SiteNavigationMenuItemLocalService _siteNavigationMenuItemLocalService;

    @Reference
    private SiteNavigationMenuItemTypeRegistry _siteNavigationMenuItemTypeRegistry;

    @Reference
    private SiteNavigationMenuLocalService _siteNavigationMenuLocalService;

    @Reference
    private StructuredContentFolderResource.Factory _structuredContentFolderResourceFactory;

    @Reference
    private StyleBookEntryZipProcessor _styleBookEntryZipProcessor;

    @Reference
    private TaxonomyCategoryResource.Factory _taxonomyCategoryResourceFactory;

    @Reference
    private TaxonomyVocabularyResource.Factory _taxonomyVocabularyResourceFactory;

    @Reference
    private TemplateEntryLocalService _templateEntryLocalService;

    @Reference
    private ThemeLocalService _themeLocalService;

    @Reference
    private UserAccountResource.Factory _userAccountResourceFactory;

    @Reference
    private UserGroupLocalService _userGroupLocalService;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private WorkflowDefinitionLinkLocalService _workflowDefinitionLinkLocalService;

    @Reference
    private WorkflowDefinitionResource.Factory _workflowDefinitionResourceFactory;

    @Reference
    private ZipWriterFactory _zipWriterFactory;

    private static final Log _log = LogFactoryUtil.getLog(SolteqSiteInitializerFactoryImpl.class);
}
