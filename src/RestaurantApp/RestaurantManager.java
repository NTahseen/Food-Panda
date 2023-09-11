package RestaurantApp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;

public class RestaurantManager implements Serializable{
    List<Restaurant> restaurants = new ArrayList<>();
    List<Food> foods = new ArrayList<>();

    /* 

    private static final String INPUT_FILE_NAME = "restaurant.txt";

    public void readRestaurantFromFile() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String [] array = line.split(",(?! )", -1);

            int id = Integer.parseInt(array[0]);
            double score = Double.parseDouble(array[2]);

            List<String> s = new ArrayList<>();

            for(int i = 5; i <= 7; i++){
                s.add(array[i]);
            }
            Restaurant r1 = new Restaurant(id,array[1],score,array[3],array[4], s);
            addRestaurant(r1);
        }
        br.close();
    }

    public void readFoodFromFile() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            //System.out.println(line);
            String [] array = line.split(",(?! )", -1);

            int restaurantId = Integer.parseInt(array[0]);
            double price = Double.parseDouble(array[3]);

            Food f1 = new Food(restaurantId,array[1],array[2],price);
            if(addFoodItem(f1)){

            }
            else{
                System.out.println(f1.getName()+ " already exists in the restaurant in the same category");
            }
        }
        br.close();
    }

    public void writeRestaurantToFile() throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter("restaurant.txt"));

        List<Restaurant> restaurants = getRestaurantsList();
        for(Restaurant restaurant : restaurants){
            bw.write(restaurant.getId()+","+restaurant.getName()+",");
            bw.write(restaurant.getScore()+","+restaurant.getPrice()+","+restaurant.getZipCode()+",");

            List<String>categoryName =  restaurant.getCategories();
            int i;
            for(i = 0; i < categoryName.size()-1; i++){
                bw.write(categoryName.get(i)+",");
            }
            bw.write(categoryName.get(i));
            bw.write(System.lineSeparator());
        }
        bw.close();
    }
    */
    

    public boolean addRestaurant(Restaurant r) throws IOException {

        for(Restaurant match : restaurants){
            if(match.getName().equalsIgnoreCase(r.getName())){
                //System.out.println(r.getName()+" restaurant already exists.");
                return false;
            }
        }
        restaurants.add(r);
        return true;
        //saveToFile();
    }

    

    public void setFoodList(List<Food> foodList){
        this.foods = foodList;
    }

    public List<Food> getFoodList(){
        return foods;
    }

    public void setResList(List<Restaurant> resList){
        this.restaurants = resList;
    }

    public List<Restaurant> getResList(){
        return restaurants;
    }
 
    public boolean addFoodItem(Food f)
    {
        //TODO get the restaurant obj first to which the food belongs to 
        /* 
        for(Restaurant r : restaurants){
            List<Food> foods = r.getFoods();
            for(Food match : foods){
            if((match.getName().equalsIgnoreCase(f.getName())) && (match.getRestaurantId() == f.getRestaurantId()) && (match.getCategory().equalsIgnoreCase(f.getCategory()))){
                return false;
            }
            }
            foods.add(f);
            return true;
        }
        
        return false;
        */

        Restaurant restaurant = null;

        for(Restaurant r : restaurants){
            if(r.getId() == f.getRestaurantId()){
                restaurant = r;
                break;
            }
        }

        if(restaurant == null)return false;
        
        List<Food> foods = restaurant.getFoods();

        int flag = 0;
        for(Food food : foods){
            if((food.getName().equalsIgnoreCase(f.getName())) && (food.getRestaurantId() == f.getRestaurantId()) && (food.getCategory().equalsIgnoreCase(f.getCategory()))){
                flag = 1;
                break;
            }
        }

        if(flag == 1){
            return false;
        }
        else{
            foods.add(f);
            return true;
        }


    }
    

