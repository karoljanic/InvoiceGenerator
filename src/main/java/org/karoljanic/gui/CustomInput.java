package org.karoljanic.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

// Cel klasy: ustawienie stylu dla wszystkich uzywanych pol do wprowadzania danych
public class CustomInput extends HBox {
    final private TextField textField;

    public CustomInput(String text) {
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

    public String getText() {
        return textField.getText();
    }

    public boolean isBlank() {
        return getText().isBlank();
    }
}
