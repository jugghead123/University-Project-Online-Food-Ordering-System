package sample;

import java.util.Date;

public class Visa extends Payment {

    private String accountNumber;
    private String expirationDate;
    private String CVV;

    public Visa(double amount, String accountNumber, String expirationDate, String CVV) {
        super(amount);
        this.accountNumber = accountNumber;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
    }

    public Visa(String accountNumber, String expirationDate, String CVV) {
        super();
        this.accountNumber = accountNumber;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
}
