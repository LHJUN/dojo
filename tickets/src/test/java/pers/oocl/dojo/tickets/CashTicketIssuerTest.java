package pers.oocl.dojo.tickets;

import org.junit.Assert;
import org.junit.Test;

public class CashTicketIssuerTest {

    @Test
    public void should_return_right_ticket_when_compute_given_label_is_apple_Quantity_is_1_Unitprice_is_1_statecode_is_UT(){
        TicketItem ticketItem = new TicketItem("apple", 1, 1);
        CashTicketIssuer cashTicketIssuer = new CashTicketIssuer();
        cashTicketIssuer.addTicketItem(ticketItem);
        cashTicketIssuer.setStateCode("UT");

        String ticket = cashTicketIssuer.compute();

        String expectedTicket = "apple     1   1   1\n" + "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                                 1\n" +
                "Discout 0%                                          0\n" +
                "Tax 6.85%                                     +0.0685\n" +
                "-----------------------------------------------------\n" +
                "Total price                                    1.0685";
        System.out.println(expectedTicket);
        Assert.assertEquals(expectedTicket, ticket);
    }
}
