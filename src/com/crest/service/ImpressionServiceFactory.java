package com.crest.service;

import com.crest.model.Document;
import com.crest.model.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.crest.service.ImpressionServiceThread.addDocumentToMarkImpression;

/**
 * Created by acer on 11/12/2014.
 */
public class ImpressionServiceFactory {

    private Map<Ticket, Document> ticketDocumentMap = new HashMap<Ticket, Document>();

    public Ticket submitRequestForImpressionMark(Document _document) {

        Ticket ticket = generateTicket();
        addDocumentToMarkImpression(_document);
        ticketDocumentMap.put(ticket, _document);
        return ticket;
    }

    private Ticket generateTicket() {
        Ticket ticket = null;

        Random rd = new Random();
        do {
            int tktId = rd.nextInt();
            ticket = new Ticket(tktId);
        } while (ticket == null || ticketDocumentMap.containsKey(ticket));

        return ticket;
    }

    public boolean getStatus (Ticket _ticket) {
        Document queriedDocument = ticketDocumentMap.get(_ticket);

        if (queriedDocument == null) {
            // Invalid ticket
            return false;
        }

        return queriedDocument.isImpressionMarked();
    }

    public String getImpressionMark(Ticket _ticket) {
        if (!getStatus(_ticket))
            return "";

        Document queriedDocument = ticketDocumentMap.get(_ticket);
        return queriedDocument.getImpressionMarkProperty();
    }
}
