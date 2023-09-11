package RestaurantApp;

import java.io.Serializable;

public class Food implements Serializable {
    private int restaurantId;
    private String category;
    private String name;
    private double price;

    public Food(int restaurantId, String category, String name, double price) {
        this.restaurantId = restaurantId;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setRestaurantId(int restaurantId)
    {
        this.restaurantId = restaurantId;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public int getRestaurantId()
    {
        return restaurantId;
    }

    public String getCategory()
    {
        return category;
    }

    public double getPrice()
    {
        return price;
    }


    /*
    public void showDetails()
    {
        System.out.println("Restaurant Id : "+ restaurantId);
        System.out.println("Category : "+ category);
        System.out.println("Name : "+ name);
        System.out.println("Price : "+ price);
        System.out.println();
    }
     */

}
