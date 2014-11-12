package com.crest.model;

import com.crest.service.ImpressionServiceFactory;
import com.crest.service.ImpressionServiceThread;
import org.junit.Assert;
import org.junit.Test;

public class JournalTest {

    @Test
    public void should_return_impression_mark_string_for_journal(){
        //Given
              Journal journal = new Journal("Journal of human flight routes","Clark Kent");
        String expectedImpressionMark = "{content:" + "\"journal\",title:\"" + "Journal of human flight routes" + "\",author:\"" + "Clark Kent" + "\"}";

        //When
        ImpressionServiceFactory impressionServiceFactory = new ImpressionServiceFactory();
        Ticket journalTicket = impressionServiceFactory.submitRequestForImpressionMark(journal);
        ImpressionServiceThread impressionServiceThread = new ImpressionServiceThread();
        impressionServiceThread.start();
        try{
        Thread.sleep(1000);
        }catch (Exception e){}
        String actualImpressionMark = impressionServiceFactory.getImpressionMark(journalTicket);

        //Then
        Assert.assertEquals(expectedImpressionMark,actualImpressionMark);
    }
}
