package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PizzaController implements Initializable {

    @FXML
    private Button pizzaButton;
    @FXML
    private Button pizzahutorderButton;
    @FXML
    private Button papajohnsorderButton;
    @FXML
    private ImageView pizzahutImageView;
    @FXML
    private ImageView papajohnsImageView;

    @FXML
    public void pizzaButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Pizza.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage pizzaStage = new Stage();
            pizzaStage.setTitle("YallaNakol");
            pizzaStage.setScene(new Scene(root));
            pizzaStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File pizzahutFile = new File("@../../../../Desktop/Images/pizzahut-logo_freelogovectors.net_.png");
        Image pizzahutimage = new Image(pizzahutFile.toURI().toString());
        pizzahutImageView.setImage(pizzahutimage);

        File papajohnsFile = new File("@../../../../Desktop/Images/papa-john-s-azerbaijan.jpg");
        Image papajohnsimage = new Image(papajohnsFile.toURI().toString());
        papajohnsImageView.setImage(papajohnsimage);

    }

    @FXML
    public void pizzahutorderButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("orderpizzahut.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage pizzahutorderStage = new Stage();
            pizzahutorderStage.setTitle("YallaNakol");
            pizzahutorderStage.setScene(new Scene(root));
            pizzahutorderStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }

    @FXML
    public void papajohnsorderButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("oderpapajohns.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage papajohnsorderStage = new Stage();
            papajohnsorderStage.setTitle("YallaNakol");
            papajohnsorderStage.setScene(new Scene(root));
            papajohnsorderStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }


}
