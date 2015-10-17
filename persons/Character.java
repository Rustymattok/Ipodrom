package ru.makarov.ipodrom.persons;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Created by makarov_vv on 08.10.2015.
 */
public class Character extends Pane {
    private ImageView imageView;
    private int count;
    private int columns;
    private int offsetX;
    private int offsetY;
    private int width;
    private int height;
    SpriteAnimation animation;

    public Character(ImageView imageView, int n, int count, int columns, int offsetX, int offsetY, int width, int height) {
        this.imageView = imageView;
        this.count = count;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.columns = columns;
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        animation = new SpriteAnimation(imageView, Duration.millis(n * 5), count, columns, offsetX, offsetY, width, height);
        getChildren().addAll(imageView);
    }

}
