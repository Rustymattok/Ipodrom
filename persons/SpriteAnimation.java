package ru.makarov.ipodrom.persons;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Created by makarov_vv on 08.10.2015.
 */
public class SpriteAnimation extends Transition {

    private final ImageView imageView;
    private final int count;
    private final int colomuns;
    private final int width;
    private final int height;
    private int offsetX;
    private int offsetY;

    public SpriteAnimation(ImageView imageView, Duration duration, int count, int colomns,
                           int offsetX, int offsetY, int width, int height) {
        this.imageView = imageView;
        this.count = count;
        this.colomuns = colomns;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setCycleCount(Animation.INDEFINITE);
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));

    }

    @Override
    protected void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        final int x = (index % colomuns) * width + offsetX;
        final int y = (index / colomuns) * height + offsetY;
        imageView.setViewport(new Rectangle2D(x, y, width, height));
    }
}
