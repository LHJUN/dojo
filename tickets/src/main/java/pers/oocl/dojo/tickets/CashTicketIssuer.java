package pers.oocl.dojo.tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CashTicketIssuer {
    private String stateCode;
    private ArrayList<TicketItem> ticketItems = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private double totalWithoutTaxes = 0;
    private double discountRate = 0;
    private double discountMoney = 0;
    private double taxMoney = 0;
    private double totalPrice = 0;

    private static Map<String, Double> TAXREATEMAP = new HashMap<>();

    private String itemFormat = "%s     %d   %.2f   %.2f\n";
    private String lineWrap = "-----------------------------------------------------\n";
    private String totalWithoutTaxFormat = "Total without taxes                              %.2f\n";
    private String discountFormat = "Discount %.2f%%                                   -%.2f\n";
    private String taxRateFormat = "Tax %.2f%%                                       +%.2f\n";
    private String totalPriceFormat = "Total price                                      %.2f";

    static{
        TAXREATEMAP.put("UT", 0.0685);
        TAXREATEMAP.put("NV", 0.08);
        TAXREATEMAP.put("TX", 0.0625);
        TAXREATEMAP.put("AL", 0.04);
        TAXREATEMAP.put("CA", 0.0825);
    }

    public void addTicketItem(TicketItem ticketItem) {
        ticketItems.add(ticketItem);
    }

    private void compute(){
        totalWithoutTaxes  = 0;
        for(TicketItem item : ticketItems){
            totalWithoutTaxes+=item.getTotalPrice();
        }
        if(totalWithoutTaxes > 1000){
            discountRate=0.03;
        }
        discountMoney = totalWithoutTaxes * discountRate;
        taxMoney = TAXREATEMAP.get(stateCode) * totalWithoutTaxes;
        totalPrice = totalWithoutTaxes - discountMoney + taxMoney;
    }

    public String generate() {
        compute();

        generateItemsInfo();
        generateLineWrap();
        generateTotalWithoutTax();
        generateDiscountInfo();
        generateTaxInfo();
        generateLineWrap();
        generateTotalPrice();

        return sb.toString();
    }

    private void generateTotalPrice() {
        sb.append(String.format(totalPriceFormat,totalPrice));
    }

    private void generateTaxInfo() {
        sb.append(String.format(taxRateFormat,TAXREATEMAP.get(stateCode)*100,taxMoney));
    }

    private void generateDiscountInfo() {
        sb.append(String.format(discountFormat,discountRate*100,discountMoney));
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
