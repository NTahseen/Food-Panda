package restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RestaurantApp.Food;
import RestaurantApp.Restaurant;
import RestaurantApp.RestaurantManager;
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

public class searchFoodController {

    private Main main;

    //List<Restaurant> restaurants;
    RestaurantManager info = new RestaurantManager();

    @FXML
    private Button allList;

    @FXML
    private Button back;

    @FXML
    private MenuItem costliestFood;

    @FXML
    private TableColumn<Food , String> foodCategoryCol;

    @FXML
    private TableColumn<Food , Integer> foodIdCol;

    @FXML
    private TableColumn<Food , String> foodNameCol;

    @FXML
    private TableColumn<Food ,Double> foodPriceCol;

    @FXML
    private Label giveinput1;

    @FXML
    private Label giveinput2;

    @FXML
    private Label giveinput3;

    @FXML
    private TextField giveinputbox1;

    @FXML
    private TextField giveinputbox2;

    @FXML
    private TextField giveinputbox3;

    @FXML
    private Button search;

    @FXML
    private MenuItem searchFoodByCategory;

    @FXML
    private MenuItem searchFoodByName;

    @FXML
    private MenuItem searchFoodByPriceRange;

    @FXML
    private MenuItem byCategoryAll;

    @FXML
    private MenuItem byNameAll;

    @FXML
    private MenuItem byPriceAll;

    @FXML
    private TableView<Food> tableView = new TableView<>();

    @FXML
    private TextArea textArea;

    int check = 0;

    @FXML
    void initialize() {
    // Initialize table columns and set cell value factories
        foodIdCol.setCellValueFactory(new PropertyValueFactory<>("restaurantId"));
        foodNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        foodCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        foodPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
    }

    @FXML
    void search(ActionEvent event) throws Exception {
        tableView.setOpacity(1);

        //info.readRestaurantFromFile();
        //info.readFoodFromFile();

        List<Food> res = new ArrayList<>();

        switch(check){
            case 1:{
                tableView.setOpacity(1);
                String name = giveinputbox1.getText();
                //System.out.println("input nise " + name);
                res = info.searchFoodItemByName(name);

                //System.out.println("aaaaaaaaaaaaaaaa" + res.size());

                for(Food f : res){
                    System.out.println(f.getName());
                }
                
                break;
            }
            case 2:{
                String category = giveinputbox1.getText();
                //System.out.println("input nise " + name);
                res = info.searchFoodItemByCategory(category);
                
                break;
            }
            case 3:{
                String name = giveinputbox1.getText();
                double lscore = Double.parseDouble(giveinputbox2.getText());
                double hscore = Double.parseDouble(giveinputbox3.getText());
                
                res = info.searchFoodItemByPriceRangeInAGivenRestaurant(lscore, hscore, name);
                break;
            }
            case 4:{
                String name = giveinputbox1.getText();
                res = info.costliestFoodItemInAGivenRestaurant(name);

                break;
            }
            case 5:{
                String name = giveinputbox1.getText();
                res = info.searchFoodItemByName(name);
                break;
            }
            case 6:{
                String category = giveinputbox1.getText();
                res = info.searchFoodItemByCategory(category);
                break;
            }
            case 7:{
                double lower = Double.parseDouble(giveinputbox1.getText());
                double upper = Double.parseDouble(giveinputbox2.getText());

                res = info.searchFoodItemByPriceRange(lower, upper);
                break;
            }
            case 8:{
                tableView.setOpacity(0);
                textArea.setOpacity(1);

                HashMap<String, Integer> map = new HashMap<>();
                map = info.displayTotalFoodItems();
                String result = new String();

                for(var e : map.entrySet()){
                    System.out.println(e.getKey()+":"+e.getValue());
                    result = result + e.getKey() + " : " + e.getValue() + "\n\n";
                }

                /* 

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

                */



                textArea.setText(result);
                System.out.println(result);
                break;
            }
        }
        tableView.getItems().clear();

        ObservableList<Food> observableList = FXCollections.observableArrayList(res);
        tableView.setItems(observableList);
    }
    

    @FXML
    void searchFoodByCategory(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Enter Category :");
        giveinput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0);
        search.setOpacity(1); 
        back.setOpacity(1);
        giveinput3.setOpacity(0);
        giveinputbox3.setOpacity(0);
        textArea.setOpacity(0);
        check = 2;
    }

    @FXML
    void searchFoodByName(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Enter Name :");
        giveinput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0); 
        back.setOpacity(1);
        search.setOpacity(1);
        giveinput3.setOpacity(0);
        giveinputbox3.setOpacity(0);
        textArea.setOpacity(0);
        check = 1;
    }

    @FXML
    void searchFoodByPriceRange(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Restaurant Name :");
        giveinput2.setOpacity(1);
        giveinput2.setText("Lower Range :");
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(1); 
        back.setOpacity(1);
        search.setOpacity(1);
        giveinput3.setOpacity(1);
        giveinputbox3.setOpacity(1);
        giveinput3.setText("Upper Range :");
        textArea.setOpacity(0);
        check = 3;
    }

    @FXML
    void costliestFood(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Restaurant Name :");
        giveinput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0); 
        back.setOpacity(1);
        search.setOpacity(1);
        giveinput3.setOpacity(0);
        giveinputbox3.setOpacity(0);
        textArea.setOpacity(0);
        check = 4;
    }

    @FXML
    void byCategoryAll(ActionEvent event) {
        giveinputbox1.setText(null);
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Category Name :");
        giveinput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0); 
        back.setOpacity(1);
        search.setOpacity(1);
        giveinput3.setOpacity(0);
        giveinputbox3.setOpacity(0);
        textArea.setOpacity(0);
        check = 6;
        
    }

    @FXML
    void byNameAll(ActionEvent event) {
        giveinputbox2.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Food Name :");
        giveinput2.setOpacity(0);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(0); 
        back.setOpacity(1);
        search.setOpacity(1);
        giveinput3.setOpacity(0);
        giveinputbox3.setOpacity(0);
        textArea.setOpacity(0);
        check = 5;
    }

    @FXML
    void byPriceAll(ActionEvent event) {
        giveinputbox2.setText(null);
        giveinputbox1.setText(null);
        giveinput1.setOpacity(1);
        giveinput1.setText("Lower Range :");
        giveinput2.setOpacity(1);
        giveinputbox1.setOpacity(1);
        giveinputbox2.setOpacity(1);
        giveinputbox2.setOpacity(1); 
        giveinput2.setText("Upper Range");
        back.setOpacity(1);
        search.setOpacity(1);
        giveinput3.setOpacity(0);
        giveinputbox3.setOpacity(0);
        textArea.setOpacity(0);
        check = 7;
    }

    @FXML
    void allList(ActionEvent event) {
        giveinputbox2.setText(null);
        giveinput1.setOpacity(0);
        //giveinput1.setText("Food Name :");
        giveinput2.setOpacity(0);
        giveinputbox1.setOpacity(0);
        giveinputbox2.setOpacity(0); 
        back.setOpacity(1);
        search.setOpacity(1);
        giveinput3.setOpacity(0);
        giveinputbox3.setOpacity(0);
        textArea.setOpacity(1);
        check = 8;
        search.fire();
    }

    @FXML
    void back(ActionEvent event) throws Exception {
        main.showFoodSearchPage();
    }

    void setMain(Main main) {
        this.main = main;
    }

}
