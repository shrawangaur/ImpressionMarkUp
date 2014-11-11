package com.crest.modal;

/**
 * Created by acer on 11/11/2014.
 */
public class Ticket {

    private int ticketId;

    public Ticket(int ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (ticketId != ticket.ticketId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ticketId;
    }
}
