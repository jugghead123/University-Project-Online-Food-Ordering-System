package sample;

public abstract class Payment {
    public double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public Payment() {

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
