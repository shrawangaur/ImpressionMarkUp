package com.crest.service;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;


import com.crest.model.Book;
import com.crest.model.Document;
import com.crest.model.Journal;
import com.crest.model.Ticket;


public class ImpressionServiceFactoryTest {


    @Test
    public void testImpressionMarkWhenInvalidTicket() {
        ImpressionServiceFactory factory = new ImpressionServiceFactory();
        Map<Ticket, Document> ticketDocumentMap = new HashMap<Ticket, Document>();
        Ticket ticket = new Ticket(100);
        ticketDocumentMap.put(ticket, null);
        factory.setTicketDocumentMap(ticketDocumentMap);
        String impressionMark = factory.getImpressionMark(ticket);
        Assert.assertEquals("", impressionMark);
    }

    @Test
    public void testGetImpressionMarkWhenImpressionNotMarked() {
        ImpressionServiceFactory factory = new ImpressionServiceFactory();
        Map<Ticket, Document> ticketDocumentMap = new HashMap<Ticket, Document>();
        Ticket ticket = new Ticket(100);
        Document journal = new Journal("Test Title", "Test Author");
        ticketDocumentMap.put(ticket, journal);
        factory.setTicketDocumentMap(ticketDocumentMap);
        String impressionMark = factory.getImpressionMark(ticket);
        Assert.assertEquals("", impressionMark);
    }

    @Test
    public void testGetImpressionMarkWhenImpressionMarked() {
        ImpressionServiceFactory factory = new ImpressionServiceFactory();
        Map<Ticket, Document> ticketDocumentMap = new HashMap<Ticket, Document>();
        Ticket ticket = new Ticket(100);
        Document journal = new Journal("Test Title", "Test Author");
        journal.setImpressionMarkProperty("test impression");
        ticketDocumentMap.put(ticket, journal);
        factory.setTicketDocumentMap(ticketDocumentMap);
        String impressionMark = factory.getImpressionMark(ticket);
        Assert.assertEquals(journal.getImpressionMarkProperty(), impressionMark);
    }

    @Test
    public void testWhenDocumentSubmittedForTicketGeneration() {
        ImpressionServiceFactory factory = new ImpressionServiceFactory();
        Document book = new Book("Test Title", "Test Author", "Business");
        Ticket ticket = factory.submitRequestForImpressionMark(book);
        Assert.assertTrue(factory.getTicketDocumentMap().containsKey(ticket));
        Assert.assertEquals(book, factory.getTicketDocumentMap().get(ticket));
    }

    @Test
    public void testImpressionNotMarkedWhenDocumentSubmittedForTicketGeneration() {
        ImpressionServiceFactory factory = new ImpressionServiceFactory();
        Document book = new Book("Test Title", "Test Author", "Business");
        Ticket ticket = factory.submitRequestForImpressionMark(book);
        Assert.assertFalse(factory.getTicketDocumentMap().get(ticket).isImpressionMarked());


    }
}
