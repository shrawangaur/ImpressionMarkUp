package com.crest.model;

public class Journal extends Document {

    public Journal(String _title, String _author) {
        super(_title, _author);
    }

    @Override
    public String markImpression() {
        return   "{content:" + "\"journal\",title:\"" + this.getTitle() + "\",author:\"" + this.getAuthor() + "\"}";
    }
}
