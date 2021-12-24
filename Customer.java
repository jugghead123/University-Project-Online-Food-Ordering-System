package sample;

public class Customer extends Person {

    String myOrder;

    public Customer(String username, String password, String myOrder) {
        super(username, password);
        this.myOrder = myOrder;
    }

    public Customer(String username, String password) {
        super(username, password);
    }



    public String getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(String myOrder) {
        this.myOrder = myOrder;
    }
}


