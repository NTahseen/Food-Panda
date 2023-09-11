package customer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


import javax.swing.text.TableView.TableCell;

import RestaurantApp.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class searchRestaurantController {

    //private static final String HashMap = null;

    private Main main;

    //List<Restaurant> restaurants;
    RestaurantManager info = new RestaurantManager();
    
    
    @FXML
    private Button search;

    @FXML
    private Button back;

    @FXML
    private Label giveInput2;

    @FXML
    private Label giveinput1;

    @FXML
    private TextField giveinputbox1;

    @FXML
    private TextField giveinputbox2;

    @FXML
    private TextArea textArea;

    @FXML
    private MenuItem searchRestaurantByCategory;

    @FXML
    private MenuItem searchRestaurantByName;

    @FXML
    private MenuItem searchRestaurantByPrice;

    @FXML
    private MenuItem searchRestaurantByScore;

    @FXML
    private MenuItem searchRestaurantByZipCode;

    @FXML
    private MenuItem differentCategoryWiseList;

    @FXML
    private TableColumn<Restaurant, List<String>> resCategoryCol;

    @FXML
    private TableColumn<Restaurant , Integer> resIdCol;

    @FXML
    private TableColumn<Restaurant , String> resNameCol;

    @FXML
    private TableColumn<Restaurant, String> resPriceCol;

    @FXML
    private TableColumn<Restaurant, Double> resScoreCol;

    @FXML
    private TableColumn<Restaurant , String> resZipcodeCol;

    @FXML
    private TableView<Restaurant> tableView = new TableView<>();



    @FXML
    void searchRestaurantByCategory(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Enter Category :");
        giveInput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0);
        search.setOpacity(1); 
        back.setOpacity(1);
        textArea.setOpacity(0);
        check = 1;
    }

    @FXML
    void searchRestaurantByName(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Enter Name :");
        giveInput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0); 
        back.setOpacity(1);
        search.setOpacity(1);
        textArea.setOpacity(0);
        check = 2;
    }

    @FXML
    void searchRestaurantByPrice(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Enter Price :");
        giveInput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0);
        back.setOpacity(1);
        search.setOpacity(1);
        textArea.setOpacity(0);
        check = 3; 
    }

    @FXML
    void searchRestaurantByZipCode(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Enter ZipCode :");
        giveInput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0); 
        back.setOpacity(1);
        search.setOpacity(1);
        textArea.setOpacity(0);
        check = 5;
    }

    @FXML
    void searchScoreByScore(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Enter Lower Score :");
        giveInput2.setOpacity(1);
        giveInput2.setText("Enter Upper Score :");
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(1); 
        back.setOpacity(1);
        search.setOpacity(1);
        textArea.setOpacity(0);
        check = 4;

    }

    @FXML
    void differentCategoryWiseList(ActionEvent event) {
        giveinput1.setOpacity(0);
        giveInput2.setOpacity(0);
        giveinputbox1.setOpacity(0);
        giveinputbox2.setOpacity(0);
        textArea.setOpacity(1);
        back.setOpacity(1);
        tableView.setOpacity(0);
        
        check = 6;
        search.fire();
    }

    /* 
    @FXML
void initialize() {
    // Initialize table columns and set cell value factories
    resCategoryCol.setCellValueFactory(new PropertyValueFactory<>("categories"));
    resIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    resNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    resPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    resScoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
    resZipcodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));

    // Add a cell factory to format the score column
    resScoreCol.setCellFactory(column -> new TableCell<Restaurant, Double>() {
        @Override
        protected void updateItem(Double score, boolean empty) {
            super.updateItem(score, empty);
            if (empty || score == null) {
                setText(null);
            } else {
                setText(String.format("%.2f", score));
            }
        }
    });
}
*/

