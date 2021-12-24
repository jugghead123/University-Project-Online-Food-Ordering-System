package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;

public class ManagerhomepageController {

    @FXML
    private Button addrestaurantButton;
    @FXML
    private Button addmealButton;
    @FXML
    private Button deletemealButton;

    public void addrestaurantButtonOnAction(ActionEvent event) {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("addrestaurant.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage homepageStage = new Stage();
            homepageStage.setTitle("YallaNakol");
            homepageStage.setScene(new Scene(root));
            homepageStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }


    public void addmealButtonOnAction(ActionEvent event) {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("addmeal.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage homepageStage = new Stage();
            homepageStage.setTitle("YallaNakol");
            homepageStage.setScene(new Scene(root));
            homepageStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }

        public void deletemealButtonOnAction (ActionEvent event) {

            try {
                FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("deletemeal.fxml"));
                Parent root = (Parent) fxmloader.load();
                Stage homepageStage = new Stage();
                homepageStage.setTitle("YallaNakol");
                homepageStage.setScene(new Scene(root));
                homepageStage.show();
            } catch (Exception e) {

                System.out.println("Can't load");
            }
        }


    }
