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

public class orderbuffaloburgerController implements Initializable {

    public double total;

    @FXML
    private RadioButton rbbuffalohunk;
    @FXML
    private RadioButton rbbdogsandwich;
    @FXML
    private RadioButton rbchickenditch;
    @FXML
    private RadioButton rbchickenbuster;
    @FXML
    private ImageView buffaloburgerImageView;
    @FXML
    private Button orderButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button confirmorderButton;
    @FXML
    private Button checkoutButton;
    @FXML
    private TextArea textArea;
    @FXML
    private ChoiceBox size;
    @FXML
    private TextField quantityTextField;

    ObservableList<String> sizelist = FXCollections.observableArrayList("Small", "Medium", "Large");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File papajohnsFile = new File("@../../../Images/download.png");
        Image papajohnsimage = new Image(papajohnsFile.toURI().toString());
        buffaloburgerImageView.setImage(papajohnsimage);

        size.setItems(sizelist);
        size.setValue("mmmm");

    }

    @FXML
    public void confirmorderButtonOnAction() {

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("Payment.fxml"));
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

    public void displayOrder() {

        String ordersize = (String) size.getSelectionModel().getSelectedItem();
        double price = 0.0;
        int quantity = Integer.parseInt(quantityTextField.getText());

        if (rbbuffalohunk.isSelected()) {
            price = 70;
            textArea.appendText("Buffalo Hunk " + ordersize + " " + (price * quantity) + " " + "\n"  );
            total += (price * quantity);
        }
        else if(rbbdogsandwich.isSelected()) {

            price = 60;
            textArea.appendText("BDog Sandwich " + ordersize + " " + (price * quantity)  + "\n" );
            total += (price * quantity);
        }

        else if(rbchickenditch.isSelected()) {

            price = 80;
            textArea.appendText("Chicken Hitch " + ordersize + " " + (price * quantity) + " " + "\n" );
            total += (price * quantity);
        }

        else if(rbchickenbuster.isSelected()) {

            price = 90;
            textArea.appendText("Chicken Buster " + ordersize + " " + (price * quantity) + " " + "\n"  );
            total += (price * quantity);
        }

    }

    public void checkoutButtonOnAction (ActionEvent event) {

        String ordersize = (String) size.getSelectionModel().getSelectedItem();
        double price = 0.0;
        int quantity = Integer.parseInt(quantityTextField.getText());
        double tax = 0.14;
        double deliverFee = 10;
        double taxTotal = Math.round((tax*total)*100.0)/100.0;

        textArea.appendText("\n" + "\n" + "Subtotal is = "  + total + "\n" + "Tax is = " + taxTotal + "\n" + "Delivery Fees = " + deliverFee + "\n" + "Total = " + (total + taxTotal + deliverFee ));
    }

    public void resetButtonOnAction () {

        rbbdogsandwich.setSelected(false);
        rbbuffalohunk.setSelected(false);
        rbchickenbuster.setSelected(false);
        rbchickenditch.setSelected(false);
        quantityTextField.setText(null);
        size.setValue(null);

    }
}
