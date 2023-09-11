package restaurant;

import java.util.ArrayList;
import java.util.List;

import RestaurantApp.Restaurant;
import RestaurantApp.RestaurantManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeController {

    private Main main;

    @FXML
    private Label message;

    String name;

    public void init(String msg) {
        message.setText(msg);
        //Image img = new Image(Main.class.getResourceAsStream("1.png"));
        //image.setImage(img);
    }

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    private Button Menu;

    @FXML
    private Button addFood;

    @FXML
    private TextArea area;

    @FXML
    private Button details;

    @FXML
    private Button logOut;

    @FXML
    void addFood(ActionEvent event) {

    }

    @FXML
    void details(ActionEvent event) throws Exception {
        area.setOpacity(1);
        
        RestaurantManager info = new RestaurantManager();
        //info.readRestaurantFromFile();;
        //info.readFoodFromFile();

        List<Restaurant> res = new ArrayList<>();
        
        res = info.searchRestaurantsByName(name);
        //nam set kora lagbe je login korse tar???????????????????????????????

        
        
    }

    @FXML
    void showMenu(ActionEvent event) {

    }

    void setMain(Main main) {
        this.main = main;
    }

}
