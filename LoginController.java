package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;


public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView pizzaImageView;
    @FXML
    private ImageView burgerImageView;
    @FXML
    private ImageView dessertImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label messageLabel;


    Customer c2 = new Customer("Mazen", "aaaa");
    Customer c3 = new Customer("Hamza", "aaaa");

    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void createAccountButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Registration.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage registerStage = new Stage();
            registerStage.setTitle("YallaNakol");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
    }

    @FXML
    public void loginButtonOnAction() {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
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

    public void checkBlank(ActionEvent event) {

        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false)
            validateLogin();

        else
            messageLabel.setText("Please Enter Username and Password");
    }

    public void validateLogin() {

        if (usernameTextField.getText().equals(c2.getUsername()) && passwordTextField.getText().equals(c2.getPassword()))
            loginButtonOnAction();

        else if (usernameTextField.getText().equals(c3.getUsername()) && passwordTextField.getText().equals(c3.getPassword()))
            loginButtonOnAction();

        else
            messageLabel.setText("Invalid Username and Password");
    }

    public void initialize(URL location, ResourceBundle resources) {
    }


}



