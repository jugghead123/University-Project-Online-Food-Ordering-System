package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerloginController implements Initializable{

    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label messageLabel;

    Manager m1 = new Manager("Hamza", "aaaa");

    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void loginButtonOnAction() {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Managerhomepage.fxml"));
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

    }

    public void checkBlank(ActionEvent event) {

        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false)
            validateLogin();
        else
            messageLabel.setText("Please Enter Username and Password");
    }

    public void validateLogin() {

        if (usernameTextField.getText().equals(m1.getUsername()) && passwordTextField.getText().equals(m1.getPassword()))
            loginButtonOnAction();

        else
            messageLabel.setText("Invalid Username and Password");
    }


}
