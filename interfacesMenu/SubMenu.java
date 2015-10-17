package ru.makarov.ipodrom.interfacesMenu;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class SubMenu extends VBox {

    public SubMenu(MainItem... items) {
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setTranslateX(300);
        setTranslateY(200);
        for (MainItem x : items) {
            getChildren().add(x);
        }
    }

    public SubMenu(ButtonBack... items) {
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setTranslateX(300);
        setTranslateY(200);
        for (ButtonBack x : items) {
            getChildren().add(x);
        }
    }
}