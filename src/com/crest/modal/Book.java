package com.crest.modal;

/**
 * Created by acer on 11/11/2014.
 */
public class Book extends Document {

    private TopicType topicType;

    public Book(String _title, String _author, String _topic) {
        super(_title, _author);
        this.topicType = TopicType.valueOf(_topic);
    }

    @Override
    public String toString() {
     return  "{content:" + "\"book\",title:\"" + this.getTitle() + "\",author:\"" + this.getAuthor() + "\",topic:\"" + this.topicType + "\"}";
   }

}
