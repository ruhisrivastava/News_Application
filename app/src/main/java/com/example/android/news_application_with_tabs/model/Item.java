
package com.example.android.news_application_with_tabs.model;

import android.os.Parcel;
import android.os.Parcelable;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.*;
import java.lang.Override;
import java.util.List;

public class Item implements Parcelable{

    public static final String BODY_KEY = "Body";

    private String body;

    @SerializedName("ChildContent")
    @Expose
    private ChildContent childContent;
    @SerializedName("ChildContentCount")
    @Expose
    private Integer childContentCount;
    @SerializedName("Credit")
    @Expose
    private String credit;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("DisplayTime")
    @Expose
    private String displayTime;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("LastModified")
    @Expose
    private String lastModified;
    @SerializedName("LastUpdateTime")
    @Expose
    private String lastUpdateTime;
    @SerializedName("MetaData")
    @Expose
    private List<MetaDatum> metaData = null;
    @SerializedName("MimeType")
    @Expose
    private String mimeType;
    @SerializedName("Section")
    @Expose
    private Section section;
    @SerializedName("Source")
    @Expose
    private Source source;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("CreditSource")
    @Expose
    private String creditSource;
    @SerializedName("EmbeddedContent")
    @Expose
    private EmbeddedContent embeddedContent;
    @SerializedName("EmbeddedContentCount")
    @Expose
    private Integer embeddedContentCount;
    @SerializedName("RelatedContentCount")
    @Expose
    private Integer relatedContentCount;

    protected Item(Parcel in) {
        body = in.readString();
        if (in.readByte() == 0) {
            childContentCount = null;
        } else {
            childContentCount = in.readInt();
        }
        credit = in.readString();
        description = in.readString();
        displayTime = in.readString();
        id = in.readString();
        lastModified = in.readString();
        lastUpdateTime = in.readString();
        mimeType = in.readString();
        title = in.readString();
        type = in.readString();
        creditSource = in.readString();
        if (in.readByte() == 0) {
            embeddedContentCount = null;
        } else {
            embeddedContentCount = in.readInt();
        }
        if (in.readByte() == 0) {
            relatedContentCount = null;
        } else {
            relatedContentCount = in.readInt();
        }
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };



    public ChildContent getChildContent() {
        return childContent;
    }

    public void setChildContent(ChildContent childContent) {
        this.childContent = childContent;
    }

    public Integer getChildContentCount() {
        return childContentCount;
    }

    public void setChildContentCount(Integer childContentCount) {
        this.childContentCount = childContentCount;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<MetaDatum> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<MetaDatum> metaData) {
        this.metaData = metaData;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreditSource() {
        return creditSource;
    }

    public void setCreditSource(String creditSource) {
        this.creditSource = creditSource;
    }

    public EmbeddedContent getEmbeddedContent() {
        return embeddedContent;
    }

    public void setEmbeddedContent(EmbeddedContent embeddedContent) {
        this.embeddedContent = embeddedContent;
    }

    public Integer getEmbeddedContentCount() {
        return embeddedContentCount;
    }

    public void setEmbeddedContentCount(Integer embeddedContentCount) {
        this.embeddedContentCount = embeddedContentCount;
    }

    public Integer getRelatedContentCount() {
        return relatedContentCount;
    }

    public void setRelatedContentCount(Integer relatedContentCount) {
        this.relatedContentCount = relatedContentCount;
    }

    public void setBody() {
        if(metaData != null && metaData.size() > 0) {
            for (MetaDatum metaDatum : metaData) {
                if(metaDatum.getKey().equals(BODY_KEY)) {
                    body = metaDatum.getValue();
                }
            }
        }
    }

    public String getBody() {
        return body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(body);
        if (childContentCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(childContentCount);
        }
        parcel.writeString(credit);
        parcel.writeString(description);
        parcel.writeString(displayTime);
        parcel.writeString(id);
        parcel.writeString(lastModified);
        parcel.writeString(lastUpdateTime);
        parcel.writeString(mimeType);
        parcel.writeString(title);
        parcel.writeString(type);
        parcel.writeString(creditSource);
        if (embeddedContentCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(embeddedContentCount);
        }
        if (relatedContentCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(relatedContentCount);
        }
    }
}
