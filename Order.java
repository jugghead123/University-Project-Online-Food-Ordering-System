package sample;

public class Order {

    private String mealname;
    private int quantity;
    private String additionalnotes;

    public Order(String mealname, int quantity, String additionalnotes) {
        this.mealname = mealname;
        this.quantity = quantity;
        this.additionalnotes = additionalnotes;
    }

    public String getMealname() {
        return mealname;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAdditionalnotes() {
        return additionalnotes;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAdditionalnotes(String additionalnotes) {
        this.additionalnotes = additionalnotes;
    }

}