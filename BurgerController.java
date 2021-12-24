package sample;

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
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class BurgerController implements Initializable {

    @FXML
    private ImageView buffaloburgerImageView;
    @FXML
    private ImageView holmesburgerImageView;

    public void burgerButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Burger.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage burgerStage = new Stage();
            burgerStage.setTitle("YallaNakol");
            burgerStage.setScene(new Scene(root));
            burgerStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File buffaloburgerFile = new File("@../../../../Desktop/Images/download.png");
        Image buffaloburgerimage = new Image(buffaloburgerFile.toURI().toString());
        buffaloburgerImageView.setImage(buffaloburgerimage);

        File papajohnsFile = new File("@../../../../Desktop/Images/Holmes.png");
        Image papajohnsimage = new Image(papajohnsFile.toURI().toString());
        holmesburgerImageView.setImage(papajohnsimage);

    }

    @FXML
    public void buffaloburgerorderButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("orderbuffaloburger.fxml"));
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
    public void holmesburgerorderButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("orderholmesburger.fxml"));
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
