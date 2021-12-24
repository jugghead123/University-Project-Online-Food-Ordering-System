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


public class HomepageController implements Initializable {

    @FXML
    private ImageView pizzaImageView;
    @FXML
    private ImageView burgerImageView;
    @FXML
    private ImageView dessertImageView;
    @FXML
    private Button pizzaButton;
    @FXML
    private Button burgerButton;
    @FXML
    private Button dessertButton;

    public void loginButtonOnAction (ActionEvent event) {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage homepageStage = new Stage();
            homepageStage.setTitle("YallaNakol");
            homepageStage.setScene(new Scene(root));
            homepageStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File pizzaFile = new File("@../../src/Images/pizza.jpg");
        Image pizzaimage = new Image(pizzaFile.toURI().toString());
        pizzaImageView.setImage(pizzaimage);

        File burgerFile = new File("@../../src/Images/Burger-1916-web2-681x454.png");
        Image burgerimage = new Image(burgerFile.toURI().toString());
        burgerImageView.setImage(burgerimage);

        File dessertFile = new File("@../../src/Images/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__2019__05__20190520-cheesecake-vicky-wasik-34-16488b3671ae47b5b29eb7124dbaf938.jpg");
        Image dessertimage = new Image(dessertFile.toURI().toString());
        dessertImageView.setImage(dessertimage);

    }

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

    public void dessertButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Dessert.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage dessertStage = new Stage();
            dessertStage.setTitle("YallaNakol");
            dessertStage.setScene(new Scene(root));
            dessertStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }

}
