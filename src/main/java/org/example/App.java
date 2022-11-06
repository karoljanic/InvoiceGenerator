package org.example;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        var label = new Label("Hello, JavaFX");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Company company = new Company("NOKIA", "2732", "Fajna ulica", "54-330 Wroclaw", "kontakt@nokia.com");
        Person person = new Person("Jan", "Kowalski", "AHD235", "Lepsza Ulica", "10-100 Super Miasto", "jan.kowalski@mail.com");

        Invoice invoice = new Invoice(company, person, "ZH-KD-");
        invoice.addProducts("Kasztan", 10.99F, 5);
        invoice.addProducts("Japko", 0.99F, 12);
        invoice.addProducts("Krowa", 1799.0F,2);

        invoice.generatePdf();

        launch();
    }
}