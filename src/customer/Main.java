package customer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.util.List;

import RestaurantApp.Food;
import RestaurantApp.Restaurant;
import RestaurantApp.RestaurantManager;

public class Main extends Application {

    private Stage stage;
    private NetworkUtil networkUtil;
    private List<Food> foodList;
    private List<Restaurant> resList;
    private RestaurantManager info = new RestaurantManager();

    public Stage getStage() {
        return stage;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        connectToServer();
        showLoginPage();
        //info = new RestaurantManager();
    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 3000;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new Client(this);
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    public void showHomePage(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeController controller = loader.getController();
        controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();


        System.out.println("from main's home page " + info.getRestaurantsList().size());
    }

    public void showRestaurantSearchPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchRestaurant.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchRestaurantController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search Restaurant");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    public void showFoodSearchPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchFood.fxml"));
        Parent root = loader.load();

        // Loading the controller
        searchFoodController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search Food");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }



    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }

    public void setFoodList(List<Food> foodList){
        this.foodList = foodList;
    }

    public List<Food> getFoodList(){
        return foodList;
    }

    public void setResList(List<Restaurant> resList){
        this.resList = resList;
    }

    public List<Restaurant> getResList(){
        return resList;
    }

    RestaurantManager getRestaurantManager(){
        return info;
    }

    void setRestaurantManager(RestaurantManager obj){

        this.info = obj;
        System.out.println("main er set func theke " + info.getResList().size());
    }
    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }
}