    public boolean addFoodItemInASpecificRestaurant(Food f, String restaurantname) throws IOException {
         Restaurant restaurant = null;

        for(Restaurant r : restaurants){
            if(r.getName().equalsIgnoreCase(restaurantname)){
                restaurant = r;
                break;
            }
        }

        List<Food> foods = restaurant.getFoods();
        int flag = 0;
        for(Food food : foods){
            if((food.getName().equalsIgnoreCase(f.getName())) && (food.getRestaurantId() == f.getRestaurantId()) && (food.getCategory().equalsIgnoreCase(f.getCategory()))){
                flag = 1;
                break;
            }
        }

        if(flag == 1){
            return false;
        }
        else{
            foods.add(f);
            return true;
        }

        /* 
        for(Restaurant r : restaurants){
            if(r.getName().equalsIgnoreCase(restaurantname)){
                List<Food> foods = r.getFoods();
                for(Food match : foods){
                    if(match.getName().equalsIgnoreCase(f.getName())){
                        //System.out.println(f.getName()+ " already exists in the restaurant "+restaurantname+" in the same category");
                        return 1;
                    }
                }
                foods.add(f);
                //saveToFile();
                return 2;
            }
        }
        //System.out.println("This restaurant does not exist.");
        return 3;
        */
    }

    public List<Restaurant> getRestaurantsList()
    {
        return restaurants;
    }

    /*
    List<Food> getFoodList(){
        return foods;
    }
    */
    /*
    public void showDetailsofRestaurants()
    {
        for(Restaurant r : restaurants){
            r.showDetails();
            System.out.println();
        }
    }

    public void showDetailsofFoods()
    {
        for(Food f : foods){
            f.showDetails();
            System.out.println();
        }
    }

     */
    public List<Restaurant> searchRestaurantsByName(String name) {
        List<Restaurant> list = new ArrayList<>();

        for(Restaurant r : restaurants){
            if(r.getName().toLowerCase().contains(name.toLowerCase())){
                list.add(r);
            }
        }
        System.out.println(list.size());
        return list;
    }

    public List<Restaurant> searchRestaurantsByScore(double score1, double score2) {
        List<Restaurant> list = new ArrayList<>();

        for(Restaurant r : restaurants){
            if((score1 <= r.getScore()) && (score2 >= r.getScore())){
                list.add(r);
            }
        }
        return list;
    }

    public List<Restaurant> searchRestaurantsByCategory(String category){
        List<Restaurant> list = new ArrayList<>();
        for(Restaurant r : restaurants){
            List<String> categories = r.getCategories();

            for(String c : categories){
                if(c.toLowerCase().contains(category.toLowerCase())){
                    list.add(r);
                }
            }
        }
        return list;
    }

    public List<Restaurant> searchRestaurantsByPrice(String price) {
        List<Restaurant> list = new ArrayList<>();
        for(Restaurant r : restaurants){
            if(price.equals(r.getPrice())){
                list.add(r);
            }
        }
        return list;
    }

    public List<Restaurant> searchRestaurantsByZipCode(String zipcode) {
        List<Restaurant> list = new ArrayList<>();
        for(Restaurant r : restaurants){
            if(zipcode.equals(r.getZipCode())){
                list.add(r);
            }
        }
        return list;
    }

    public HashMap<String, List<String>> differentCategoryWiseLiftOfRestaurants()
    {
        List<String> allCategories = new ArrayList<>();

        List<String> temp = new ArrayList<>();
        for(Restaurant r : restaurants){
            temp = r.getCategories(); //taking the list of categories of a restaurant in temp list
            for(String c : temp){     //parsing through temp list
                int alreadyExist = -1;
                for (String match : allCategories) {  //check if the category already exist in allcategory exist
                    if (c.equalsIgnoreCase(match)) {
                        alreadyExist = 0;
                        break;
                    }
                }
                if(alreadyExist == -1){
                    allCategories.add(c);
                }
            }
        }

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String category : allCategories){
            //search in the restaurant list if this category exist or not
            //System.out.printf(category+":");
            List<String>restaurantNames = new ArrayList<>();
            for(Restaurant r : restaurants){
                List<String>temp1 = r.getCategories();
                for(String match : temp1){
                    if(match.equalsIgnoreCase(category)){
                        restaurantNames.add(r.getName());
                    }
                }
            }
            map.put(category, restaurantNames);
        }

