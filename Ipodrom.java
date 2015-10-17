package ru.makarov.ipodrom;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.makarov.ipodrom.interfacesMenu.*;
import java.util.ArrayList;

/*
Класс отвечает за сцену и установку всех менюшек
 */
public class Ipodrom extends Application {
   public static String rate;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        SetActionBar setActionBar = new SetActionBar().invoke();
        MainItem newGame = setActionBar.getNewGame();
        MainItem exitGame = setActionBar.getExitGame();
        ButtonBack back = setActionBar.getBack();
        SubMenu subMenu = setActionBar.getSubMenu();
        MainItem chooseHorse = setActionBar.getChooseHorse();
        SubMenu subMenu1 = setActionBar.getSubMenu1();
        ArrayList<MainItem> horse = setActionBar.getHorse();
        SubMenu subMenu2 = setActionBar.getSubMenu2();
        MainMenu mainMenu1 = setActionBar.getMainMenu1();
        ImageView img = setActionBar.getImg();

//Пишем обработчики выбора меню
        actionBar(newGame, exitGame, back, subMenu, chooseHorse, subMenu1, horse, subMenu2, mainMenu1);

        Scene scene = new Scene(root, 900, 600);
        root.getChildren().addAll(img, mainMenu1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void actionBar(MainItem newGame, MainItem exitGame, ButtonBack back, SubMenu subMenu, MainItem chooseHorse,
                          SubMenu subMenu1, ArrayList<MainItem> horse, SubMenu subMenu2, MainMenu mainMenu1) {
        back.setVisible(false);
        newGame.setOnMouseClicked(event -> {
            mainMenu1.setSubMenu(subMenu1);
            back.setVisible(true);
        });
        back.setOnMouseClicked(event -> {
            mainMenu1.setSubMenu(subMenu);
            back.setVisible(false);
        });
        chooseHorse.setOnMouseClicked(event -> {
            mainMenu1.setSubMenu(subMenu2);
            back.setVisible(true);
        });
        exitGame.setOnMouseClicked(event -> System.exit(0));
        new ActionMenu(horse.get(0)).invoke();
        new ActionMenu(horse.get(1)).invoke();
        new ActionMenu(horse.get(2)).invoke();
        new ActionMenu(horse.get(3)).invoke();
        new ActionMenu(horse.get(4)).invoke();
        new ActionMenu(horse.get(5)).invoke();
        new ActionMenu(horse.get(6)).invoke();
        new ActionMenu(horse.get(7)).invoke();
    }

    private class SetActionBar {

        private ImageView img;
        private MainItem newGame;
        private MainItem exitGame;
        private ButtonBack back;
        private SubMenu subMenu;
        private MainItem chooseHorse;
        private SubMenu subMenu1;
        private ArrayList<MainItem> horse;
        private SubMenu subMenu2;
        private MainMenu mainMenu1;

        public ImageView getImg() {
            return img;
        }

        public MainItem getNewGame() {
            return newGame;
        }

        public MainItem getExitGame() {
            return exitGame;
        }

        public ButtonBack getBack() {
            return back;
        }

        public SubMenu getSubMenu() {
            return subMenu;
        }

        public MainItem getChooseHorse() {
            return chooseHorse;
        }

        public SubMenu getSubMenu1() {
            return subMenu1;
        }

        public ArrayList<MainItem> getHorse() {
            return horse;
        }

        public SubMenu getSubMenu2() {
            return subMenu2;
        }

        public MainMenu getMainMenu1() {
            return mainMenu1;
        }

        public SetActionBar invoke() {
            Image image = new Image(getClass().getResourceAsStream("rec\\speed.jpg"));
            img = new ImageView(image);
            img.setFitHeight(600);
            img.setFitWidth(900);

            newGame = new MainItem("НОВАЯ ИГРА");
            MainItem statistic = new MainItem("СТАТИСТИКА");
            exitGame = new MainItem("ВЫХОД");
            back = new ButtonBack("НАЗАД");
            SubMenu subMenuBack = new SubMenu(
                    back
            );
            subMenuBack.setTranslateX(750);
            subMenuBack.setTranslateY(500);

            subMenu = new SubMenu(
                    newGame,
                    statistic,
                    exitGame
            );

            MainItem balance = new MainItem("БАЛАНС");
            chooseHorse = new MainItem("ВЫБРАТЬ ЛОШАДЬ");

            subMenu1 = new SubMenu(
                    balance,
                    chooseHorse
            );

            horse = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                horse.add(new MainItem("Дорожка - " + (i + 1)));
            }

            subMenu2 = new SubMenu(
                    horse.get(0),
                    horse.get(1),
                    horse.get(2),
                    horse.get(3),
                    horse.get(4),
                    horse.get(5),
                    horse.get(6),
                    horse.get(7)
            );

            subMenu2.setTranslateY(100);

            mainMenu1 = new MainMenu(subMenu, subMenuBack);
            return this;
        }
    }
}

