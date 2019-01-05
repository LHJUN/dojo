package pers.oocl.dojo.tickets;

import org.junit.Assert;
import org.junit.Test;

public class CashTicketIssuerTest {

    @Test
    public void should_return_right_ticket_when_compute_given_label_is_apple_Quantity_is_1_Unitprice_is_1_statecode_is_UT(){
        TicketItem ticketItem = new TicketItem("apple", 1, 1, "UT");
        CashTicketIssuer cashTicketIssuer = new CashTicketIssuer();
        cashTicketIssuer.addTicketItem(ticketItem);

        String ticket = cashTicketIssuer.compute();

        String expectedTicket = "apple     1   1   1\n" + "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                                 0\n" +
                "Discout X%                                         -0\n" +
                "Tax Y%                                             +0\n" +
                "-----------------------------------------------------\n" +
                "Total price                                         0";
        Assert.assertEquals(expectedTicket, ticket);
    }
}
