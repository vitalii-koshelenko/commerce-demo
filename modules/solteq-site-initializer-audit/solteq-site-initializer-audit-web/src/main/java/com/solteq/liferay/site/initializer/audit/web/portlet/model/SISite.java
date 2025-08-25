package com.solteq.liferay.site.initializer.audit.web.portlet.model;

public class SISite {

    private final long id;
    private final long groupId;
    private final String name;
    private final String friendlyURL;
    private final String siKey;
    private final String siteVersion;
    private final String siVersion;

    public SISite(
            long id,
            long groupId,
            String name,
            String friendlyURL,
            String siKey,
            String siteVersion,
            String siVersion) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.friendlyURL = friendlyURL;
        this.siKey = siKey;
        this.siteVersion = siteVersion;
        this.siVersion = siVersion;
    }

    public long getId() {
        return id;
    }

    public long getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public String getFriendlyURL() {
        return friendlyURL;
    }

    public String getSiKey() {
        return siKey;
    }

    public String getSiteVersion() {
        return siteVersion;
    }

    public String getSiVersion() {
        return siVersion;
    }
}
