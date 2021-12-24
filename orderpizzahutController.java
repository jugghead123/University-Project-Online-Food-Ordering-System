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

public class orderpizzahutController implements Initializable {

    public double total;

    @FXML
    private RadioButton rbsupersupreme;
    @FXML
    private RadioButton rbdoublecheese;
    @FXML
    private RadioButton rbmargherita;
    @FXML
    private RadioButton rbpepperoni;
    @FXML
    private ImageView pizzahutImageView;
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
    public void pizzahutorderButtonOnAction (ActionEvent event) {
        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("orderpizzahut.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage pizzaStage = new Stage();
            pizzaStage.setTitle("YallaNakol");
            pizzaStage.setScene(new Scene(root));
            pizzaStage.show();
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

        File pizzahutFile = new File("@../../../../Desktop/Images/pizzahut-logo_freelogovectors.net_.png");
        Image pizzahutimage = new Image(pizzahutFile.toURI().toString());
        pizzahutImageView.setImage(pizzahutimage);

        size.setItems(sizelist);
        size.setValue("mmmm");

    }

    public void displayOrder() {

        String ordersize = (String) size.getSelectionModel().getSelectedItem();
        double price = 0.0;
        int quantity = Integer.parseInt(quantityTextField.getText());

        if (rbsupersupreme.isSelected()) {
            price = 78;
            textArea.appendText("Super Supreme " + ordersize + " " + (price * quantity) + " " + "\n"  );
            total += (price * quantity);
        }
        else if(rbmargherita.isSelected()) {

            price = 66;
            textArea.appendText("Margherita Pizza " + ordersize + " " + (price * quantity)  + "\n" );
            total += (price * quantity);
        }

        else if(rbdoublecheese.isSelected()) {

            price = 84;
            textArea.appendText("Double Cheese " + ordersize + " " + (price * quantity) + " " + "\n" );
            total += (price * quantity);
        }

        else if(rbpepperoni.isSelected()) {

            price = 86;
            textArea.appendText("Pepperoni " + ordersize + " " + (price * quantity) + " " + "\n"  );
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

         rbsupersupreme.setSelected(false);
         rbmargherita.setSelected(false);
         rbdoublecheese.setSelected(false);
         rbpepperoni.setSelected(false);
         quantityTextField.setText(null);
         size.setValue(null);

        }
}


