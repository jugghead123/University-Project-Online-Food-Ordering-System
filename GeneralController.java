package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class GeneralController implements Initializable{

    @FXML
    private Button loginascustomerButton;
    @FXML
    private Button loginasmanagerButton;
    @FXML
    private ImageView generalImageView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File generalFile = new File("@../../src/Images/shutterstock_554010487-768x384.png");
        Image generalimage = new Image(generalFile.toURI().toString());
        generalImageView.setImage(generalimage);

    }

    @FXML
    public void loginascustomerButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage generalStage = new Stage();
            generalStage.setTitle("YallaNakol");
            generalStage.setScene(new Scene(root));
            generalStage.show();

        } catch (Exception e) {

            System.out.println("Can't load");
        }


    }

    @FXML
    public void loginasmanagerButtonOnAction(ActionEvent event) {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Managerlogin.fxml"));
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
