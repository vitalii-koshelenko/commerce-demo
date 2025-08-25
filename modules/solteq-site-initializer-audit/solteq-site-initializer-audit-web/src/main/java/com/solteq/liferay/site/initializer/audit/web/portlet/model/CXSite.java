package com.solteq.liferay.site.initializer.audit.web.portlet.model;

import java.io.Serializable;

public class CXSite implements Serializable {

    private String externalReferenceCode;
    private String name;

    public String getExternalReferenceCode() {
        return externalReferenceCode;
    }

    public void setExternalReferenceCode(String externalReferenceCode) {
        this.externalReferenceCode = externalReferenceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
