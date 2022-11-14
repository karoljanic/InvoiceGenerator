package org.karoljanic.creators;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.karoljanic.gui.CustomButton;
import org.karoljanic.gui.CustomVBox;
import org.karoljanic.gui.CustomInput;
import org.karoljanic.models.Customer;

// Cel klasy: tworzenie modelu klienta
public class CustomerCreator {
    private static final CustomInput customerForeNameInput = new CustomInput("First Name");
    private static final CustomInput customerSurNameInput = new CustomInput("Second Name");
    private static final CustomInput customerID = new CustomInput("ID");
    private static final CustomInput customerAddress = new CustomInput("Address");
    private static final CustomInput customerZipCode = new CustomInput("Zip Code");
    private static final CustomInput customerEmail = new CustomInput("Email");
    private static final CustomButton addCustomerButton = new CustomButton("Add Customer");
    private static final Scene scene = new Scene(new CustomVBox(customerForeNameInput, customerSurNameInput, customerID,
            customerAddress, customerZipCode, customerEmail, addCustomerButton));

    public interface CustomerCreatedCallbackInterface {
        void callback(Customer createdCustomer);
    }

    static void create(CustomerCreator.CustomerCreatedCallbackInterface callback) {
        Stage stage = new Stage();
        stage.setTitle("Customer Creating");
        stage.setScene(CustomerCreator.scene);
        stage.show();
        stage.sizeToScene();

        addCustomerButton.setOnMouseClicked(event -> {
            if(!customerForeNameInput.isBlank() && !customerSurNameInput.isBlank() && !customerID.isBlank() &&
                    !customerAddress.isBlank() && !customerZipCode.isBlank() && !customerEmail.isBlank()) {
                stage.hide();
                callback.callback(new Customer(customerForeNameInput.getText(), customerSurNameInput.getText(),
                        customerID.getText(), customerAddress.getText(), customerZipCode.getText(),
                        customerEmail.getText()));
            }
        });
    }
}
