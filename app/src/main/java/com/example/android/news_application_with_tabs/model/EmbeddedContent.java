
package com.example.android.news_application_with_tabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmbeddedContent {

    @SerializedName("Index")
    @Expose
    private Integer index;
    @SerializedName("Items")
    @Expose
    private List<Item> items = null;
    @SerializedName("Layout")
    @Expose
    private List<Layout> layout = null;
    @SerializedName("Timestamped")
    @Expose
    private String timestamped;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Layout> getLayout() {
        return layout;
    }

    public void setLayout(List<Layout> layout) {
        this.layout = layout;
    }

    public String getTimestamped() {
        return timestamped;
    }

    public void setTimestamped(String timestamped) {
        this.timestamped = timestamped;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}

