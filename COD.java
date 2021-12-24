package sample;

public class COD extends Payment{

    double cashback;

    public COD(double amount, double cashback) {
        super(amount);
        this.cashback = cashback;
    }

    public double getCashback() {
        return cashback;
    }

    public void setCashback(double cashback) {
        this.cashback = cashback;
    }
}
