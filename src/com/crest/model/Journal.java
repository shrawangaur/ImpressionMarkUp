package com.crest.model;

/**
 * Created by acer on 11/11/2014.
 */
public class Journal extends Document {

    public Journal(String _title, String _author) {
        super(_title, _author);
    }

    @Override
    public String markImpression() {
        return   "{content:" + "\"journal\",title:\"" + this.getTitle() + "\",author:\"" + this.getAuthor() + "\"}";
    }
}
