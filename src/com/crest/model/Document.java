package com.crest.model;

/**
 * Created by acer on 11/11/2014.
 */
public abstract class Document {

    private String title;
    private String author;
    private String impressionMarkProperty;
    private boolean isImpressionMarked;

    public Document(String title, String author) {
        this.title = title;
        this.author = author;
        this.isImpressionMarked = false;
    }

    public abstract String markImpression();

    public String getAuthor() {
        return this.author;
    }


    public String getTitle() {
        return this.title;
    }


    public String getImpressionMarkProperty() {
        return this.impressionMarkProperty;
    }

    public void setImpressionMarkProperty(String impressionMarkProperty) {
        this.impressionMarkProperty = impressionMarkProperty;
        this.isImpressionMarked = true;
    }

    public boolean isImpressionMarked() {
        return isImpressionMarked;
    }
}
