package org.karoljanic.creators;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.karoljanic.gui.CustomButton;
import org.karoljanic.gui.CustomHBox;
import org.karoljanic.gui.CustomInput;
import org.karoljanic.models.Product;

// Cel klasy: tworzenie modelu produktu
public class ProductCreator {
    private static final CustomInput productNameInput = new CustomInput("Product Name");
    private static final CustomInput productPriceInput = new CustomInput("Product Price(Gross)");
    private static final CustomButton addProductButton = new CustomButton("Add Product");
    private static final Scene scene = new Scene(new CustomHBox(productNameInput, productPriceInput, addProductButton));

    public interface ProductCreatedCallbackInterface {
        void callback(Product createdProduct);
    }

    static void create(ProductCreatedCallbackInterface callback) {
        Stage stage = new Stage();
        stage.setTitle("Product Creating");
        stage.setScene(ProductCreator.scene);
        stage.show();
        stage.sizeToScene();

        addProductButton.setOnMouseClicked(event -> {
            if(!ProductCreator.productNameInput.isBlank() && !ProductCreator.productPriceInput.isBlank()) {
                stage.hide();
                callback.callback(new Product(ProductCreator.productNameInput.getText(), Float.parseFloat(ProductCreator.productPriceInput.getText())));
            }
        });
    }
}
