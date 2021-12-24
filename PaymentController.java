package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable{

    @FXML
    private ImageView visaImageView;
    @FXML
    private ImageView codImageView;
    @FXML
    private Button visaButton;
    @FXML
    private Button codButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File visaFile = new File("@../../../Images/48_visa-logo-1024x768.png");
        Image visaimage = new Image(visaFile.toURI().toString());
        visaImageView.setImage(visaimage);

        File codFile = new File("@../../../Images/cod1.png");
        Image codimage = new Image(codFile.toURI().toString());
        codImageView.setImage(codimage);
    }

    @FXML
    public void codButtonOnAction() {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("successfulorder.fxml"));
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

    @FXML
    public void visaButtonOnAction() {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("visadetails.fxml"));
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


}
