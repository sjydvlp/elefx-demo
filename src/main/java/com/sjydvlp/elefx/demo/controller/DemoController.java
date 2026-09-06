package com.sjydvlp.elefx.demo.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DemoController implements Initializable {

    private final Stage stage;

    private double lastMouseX;

    private double lastMouseY;

    private boolean dragging;

    @FXML
    private HBox windowHeader;

    @FXML
    private VBox navBar;

    @FXML
    private StackPane contentPane;

    @FXML
    private StackPane logoContainer;

    public DemoController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        windowHeader.setOnMouseDragged(event -> {
            double mouseX = event.getScreenX();
            double mouseY = event.getScreenY();

            if (!dragging) {
                dragging = true;
                lastMouseX = mouseX;
                lastMouseY = mouseY;
                return;
            }

            stage.setX(stage.getX() + mouseX - lastMouseX);
            stage.setY(stage.getY() + mouseY - lastMouseY);

            lastMouseX = mouseX;
            lastMouseY = mouseY;
        });
        windowHeader.setOnMouseReleased(event -> {
            dragging = false;
        });

        initializeLoader();

        // The only way to get a fucking smooth image in this shitty framework
        Image image = new Image(ResourceUtil.getStream("logo_alt.png"), 64, 64, true, true);
        ImageView logo = new ImageView(image);
        Circle clip = new Circle(30);
        clip.centerXProperty().bind(
                Bindings.createDoubleBinding(
                        () -> logo.getLayoutBounds().getCenterX(),
                        logo.layoutBoundsProperty()));
        clip.centerYProperty().bind(
                Bindings.createDoubleBinding(
                        () -> logo.getLayoutBounds().getCenterY(),
                        logo.layoutBoundsProperty()));
        logo.setClip(clip);
        logoContainer.getChildren().add(logo);
    }

    private void initializeLoader() {
        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(20));
        hBox1.setSpacing(10);
        hBox1.getChildren().addAll(
                new EleFXButton("Default"),
                new EleFXButton("Primary", EleFXButtonType.PRIMARY),
                new EleFXButton("Success", EleFXButtonType.SUCCESS),
                new EleFXButton("Info", EleFXButtonType.INFO),
                new EleFXButton("Warning", EleFXButtonType.WARNING),
                new EleFXButton("Danger", EleFXButtonType.DANGER));

        double iconSize = 18.0;
        
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(20));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(
                new EleFXButton(EleFXIcons.of(EleFXIconType.PLUS, iconSize), EleFXButtonType.DEFAULT, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.MINUS, iconSize), EleFXButtonType.PRIMARY, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CIRCLE_PLUS, iconSize), EleFXButtonType.SUCCESS, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.SEARCH, iconSize), EleFXButtonType.INFO, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CHAT_LINE_SQUARE, iconSize), EleFXButtonType.WARNING, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CIRCLE_CLOSE, iconSize), EleFXButtonType.DANGER, true));

        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(20));
        hBox3.setSpacing(10);
        hBox3.getChildren().addAll(
                EleFXIcons.of(EleFXIconType.PLUS, iconSize),
                EleFXIcons.of(EleFXIconType.MINUS, iconSize),
                EleFXIcons.of(EleFXIconType.CIRCLE_PLUS, iconSize),
                EleFXIcons.of(EleFXIconType.SEARCH, iconSize),
                EleFXIcons.of(EleFXIconType.CHAT_LINE_SQUARE, iconSize),
                EleFXIcons.of(EleFXIconType.CIRCLE_CLOSE, iconSize));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1, hBox2, hBox3);

        contentPane.getChildren().add(vBox);
    }
}
