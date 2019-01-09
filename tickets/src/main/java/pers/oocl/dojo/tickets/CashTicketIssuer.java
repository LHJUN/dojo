package pers.oocl.dojo.tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CashTicketIssuer {
    private String stateCode;
    private ArrayList<TicketItem> ticketItems = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private double totalWithoutTaxes = 0;
    private double discountRate = 0;
    private double discountMoney = 0;
    private double taxMoney = 0;
    private double totalPrice = 0;

    private static Map<String, Double> TAX_RATE_MAP = new HashMap<>();

    private static Map<Double,Double> DISCOUNT_RATE_MAP = new TreeMap<>();

    static{
        TAX_RATE_MAP.put("UT", 0.0685);
        TAX_RATE_MAP.put("NV", 0.08);
        TAX_RATE_MAP.put("TX", 0.0625);
        TAX_RATE_MAP.put("AL", 0.04);
        TAX_RATE_MAP.put("CA", 0.0825);

        DISCOUNT_RATE_MAP.put(1000.0,0.03);
        DISCOUNT_RATE_MAP.put(5000.0,0.05);
        DISCOUNT_RATE_MAP.put(7000.0,0.07);
        DISCOUNT_RATE_MAP.put(10000.0,0.1);
        DISCOUNT_RATE_MAP.put(50000.0,0.15);
    }

    public void addTicketItem(TicketItem ticketItem) {
        ticketItems.add(ticketItem);
    }

    private void compute(){
        totalWithoutTaxes  = 0;
        for(TicketItem item : ticketItems){
            totalWithoutTaxes+=item.getTotalPrice();
        }

        discountRate = getDiscountRate();

        discountMoney = totalWithoutTaxes * discountRate;
        taxMoney = TAX_RATE_MAP.get(stateCode) * totalWithoutTaxes;
        totalPrice = totalWithoutTaxes - discountMoney + taxMoney;
    }

    private double getDiscountRate() {
        double t_discountRate = 0.0;
        for (Double key : DISCOUNT_RATE_MAP.keySet()) {
            if(totalWithoutTaxes < key){
                return t_discountRate;
            }
            t_discountRate = DISCOUNT_RATE_MAP.get(key);
        }
        return discountRate;
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
        String totalPriceFormat = "Total price                                      %.2f";
        sb.append(String.format(totalPriceFormat,totalPrice));
    }

    private void generateTaxInfo() {
        String taxRateFormat = "Tax %.2f%%                                       +%.2f\n";
        sb.append(String.format(taxRateFormat, TAX_RATE_MAP.get(stateCode)*100,taxMoney));
    }

    private void generateDiscountInfo() {
        String discountFormat = "Discount %.2f%%                                   -%.2f\n";
        sb.append(String.format(discountFormat,discountRate*100,discountMoney));
    }

    private void generateTotalWithoutTax() {
        String totalWithoutTaxFormat = "Total without taxes                              %.2f\n";
        sb.append(String.format(totalWithoutTaxFormat, totalWithoutTaxes));
    }

    private void generateLineWrap() {
        String lineWrap = "-----------------------------------------------------\n";
        sb.append(lineWrap);
    }

    private void generateItemsInfo() {
        String itemFormat = "%s     %d   %.2f   %.2f\n";
        for(TicketItem item : ticketItems){
            sb.append(String.format(itemFormat,item.getLabel(),item.getQuantity(),item.getUnitPrice(),item.getTotalPrice()));
        }
        sb.append("\n");
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public double getTotalWithoutTaxes() {
        return totalWithoutTaxes;
    }

    public double getDiscountMoney() {
        return discountMoney;
    }

    public double getTaxMoney() {
        return taxMoney;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
