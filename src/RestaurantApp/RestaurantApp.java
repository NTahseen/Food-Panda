package RestaurantApp;

import java.io.*;
import java.util.*;

public class RestaurantApp {

    public static void showDetailsOfAFood(Food f)
    {
        System.out.println("Restaurant Id : "+ f.getRestaurantId());
        System.out.println("Category : "+ f.getCategory());
        System.out.println("Name : "+ f.getName());
        System.out.println("Price : "+ f.getPrice());
        System.out.println();
    }

    public static void showDetailsOfARestaurant(Restaurant r)
    {
        System.out.println("Restaurant Id : "+ r.getId());
        System.out.println("Name : "+ r.getName());
        System.out.println("Score : "+ r.getScore());
        System.out.println("Price : "+ r.getPrice());
        System.out.println("Zip Code : "+ r.getZipCode());
        System.out.printf("Catagories : ");

        List<String> categories = r.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            //if(categories.get(i).isEmpty())break;
            System.out.print(categories.get(i));
            if (i < categories.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) throws Exception{
        RestaurantManager restaurantManager = new RestaurantManager();

        int choice;
        Scanner scanner = new Scanner(System.in);

        //restaurantManager.readRestaurantFromFile();
        //restaurantManager.readFoodFromFile();

        /* 
        String INPUT_FILE_NAME = "restaurant.txt";

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
            restaurantManager.addRestaurant(r1);
        }
        br.close();
        */

        /* 
        BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            //System.out.println(line);
            String [] array = line.split(",(?! )", -1);

            int restaurantId = Integer.parseInt(array[0]);
            double price = Double.parseDouble(array[3]);

            Food f1 = new Food(restaurantId,array[1],array[2],price);
            if(restaurantManager.addFoodItem(f1)){

            }
            else{
                System.out.println(f1.getName()+ " already exists in the restaurant in the same category");
            }
        }
        br.close();
        */

        do {
            System.out.println("Main Menu:");
            System.out.println("1) Search Restaurants");
            System.out.println("2) Search Food Items");
            System.out.println("3) Add Restaurant");
            System.out.println("4) Add Food Item to the Menu");
            System.out.println("5) Exit Syestem");

            System.out.println("Enter option : ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Search Restaurants

                    int option;

                    do{
                        System.out.println("Restaurant Searching Options:");
                        System.out.println("1) By Name");
                        System.out.println("2) By Score");
                        System.out.println("3) By Category");
                        System.out.println("4) By Price");
                        System.out.println("5) By Zip COde");
                        System.out.println("6) Different Category Wise List of Restaurants");
                        System.out.println("7) Back to Main Menu");

                        option = scanner.nextInt();
                        scanner.nextLine();


                        if(option == 1) {
                            System.out.println("Input a resturant name : ");
                            String name = scanner.nextLine();

                            List<Restaurant> restaurantList = restaurantManager.searchRestaurantsByName(name);

                            if(restaurantList.isEmpty()){
                                System.out.println("No such restaurant with this name");
                            }
                            else{
                                for(Restaurant r : restaurantList){
                                    showDetailsOfARestaurant(r);
                                }
                            }
                        }

                        else if (option == 2) {
                            System.out.println("Input two numbers as range : ");
                            double score1 = scanner.nextDouble();
                            double score2 = scanner.nextDouble();

                            List<Restaurant> restaurantList = restaurantManager.searchRestaurantsByScore(score1, score2);

                            if(restaurantList.isEmpty()){
                                System.out.println("No such restaurant with this score range");
                            }
                            else{
                                for(Restaurant r : restaurantList){
                                    showDetailsOfARestaurant(r);
                                }
                            }
                        }

                        else if (option == 3) {
                            System.out.println("Input a category : ");
                            String category = scanner.nextLine();

                            List<Restaurant> restaurantList = restaurantManager.searchRestaurantsByCategory(category);

                            if(restaurantList.isEmpty()){
                                System.out.println("No such restaurant with this category");
                            }
                            else{
                                for(Restaurant r : restaurantList){
                                    showDetailsOfARestaurant(r);
                                }
                            }
                        }

                        else if (option == 4) {
                            System.out.println("Input a price : ");
                            String price = scanner.nextLine();

                            List<Restaurant> restaurantList = restaurantManager.searchRestaurantsByPrice(price);

                            if(restaurantList.isEmpty()){
                                System.out.println("No such restaurant with this price");
                            }
                            else{
                                for(Restaurant r : restaurantList){
                                    showDetailsOfARestaurant(r);
                                }
                            }
                        }

                        else if (option == 5) {
                            System.out.println("Input a zip code : ");
                            String zipCode = scanner.nextLine();

                            List<Restaurant> restaurantList = restaurantManager.searchRestaurantsByZipCode(zipCode);

                            if(restaurantList.isEmpty()){
                                System.out.println("No such restaurant with this ZipCode");
                            }
                            else{
                                for(Restaurant r : restaurantList){
                                    showDetailsOfARestaurant(r);
                                }
                            }
                        }

                        else if (option == 6) {
                            HashMap<String, List<String>> map = restaurantManager.differentCategoryWiseLiftOfRestaurants();
                            for(var e : map.entrySet()){
                                if(!e.getKey().isEmpty()) {
                                    System.out.printf(e.getKey() + ":");

                                    List<String> values = e.getValue();
                                    for (int i = 0; i < values.size(); i++) {
                                        System.out.print(values.get(i));
                                        if (i < values.size() - 1) {
                                            System.out.print(",");
                                        }
                                    }
                                    System.out.println();
                                }
                            }
                        }

                        else if (option == 7) {
                            break;
                        }

                        else {
                            System.out.println("Invalid Option. Please try again.");
                        }

                    }while(option != 7);

                    break;


                case 2: // Search Food items

                    do{
                        System.out.println("Food Item Searching Options:");
                        System.out.println("1) By Name");
                        System.out.println("2) By Name in a Given Restaurant");
                        System.out.println("3) By Category");
                        System.out.println("4) By Category in a Given Restaurant");
                        System.out.println("5) By Price Range");
                        System.out.println("6) By Price Range in a Given Category");
                        System.out.println("7) Costliest Food Item(s) on the Menu in a Given Restaurant");
                        System.out.println("8) List of Restaurants and Total Food Item on the Menu");
                        System.out.println("9) Back to Main Menu");

                        option = scanner.nextInt();
                        scanner.nextLine();


                        if(option == 1) {
                            System.out.println("Input a food item : ");
                            String name = scanner.nextLine();

                            List<Food> foodList = restaurantManager.searchFoodItemByName(name);

                            if(foodList.isEmpty()){
                                System.out.println("No such food with this name");
                            }
                            else{
                                for(Food f : foodList){
                                    showDetailsOfAFood(f);
                                }
                            }

                        }

                        else if (option == 2) {
                            System.out.println("Input a food item : ");
                            String foodname = scanner.nextLine();
                            System.out.println("Input a restaurant name : ");
                            String restaurantname = scanner.nextLine();

                            List<Food> foodList = restaurantManager.searchFoodItemByNameInAGivenRestaurant(foodname, restaurantname);

                            if(foodList.isEmpty()){
                                System.out.println("No such food item with this name on the menu of this restaurant");
                            }
                            else{
                                for(Food f : foodList){
                                    showDetailsOfAFood(f);
                                }
                            }
                        }

                        else if (option == 3) {
                            System.out.println("Input a category : ");
                            String category = scanner.nextLine();

                            List<Food> foodList = restaurantManager.searchFoodItemByCategory(category);

                            if(foodList.isEmpty()){
                                System.out.println("No such food item with this category");
                            }
                            else{
                                for(Food f : foodList){
                                    showDetailsOfAFood(f);
                                }
                            }
                        }

                        else if (option == 4) {
                            System.out.println("Input a category : ");
                            String category = scanner.nextLine();
                            System.out.println("Input a restaurant name : ");
                            String restaurantname = scanner.nextLine();

                            List<Food> foodList = restaurantManager.searchFoodItemByCaregoryInAGivenRestaurant(category, restaurantname);

                            if(foodList.isEmpty()){
                                System.out.println("No such food item with this category in this restaurant");
                            }
                            else{
                                for(Food f : foodList){
                                    showDetailsOfAFood(f);
                                }
                            }
                        }

                        else if (option == 5) {
                            System.out.println("Input two numbers as range : ");
                            double range1 = scanner.nextDouble();
                            double range2 = scanner.nextDouble();

                            List<Food> foodList = restaurantManager.searchFoodItemByPriceRange(range1, range2);

                            if(foodList.isEmpty()){
                                System.out.println("No such food item with this price range");
                            }
                            else{
                                for(Food f : foodList){
                                    showDetailsOfAFood(f);
                                }
                            }
                        }

                        else if (option == 6) {
                            System.out.println("Input two numbers as range : ");
                            double range1 = scanner.nextDouble();
                            double range2 = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Input a restaurant name : ");
                            String restaurantName = scanner.nextLine();

                            List<Food> foodList = restaurantManager.searchFoodItemByPriceRangeInAGivenRestaurant(range1, range2, restaurantName);

                            if(foodList.isEmpty()){
                                System.out.println("No such food item with this price range on the menu of this restaurant");
                            }
                            else{
                                for(Food f : foodList){
                                    showDetailsOfAFood(f);
                                }
                            }
                        }

                        else if(option == 7){
                            System.out.println("Input a restaurant name : ");
                            String restaurantname = scanner.nextLine();

                            List<Food> foodList = restaurantManager.costliestFoodItemInAGivenRestaurant(restaurantname);

                            if(foodList.isEmpty()){
                                System.out.println("No food item in this restaurant or restaurant doesn't exist");
                            }
                            else{
                                for(Food f : foodList){
                                    showDetailsOfAFood(f);
                                }
                            }
                        }

                        else if(option == 8){
                            HashMap<String,Integer> map = restaurantManager.displayTotalFoodItems();

                            for(var e : map.entrySet()){
                                System.out.println(e.getKey()+":"+e.getValue());
                            }

                            break;
                        }

                        else if (option == 9) {
                            break;
                        }

                        else {
                            System.out.println("Invalid Option. Please try again.");
                        }

                    }while(option != 9);

                    break;

                case 3:

                    System.out.println("Input the name of the restaurant : ");
                    String name = scanner.nextLine();
                    System.out.println("Input the Id of the restaurant : ");
                    int id = scanner.nextInt();
                    System.out.println("Input Score for this restaurant : ");
                    double score = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Input Price for this restaurant : ");
                    String price = scanner.nextLine();
                    System.out.println("Input zipcode for this restaurant : ");
                    String zipcode = scanner.nextLine();
                    System.out.println("How many categories you wanna insert?(atmost three and atleat one)");
                    int number = scanner.nextInt();
                    scanner.nextLine();

                    List<String> s = new ArrayList<>();
                    for(int i = 1; i <= number; i++){
                        System.out.println("enter category " + i);
                        String str = scanner.nextLine();
                        s.add(str);
                    }
                    if(number == 1){
                        s.add("");
                        s.add("");
                    }
                    else if(number == 2){
                        s.add("");
                    }

                    Restaurant r = new Restaurant(id, name, score, price, zipcode, s);

                    if(restaurantManager.addRestaurant(r)){
                        System.out.println(r.getName() + " has been added successfully");
                    }
                    else{
                        System.out.println(r.getName()+" restaurant already exists.");
                    }

                    break;

                case 4:

                    System.out.println("Input the name of the food item : ");
                    String foodName = scanner.nextLine();
                    System.out.println("Input the name of the restaurant : ");
                    String restaurantName = scanner.nextLine();
                    System.out.println("Input the Id of the restaurant : ");
                    int restaurantId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the category of the food : ");
                    String category = scanner.nextLine();
                    System.out.println("Enter price of the food : ");
                    double foodPrice = scanner.nextDouble();
                    scanner.nextLine();

                    Food f = new Food(restaurantId, category, foodName, foodPrice);

                    if(restaurantManager.addFoodItemInASpecificRestaurant(f, restaurantName)){
                        System.out.println(foodName + " has been added in "+ restaurantName);
                    }
                    else{
                        System.out.println("cannot add this food item");
                    }

                    break;

                case 5:

                    BufferedWriter bw = new BufferedWriter(new FileWriter("restaurant.txt"));

                    List<Restaurant> restaurants = restaurantManager.getRestaurantsList();
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

                    bw = new BufferedWriter((new FileWriter("menu.txt")));

                    List<Food> foods = new ArrayList<>();
                    List<Restaurant> restaurantsList = restaurantManager.getRestaurantsList();

                    for(Restaurant restaurant : restaurantsList){
                        List<Food> tempFoodList = restaurant.getFoods();
                        for(Food food : tempFoodList){
                            foods.add(food);
                        }
                    }

                    for(Food food : foods){
                        bw.write(food.getRestaurantId()+","+food.getCategory()+","+food.getName()+","+food.getPrice());
                        bw.write(System.lineSeparator());
                    }
                    bw.close();;

                    break;

                default:
                    System.out.println("Invalid option. Please try again.");

            }
            System.out.println();
        }while(choice != 5);
        scanner.close();
    }
}
