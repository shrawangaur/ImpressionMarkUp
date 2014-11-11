package com.crest.modal;

/**
 * Created by acer on 11/11/2014.
 */
public class Journal extends Document {

    public Journal(String _title, String _author) {
        super(_title, _author);
    }

    @Override
    public String toString() {
        return   "{content:" + "\"journal\",title:\"" + this.getTitle() + "\",author:\"" + this.getAuthor() + "\"}";
    }
}
