package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class App extends Application {
    private class CustomInput extends HBox {
        private Label label;
        private TextField textField;

        CustomInput(String text) {
            super(10);

            setAlignment(Pos.TOP_CENTER);

            label = new Label(text);
            label.setFont(Font.font ("Verdana", 14));

            textField = new TextField();
            textField.setMaxWidth(200);
            textField.setMinWidth(200);
            textField.setFont(Font.font ("Verdana", 14));

            getChildren().addAll(label, textField);
        }

        String getText() {
            return textField.getText();
        }

        boolean isBlank() {
            return getText().isBlank();
        }
    }

    Invoice invoice;

    @Override
    public void start(Stage stage) {
        var companyNameInput = new CustomInput("Company Name");
        var companyNipInput = new CustomInput("Company NIP");
        var companyAddressInput = new CustomInput("Company Address");
        var companyZipCodeInput = new CustomInput("Company Zip Code");
        var companyEmailInput = new CustomInput("Company Email");
        var inputs1 = new VBox(companyNameInput, companyNipInput, companyAddressInput, companyZipCodeInput, companyEmailInput);
        var runInvoicesGeneratorButton = new Button("Open Invoices Generator");
        var loginScene = new Scene(new VBox(inputs1, runInvoicesGeneratorButton));

        var customerForenameInput = new CustomInput("Customer Forename");
        var customerSurnameInput = new CustomInput("Customer Surname");
        var customerIdInput = new CustomInput("Customer ID");
        var customerAddressInput = new CustomInput("Customer Address");
        var customerZipCodeInput = new CustomInput("Customer Zip Code");
        var customerEmailInput = new CustomInput("Customer Email");
        var invoiceSeriesInput = new CustomInput("Invoice Series");
        var inputs2 = new VBox(customerForenameInput, customerSurnameInput, customerIdInput, customerAddressInput, customerZipCodeInput, customerEmailInput, invoiceSeriesInput);
        var issueInvoicesButton = new Button("Issue Invoices");
        var invoicesGeneratorScene = new Scene(new VBox(inputs2, issueInvoicesButton));

        var productNameInput = new CustomInput("Product Name");
        var productPriceInput = new CustomInput("Product Price");
        var productAmountInput = new CustomInput("Product Amount");
        var inputs3 = new VBox(productNameInput, productPriceInput, productAmountInput);
        var addProductButton = new Button("Add Product");
        var generateInvoiceButton = new Button("Generate Invoice");
        var productsListTitle = new Label("Products Already Added");
        var productsList = new VBox(10);
        var invoicesDashboardScene = new Scene(new HBox(new VBox(inputs3, addProductButton, generateInvoiceButton),
                new VBox(productsListTitle, productsList)));

        runInvoicesGeneratorButton.setOnMouseClicked(event -> {
            if(allInputsAreNotBlank(inputs1)) {
                stage.close();
                stage.setScene(invoicesGeneratorScene);
                stage.show();
            }
        });

        issueInvoicesButton.setOnMouseClicked(event -> {
            if(allInputsAreNotBlank(inputs2)) {
                invoice = new Invoice(new Company(companyNameInput.getText(), companyNipInput.getText(), companyAddressInput.getText(), companyZipCodeInput.getText(), companyEmailInput.getText()),
                        new Person(customerForenameInput.getText(), customerSurnameInput.getText(), customerIdInput.getText(), customerAddressInput.getText(), customerZipCodeInput.getText(), customerEmailInput.getText()),
                        invoiceSeriesInput.getText());
                stage.close();
                stage.setScene(invoicesDashboardScene);
                stage.show();
            }
        });

        addProductButton.setOnMouseClicked(event -> {
            if(allInputsAreNotBlank(inputs3)) {
                productsList.getChildren().add(new Label(productNameInput.getText() + " - " + productAmountInput.getText() + " - " + productPriceInput.getText()));
                invoice.addProducts(productNameInput.getText(), Float.parseFloat(productPriceInput.getText()), Integer.parseInt(productAmountInput.getText()));
            }
        });

        generateInvoiceButton.setOnMouseClicked(event -> {
            invoice.generatePdf();
        });

        stage.setScene(loginScene);
        stage.show();
    }
    public static void main(String[] args) { launch(); }

    boolean allInputsAreNotBlank(VBox inputs) {
        for(Object input: inputs.getChildren()) {
            if(((CustomInput)input).isBlank()) {
                return false;
            }
        }

        return true;
    }
}