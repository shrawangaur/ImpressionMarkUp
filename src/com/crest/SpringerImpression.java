package com.crest;

import com.crest.modal.Book;
import com.crest.modal.Document;
import com.crest.modal.Journal;
import com.crest.modal.Ticket;
import com.crest.service.ServiceFactory;
import com.crest.service.ServiceThread;

/**
 * Created by acer on 11/11/2014.
 */
public class SpringerImpression {


    public static void main(String... args) throws Exception{
        ServiceThread serviceThread = new ServiceThread();
        serviceThread.start();

        Document book = new Book("The Dark Code", "Bruce Wayne", "Business");
        Document journal = new Journal("Journal of human flight routes", "Clark kent");



        ServiceFactory serviceFactory = new ServiceFactory();
        Ticket bookTkt = serviceFactory.submitRequestForImpressionMark(book);

        System.out.println("This request is just submitted. Its poll status is " + serviceFactory.getStatus(bookTkt));

        Ticket  journalTkt = serviceFactory.submitRequestForImpressionMark(journal);
        Thread.sleep(1000);
        System.out.println("This request has taken time . Its poll status is " + serviceFactory.getStatus(bookTkt) + " and its impression mark is " + serviceFactory.getImpressionMark(bookTkt));
        System.out.println(serviceFactory.getStatus(bookTkt));
        System.out.println(serviceFactory.getStatus(journalTkt));
        System.out.println(serviceFactory.getImpressionMark(bookTkt));
        System.out.println(serviceFactory.getImpressionMark(journalTkt));
    }
}
