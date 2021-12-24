package sample;

import java.util.ArrayList;
import java.util.List;

public class Restaurant{

    private String name;
    private String category;

    public ArrayList<Meal> menu=new ArrayList<>();


    public Restaurant(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Meal> getMenu() {
        return menu;
    }
}
