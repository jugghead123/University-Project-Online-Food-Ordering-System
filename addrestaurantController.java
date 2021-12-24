package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class addrestaurantController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button addrestaurantButton;
    @FXML
    private ChoiceBox category;
    @FXML
    private TextField meal1TextField;
    @FXML
    private TextField meal2TextField;
    @FXML
    private TextField meal3TextField;
    @FXML
    private TextField meal4TextField;
    @FXML
    private TextField restaurantTextField;

    ObservableList<String> categorylist = FXCollections.observableArrayList("Pizza", "Burger", "Dessert");


    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addrestaurantButtonOnAction(ActionEvent event) {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("successfuladdedrestaurant.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage homepageStage = new Stage();
            homepageStage.setTitle("YallaNakol");
            homepageStage.setScene(new Scene(root));
            homepageStage.show();
        } catch (Exception e) {

            e.printStackTrace();
            e.getCause();
        }

        Restaurant r1 = new Restaurant(restaurantTextField.getText(), (String) category.getSelectionModel().getSelectedItem());
        Meal r1meals = new Meal(meal1TextField.getText(), meal2TextField.getText(), meal3TextField.getText(), meal4TextField.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        category.setItems(categorylist);
        category.setValue("mmmm");
    }

}
