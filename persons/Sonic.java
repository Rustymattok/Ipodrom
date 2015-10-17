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
public class Sonic extends Transition {
    public int x;
    private String name ;
    private Character character;
    private Image image = new Image(getClass().getResourceAsStream("rec\\sonic1.png"));
    private ImageView imageView = new ImageView(image);
    private int count = 4;
    private int columns = 10;
    private int offsetX = 0;
    private int offsetY = 78;
    private int width = 30;
    private int height = 39;

    public Sonic(int n,String name) {
        this.character = new Character(imageView, n, count, columns, offsetX, offsetY, width, height);
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
