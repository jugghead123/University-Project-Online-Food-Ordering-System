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

public class oderpapajohnsController implements Initializable {

    public double total;

    @FXML
    private RadioButton rbchickenranch;
    @FXML
    private RadioButton rbsmokey;
    @FXML
    private RadioButton rbsixcheese;
    @FXML
    private RadioButton rbbuffalopoppers;
    @FXML
    private ImageView papajohnsImageView;
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

    @FXML
    public void papajohnsorderButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("orderpapajohns.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage papajohnsorderStage = new Stage();
            papajohnsorderStage.setTitle("YallaNakol");
            papajohnsorderStage.setScene(new Scene(root));
            papajohnsorderStage.show();
        } catch (Exception e) {

            System.out.println("Can't load");
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File papajohnsFile = new File("@../../../../Desktop/Images/papa-john-s-azerbaijan.jpg");
        Image papajohnsimage = new Image(papajohnsFile.toURI().toString());
        papajohnsImageView.setImage(papajohnsimage);

        size.setItems(sizelist);
        size.setValue("mmmm");

    }

    public void displayOrder() {

        String ordersize = (String) size.getSelectionModel().getSelectedItem();
        double price = 0.0;
        int quantity = Integer.parseInt(quantityTextField.getText());

        if (rbchickenranch.isSelected()) {
            price = 100;
            textArea.appendText("Chicken Ranch Pizza " + ordersize + " " + (price * quantity) + " " + "\n"  );
            total += (price * quantity);
        }
        else if(rbsmokey.isSelected()) {

            price = 120;
            textArea.appendText("Smokey Pizza " + ordersize + " " + (price * quantity)  + "\n" );
            total += (price * quantity);
        }

        else if(rbsixcheese.isSelected()) {

            price = 110;
            textArea.appendText("Six Cheese Pizza " + ordersize + " " + (price * quantity) + " " + "\n" );
            total += (price * quantity);
        }

        else if(rbbuffalopoppers.isSelected()) {

            price = 115;
            textArea.appendText("Buffalo Poppers " + ordersize + " " + (price * quantity) + " " + "\n"  );
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

        rbchickenranch.setSelected(false);
        rbsmokey.setSelected(false);
        rbsixcheese.setSelected(false);
        rbbuffalopoppers.setSelected(false);
        quantityTextField.setText(null);
        size.setValue(null);

    }
}

