package pers.oocl.dojo.tickets;

import java.util.ArrayList;

public class CashTicketIssuer {
    private String stateCode;
    private ArrayList<TicketItem> ticketItems = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private double totalWithoutTaxes = 0;
    private double discoutRate = 0;
    private double discoutMoney = 0;
    private double taxRate = 0;
    private double taxMoney = 0;
    private double totalPrice = 0;

    private String itemFormat = "%s     %d   %.2f   %.2f\n";
    private String lineWrap = "-----------------------------------------------------\n";
    private String totalWithoutTaxFormat = "Total without taxes                              %.2f\n";
    private String discoutFormat = "Discout %.2f%%                                   -%.2f\n";
    private String taxRateFormat = "Tax %.2f%%                                       +%.2f\n";
    private String totalPriceFormat = "Total price                                      %.2f";

    public void addTicketItem(TicketItem ticketItem) {
        ticketItems.add(ticketItem);
    }

    private void compute(){
        totalWithoutTaxes  = 0;
        for(TicketItem item : ticketItems){
            totalWithoutTaxes+=item.getTotalPrice();
        }
        if(totalWithoutTaxes > 1000){
            discoutRate=0.03;
        }
        discoutMoney = totalWithoutTaxes * discoutRate;
        taxRate = 0.0685;
        taxMoney = taxRate * totalWithoutTaxes;
        totalPrice = totalWithoutTaxes - discoutMoney + taxMoney;
    }

    public String generate() {
        compute();

        generateItemsInfo();
        generateLineWrap();
        generateTotalWithoutTax();
        generateDiscoutInfo();
        generateTaxInfo();
        generateLineWrap();
        generateTotalPrice();

        return sb.toString();
    }

    private void generateTotalPrice() {
        sb.append(String.format(totalPriceFormat,totalPrice));
    }

    private void generateTaxInfo() {
        sb.append(String.format(taxRateFormat,taxRate*100,taxMoney));
    }

    private void generateDiscoutInfo() {
        sb.append(String.format(discoutFormat,discoutRate*100,discoutMoney));
    }

    private void generateTotalWithoutTax() {
        sb.append(String.format(totalWithoutTaxFormat, totalWithoutTaxes));
    }

    private void generateLineWrap() {
        sb.append(lineWrap);
    }

    private void generateItemsInfo() {
        for(TicketItem item : ticketItems){
            sb.append(String.format(itemFormat,item.getLable(),item.getQuantity(),item.getUnitPrice(),item.getTotalPrice()));
        }
        sb.append("\n");
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
