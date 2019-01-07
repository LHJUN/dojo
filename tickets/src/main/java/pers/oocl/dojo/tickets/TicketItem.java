package pers.oocl.dojo.tickets;

public class TicketItem {

    private String lable;
    private int quantity;
    private double unitPrice;

    public TicketItem(String label, int quantity, double unitPrice) {
        this.lable = label;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
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

    public double getTotalPrice(){
        return quantity*unitPrice;
    }
}
