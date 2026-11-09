package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.notification.EleFXNotification;
import com.sjydvlp.elefx.component.notification.EleFXNotificationOptions;
import com.sjydvlp.elefx.component.notification.EleFXNotificationPosition;
import com.sjydvlp.elefx.component.notification.EleFXNotificationType;
import com.sjydvlp.elefx.component.progress.EleFXProgressColorStop;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Locale;

/**
 * EleFXNotificationFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXNotificationFiller {

    public static void fill(VBox vBox) {
        HBox basicUsageTest = basicUsageTest();
        HBox withTypesTest = withTypesTest();
        HBox customPositionTest = customPositionTest();
        HBox withOffsetTest = withOffsetTest();
        HBox withProgressBarTest = withProgressBarTest();
        HBox hideCloseButtonTest = hideCloseButtonTest();

        vBox.getChildren().add(basicUsageTest);
        vBox.getChildren().add(withTypesTest);
        vBox.getChildren().add(customPositionTest);
        vBox.getChildren().add(withOffsetTest);
        vBox.getChildren().add(withProgressBarTest);
        vBox.getChildren().add(hideCloseButtonTest);
        vBox.setSpacing(10);
    }

    private static HBox basicUsageTest() {
        EleFXButton autoClose = new EleFXButton("Closes automatically");
        autoClose.setPlain(true);
        autoClose.setOnAction(event -> {
            Label message = new Label("This is a reminder");
            message.setStyle(
                    "-fx-text-fill: teal; -fx-font-style: italic;");

            EleFXNotification.show(new EleFXNotificationOptions()
                    .owner(autoClose.getScene().getWindow())
                    .title("Title")
                    .messageNode(message));
        });

        EleFXButton manualClose = new EleFXButton("Won't close automatically");
        manualClose.setPlain(true);
        manualClose.setOnAction(event -> EleFXNotification.show(new EleFXNotificationOptions()
                .owner(manualClose.getScene().getWindow())
                .title("Prompt")
                .message("This is a message that does not automatically close")
                .duration(0)));

        HBox root = new HBox(8);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(autoClose, manualClose);

        return root;
    }

    private static HBox withTypesTest() {
        EleFXButton primary = new EleFXButton("Primary");
        primary.setPlain(true);
        primary.setOnAction(event -> EleFXNotification.primary(new EleFXNotificationOptions()
                .owner(primary.getScene().getWindow())
                .title("Primary")
                .message("This is a primary message")));

        EleFXButton success = new EleFXButton("Success");
        success.setPlain(true);
        success.setOnAction(event -> EleFXNotification.success(new EleFXNotificationOptions()
                .owner(success.getScene().getWindow())
                .title("Success")
                .message("This is a success message")));

        EleFXButton warning = new EleFXButton("Warning");
        warning.setPlain(true);
        warning.setOnAction(event -> EleFXNotification.warning(new EleFXNotificationOptions()
                .owner(warning.getScene().getWindow())
                .title("Warning")
                .message("This is a warning message")));

        EleFXButton info = new EleFXButton("Info");
        info.setPlain(true);
        info.setOnAction(event -> EleFXNotification.info(new EleFXNotificationOptions()
                .owner(info.getScene().getWindow())
                .title("Info")
                .message("This is an info message")));

        EleFXButton error = new EleFXButton("Error");
        error.setPlain(true);
        error.setOnAction(event -> EleFXNotification.error(new EleFXNotificationOptions()
                .owner(error.getScene().getWindow())
                .title("Error")
                .message("This is an error message")));

        HBox root = new HBox(8);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(primary, success, warning, info, error);

        return root;
    }

    private static HBox customPositionTest() {
        EleFXButton topRight = new EleFXButton("Top Right");
        topRight.setPlain(true);
        topRight.setOnAction(event -> EleFXNotification.show(new EleFXNotificationOptions()
                .owner(topRight.getScene().getWindow())
                .title("Custom Position")
                .message("I'm at the top right corner")));

        EleFXButton bottomRight = new EleFXButton("Bottom Right");
        bottomRight.setPlain(true);
        bottomRight.setOnAction(event -> EleFXNotification.show(new EleFXNotificationOptions()
                .owner(bottomRight.getScene().getWindow())
                .title("Custom Position")
                .message("I'm at the bottom right corner")
                .position(EleFXNotificationPosition.BOTTOM_RIGHT)));

        EleFXButton bottomLeft = new EleFXButton("Bottom Left");
        bottomLeft.setPlain(true);
        bottomLeft.setOnAction(event -> EleFXNotification.show(new EleFXNotificationOptions()
                .owner(bottomLeft.getScene().getWindow())
                .title("Custom Position")
                .message("I'm at the bottom left corner")
                .position(EleFXNotificationPosition.BOTTOM_LEFT)));

        EleFXButton topLeft = new EleFXButton("Top Left");
        topLeft.setPlain(true);
        topLeft.setOnAction(event -> EleFXNotification.show(new EleFXNotificationOptions()
                .owner(topLeft.getScene().getWindow())
                .title("Custom Position")
                .message("I'm at the top left corner")
                .position(EleFXNotificationPosition.TOP_LEFT)));

        HBox root = new HBox(8);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(topRight, bottomRight, bottomLeft, topLeft);

        return root;
    }

    private static HBox withOffsetTest() {
        EleFXButton button = new EleFXButton("Notification with offset");
        button.setPlain(true);
        button.setOnAction(event -> EleFXNotification.success(new EleFXNotificationOptions()
                .owner(button.getScene().getWindow())
                .title("Success")
                .message("This is a success message")
                .offset(100)));

        HBox root = new HBox(8);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(button);

        return root;
    }

    private static HBox withProgressBarTest() {
        HBox root = new HBox(8);
        root.setPadding(new Insets(10));

        String[] labels = {
                "Default", "Success", "Warning", "Error", "Info",
                "Custom color", "No pause on hover"
        };

        EleFXButtonType[] buttonTypes = {
                EleFXButtonType.DEFAULT,
                EleFXButtonType.SUCCESS,
                EleFXButtonType.WARNING,
                EleFXButtonType.DANGER,
                EleFXButtonType.INFO,
                EleFXButtonType.DEFAULT,
                EleFXButtonType.DEFAULT
        };

        EleFXNotificationType[] notificationTypes = {
                null,
                EleFXNotificationType.SUCCESS,
                EleFXNotificationType.WARNING,
                EleFXNotificationType.ERROR,
                EleFXNotificationType.INFO
        };

        for (int i = 0; i < labels.length; i++) {
            final int index = i;

            EleFXButton button = new EleFXButton(labels[i], buttonTypes[i]);
            button.setPlain(true);
            button.setOnAction(event -> {
                EleFXNotificationOptions options = new EleFXNotificationOptions()
                        .owner(button.getScene().getWindow())
                        .duration(6000)
                        .progress(true);

                if (index < 5) {
                    String name = index == 0
                            ? "Default"
                            : labels[index].toLowerCase(Locale.ROOT);

                    options.title(name + " progress")
                            .message("Hover to pause the timer and progress bar")
                            .type(notificationTypes[index]);

                } else if (index == 5) {
                    options.title("Custom color")
                            .message("Custom progress bar color overrides the default")
                            .progressColors(
                                    new EleFXProgressColorStop(
                                            20, Color.web("#f56c6c")),
                                    new EleFXProgressColorStop(
                                            40, Color.web("#e6a23c")),
                                    new EleFXProgressColorStop(
                                            60, Color.web("#5cb87a")),
                                    new EleFXProgressColorStop(
                                            80, Color.web("#1989fa")),
                                    new EleFXProgressColorStop(
                                            100, Color.web("#6f7ad3")));

                } else {
                    options.title("No pause on hover")
                            .message("Timer and progress bar keep running even when hovering")
                            .pauseOnHover(false);
                }

                EleFXNotification.show(options);
            });

            root.getChildren().add(button);
        }

        return root;
    }

    private static HBox hideCloseButtonTest() {
        EleFXButton button = new EleFXButton("Hide close button");
        button.setPlain(true);

        button.setOnAction(event -> EleFXNotification.success(new EleFXNotificationOptions()
                .owner(button.getScene().getWindow())
                .title("Info")
                .message("This is a message without close button")
                .showClose(false)));

        HBox root = new HBox(8);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(button);

        return root;
    }

    private EleFXNotificationFiller() {
    }
}
