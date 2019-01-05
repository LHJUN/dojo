package pers.oocl.dojo.tickets;

public class TicketItem {

    private String lable;
    private int quantity;
    private double unitPrice;
    private String stateCode;

    public TicketItem(String label, int quantity, double unitPrice, String stateCode) {
        this.lable = label;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.stateCode = stateCode;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
