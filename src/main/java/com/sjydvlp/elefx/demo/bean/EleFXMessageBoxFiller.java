package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.message.EleFXMessage;
import com.sjydvlp.elefx.component.message.EleFXMessageOptions;
import com.sjydvlp.elefx.component.message.EleFXMessagePlacement;
import com.sjydvlp.elefx.component.message.EleFXMessageType;
import com.sjydvlp.elefx.component.messagebox.EleFXMessageBox;
import com.sjydvlp.elefx.component.messagebox.EleFXMessageBoxAction;
import com.sjydvlp.elefx.component.messagebox.EleFXMessageBoxOptions;
import com.sjydvlp.elefx.component.messagebox.EleFXMessageBoxType;
import com.sjydvlp.elefx.component.switcher.EleFXSwitch;
import javafx.animation.PauseTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

/**
 * EleFXMessageFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXMessageBoxFiller {

    private static final Map<EleFXMessagePlacement, Integer> counts =
            new EnumMap<>(EleFXMessagePlacement.class);

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*"
                    + "@(?:\\w(?:[\\w-]*\\w)?\\.)+\\w(?:[\\w-]*\\w)?$"
    );

    public static void fill(VBox vBox) {
        HBox alertTest = alertTest();
        HBox confirmTest = confirmTest();
        HBox promptTest = promptTest();
        HBox useVNodeTest = useVNodeTest();
        VBox useVNodeWithActionHandlersTest = useVNodeWithActionHandlersTest();
        VBox customizationTest = customizationTest();
        VBox distinguishingCancelAndCloseTest = distinguishingCancelAndCloseTest();
        VBox centeredContentTest = centeredContentTest();
        VBox customizedIconTest = customizedIconTest();
        HBox draggableTest = draggableTest();

        vBox.getChildren().add(alertTest);
        vBox.getChildren().add(confirmTest);
        vBox.getChildren().add(promptTest);
        vBox.getChildren().add(useVNodeTest);
        vBox.getChildren().add(useVNodeWithActionHandlersTest);
        vBox.getChildren().add(customizationTest);
        vBox.getChildren().add(distinguishingCancelAndCloseTest);
        vBox.getChildren().add(centeredContentTest);
        vBox.getChildren().add(customizedIconTest);
        vBox.getChildren().add(draggableTest);
        vBox.setSpacing(20);
    }

    private static HBox alertTest() {
        Button button = new Button("Click to open the Message Box");

        button.setOnAction(event ->
                EleFXMessageBox.alert(
                        "This is a message",
                        "Title",
                        new EleFXMessageBoxOptions()
                                .owner(button.getScene().getWindow())
                                .confirmButtonText("OK")
                                // .autofocus(false)
                                .callback(result -> {
                                    String action = result.action().name()
                                            .toLowerCase(Locale.ROOT);

                                    EleFXMessage.show(
                                            new EleFXMessageOptions()
                                                    .owner(button.getScene().getWindow())
                                                    .message("action: " + action)
                                    );
                                })
                )
        );

        HBox root = new HBox(8, button);
        root.setPadding(new Insets(20));

        return root;
    }

    private static HBox confirmTest() {
        Button button = new Button("Click to open the Message Box");

        button.setOnAction(event ->
                EleFXMessageBox.confirm(
                        "proxy will permanently delete the file. Continue?",
                        "Warning",
                        new EleFXMessageBoxOptions()
                                .owner(button.getScene().getWindow())
                                .confirmButtonText("OK")
                                .cancelButtonText("Cancel")
                                .type(EleFXMessageBoxType.WARNING)
                ).thenAccept(result -> {
                    if (result.confirmed()) {
                        showMessage(button.getScene().getWindow(), EleFXMessageType.SUCCESS, "Delete completed");
                    } else {
                        showMessage(button.getScene().getWindow(), EleFXMessageType.INFO, "Delete canceled");
                    }
                })
        );

        HBox root = new HBox(button);
        root.setPadding(new Insets(20));

        return root;
    }

    private static HBox promptTest() {
        Button button = new Button("Click to open Message Box");

        button.setOnAction(event ->
                EleFXMessageBox.prompt(
                        "Please input your e-mail",
                        "Tip",
                        new EleFXMessageBoxOptions()
                                .owner(button.getScene().getWindow())
                                .confirmButtonText("OK")
                                .cancelButtonText("Cancel")
                                .inputPattern(EMAIL_PATTERN)
                                .inputErrorMessage("Invalid Email")
                ).thenAccept(result -> {
                    if (result.confirmed()) {
                        showMessage(button.getScene().getWindow(), EleFXMessageType.SUCCESS,
                                "Your email is:" + result.value());
                    } else {
                        showMessage(button.getScene().getWindow(), EleFXMessageType.INFO, "Input canceled");
                    }
                })
        );

        HBox root = new HBox(button);
        root.setPadding(new Insets(20));

        return root;
    }

    private static HBox useVNodeTest() {
        EleFXButton commonButton = new EleFXButton("Common VNode");
        commonButton.setPlain(true);
        commonButton.setOnAction(event -> {
            Text normal = new Text("Message can be ");
            Text italic = new Text("VNode");
            italic.setFill(Color.TEAL);
            italic.setStyle("-fx-font-style: italic;");

            EleFXMessageBox.show(new EleFXMessageBoxOptions()
                    .owner(commonButton.getScene().getWindow())
                    .title("Message")
                    .messageNode(new TextFlow(normal, italic)));
        });

        EleFXButton dynamicButton = new EleFXButton("Dynamic props");
        dynamicButton.setPlain(true);
        dynamicButton.setOnAction(event -> {
            BooleanProperty checked = new SimpleBooleanProperty(false);
            EleFXSwitch toggle = new EleFXSwitch();
            toggle.selectedProperty().bindBidirectional(checked);

            EleFXMessageBox.show(new EleFXMessageBoxOptions()
                    .owner(dynamicButton.getScene().getWindow())
                    .title("Message")
                    .messageNode(toggle));
        });

        return new HBox(8, commonButton, dynamicButton);
    }

    private static VBox useVNodeWithActionHandlersTest() {
        EleFXButton openButton = new EleFXButton("Click to open Message Box");
        openButton.setPlain(true);

        openButton.setOnAction(event -> {
            Window owner = openButton.getScene().getWindow();

            EleFXMessageBox.show(new EleFXMessageBoxOptions()
                            .owner(owner)
                            .title("Message")
                            .showConfirmButton(false)
                            .showCancelButton(false)
                            .distinguishCancelAndClose(true)
                            .messageNodeFactory(box -> {
                                Label description = new Label(
                                        "Custom buttons with MessageBox action handlers");

                                EleFXButton resolve = new EleFXButton("Resolve", EleFXButtonType.PRIMARY);
                                resolve.setOnAction(e -> box.confirm());

                                EleFXButton reject = new EleFXButton("Reject", EleFXButtonType.DANGER);
                                reject.setOnAction(e -> box.cancel());

                                EleFXButton close = new EleFXButton("Close");
                                close.setOnAction(e -> box.close());

                                return new VBox(8, description, new HBox(8, resolve, reject, close));
                            }))
                    .thenAccept(result -> {
                        EleFXMessageBoxAction action = result.action();
                        String actionText = action.name().toLowerCase(Locale.ROOT);

                        EleFXMessage.show(new EleFXMessageOptions()
                                .owner(owner)
                                .type(action == EleFXMessageBoxAction.CONFIRM
                                        ? EleFXMessageType.SUCCESS
                                        : EleFXMessageType.ERROR)
                                .message((action == EleFXMessageBoxAction.CONFIRM
                                        ? "resolved: "
                                        : "rejected: ") + actionText));
                    });
        });

        return new VBox(openButton);
    }

    private static VBox customizationTest() {
        EleFXButton openButton = new EleFXButton("Click to open Message Box");
        openButton.setPlain(true);

        openButton.setOnAction(event -> {
            Window owner = openButton.getScene().getWindow();

            Text normal = new Text("Message can be ");
            Text italic = new Text("VNode");
            italic.setFill(Color.TEAL);
            italic.setStyle("-fx-font-style: italic;");

            EleFXMessageBox.show(new EleFXMessageBoxOptions()
                            .owner(owner)
                            .title("Message")
                            .messageNode(new TextFlow(normal, italic))
                            .showCancelButton(true)
                            .confirmButtonText("OK")
                            .cancelButtonText("Cancel")
                            .beforeClose((action, instance, done) -> {
                                if (action == EleFXMessageBoxAction.CONFIRM) {
                                    instance.setConfirmButtonLoading(true);
                                    instance.getConfirmButton().setText("Loading...");

                                    PauseTransition delay = new PauseTransition(Duration.seconds(3));
                                    delay.setOnFinished(e -> {
                                        done.run();

                                        PauseTransition reset =
                                                new PauseTransition(Duration.millis(300));
                                        reset.setOnFinished(e2 ->
                                                instance.setConfirmButtonLoading(false));
                                        reset.play();
                                    });
                                    delay.play();
                                } else {
                                    done.run();
                                }
                            }))
                    .thenAccept(result ->
                            EleFXMessage.show(new EleFXMessageOptions()
                                    .owner(owner)
                                    .type(EleFXMessageType.INFO)
                                    .message("action: " + result.action()
                                            .name().toLowerCase(Locale.ROOT))));
        });

        return new VBox(openButton);
    }

    private static VBox distinguishingCancelAndCloseTest() {
        EleFXButton openButton = new EleFXButton("Click to open Message Box");
        openButton.setPlain(true);

        openButton.setOnAction(event -> {
            Window owner = openButton.getScene().getWindow();

            EleFXMessageBox.confirm(
                    "You have unsaved changes, save and proceed?",
                    "Confirm",
                    new EleFXMessageBoxOptions()
                            .owner(owner)
                            .distinguishCancelAndClose(true)
                            .confirmButtonText("Save")
                            .cancelButtonText("Discard Changes")
            ).thenAccept(result -> {
                String message = switch (result.action()) {
                    case CONFIRM -> "Changes saved. Proceeding to a new route.";
                    case CANCEL -> "Changes discarded. Proceeding to a new route.";
                    case CLOSE -> "Stay in the current route";
                };

                EleFXMessage.show(new EleFXMessageOptions()
                        .owner(owner)
                        .type(EleFXMessageType.INFO)
                        .message(message));
            });
        });

        return new VBox(openButton);
    }

    private static VBox centeredContentTest() {
        EleFXButton openButton = new EleFXButton("Click to open Message Box");
        openButton.setPlain(true);

        openButton.setOnAction(event -> {
            Window owner = openButton.getScene().getWindow();

            EleFXMessageBox.confirm(
                    "proxy will permanently delete the file. Continue?",
                    "Warning",
                    new EleFXMessageBoxOptions()
                            .owner(owner)
                            .confirmButtonText("OK")
                            .cancelButtonText("Cancel")
                            .type(EleFXMessageBoxType.WARNING)
                            .center(true)
            ).thenAccept(result -> {
                boolean confirmed = result.action() == EleFXMessageBoxAction.CONFIRM;

                EleFXMessage.show(new EleFXMessageOptions()
                        .owner(owner)
                        .type(confirmed
                                ? EleFXMessageType.SUCCESS
                                : EleFXMessageType.INFO)
                        .message(confirmed
                                ? "Delete completed"
                                : "Delete canceled"));
            });
        });

        return new VBox(openButton);
    }

    private static VBox customizedIconTest() {
        EleFXButton openButton = new EleFXButton("Click to open Message Box");
        openButton.setPlain(true);

        openButton.setOnAction(event -> {
            Window owner = openButton.getScene().getWindow();

            EleFXMessageBox.confirm(
                    "It will permanently delete the file. Continue?",
                    "Warning",
                    new EleFXMessageBoxOptions()
                            .owner(owner)
                            .confirmButtonText("OK")
                            .cancelButtonText("Cancel")
                            .type(EleFXMessageBoxType.WARNING)
                            .icon(new EleFXIcon(EleFXIconType.DELETE, 24))
            ).thenAccept(result -> {
                boolean confirmed = result.action() == EleFXMessageBoxAction.CONFIRM;

                EleFXMessage.show(new EleFXMessageOptions()
                        .owner(owner)
                        .type(confirmed
                                ? EleFXMessageType.SUCCESS
                                : EleFXMessageType.INFO)
                        .message(confirmed
                                ? "Delete completed"
                                : "Delete canceled"));
            });
        });

        return new VBox(openButton);
    }

    private static HBox draggableTest() {
        EleFXButton draggable = new EleFXButton("Open a draggable Message Box");
        EleFXButton overflow = new EleFXButton("Open a overflow draggable Message Box");
        EleFXButton custom = new EleFXButton("Open a custom dragging style Message Box");

        draggable.setPlain(true);
        overflow.setPlain(true);
        custom.setPlain(true);

        BiConsumer<EleFXButton, Boolean> openWarning = (button, allowOverflow) -> {
            Window owner = button.getScene().getWindow();

            EleFXMessageBox.confirm(
                    "proxy will permanently delete the file. Continue?",
                    "Warning",
                    new EleFXMessageBoxOptions()
                            .owner(owner)
                            .confirmButtonText("OK")
                            .cancelButtonText("Cancel")
                            .type(EleFXMessageBoxType.WARNING)
                            .draggable(true)
                            .overflow(allowOverflow)
            ).thenAccept(result -> {
                boolean confirmed = result.action() == EleFXMessageBoxAction.CONFIRM;
                EleFXMessage.show(new EleFXMessageOptions()
                        .owner(owner)
                        .type(confirmed
                                ? EleFXMessageType.SUCCESS
                                : EleFXMessageType.INFO)
                        .message(confirmed
                                ? "Delete completed"
                                : "Delete canceled"));
            });
        };

        draggable.setOnAction(event -> openWarning.accept(draggable, false));
        overflow.setOnAction(event -> openWarning.accept(overflow, true));

        custom.setOnAction(event -> {
            Window owner = custom.getScene().getWindow();

            EleFXMessageBox.confirm(
                    "This message box has custom dragging styles. "
                            + "Try dragging it to see the effects!",
                    "Custom Dragging Style",
                    new EleFXMessageBoxOptions()
                            .owner(owner)
                            .confirmButtonText("OK")
                            .cancelButtonText("Cancel")
                            .type(EleFXMessageBoxType.INFO)
                            .draggable(true)
                            .draggingStyle(
                                    "-fx-border-color: #409eff; "
                                            + "-fx-border-style: dashed; "
                                            + "-fx-border-width: 2px; "
                                            + "-fx-border-radius: 4px; "
                                            + "-fx-opacity: 0.65;")
            ).thenAccept(result -> {
                boolean confirmed = result.action() == EleFXMessageBoxAction.CONFIRM;
                EleFXMessage.show(new EleFXMessageOptions()
                        .owner(owner)
                        .type(confirmed
                                ? EleFXMessageType.SUCCESS
                                : EleFXMessageType.INFO)
                        .message(confirmed
                                ? "Action completed"
                                : "Action canceled"));
            });
        });

        return new HBox(8, draggable, overflow, custom);
    }

    private static void showMessage(Window window, EleFXMessageType type, String text) {
        EleFXMessage.show(
                new EleFXMessageOptions()
                        .owner(window)
                        .type(type)
                        .message(text)
        );
    }

    private EleFXMessageBoxFiller() {
    }
}
