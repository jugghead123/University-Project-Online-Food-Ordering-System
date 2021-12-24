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

public class ordersalesucreController implements Initializable {

    public double total;

    @FXML
    private RadioButton rbnutellafudge;
    @FXML
    private RadioButton rbcaramelfudge;
    @FXML
    private RadioButton rbcdarkforest;
    @FXML
    private RadioButton rboreoicecream;
    @FXML
    private ImageView salesucreImageView;
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

        File salesucreFile = new File("@../../../Images/SaleSucre.jpg");
        Image salesucreimage = new Image(salesucreFile.toURI().toString());
        salesucreImageView.setImage(salesucreimage);

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

        if (rbnutellafudge.isSelected()) {
            price = 88;
            textArea.appendText("Nutella Fudge " + ordersize + " " + (price * quantity) + " " + "\n"  );
            total += (price * quantity);
        }
        else if(rbcaramelfudge.isSelected()) {

            price = 140;
            textArea.appendText("Caramel Fudge " + ordersize + " " + (price * quantity)  + "\n" );
            total += (price * quantity);
        }

        else if(rbcdarkforest.isSelected()) {

            price = 170;
            textArea.appendText("Dark Forest " + ordersize + " " + (price * quantity) + " " + "\n" );
            total += (price * quantity);
        }

        else if(rboreoicecream.isSelected()) {

            price = 130;
            textArea.appendText("Oreo Icecream " + ordersize + " " + (price * quantity) + " " + "\n"  );
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

        rbnutellafudge.setSelected(false);
        rbcaramelfudge.setSelected(false);
        rbcdarkforest.setSelected(false);
        rboreoicecream.setSelected(false);
        quantityTextField.setText(null);
        size.setValue(null);

    }
}
