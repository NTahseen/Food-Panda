package restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

import RestaurantApp.*;

public class addRestaurantController {

    private RestaurantManager info;
    @FXML
    private TextField cat1;

    @FXML
    private TextField cat2;

    @FXML
    private TextField cat3;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField score;

    @FXML
    private Button submit;

    @FXML
    private TextField zpcode;

    @FXML
    void submitAction(ActionEvent event) throws Exception {
        info = new RestaurantManager();
        //info.readFoodFromFile();
        //info.readRestaurantFromFile();
        String Name;
        int Id;
        String Cat1;
        String Cat2;
        String Cat3;
        Double Score;
        String Price;
        String zipcode;
        Name = new String();
        Cat1 = new String();
        Cat2 = new String();
        Cat3 = new String();
        Price = new String();
        zipcode = new String();
        Name = name.getText();
        Id = Integer.parseInt(id.getText());
        Cat1 = cat1.getText();
        Cat2 = cat2.getText();
        Cat3 = cat3.getText();
        
        Score = Double.parseDouble(score.getText());
        List<String>categories = new ArrayList<>();
        categories.add(Cat1);
        categories.add(Cat2);
        categories.add(Cat3);

        Restaurant restaurant = new Restaurant(Id, Name, Score, Price, zipcode, categories);
        info.addRestaurant(restaurant);
        System.out.println("here");
        //info.writeRestaurantToFile();
    }

}
