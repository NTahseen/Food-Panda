package customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeController {

    private Main main;

    @FXML
    private Label message;

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
    void searchFood(ActionEvent event) {
        System.out.println("searching food");
        try {
            main.showFoodSearchPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchRestaurant(ActionEvent event) {
        System.out.println("searching restaurant");
        try {
            main.showRestaurantSearchPage();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

}
