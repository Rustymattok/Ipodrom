package ru.makarov.ipodrom.persons;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.lang.*;

/**
 * Created by makarov_vv on 08.10.2015.
 */
public class Hero extends Transition {
    public int x;
    private Character character;
    private String name;
    private Image image = new Image(getClass().getResourceAsStream("rec\\hero.png"));
    private ImageView imageView = new ImageView(image);
    private int count = 6;
    private int columns = 4;
    private int offsetX = 7;
    private int offsetY = 123;
    private int width = 40;
    private int height = 38;

    //  Character(ImageView imageView, int n,int count,int offsetX,int offsetY,int width,int height)
    public Hero(int n, String name) {
        this.character = new ru.makarov.ipodrom.persons.Character(imageView, n, count, columns, offsetX, offsetY, width, height);
        this.name = name;
        setCycleCount(Animation.INDEFINITE);
        setCycleDuration(Duration.millis(n));
        this.x = offsetX;
        character.animation.play();

    }

    public String getName() {
        return name;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    protected void interpolate(double frac) {
        character.setTranslateX(x++);
    }
}
