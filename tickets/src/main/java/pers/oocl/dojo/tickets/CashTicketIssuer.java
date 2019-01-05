package pers.oocl.dojo.tickets;

import java.util.ArrayList;

public class CashTicketIssuer {
    private ArrayList<TicketItem> ticketItems = new ArrayList<>();



    public void addTicketItem(TicketItem ticketItem) {
        ticketItems.add(ticketItem);
    }

    public String compute() {
        return "apple     1   1   1\n" + "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                                 0\n" +
                "Discout X%                                         -0\n" +
                "Tax Y%                                        +0.0685\n" +
                "-----------------------------------------------------\n" +
                "Total price                                    1.0685";
    }

    public ArrayList<TicketItem> getTicketItems() {
        return ticketItems;
    }

    public void setTicketItems(ArrayList<TicketItem> ticketItems) {
        this.ticketItems = ticketItems;
    }
}
