package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.message.EleFXMessage;
import com.sjydvlp.elefx.component.message.EleFXMessageOptions;
import com.sjydvlp.elefx.component.message.EleFXMessagePlacement;
import com.sjydvlp.elefx.component.message.EleFXMessageType;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

/**
 * EleFXMessageFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXMessageFiller {

    private static final Map<EleFXMessagePlacement, Integer> counts =
            new EnumMap<>(EleFXMessagePlacement.class);

    public static void fill(VBox vBox) {
        HBox basisUsageTest = basisUsageTest();
        HBox typesTest = typesTest();
        HBox plainTest = plainTest();
        HBox closableTest = closableTest();
        VBox useHtmlStringTest = useHtmlStringTest();
        VBox placementTest = placementTest();

        vBox.getChildren().add(basisUsageTest);
        vBox.getChildren().add(typesTest);
        vBox.getChildren().add(plainTest);
        vBox.getChildren().add(closableTest);
        vBox.getChildren().add(useHtmlStringTest);
        vBox.getChildren().add(placementTest);
        vBox.setSpacing(20);
    }

    private static HBox basisUsageTest() {
        Button showMessage = new Button("Show message");
        showMessage.setOnAction(event ->
                EleFXMessage.show("This is a message.")
        );

        Button showNode = new Button("VNode");
        showNode.setOnAction(event -> {
            Text normal = new Text("Message can be ");
            Text highlighted = new Text("VNode");
            highlighted.setStyle("-fx-fill: teal; -fx-font-style: italic;");

            TextFlow content = new TextFlow(normal, highlighted);

            EleFXMessage.show(
                    new EleFXMessageOptions()
                            .messageNode(content)
                            .owner(showNode.getScene().getWindow())
            );
        });

        HBox root = new HBox(8, showMessage, showNode);
        root.setPadding(new Insets(20));

        return root;
    }

    private static HBox typesTest() {
        Button primary = new Button("Primary");
        primary.setOnAction(e ->
                EleFXMessage.primary("This is a primary message.")
        );

        Button success = new Button("Success");
        success.setOnAction(e ->
                EleFXMessage.success("Congrats, this is a success message.")
        );

        Button warning = new Button("Warning");
        warning.setOnAction(e ->
                EleFXMessage.warning("Warning, this is a warning message.")
        );

        Button info = new Button("Info");
        info.setOnAction(e ->
                EleFXMessage.info("This is an info message.")
        );

        Button error = new Button("Error");
        error.setOnAction(e ->
                EleFXMessage.error("Oops, this is an error message.")
        );

        HBox root = new HBox(8, primary, success, warning, info, error);
        root.setPadding(new Insets(20));

        return root;
    }

    private static HBox plainTest() {
        HBox root = new HBox(8,
                messageButton("Primary", "This is a primary message.", EleFXMessageType.PRIMARY, false),
                messageButton("Success", "Congrats, this is a success message.", EleFXMessageType.SUCCESS, false),
                messageButton("Warning", "Warning, this is a warning message.", EleFXMessageType.WARNING, false),
                messageButton("Info", "This is an info message.", EleFXMessageType.INFO, false),
                messageButton("Error", "Oops, this is an error message.", EleFXMessageType.ERROR, false)
        );
        root.setPadding(new Insets(20));

        return root;
    }

    private static HBox closableTest() {
        HBox root = new HBox(8,
                messageButton("Primary", "This is a primary message.", EleFXMessageType.PRIMARY, true),
                messageButton("Success", "Congrats, this is a success message.", EleFXMessageType.SUCCESS, true),
                messageButton("Warning", "Warning, this is a warning message.", EleFXMessageType.WARNING, true),
                messageButton("Info", "This is an info message.", EleFXMessageType.INFO, true),
                messageButton("Error", "Oops, this is an error message.", EleFXMessageType.ERROR, true)
        );

        Button persistent = new Button("Won't close automatically");
        persistent.setOnAction(event ->
                EleFXMessage.show(
                        new EleFXMessageOptions()
                                .message("Oops, this is a message that does not automatically close.")
                                .showClose(true)
                                .duration(0)
                )
        );
        root.getChildren().add(persistent);
        root.setPadding(new Insets(20));

        return root;
    }

    private static VBox useHtmlStringTest() {
        Button button = new Button("Use HTML string");
        button.setOnAction(event -> {
            Text first = new Text("This is ");
            first.setStyle("-fx-font-weight: bold;");

            Text html = new Text("HTML");
            html.setStyle("-fx-font-weight: bold; -fx-font-style: italic;");

            Text last = new Text(" string");
            last.setStyle("-fx-font-weight: bold;");

            EleFXMessage.show(new TextFlow(first, html, last));
        });

        return new VBox(button);
    }

    private static VBox placementTest() {
        HBox root = new HBox(8,
                button("Top", EleFXMessagePlacement.TOP),
                button("Top Left", EleFXMessagePlacement.TOP_LEFT),
                button("Top Right", EleFXMessagePlacement.TOP_RIGHT),
                button("Bottom", EleFXMessagePlacement.BOTTOM),
                button("Bottom Left", EleFXMessagePlacement.BOTTOM_LEFT),
                button("Bottom Right", EleFXMessagePlacement.BOTTOM_RIGHT)
        );
        root.setPadding(new Insets(20));

        return new VBox(root);
    }

    private static Button messageButton(String title, String text, EleFXMessageType type, boolean showClose) {
        Button button = new Button(title);
        button.setOnAction(event ->
                EleFXMessage.show(
                        new EleFXMessageOptions()
                                .message(text)
                                .type(type)
                                .plain(true)
                                .showClose(showClose)
                )
        );
        return button;
    }

    private static Button button(String title, EleFXMessagePlacement placement) {
        Button button = new Button(title);
        button.setOnAction(event -> openMessage(placement));
        return button;
    }

    private static void openMessage(EleFXMessagePlacement placement) {
        int count = counts.merge(placement, 1, Integer::sum);

        EleFXMessageType type = switch (placement) {
            case TOP -> EleFXMessageType.SUCCESS;
            case TOP_LEFT -> EleFXMessageType.INFO;
            case TOP_RIGHT -> EleFXMessageType.PRIMARY;
            case BOTTOM, BOTTOM_LEFT -> EleFXMessageType.WARNING;
            case BOTTOM_RIGHT -> EleFXMessageType.ERROR;
        };

        String position = placement.name()
                .toLowerCase(Locale.ROOT)
                .replace('_', '-');

        EleFXMessage.show(
                new EleFXMessageOptions()
                        .message("This is a message from the " + position + " " + count)
                        .type(type)
                        .placement(placement)
        );
    }

    private EleFXMessageFiller() {
    }
}
