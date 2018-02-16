
package com.example.android.news_application_with_tabs.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Layout {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("LastModifiedTime")
    @Expose
    private String lastModifiedTime;
    @SerializedName("Overrides")
    @Expose
    private List<Override> overrides = null;
    @SerializedName("Type")
    @Expose
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public List<Override> getOverrides() {
        return overrides;
    }

    public void setOverrides(List<Override> overrides) {
        this.overrides = overrides;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
