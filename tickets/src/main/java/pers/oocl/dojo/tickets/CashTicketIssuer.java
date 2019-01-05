package pers.oocl.dojo.tickets;

import java.util.ArrayList;

public class CashTicketIssuer {
    private ArrayList<TicketItem> ticketItems;

    public void addTicketItem(TicketItem ticketItem) {
        ticketItems.add(ticketItem);
    }

    public String compute() {
        return "";
    }

    public ArrayList<TicketItem> getTicketItems() {
        return ticketItems;
    }

    public void setTicketItems(ArrayList<TicketItem> ticketItems) {
        this.ticketItems = ticketItems;
    }
}
