package org.karoljanic.creators;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.karoljanic.gui.CustomButton;
import org.karoljanic.gui.CustomHBox;
import org.karoljanic.gui.CustomInput;
import org.karoljanic.models.InvoicePart;

// Cel klasy: tworzenie modelu czesci faktury
public class InvoicePartCreator {
    private static final CustomInput productAmountInput = new CustomInput("Product Amount");
    private static final CustomButton addInvoicePartButton = new CustomButton("Add Products");
    private static final Scene scene = new Scene(new CustomHBox(productAmountInput, addInvoicePartButton));

    public interface InvoicePartCreatedCallbackInterface {
        void callback(InvoicePart createdInvoicePart);
    }

    static void create(InvoicePartCreator.InvoicePartCreatedCallbackInterface callback) {
        Stage stage = new Stage();
        stage.setScene(InvoicePartCreator.scene);
        stage.show();
        stage.sizeToScene();

        ProductCreator.create(createdProduct -> {
            addInvoicePartButton.setOnMouseClicked(event -> {
                if(!InvoicePartCreator.productAmountInput.isBlank()) {
                    stage.hide();
                    callback.callback(new InvoicePart(createdProduct, Integer.parseInt(InvoicePartCreator.productAmountInput.getText())));
                }
            });
        });
    }
}
