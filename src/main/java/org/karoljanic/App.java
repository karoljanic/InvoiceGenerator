package org.karoljanic;

import javafx.application.Application;
import javafx.stage.Stage;
import org.karoljanic.creators.InvoiceCreator;
import org.karoljanic.pdf.PdfCreatorAdapter;

// Cel klasy: uruchomienie kreatora faktur i przekierowanie stworzych faktur do klasy je wyswietlajaych
public class App extends Application {
    public static void main(String[] args) { launch(); }

    @Override
    public void start(Stage stage) {
        InvoiceCreator.create(createdInvoice -> {
            InvoiceViewer viewer = new InvoiceViewer(new PdfCreatorAdapter(), getHostServices());
            viewer.show(createdInvoice);
        });
    }
}