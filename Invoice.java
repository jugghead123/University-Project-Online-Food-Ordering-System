package sample;

public class Invoice {
    double amount;
    String order;
    double tax;
    double deliveryFees;
    double subtotal;

    public Invoice(int amount, String order, float tax, int deliveryFees) {
        this.amount = amount;
        this.order = order;
        this.tax = tax;
        this.deliveryFees = deliveryFees;
    }

    public double getAmount() {
        return amount;
    }

    public String getOrder() {
        return order;
    }

    public double getTax() {
        return tax;
    }

    public double getDeliveryFees() {
        return deliveryFees;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setDeliveryFees(double deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
