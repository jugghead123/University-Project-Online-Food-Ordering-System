package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class visadetailsController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmpaymentButton;
    @FXML
    private TextField cardnumberTextField;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField cvvTextField;
    @FXML
    private TextField monthTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private Label visaMessageLabel;

    @FXML
    public void confirmpaymentButtonOnAction() {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("successfulorder.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage papajohnsorderStage = new Stage();
            papajohnsorderStage.setTitle("YallaNakol");
            papajohnsorderStage.setScene(new Scene(root));
            papajohnsorderStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }

        Visa visa1 = new Visa(cardnumberTextField.getText(), dateTextField.getText(), cvvTextField.getText());
    }

    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validatePayment(){

        if(cvvTextField.getLength()==3 && cardnumberTextField.getLength()==16 && cardnumberTextField.getText().startsWith("4") && yearTextField.getLength()==2 && (monthTextField.getLength()==2 ||monthTextField.getLength()==1) && ((Double.parseDouble(monthTextField.getText())>6 && Double.parseDouble(yearTextField.getText())>20)||Double.parseDouble(yearTextField.getText())>20)){

            confirmpaymentButtonOnAction();
        }
        else if(cvvTextField.getLength()!=3)
            visaMessageLabel.setText("CVV must be 3 numbers");
        else if(cardnumberTextField.getLength()!=16)
            visaMessageLabel.setText("Account Number must be 16 numbers");
        else if(cardnumberTextField.getText().startsWith("4")==false)
            visaMessageLabel.setText("Account Number must start with 4");
        else if(Double.parseDouble(monthTextField.getText())>12 ||Double.parseDouble(monthTextField.getText()) <1)
            visaMessageLabel.setText("This month is not valid");
        else if((Double.parseDouble(monthTextField.getText())<21))
            visaMessageLabel.setText("The VISA is expired");
        else if((Double.parseDouble(monthTextField.getText())<7)&& (Double.parseDouble(monthTextField.getText())<21))
            visaMessageLabel.setText("The VISA is expired");
    }

    public void visaButtonOnAction(ActionEvent event){
        if(cvvTextField.getText().isBlank()==false && cardnumberTextField.getText().isBlank()==false && monthTextField.getText().isBlank()==false && yearTextField.getText().isBlank()==false )
            validatePayment();
        else
            visaMessageLabel.setText("Please enter Visa Details");
    }
}

