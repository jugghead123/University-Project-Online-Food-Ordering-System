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

public class DessertController implements Initializable{

    @FXML
    private ImageView salesucreImageView;
    @FXML
    private ImageView lapoireImageView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File salesucreFile = new File("@../../../../Desktop/Images/SaleSucre.jpg");
        Image salesucreimage = new Image(salesucreFile.toURI().toString());
        salesucreImageView.setImage(salesucreimage);

        File lapoireFile = new File("@../../../../Desktop/Images/la-poire-logo-DDD0DC2F6B-seeklogo.com.png");
        Image lapoireimage = new Image(lapoireFile.toURI().toString());
        lapoireImageView.setImage(lapoireimage);

    }

    @FXML
    public void salesucreorderButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("ordersalesucre.fxml"));
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
    public void lapoireorderButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("orderlapoire.fxml"));
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
