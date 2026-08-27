package com.sjydvlp.elefx.demo.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import com.sjydvlp.elefx.button.EleFxButton;
import com.sjydvlp.elefx.button.EleFxButtonType;
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
import javafx.scene.text.Text;
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
                new EleFxButton("Default"),
                new EleFxButton("Primary", EleFxButtonType.PRIMARY),
                new EleFxButton("Success", EleFxButtonType.SUCCESS),
                new EleFxButton("Info", EleFxButtonType.INFO),
                new EleFxButton("Warning", EleFxButtonType.WARNING),
                new EleFxButton("Danger", EleFxButtonType.DANGER)
        );

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(20));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(
                new EleFxButton(new Text("a"), EleFxButtonType.DEFAULT, true),
                new EleFxButton(new Text("a"), EleFxButtonType.PRIMARY, true),
                new EleFxButton(new Text("a"), EleFxButtonType.SUCCESS, true),
                new EleFxButton(new Text("a"), EleFxButtonType.INFO, true),
                new EleFxButton(new Text("a"), EleFxButtonType.WARNING, true),
                new EleFxButton(new Text("a"), EleFxButtonType.DANGER, true)
        );

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1, hBox2);

        contentPane.getChildren().add(vBox);
    }
}
