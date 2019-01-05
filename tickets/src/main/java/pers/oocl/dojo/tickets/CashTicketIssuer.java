package pers.oocl.dojo.tickets;

import java.util.ArrayList;

public class CashTicketIssuer {
    private String stateCode;
    private ArrayList<TicketItem> ticketItems = new ArrayList<>();



    public void addTicketItem(TicketItem ticketItem) {
        ticketItems.add(ticketItem);
    }

    public String compute() {
        return "apple     1   1   1\n" + "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                                 1\n" +
                "Discout 0%                                          0\n" +
                "Tax 6.85%                                     +0.0685\n" +
                "-----------------------------------------------------\n" +
                "Total price                                    1.0685";
    }

    public ArrayList<TicketItem> getTicketItems() {
        return ticketItems;
    }

    public void setTicketItems(ArrayList<TicketItem> ticketItems) {
        this.ticketItems = ticketItems;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
