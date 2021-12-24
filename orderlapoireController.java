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

public class orderlapoireController implements Initializable {

    public double total;

    @FXML
    private RadioButton rbfourseasons;
    @FXML
    private RadioButton rblotusicecream;
    @FXML
    private RadioButton rbmillefeuille;
    @FXML
    private RadioButton rbraspberrycheesecake;
    @FXML
    private ImageView lapoireImageView;
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

        File lapoireFile = new File("@../../../Images/la-poire-logo-DDD0DC2F6B-seeklogo.com.png");
        Image lapoireimage = new Image(lapoireFile.toURI().toString());
        lapoireImageView.setImage(lapoireimage);

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

        if (rbfourseasons.isSelected()) {
            price = 66;
            textArea.appendText("Four Seasons " + ordersize + " " + (price * quantity) + " " + "\n"  );
            total += (price * quantity);
        }
        else if(rblotusicecream.isSelected()) {
            price = 99;
            textArea.appendText("Lotus Icecream Tart " + ordersize + " " + (price * quantity)  + "\n" );
            total += (price * quantity);
        }
        else if(rbmillefeuille.isSelected()) {
            price = 80;
            textArea.appendText("Mille Feuille " + ordersize + " " + (price * quantity) + " " + "\n" );
            total += (price * quantity);
        }

        else if(rbraspberrycheesecake.isSelected()) {
            price = 87;
            textArea.appendText("Raspberry Cheesecake " + ordersize + " " + (price * quantity) + " " + "\n"  );
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

        rbmillefeuille.setSelected(false);
        rbraspberrycheesecake.setSelected(false);
        rbfourseasons.setSelected(false);
        rblotusicecream.setSelected(false);
        quantityTextField.setText(null);
        size.setValue(null);

    }
}
