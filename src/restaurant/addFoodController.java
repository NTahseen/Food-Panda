package restaurant;

import java.io.IOException;

import RestaurantApp.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addFoodController {

    RestaurantManager info = new RestaurantManager();

    private Main main;
    private String username;

    @FXML
    private Button add;

    @FXML
    private Button back;

    @FXML
    private TextField giveinput1;

    @FXML
    private TextField giveinput2;

    @FXML
    private TextField giveinput3;

    @FXML
    private TextField giveinput4;

    @FXML
    void add(ActionEvent event) {
        int restaurantId = Integer.parseInt(giveinput1.getText());
        String foodName = giveinput2.getText();
        String Category = giveinput3.getText();
        Double price = Double.parseDouble(giveinput4.getText());

        Food food = new Food(restaurantId, Category, foodName, price);       

        try {
            info.addFoodItemInASpecificRestaurant(food ,username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) throws Exception {
        main.showHomePage(username);
    }

    @FXML
    void giveinputbox1(ActionEvent event) {

    }

    @FXML
    void giveinputbox2(ActionEvent event) {

    }

    @FXML
    void giveinputbox3(ActionEvent event) {

    }

    @FXML
    void giveinputbox4(ActionEvent event) {

    }

    void setMain(Main main){
        this.main = main;
    }

    void setName(String name){
        this.username = name;
    }

}
