
package com.example.android.news_application_with_tabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Path")
    @Expose
    private String path;
    @SerializedName("ProductAffiliateCode")
    @Expose
    private String productAffiliateCode;
    @SerializedName("SectionAdZone")
    @Expose
    private String sectionAdZone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProductAffiliateCode() {
        return productAffiliateCode;
    }

    public void setProductAffiliateCode(String productAffiliateCode) {
        this.productAffiliateCode = productAffiliateCode;
    }

    public String getSectionAdZone() {
        return sectionAdZone;
    }

    public void setSectionAdZone(String sectionAdZone) {
        this.sectionAdZone = sectionAdZone;
    }

}
