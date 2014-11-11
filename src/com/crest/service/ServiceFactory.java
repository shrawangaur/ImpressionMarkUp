package com.crest.service;

import com.crest.modal.Document;
import com.crest.modal.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.crest.service.ServiceThread.addDocumentToMarkImpression;

/**
 * Created by acer on 11/12/2014.
 */
public class ServiceFactory {

    private Map<Ticket, Document> ticketDocumentMap = new HashMap<Ticket, Document>();

    public Ticket submitRequestForImpressionMark(Document _document) {

        Ticket ticket = generateTicket();
        addDocumentToMarkImpression(_document);
        ticketDocumentMap.put(ticket, _document);
        return ticket;
    }

    private Ticket generateTicket() {
        Ticket tkt = null;

        Random rd = new Random();
        do {
            int tktId = rd.nextInt();
            tkt = new Ticket(tktId);
        } while (tkt == null || ticketDocumentMap.containsKey(tkt));

        return tkt;
    }

    public boolean getStatus (Ticket _ticket) {
        Document queriedDocument = ticketDocumentMap.get(_ticket);

        if (queriedDocument == null) {
            // Invalid ticket
            return false;
        }

        return queriedDocument.isImpressionMarked();
    }

    public String getImpressionMark(Ticket ticket) {
        if (!getStatus(ticket))
            return "";

        Document queriedDocument = ticketDocumentMap.get(ticket);
        return queriedDocument.getImpressionMarkProperty();
    }
}