@FXML
void initialize() {
    // Initialize table columns and set cell value factories
    resCategoryCol.setCellValueFactory(new PropertyValueFactory<>("categories"));
    resIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    resNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    resPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    resZipcodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));

    // Add a cell factory to format the score column
    resScoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
    /* 
    resScoreCol.setCellFactory(column -> new TableCell<Restaurant, Double>() {
        @Override
        protected void updateItem(Double score, boolean empty) {
            super.updateItem(score, empty);
            if (empty || score == null) {
                setText(null);
            } else {
                setText(String.format("%.2f", score));
            }
        }
    });
    */

    // Add columns for id, password, and zipcode
    /* 
    TableColumn<Restaurant, Integer> idColumn = new TableColumn<>("ID");
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    
    TableColumn<Restaurant, String> passwordColumn = new TableColumn<>("Password");
    passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
    
    TableColumn<Restaurant, String> zipcodeColumn = new TableColumn<>("Zip Code");
    zipcodeColumn.setCellValueFactory(new PropertyValueFactory<>("zipcode"));

    tableView.getColumns().addAll(idColumn, passwordColumn, zipcodeColumn);
    */
}





    private int check = 0;


    @FXML
    void search(ActionEvent event) throws Exception {
        tableView.setOpacity(1);

        //info.readRestaurantFromFile();
        //info.readFoodFromFile();

        info = main.getRestaurantManager();


        List<Restaurant> res = new ArrayList<>();

        switch(check){

            case 1:{
                
                String category = giveinputbox1.getText();
                res = info.searchRestaurantsByCategory(category);
                System.out.println("searched by category");
                
                break;
            }
            case 2:{
                String name = giveinputbox1.getText();
                //System.out.println("input nise " + name);
                res = info.searchRestaurantsByName(name);

                
                
                break;
            }
            case 3: {
                String price = giveinputbox1.getText();
                if (!price.isEmpty()) {
                    res = info.searchRestaurantsByPrice(price);
                    for (Restaurant r : res) {
                        System.out.println(r.getName());
                    }
                } else {
                    System.out.println("Price input is empty.");
                }
                break;
            }
            
            
            case 4:{
                double hscore = Double.parseDouble(giveinputbox2.getText());
                double lscore = Double.parseDouble(giveinputbox1.getText());
                res = info.searchRestaurantsByScore(lscore, hscore);
                for(Restaurant r : res){
                    System.out.println(r.getName());
                }
                break;
            }
            case 5:{
                System.out.println("in zipcode");
                String zipcode = giveinputbox1.getText();
                res = info.searchRestaurantsByZipCode(zipcode);
                System.out.println(res.size() + "hello");
                for(Restaurant r : res){
                    System.out.println(r.getName());
                }
                break;
            }
            case 6:{
                //category wise list
                //System.out.println("dhukse");
                tableView.setOpacity(0);
                textArea.setOpacity(1);

                HashMap<String, List<String>> map = new HashMap<>();
                map = info.differentCategoryWiseLiftOfRestaurants();
                String result = new String();
                

                for (var e : map.entrySet()) {
                    if (!e.getKey().isEmpty()) {
                    System.out.printf(e.getKey() + ":");
                    result = result + e.getKey() + " : ";

                    List<String> values = e.getValue();
                    for (int i = 0; i < values.size(); i++) {
                        System.out.print(values.get(i));
                        result = result + values.get(i);
                        if (i < values.size() - 1) {
                            System.out.print(",");
                            result = result + " , ";
                        }
                        //result = result + values.get(i) + ", "; // Append individual elements
                     }
                    result = result + "\n\n";
                    }
                }



                textArea.setText(result);
                System.out.println(result);
                break;

                
            }
            default:{
                System.out.println(check);
                break;
            }
        }
        tableView.getItems().clear();

        ObservableList<Restaurant> observableList = FXCollections.observableArrayList(res);
        tableView.setItems(observableList);

    }

    @FXML
    void back(ActionEvent event) throws Exception {
        main.showHomePage("");
    }

    void setMain(Main main) {
        this.main = main;
    }

}
