package ru.makarov.ipodrom;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.makarov.ipodrom.interfacesMenu.MainItem;
import ru.makarov.ipodrom.persons.*;

import java.util.ArrayList;

/**
 * Created by makarov_vv on 08.10.2015.
 */
public class GameCharector {
    static String name = "";
    static String rateGame = "";
    static int time = 0;

    public static void newWindow(String title) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        ArrayList<String> result = new ArrayList<String>();

        Pane root = new Pane();
        Pane gameroot = new Pane();
        //задний фон
        Image image = new Image(GameCharector.class.getResourceAsStream("rec\\track.jpg"));
        ImageView img = new ImageView(image);
        img.setFitWidth(900);
        img.setFitHeight(600);
        //Иницилизация кнопок на панели после скачек
        MainItem button = new MainItem("ВЫХОД");
        button.setTranslateY(250);
        button.setTranslateX(300);
        button.setVisible(false);

        Ninja ninja = new Ninja(RandomLogic.creatVmax(),"Дорожка - 1");
        Sonic sonic = new Sonic(RandomLogic.creatVmax(),"Дорожка - 2");
        FunnyMan funnyMan = new FunnyMan(RandomLogic.creatVmin(),"Дорожка - 3");
        FunnyGirl funnyGirl = new FunnyGirl(RandomLogic.creatVmin(),"Дорожка - 4");
        Hero hero = new Hero(RandomLogic.creatVmax(),"Дорожка -6");
        FunnyMan funnyMan1 = new FunnyMan(RandomLogic.creatVmin(),"Дорожка - 5");
        Sonic sonic1 = new Sonic(RandomLogic.creatVmax(),"Дорожка - 7");
        Ninja ninja1 = new Ninja(RandomLogic.creatVmax(),"Дорожка - 8");

        ninja.getCharacter().setTranslateY(45);
        sonic.getCharacter().setTranslateY(120);
        funnyMan.getCharacter().setTranslateY(185);
        funnyGirl.getCharacter().setTranslateY(260);
        funnyMan1.getCharacter().setTranslateY(320);
        hero.getCharacter().setTranslateY(390);
        sonic1.getCharacter().setTranslateY(460);
        ninja1.getCharacter().setTranslateY(510);

        ninja.play();
        sonic.play();
        funnyMan.play();
        funnyGirl.play();
        funnyMan1.play();
        hero.play();
        sonic1.play();
        ninja1.play();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
// для теста
                System.out.println(ninja.x + "_--------------------НИНЗЯ");
                System.out.println(sonic.x + "_--------------------СОНИК");
                System.out.println(funnyGirl.x + "_--------------------ДЕВА");
                System.out.println(funnyMan.x + "_--------------------МУЖИК");
                System.out.println(funnyMan1.x + "_--------------------МУЖИК1");
                System.out.println(hero.x + "_--------------------МУЖИЧИЩЕ");
                System.out.println(sonic1.x + "_--------------------СОНИК1");
                System.out.println(ninja1.x + "_--------------------НИНЗЯ1");
                System.out.println(time++);

//todo подумать над более грамотным условием выйгрыша той или иной позиции

                if (ninja.x >= 800) {
                    stop();
                    result.add(ninja.getName());
                    stopGame(button, result, root);
                }
                if (sonic.x >= 800) {
                    stop();
                    result.add(sonic.getName());
                    stopGame(button, result, root);
                }
                if (funnyGirl.x >= 800) {
                    stop();
                    result.add(funnyGirl.getName());
                    stopGame(button, result, root);
                }
                if (funnyMan.x >= 800) {
                    stop();
                    result.add(funnyMan.getName());
                    stopGame(button, result, root);
                }
                if (funnyMan1.x >= 800) {
                    stop();
                    result.add(funnyMan1.getName());
                    stopGame(button, result, root);
                }
                if (hero.x >= 800) {
                    stop();
                    result.add(hero.getName());
                    stopGame(button, result, root);
                }
                if (sonic1.x >= 800) {
                    stop();
                    result.add(sonic1.getName());
                    stopGame(button, result, root);
                }
                if (ninja1.x >= 800) {
                    stop();
                    result.add(ninja1.getName());
                    stopGame(button, result, root);
                }

 //todo счетчик анимации обнуляется только после нажатия клавиши ВЫХОД. Пока не нажата операция выполняется(исправить)

            }
        };

        timer.start();
        button.setOnMouseClicked(event -> {
            time = 0;
            timer.stop();
            window.close();
            System.out.println(result.toString());
        });

        root.getChildren().addAll(ninja.getCharacter(), sonic.getCharacter(), funnyMan.getCharacter(),
                funnyGirl.getCharacter(),funnyMan1.getCharacter(),hero.getCharacter(),sonic1.getCharacter(),
                ninja1.getCharacter(), button);
        gameroot.getChildren().addAll(img, root);
        Scene scene = new Scene(gameroot, 900, 600);
        window.setScene(scene);
        window.show();
    }

    private static void stopGame(MainItem button, ArrayList<String> result, Pane root) {
        button.setVisible(true);
        name = result.get(0);
        MainItem button1 = new MainItem("Победитель на " + name);
        button1.setTranslateY(200);
        button1.setTranslateX(300);
        if (Ipodrom.rate.equals(name)) {
            rateGame = "ВЫ ВЫЙГРАЛИ";
        } else {
            rateGame = "ВЫ ПРОИГРАЛИ";
        }
        MainItem button2 = new MainItem(rateGame);
        button2.setTranslateY(100);
        button2.setTranslateX(300);
        root.getChildren().addAll(button1, button2);
    }

}


