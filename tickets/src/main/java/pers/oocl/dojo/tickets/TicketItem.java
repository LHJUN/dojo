package pers.oocl.dojo.tickets;

public class TicketItem {

    private String label;
    private int quantity;
    private double unitPrice;

    public TicketItem(String label, int quantity, double unitPrice) {
        this.label = label;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