        return map;
    }


    //for searching food

    public List<Food> searchFoodItemByName(String name)
    {
        List<Food> list = new ArrayList<>();

        for(Restaurant r : restaurants){
            List<Food> foods = r.getFoods();
            for(Food f : foods){
                if(f.getName().toLowerCase().contains(name.toLowerCase())){
                    list.add(f);
                }
            }
        }

        System.out.println("list size " + list.size());
        return list;

    }

    public List<Food> searchFoodItemByNameInAGivenRestaurant(String fooditem, String restaurant)
    {
        
        List<Food> foodList = new ArrayList<>();

        for(Restaurant r : restaurants){
            if(r.getName().equalsIgnoreCase(restaurant.toLowerCase())){
                List<Food> foods = r.getFoods();
                for(Food f : foods){
                    if(f.getName().toLowerCase().contains(fooditem.toLowerCase())){
                        foodList.add(f);
                    }
                }
            }
        }

        return foodList;

    }

    public List<Food> searchFoodItemByCategory(String category)
    {
        List<Food> foodList = new ArrayList<>();

        for(Restaurant r : restaurants){
            List<Food> foods = r.getFoods();
            for(Food f : foods){
                if(f.getCategory().toLowerCase().contains(category.toLowerCase())){
                    foodList.add(f);
                }
            }
        }

        return foodList;
    }



    public List<Food> searchFoodItemByCaregoryInAGivenRestaurant(String category, String restaurant)
    {
        List<Food> foodList = new ArrayList<>();

        for(Restaurant r : restaurants){
            if(r.getName().equalsIgnoreCase(restaurant)){
                List<Food> foods = r.getFoods();
                for(Food f : foods){
                    if(f.getCategory().toLowerCase().contains(category.toLowerCase())){
                        foodList.add(f);
                    }
                }
            }
        }

        return foodList;

    }

    public List<Food> searchFoodItemByPriceRange(double range1, double range2)
    {
        List<Food> foodList = new ArrayList<>();

        for(Restaurant r : restaurants){
            List<Food> foods = r.getFoods();
            for(Food f : foods){
                if((range1 <= f.getPrice()) && (range2 >= f.getPrice())){
                    foodList.add(f);
                }
            }
        }

        return foodList;
    }

    public List<Food> searchFoodItemByPriceRangeInAGivenRestaurant(double range1, double range2, String restaurant)
    {
        List<Food> foodList = new ArrayList<>();

        for(Restaurant r : restaurants){
            if(r.getName().equalsIgnoreCase(restaurant)){
                List<Food> foods = r.getFoods();
                for(Food f : foods){
                    if((range1 <= f.getPrice()) && (range2 >= f.getPrice())){
                        foodList.add(f);
                    }
                }
            }
        }

        return foodList;
    }

    public List<Food> costliestFoodItemInAGivenRestaurant(String restaurant)
    {
        List<Food> foodList = new ArrayList<>();

        double maxPrice = 0;

        for(Restaurant r : restaurants){
            if(r.getName().equalsIgnoreCase(restaurant)){
                List<Food> foods = r.getFoods();
                for(Food f : foods){
                    if(f.getPrice() > maxPrice){
                       maxPrice = f.getPrice();
                    }
                }
                for(Food f : foods){
                    if(f.getPrice() == maxPrice){
                        foodList.add(f);
                    }
                }
            }
        }  

        return foodList;

    }

    public HashMap<String, Integer> displayTotalFoodItems()
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(Restaurant r : restaurants){
            List<Food> foods = r.getFoods();
            int count = foods.size();
            map.put(r.getName(),count);
        }
        return map;
    }


}
