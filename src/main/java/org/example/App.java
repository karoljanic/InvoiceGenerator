package org.example;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;


public class App extends Application {

    private static class CustomVBox extends VBox {
        CustomVBox(Node... children) {
            super(10, children);
            setAlignment(Pos.TOP_CENTER);
            setPadding(new Insets(10, 10, 10, 10));
        }

        CustomVBox(double spacing) {
            super(spacing);
            setAlignment(Pos.TOP_CENTER);
            setPadding(new Insets(10, 10, 10, 10));
        }
    }

    private static class CustomHBox extends HBox {
        CustomHBox(Node... children) {
            super(10, children);
            setAlignment(Pos.TOP_CENTER);
            setPadding(new Insets(10, 10, 10, 10));
        }
    }

    private static class CustomInput extends HBox {
        final private TextField textField;

        CustomInput(String text) {
            super(10);

            setAlignment(Pos.TOP_CENTER);

            Label label = new Label(text);
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

    private Company company;
    private Customer customer;
    private Invoice invoice;
    private InvoiceCreator invoiceCreator;

    public static void main(String[] args) { launch(); }

    @Override
    public void start(Stage stage) {
        showCompanyInfoInputScene(stage);
    }

    private void showCompanyInfoInputScene(Stage stage) {
        var companyNameInput = new CustomInput("Company Name");
        var companyNipInput = new CustomInput("Company NIP");
        var companyAddressInput = new CustomInput("Company Address");
        var companyZipCodeInput = new CustomInput("Company Zip Code");
        var companyEmailInput = new CustomInput("Company Email");
        var inputs = new CustomVBox(companyNameInput, companyNipInput, companyAddressInput, companyZipCodeInput, companyEmailInput);
        var showCustomerInfoInputButton = new Button("Open Invoices Generator");
        showCustomerInfoInputButton.setOnMouseClicked(event -> { if(allInputsAreNotBlank(inputs)) {
            company = new Company(companyNameInput.getText(), companyNipInput.getText(), companyAddressInput.getText(), companyZipCodeInput.getText(), companyEmailInput.getText());
            showCustomerInfoInputScene(stage); }
        });

        setStageScene(stage, new Scene(new CustomVBox(inputs, showCustomerInfoInputButton)));
    }

    private void showCustomerInfoInputScene(Stage stage) {
        var customerForenameInput = new CustomInput("Customer Forename");
        var customerSurnameInput = new CustomInput("Customer Surname");
        var customerIdInput = new CustomInput("Customer ID");
        var customerAddressInput = new CustomInput("Customer Address");
        var customerZipCodeInput = new CustomInput("Customer Zip Code");
        var customerEmailInput = new CustomInput("Customer Email");
        var inputs = new CustomVBox(customerForenameInput, customerSurnameInput, customerIdInput, customerAddressInput, customerZipCodeInput, customerEmailInput);
        var showDashboardButton = new Button("Issue Invoices");
        showDashboardButton.setOnMouseClicked(event -> { if(allInputsAreNotBlank(inputs)) {
            customer = new Customer(customerForenameInput.getText(), customerSurnameInput.getText(), customerIdInput.getText(), customerAddressInput.getText(), customerZipCodeInput.getText(), customerEmailInput.getText());
            showDashboardScene(stage); }
        });

        setStageScene(stage, new Scene(new CustomVBox(inputs, showDashboardButton)));
    }

    private void showDashboardScene(Stage stage) {
        invoice = new Invoice(company, customer);

        var productsListTitle = new Label("Products Already Added");
        var productsList = new CustomVBox(10);

        var productNameInput = new CustomInput("Product Name");
        var productPriceInput = new CustomInput("Product Price");
        var productAmountInput = new CustomInput("Product Amount");
        var inputs = new CustomVBox(productNameInput, productPriceInput, productAmountInput);
        var addProductButton = new Button("Add Product");
        addProductButton.setOnMouseClicked(event -> { if(allInputsAreNotBlank(inputs)) {
            invoice.addProducts(productNameInput.getText(), Float.parseFloat(productPriceInput.getText()), Integer.parseInt(productAmountInput.getText()));
            productsList.getChildren().add(new Label(productNameInput.getText() + " - " + productAmountInput.getText() + " - " + productPriceInput.getText()));
            stage.sizeToScene();
        }});

        var generateInvoiceButton = new Button("Generate Invoice");
        generateInvoiceButton.setOnMouseClicked(event -> {
            invoiceCreator = new InvoiceCreator(new PdfCreatorAdapter());
            invoiceCreator.create(invoice);
            String resultFileName = invoiceCreator.save();

            File file = new File(resultFileName);
            HostServices hostServices = getHostServices();
            hostServices.showDocument(file.getAbsolutePath());
        });

        var newInvoiceButton = new Button("Create New Invoice");
        newInvoiceButton.setOnMouseClicked(event -> {
            invoice = new Invoice(company, customer);
            productsList.getChildren().clear();
            stage.sizeToScene();
        });

        setStageScene(stage, new Scene(new CustomHBox(new CustomVBox(inputs, addProductButton, generateInvoiceButton, newInvoiceButton),
                                       new CustomVBox(productsListTitle, new ScrollPane(productsList)))));
    }

    private void setStageScene(Stage stage, Scene scene) {
        stage.close();
        stage.setScene(scene);
        stage.show();
        stage.sizeToScene();
    }

    private boolean allInputsAreNotBlank(CustomVBox inputs) {
        for(Object input: inputs.getChildren()) {
            if(((CustomInput)input).isBlank()) {
                return false;
            }
        }

        return true;
    }
}