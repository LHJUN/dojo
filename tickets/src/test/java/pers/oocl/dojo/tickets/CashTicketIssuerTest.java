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

        String result = cashTicketIssuer.generate();

        String expectedTicket = "apple     1   1.00   1.00\n" +
                "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                              1.00\n" +
                "Discout 0.00%                                   -0.00\n" +
                "Tax 6.85%                                       +0.07\n" +
                "-----------------------------------------------------\n" +
                "Total price                                      1.07";
        Assert.assertEquals(expectedTicket, result);
    }

    /**
     apple     1   2000   2000

     -----------------------------------------------------
     Total without taxes                              2000
     Discout 3%                                        -60
     Tax 6.85%                                        +137
     -----------------------------------------------------
     Total price                                      2077
     */
    @Test
    public void should_return_right_ticket_string_when_compute_given_label_is_apple_Quantity_is_1_Unitprice_is_2000_statecode_is_UT() {

        TicketItem ticketItem = new TicketItem("apple", 1, 2000);
        CashTicketIssuer cashTicketIssuer = new CashTicketIssuer();
        cashTicketIssuer.addTicketItem(ticketItem);
        cashTicketIssuer.setStateCode("UT");



        String result = cashTicketIssuer.generate();
        String expectedTicket = "apple     1   2000.00   2000.00\n" +
                "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                              2000.00\n" +
                "Discout 3.00%                                   -60.00\n" +
                "Tax 6.85%                                       +137.00\n" +
                "-----------------------------------------------------\n" +
                "Total price                                      2077.00";
        Assert.assertEquals(expectedTicket, result);
    }
}
