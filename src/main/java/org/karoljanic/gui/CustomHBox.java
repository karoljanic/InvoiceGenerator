package org.karoljanic.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

// Cel klasy: ustawienie stylu dla wszystkich uzywanych HBoxow
public class CustomHBox extends HBox {
    public CustomHBox(Node... children) {
        super(10, children);
        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(10, 10, 10, 10));
    }

    public CustomHBox(double spacing) {
        super(spacing);
        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(10, 10, 10, 10));
    }
}
