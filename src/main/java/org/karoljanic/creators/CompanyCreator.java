package org.karoljanic.creators;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.karoljanic.gui.CustomButton;
import org.karoljanic.gui.CustomInput;
import org.karoljanic.gui.CustomVBox;
import org.karoljanic.models.Company;

// Cel klasy: tworzenie modelu firmy
public class CompanyCreator {
    private static final CustomInput companyName = new CustomInput("Name");
    private static final CustomInput companyNip = new CustomInput("NIP");
    private static final CustomInput companyAddress = new CustomInput("Address");
    private static final CustomInput companyZipCode = new CustomInput("Zip Code");
    private static final CustomInput companyEmail = new CustomInput("Email");
    private static final CustomButton addCompanyButton = new CustomButton("Add Company");
    private static final Scene scene = new Scene(new CustomVBox(companyName, companyNip,
            companyAddress, companyZipCode, companyEmail, addCompanyButton));

    public interface CompanyCreatedCallbackInterface {
        void callback(Company createdCompany);
    }

    static void create(CompanyCreator.CompanyCreatedCallbackInterface callback) {
        Stage stage = new Stage();
        stage.setTitle("Company Creating");
        stage.setScene(CompanyCreator.scene);
        stage.show();
        stage.sizeToScene();

        addCompanyButton.setOnMouseClicked(event -> {
            if(!companyName.isBlank() && !companyNip.isBlank() &&
                    !companyAddress.isBlank() && !companyZipCode.isBlank() && !companyEmail.isBlank()) {
                stage.hide();
                callback.callback(new Company(companyName.getText(), companyNip.getText(),
                        companyAddress.getText(), companyZipCode.getText(), companyEmail.getText()));
            }
        });
    }
}
