package sample;

import java.util.ArrayList;

import static java.awt.SystemColor.menu;

public class Meal implements meal_actions{
    private String name;
    private double Price;

    String meal1,meal2,meal3,meal4;
    static ArrayList<String> meals = new ArrayList<String>();
    public Meal(String meal1, String meal2, String meal3, String meal4 ){
        meals.add(meal1);
        meals.add(meal2);
        meals.add(meal3);
        meals.add(meal4);
    }

    public Meal() {
    }

    public Meal(String Name, double Price) {
        this.name = Name;
        this.Price = Price;
    }

    public Meal(String name) {
        this.name = name;
    }

    public void setName(String Name) {
        this.name=Name;

    }
    public void setPrice(double Price) {
        this.Price = Price;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return Price;
    }

    @Override
    public void Add(Restaurant restaurant) {

        restaurant.getMenu().add(this);
        System.out.println(this.toString());
        System.out.println("A new meal has been added to your restaurant");

    }

    @Override
    public void Delete(Restaurant restaurant) {

        restaurant.getMenu().remove(this);
        System.out.println(this.toString());
        System.out.println("the selected meal has been removed from your restaurant");

    }
}
