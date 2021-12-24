package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegistrationController {

    @FXML
    private Button closeButton;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmpasswordTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private Label messageLabel;


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

    public void closeButtonOnAction(ActionEvent event){
        Stage stage= (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void registerButtonOnAction() {

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

        Customer c1 = new Customer(usernameTextField.getText() , passwordTextField.getText() );
    }

    public void checkBlank(ActionEvent event) {

        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false && firstnameTextField.getText().isBlank() == false && confirmpasswordTextField.getText().isBlank() == false && lastnameTextField.getText().isBlank() == false && phoneTextField.getText().isBlank() == false && addressTextField.getText().isBlank() == false)
            validateRegistration();
        else
            messageLabel.setText("Please Enter Details");
    }

    public void validateRegistration() {

        if (passwordTextField.getText().equals(confirmpasswordTextField.getText()))
            registerButtonOnAction();
        else
            messageLabel.setText("Passwords Does not match");
    }
}
