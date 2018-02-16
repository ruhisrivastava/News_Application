
package com.example.android.news_application_with_tabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainData {

    @SerializedName("Index")
    @Expose
    private Integer index;
    @SerializedName("Items")
    @Expose
    private List<Item> items = null;
    @SerializedName("LastModifiedTime")
    @Expose
    private String lastModifiedTime;
    @SerializedName("Layout")
    @Expose
    private List<Layout> layout = null;
    @SerializedName("TimeStamped")
    @Expose
    private String timeStamped;
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
        if(items != null) {
            for (Item item : items) {
                item.setBody();
            }
        }
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public List<Layout> getLayout() {
        return layout;
    }

    public void setLayout(List<Layout> layout) {
        this.layout = layout;
    }

    public String getTimeStamped() {
        return timeStamped;
    }

    public void setTimeStamped(String timeStamped) {
        this.timeStamped = timeStamped;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}
