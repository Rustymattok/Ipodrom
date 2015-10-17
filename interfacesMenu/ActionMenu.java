package ru.makarov.ipodrom.interfacesMenu;

import ru.makarov.ipodrom.GameCharector;

/**
 * Created by Rustymattok on 17.10.2015.
 * Класс обработчки клавиш списка участников
 */
public class ActionMenu {
    private   MainItem  horse;

    public ActionMenu (MainItem  horse) {
        this.horse = horse;
    }

    public void invoke() {
        horse.setOnMouseClicked(event -> {
            GameCharector.newWindow("Game");
            ru.makarov.ipodrom.Ipodrom.rate = horse.getName();
        });
    }
}