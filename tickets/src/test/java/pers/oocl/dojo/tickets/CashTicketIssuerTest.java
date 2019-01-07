package pers.oocl.dojo.tickets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CashTicketIssuerTest {


    private CashTicketIssuer cashTicketIssuer;


    @Before
    public void setUp(){
        cashTicketIssuer = new CashTicketIssuer();
    }



    @Test
    public void should_return_right_ticket_when_compute_given_label_is_apple_Quantity_is_1_Unitprice_is_1_statecode_is_UT(){
        TicketItem ticketItem = new TicketItem("apple", 1, 1);
        cashTicketIssuer.addTicketItem(ticketItem);
        cashTicketIssuer.setStateCode("UT");

        String result = cashTicketIssuer.generate();

        String expectedTicket = "apple     1   1.00   1.00\n" +
                "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                              1.00\n" +
                "Discount 0.00%                                   -0.00\n" +
                "Tax 6.85%                                       +0.07\n" +
                "-----------------------------------------------------\n" +
                "Total price                                      1.07";
        Assert.assertEquals(expectedTicket, result);
    }

    @Test
    public void should_return_right_ticket_string_when_compute_given_label_is_apple_Quantity_is_1_Unitprice_is_2000_statecode_is_UT() {

        TicketItem ticketItem = new TicketItem("apple", 1, 2000);

        cashTicketIssuer.addTicketItem(ticketItem);
        cashTicketIssuer.setStateCode("UT");

        String result = cashTicketIssuer.generate();
        String expectedTicket = "apple     1   2000.00   2000.00\n" +
                "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                              2000.00\n" +
                "Discount 3.00%                                   -60.00\n" +
                "Tax 6.85%                                       +137.00\n" +
                "-----------------------------------------------------\n" +
                "Total price                                      2077.00";
        Assert.assertEquals(expectedTicket, result);
    }

    @Test
    public void should_return_right_ticket_string_when_compute_given_label_is_apple_Quantity_is_1_Unitprice_is_2000_statecode_is_NV() {

        TicketItem ticketItem = new TicketItem("apple", 1, 2000);

        cashTicketIssuer.addTicketItem(ticketItem);
        cashTicketIssuer.setStateCode("NV");

        String result = cashTicketIssuer.generate();
        String expectedTicket = "apple     1   2000.00   2000.00\n" +
                "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                              2000.00\n" +
                "Discount 3.00%                                   -60.00\n" +
                "Tax 8.00%                                       +160.00\n" +
                "-----------------------------------------------------\n" +
                "Total price                                      2100.00";
        Assert.assertEquals(expectedTicket, result);
    }

    @Test
    public void should_return_right_ticket_string_when_compute_given_label_is_apple_Quantity_is_1_Unitprice_is_6000_statecode_is_NV() {

        TicketItem ticketItem = new TicketItem("apple", 1, 6000);

        cashTicketIssuer.addTicketItem(ticketItem);
        cashTicketIssuer.setStateCode("NV");

        String result = cashTicketIssuer.generate();
        String expectedTicket = "apple     1   6000.00   6000.00\n" +
                "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                              6000.00\n" +
                "Discount 5.00%                                   -300.00\n" +
                "Tax 8.00%                                       +480.00\n" +
                "-----------------------------------------------------\n" +
                "Total price                                      6180.00";
        Assert.assertEquals(expectedTicket, result);
    }

    @Test
    public void should_return_right_ticket_string_when_compute_given_more_items_and_statecode_is_NV() {

        TicketItem apple = new TicketItem("apple", 1, 6000);
        TicketItem banana = new TicketItem("banana", 2, 5000);
        cashTicketIssuer.addTicketItem(banana);
        cashTicketIssuer.addTicketItem(apple);

        cashTicketIssuer.setStateCode("NV");

        String result = cashTicketIssuer.generate();
        String expectedTicket = "banana     2   5000.00   10000.00\n" +
                "apple     1   6000.00   6000.00\n" +
                "\n" +
                "-----------------------------------------------------\n" +
                "Total without taxes                              16000.00\n" +
                "Discount 10.00%                                   -1600.00\n" +
                "Tax 8.00%                                       +1280.00\n" +
                "-----------------------------------------------------\n" +
                "Total price                                      15680.00";
        Assert.assertEquals(expectedTicket, result);
    }
}
