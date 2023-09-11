package Network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RestaurantApp.Food;
import RestaurantApp.Restaurant;
import RestaurantApp.RestaurantManager;
import util.LoginDTO;
import util.NetworkUtil;

public class Server {

    public static HashMap<String, String> restaurantLoginInfo;
    public static List<Restaurant> restaurantList;
    public static List<Food>foodList;

    public static RestaurantManager restaurantManager;

        

    Server() throws Exception{
        
        restaurantManager = new RestaurantManager();
        restaurantList = new ArrayList<>();
        foodList = new ArrayList<>();
        restaurantLoginInfo = new HashMap<>();

        readRestaurantFromFile();
        readFoodFromFile();
        readRestaurantLoginInfoFromFile();

        restaurantManager.setResList(restaurantList);
        restaurantManager.setFoodList(foodList);

        restaurantList = restaurantManager.getResList();

        //System.out.println("hello from server" + restaurantList.size());
        

    }


    public static void main(String[] args) throws Exception {

        new Server();

       
        
        ServerSocket server = new ServerSocket(3000);

        
        while(true){
            Socket clientSocket = server.accept();

            System.out.println("client connected");

            NetworkUtil client = new NetworkUtil(clientSocket);

            new Thread(() -> {

                try {

                    //for restaurant login

                while(true){ //sir er code e ase

                    Object o = client.read();

                    if(o != null){
                      
                        if(o instanceof LoginDTO){
                            LoginDTO loginDTO = (LoginDTO) o;
                            String password = restaurantLoginInfo.get(loginDTO.getUserName());
                            loginDTO.setStatus(loginDTO.getPassword().equals(password));

                            loginDTO.setResList(restaurantList);
                            loginDTO.setFoodList(foodList);
                            loginDTO.setRestaurantManager(restaurantManager);

                            //System.out.println("from server thread" + loginDTO.getRestaurantManager().getRestaurantsList().size());

                            client.write(loginDTO);

                        }
                        
                    }
                }


                } catch (IOException e) {
                    System.out.println("Client disconnected");
                }catch(ClassNotFoundException e){
                    throw new RuntimeException(e);
                }finally{
                    try {
                        client.closeConnection();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                


            }).start();
            
        }
    }

    public static void readRestaurantFromFile() throws Exception {
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
            restaurantList.add(r1);

        }
        br.close();
    }

    public static void readFoodFromFile() throws Exception{
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
                foodList.add(f1);
            }
            else{
                System.out.println(f1.getName()+ " already exists in the restaurant in the same category");
            }
        }
        br.close();
    }

    public static void writeRestaurantToFile() throws Exception{
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
    }

    public static void writeFoodToFile() throws Exception{
        BufferedWriter bw = new BufferedWriter((new FileWriter("menu.txt")));

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
    }

    public static void readRestaurantLoginInfoFromFile() throws Exception{

        String INPUT_FILE_NAME = "restaurantlogin.txt";
        
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String [] array = line.split(",(?! )", -1);

            String name = array[0];
            String password = array[1];
            
            restaurantLoginInfo.put(name, password);

        }
        br.close();
    }

    RestaurantManager getClass3Obj(){
        return restaurantManager;
    }

}
