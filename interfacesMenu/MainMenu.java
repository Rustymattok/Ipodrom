package ru.makarov.ipodrom.interfacesMenu;

import javafx.scene.layout.Pane;

public class MainMenu extends Pane {
    private static SubMenu subMenu;
    private static SubMenu subMenuBack;

    public MainMenu(SubMenu subMenu, SubMenu subMenuBack) {
        MainMenu.subMenuBack = subMenuBack;
        MainMenu.subMenu = subMenu;
        getChildren().addAll(subMenu, subMenuBack);
    }

    public void setSubMenu(SubMenu subMenu) {
        getChildren().remove(MainMenu.subMenu);
        MainMenu.subMenu = subMenu;
        getChildren().addAll(subMenu);
    }
}