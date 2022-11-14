package org.karoljanic.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

// Cel klasy: ustawienie stylu dla wszystkich uzywanych VBoxow
public class CustomVBox extends VBox {
    public CustomVBox(Node... children) {
        super(10, children);
        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(10, 10, 10, 10));
    }

    public CustomVBox(double spacing) {
        super(spacing);
        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(10, 10, 10, 10));
    }
}