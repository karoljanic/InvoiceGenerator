package org.karoljanic.creators;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import org.karoljanic.gui.*;
import org.karoljanic.models.Company;
import org.karoljanic.models.Customer;
import org.karoljanic.models.Invoice;
import org.karoljanic.models.InvoicePart;

import java.util.ArrayList;

// Cel klasy: tworzenie modelu faktury
public class InvoiceCreator {
    private static final CustomButton addCompanyButton = new CustomButton("Add Company");
    private static final CustomButton addCustomerButton = new CustomButton("Add Customer");
    private static final CustomText companyInfo = new CustomText("Company Not Specified");
    private static final CustomText customerInfo = new CustomText("Customer Not Specified");
    private static final CustomLabel productsTitle = new CustomLabel("Products:");
    private static final CustomVBox productsList = new CustomVBox();
    private static final CustomButton addProductButton = new CustomButton("Add Product");
    private static final CustomButton clearProductsButton = new CustomButton("Clear Products");
    private static final CustomButton generateInvoiceButton = new CustomButton("Generate Invoice");
    private static final Scene scene = new Scene(new CustomVBox(new CustomHBox(
            new CustomVBox(addCompanyButton, companyInfo),
            new CustomVBox(addCustomerButton, customerInfo)),
            productsTitle, new ScrollPane(productsList), addProductButton, clearProductsButton, generateInvoiceButton));
    private static Stage stage;

    private static Company company = null;
    private static Customer customer = null;
    private static final ArrayList<InvoicePart> invoicePartsList = new ArrayList<>();

    public interface InvoiceCreatedCallbackInterface {
        void callback(Invoice createdInvoice);
    }

    public static void create(InvoiceCreatedCallbackInterface callback) {
        addCompanyButton.setOnMouseClicked(event -> CompanyCreator.create(createdCompany -> {
            company = createdCompany;
            companyInfo.setText(createdCompany.getText());
            stage.sizeToScene();
        }));

        addCustomerButton.setOnMouseClicked(event -> CustomerCreator.create(createdCustomer -> {
            customer = createdCustomer;
            customerInfo.setText(createdCustomer.getText());
            stage.sizeToScene();
        }));

        addProductButton.setOnMouseClicked(event -> {
            InvoicePartCreator.create(createdInvoicePart -> {
                invoicePartsList.add(createdInvoicePart);
                productsList.getChildren().add(new CustomLabel(createdInvoicePart.getText()));
                stage.sizeToScene();
            });
        });

        clearProductsButton.setOnMouseClicked(event -> {
            productsList.getChildren().clear();
            stage.sizeToScene();
        });

        generateInvoiceButton.setOnMouseClicked(event -> {
            if(company != null && customer != null && invoicePartsList.size() > 0) {
                callback.callback(new Invoice(company, customer, invoicePartsList));
            }
        });

        stage = new Stage();
        stage.setTitle("Invoice Creating");
        stage.setScene(scene);
        stage.show();
        stage.sizeToScene();
    }
}
