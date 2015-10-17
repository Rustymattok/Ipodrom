package ru.makarov.ipodrom.interfacesMenu;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MainItem extends StackPane {
    private String name;

    public MainItem(String name) {
        Rectangle rectangle = new Rectangle(250, 50, Color.WHITE);
        rectangle.setOpacity(0.5);
        this.name = name;
        Text text = new Text(name);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        setAlignment(Pos.CENTER);

        FillTransition st = new FillTransition(Duration.seconds(0.5), rectangle);

        rectangle.setOnMouseEntered(event -> {
            st.setFromValue(Color.WHITE);
            st.setToValue(Color.DARKCYAN);
            st.setCycleCount(Animation.INDEFINITE);
            st.setAutoReverse(true);
            st.play();
        });

        rectangle.setOnMouseExited(event -> {
            st.stop();
            rectangle.setFill(Color.WHITE);
        });

        getChildren().addAll(rectangle, text);
    }

    public String getName() {
        return name;
    }
}