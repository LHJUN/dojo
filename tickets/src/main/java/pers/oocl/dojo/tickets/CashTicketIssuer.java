package pers.oocl.dojo.tickets;

import java.util.ArrayList;

public class CashTicketIssuer {
    private String stateCode;
    private ArrayList<TicketItem> ticketItems = new ArrayList<>();

    public void addTicketItem(TicketItem ticketItem) {
        ticketItems.add(ticketItem);
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();

        double totalWithoutTaxes  = 0;
        // get total price
        String itemFormat = "%s     %d   %.2f   %.2f\n";

        for(TicketItem item : ticketItems){
            totalWithoutTaxes+=item.getTotalPrice();
            sb.append(String.format(itemFormat,item.getLable(),item.getQuantity(),item.getUnitPrice(),item.getTotalPrice()));
        }
        sb.append("\n");
        // line warp
        sb.append("-----------------------------------------------------\n");
        // total without tax
        String totalWithoutTaxFormat = "Total without taxes                              %.2f\n";
        sb.append(String.format(totalWithoutTaxFormat,totalWithoutTaxes));

        //get discout
        double discoutRate = 0;
        if(totalWithoutTaxes > 1000){
            discoutRate=0.03;
        }
        double discoutMoney = totalWithoutTaxes * discoutRate;
        String discoutFormat = "Discout %.2f%%                                   -%.2f\n";
        sb.append(String.format(discoutFormat,discoutRate*100,discoutMoney));


        //get Tax rate
        double taxRate = 0.0685;

        double taxMoney = taxRate * totalWithoutTaxes;
        String taxRateFormat = "Tax %.2f%%                                       +%.2f\n";
        sb.append(String.format(taxRateFormat,taxRate*100,taxMoney));


        // line warp
        sb.append("-----------------------------------------------------\n");
        //total price
        String totalPriceFormat = "Total price                                      %.2f";
        double totalPrice = totalWithoutTaxes - discoutMoney + taxMoney;
        sb.append(String.format(totalPriceFormat,totalPrice));


        return sb.toString();
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
