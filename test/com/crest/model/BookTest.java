package com.crest.model;

import com.crest.service.ImpressionServiceFactory;
import com.crest.service.ImpressionServiceThread;
import org.junit.Assert;
import org.junit.Test;

public class BookTest {

    @Test
    public void should_return_impression_mark_string_for_book(){
        //Given
        Book book = new Book("The Dark Code","Bruce Wayne","Business");
        String expectedImpressionMark = "{content:" + "\"book\",title:\"" + "The Dark Code" + "\",author:\"" + "Bruce Wayne" +  "\",topic:\"" + "Business" + "\"}";

        //When
        ImpressionServiceFactory impressionServiceFactory = new ImpressionServiceFactory();
        Ticket bookTicket = impressionServiceFactory.submitRequestForImpressionMark(book);
        ImpressionServiceThread impressionServiceThread = new ImpressionServiceThread();
        impressionServiceThread.start();
        try{
            Thread.sleep(1000);
        }catch (Exception e){}
        String actualImpressionMark = impressionServiceFactory.getImpressionMark(bookTicket);

        //Then
        Assert.assertEquals(expectedImpressionMark, actualImpressionMark);
    }
}
