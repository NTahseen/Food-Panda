package util;

import java.io.Serializable;
import java.util.List;

import RestaurantApp.RestaurantManager;
import RestaurantApp.Food;
import RestaurantApp.Restaurant;

public class LoginDTO implements Serializable {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setResList(List<Restaurant> restaurantList){
        System.out.println("logindto theke" + restaurantList.size());
        this.restaurantList = restaurantList;
    }

    public List<Restaurant> getResList()
    {
        return restaurantList;
    }

    public void setFoodList(List<Food> foodList){
        this.foodList = foodList;
    }

    public List<Food> getfoodList()
    {
        return foodList;
    }

    public RestaurantManager getRestaurantManager(){
        return restaurantManager;
    }

    public void setRestaurantManager(RestaurantManager restaurantManager){
        this.restaurantManager = restaurantManager;

    }

    private String userName;
    private String password;
    private boolean status;
    private List<Food> foodList;
    private List<Restaurant> restaurantList;

    private RestaurantManager restaurantManager;

}
