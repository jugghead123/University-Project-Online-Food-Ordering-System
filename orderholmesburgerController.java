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

public class orderholmesburgerController implements Initializable {

    public double total;

    @FXML
    private RadioButton rbyummyburger;
    @FXML
    private RadioButton rbgrandpaburger;
    @FXML
    private RadioButton rbcheesymushroom;
    @FXML
    private RadioButton rbthecubano;
    @FXML
    private ImageView holmesburgerImageView;
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

        File holmesFile = new File("@../../../Images/Holmes.png");
        Image holmesimage = new Image(holmesFile.toURI().toString());
        holmesburgerImageView.setImage(holmesimage);

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

        if (rbyummyburger.isSelected()) {
            price = 70;
            textArea.appendText("Yummy Burger " + ordersize + " " + (price * quantity) + " " + "\n"  );
            total += (price * quantity);
        }
        else if(rbgrandpaburger.isSelected()) {

            price = 75;
            textArea.appendText("Grandpa Burger " + ordersize + " " + (price * quantity)  + "\n" );
            total += (price * quantity);
        }

        else if(rbcheesymushroom.isSelected()) {

            price = 85;
            textArea.appendText("Cheesy Mushroom " + ordersize + " " + (price * quantity) + " " + "\n" );
            total += (price * quantity);
        }

        else if(rbthecubano.isSelected()) {

            price = 88;
            textArea.appendText("The Cubano " + ordersize + " " + (price * quantity) + " " + "\n"  );
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

        rbyummyburger.setSelected(false);
        rbgrandpaburger.setSelected(false);
        rbthecubano.setSelected(false);
        rbcheesymushroom.setSelected(false);
        quantityTextField.setText(null);
        size.setValue(null);

    }
}
