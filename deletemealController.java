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

public class deletemealController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button deletemealButton;
    @FXML
    private ChoiceBox restaurant;
    @FXML
    private TextField mealTextField;

    ObservableList<String> restaurantlist = FXCollections.observableArrayList("Pizza Hut", "Papa John's", "Buffalo Burger", "Holmes Burger", "Sale Sucre", "La Poire");


    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void deletemealButtonOnAction(ActionEvent event) {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("successfuldeletemeal.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage homepageStage = new Stage();
            homepageStage.setTitle("YallaNakol");
            homepageStage.setScene(new Scene(root));
            homepageStage.show();
        } catch (Exception e) {

            e.printStackTrace();
            e.getCause();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        restaurant.setItems(restaurantlist);
        restaurant.setValue("mmmm");
    }

}
