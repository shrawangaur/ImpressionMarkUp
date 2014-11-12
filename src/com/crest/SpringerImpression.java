package com.crest;

import com.crest.model.Book;
import com.crest.model.Document;
import com.crest.model.Journal;
import com.crest.model.Ticket;
import com.crest.service.ImpressionServiceFactory;
import com.crest.service.ImpressionServiceThread;

public class SpringerImpression {


    public static void main(String... args) throws Exception{
        ImpressionServiceThread impressionServiceThread = new ImpressionServiceThread();
        impressionServiceThread.start();

        Document book = new Book("The Dark Code", "Bruce Wayne", "Business");
        Document journal = new Journal("Journal of human flight routes", "Clark kent");



        ImpressionServiceFactory impressionServiceFactory = new ImpressionServiceFactory();
        Ticket bookTkt = impressionServiceFactory.submitRequestForImpressionMark(book);

        System.out.println("This request is just submitted. Its poll status is " + impressionServiceFactory.getStatus(bookTkt));

        Ticket  journalTkt = impressionServiceFactory.submitRequestForImpressionMark(journal);
        Thread.sleep(1000);
        System.out.println("This request has taken time . Its poll status is " + impressionServiceFactory.getStatus(bookTkt) + " and its impression mark is " + impressionServiceFactory.getImpressionMark(bookTkt));
        System.out.println(impressionServiceFactory.getStatus(bookTkt));
        System.out.println(impressionServiceFactory.getStatus(journalTkt));
        System.out.println(impressionServiceFactory.getImpressionMark(bookTkt));
        System.out.println(impressionServiceFactory.getImpressionMark(journalTkt));
    }
}
