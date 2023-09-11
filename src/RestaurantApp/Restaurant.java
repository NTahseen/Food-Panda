package RestaurantApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Serializable{
    private int id;
    private String name;
    private double score;
    private String price;
    private String zipCode;

    List<String> categories = new ArrayList<>();
    List<Food> foods = new ArrayList<>();

    void setName(String name)
    {
        this.name = name;
    }
    void setId(int id)
    {
        this.id = id;
    }
    void setScore(double score)
    {
        this.score = score;
    }
    void setPrice(String price)
    {
        this.price = price;
    }
    void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    void setCategories(List<String> categories)
    {
        this.categories = categories;
    }

    void setFoods(List<Food> foods)
    {
        this.foods = foods;
    }

    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    public double getScore()
    {
        return score;
    }
    public String getPrice()
    {
        return price;
    }
    public String getZipCode()
    {
        return zipCode;
    }

    public List<String> getCategories()
    {
        return categories;
    }

    public List<Food> getFoods()
    {
        return foods;
    }

    public Restaurant(int Id, String Name, double score, String price,String zipcode, List<String>categories)
    {
        this.id = Id;
        this.name = Name;
        this.score = score;
        this.price = price;
        this.zipCode = zipcode;
        this.categories = categories;

        //System.out.println("from constructor : ");
        //showDetails();
    }

    /*
    void showDetails()
    {
        System.out.println("Restaurant Id : "+ id);
        System.out.println("Name : "+ name);
        System.out.println("Score : "+ score);
        System.out.println("Price : "+ price);
        System.out.println("Zip Code : "+ zipCode);
        System.out.printf("Catagories : ");
        for(String s : categories){
            System.out.printf(s+", ");
        }
        System.out.println();
        System.out.println();
    }

     */

}
