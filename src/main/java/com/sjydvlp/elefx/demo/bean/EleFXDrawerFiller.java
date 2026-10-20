package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.drawer.EleFXDrawer;
import com.sjydvlp.elefx.component.drawer.EleFXDrawerDirection;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.messagebox.EleFXMessageBox;
import com.sjydvlp.elefx.component.radio.EleFXRadio;
import com.sjydvlp.elefx.component.radio.EleFXRadioButton;
import com.sjydvlp.elefx.component.radio.EleFXRadioGroup;
import com.sjydvlp.elefx.component.radio.EleFXRadioSize;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXDrawerFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXDrawerFiller {

    public static void fill(VBox vBox) {
        VBox basisUsageTest = basisUsageTest();
        VBox noTitleTest = noTitleTest();
        VBox customizedHeaderTest = customizedHeaderTest();
        VBox resizableDrawerTest = resizableDrawerTest();
        VBox nestedDrawerTest = nestedDrawerTest();
        VBox modalTest = modalTest();

        vBox.getChildren().add(basisUsageTest);
        vBox.getChildren().add(noTitleTest);
        vBox.getChildren().add(customizedHeaderTest);
        vBox.getChildren().add(resizableDrawerTest);
        vBox.getChildren().add(nestedDrawerTest);
        vBox.getChildren().add(modalTest);
        vBox.setSpacing(20);
    }

    private static VBox basisUsageTest() {
        // 对应 direction
        EleFXRadioGroup<EleFXDrawerDirection> directions = new EleFXRadioGroup<>(
                new EleFXRadio<>("left to right", EleFXDrawerDirection.LTR),
                new EleFXRadio<>("right to left", EleFXDrawerDirection.RTL),
                new EleFXRadio<>("top to bottom", EleFXDrawerDirection.TTB),
                new EleFXRadio<>("bottom to top", EleFXDrawerDirection.BTT)
        );
        directions.setValue(EleFXDrawerDirection.LTR);
        directions.setHgap(12);
        directions.setVgap(8);

        // 普通抽屉：关闭前确认
        EleFXDrawer drawer = new EleFXDrawer(new Label("Hi, there!"));
        drawer.setTitle("I am the title");
        drawer.setBeforeClose(done ->
                EleFXMessageBox.confirm(
                        "Are you sure you want to close this?", "Confirm"
                ).thenAccept(result -> {
                    if (result.confirmed()) {
                        Platform.runLater(done);
                    }
                })
        );

        // 带页脚的抽屉
        EleFXRadioGroup<String> options = new EleFXRadioGroup<>(
                new EleFXRadio<>("Option 1", "Option 1"),
                new EleFXRadio<>("Option 2", "Option 2")
        );
        options.setValue("Option 1");
        options.getRadios().forEach(radio ->
                radio.setSize(EleFXRadioSize.LARGE)
        );

        EleFXDrawer drawerWithFooter = new EleFXDrawer(options);
        drawerWithFooter.setHeader(new Label("set title by slot"));

        EleFXButton cancel = new EleFXButton("cancel");
        cancel.setOnAction(event -> drawerWithFooter.close());

        EleFXButton confirm = new EleFXButton(
                "confirm", EleFXButtonType.PRIMARY
        );
        confirm.setOnAction(event ->
                EleFXMessageBox.confirm(
                        "Are you confirm to chose " + options.getValue() + " ?",
                        "Confirm"
                ).thenAccept(result -> {
                    if (result.confirmed()) {
                        Platform.runLater(drawerWithFooter::close);
                    }
                })
        );

        HBox footer = new HBox(12, cancel, confirm);
        footer.setAlignment(Pos.CENTER_RIGHT);
        drawerWithFooter.setFooter(footer);

        // 两个抽屉共用所选方向
        directions.valueProperty().addListener(
                (observable, oldValue, direction) -> {
                    drawer.setDirection(direction);
                    drawerWithFooter.setDirection(direction);
                }
        );
        drawer.setDirection(directions.getValue());
        drawerWithFooter.setDirection(directions.getValue());

        EleFXButton open = new EleFXButton(
                "open", EleFXButtonType.PRIMARY
        );
        open.setOnAction(event -> drawer.show(open.getScene().getWindow()));

        EleFXButton openWithFooter = new EleFXButton(
                "with footer", EleFXButtonType.PRIMARY
        );
        openWithFooter.setOnAction(event -> drawerWithFooter.show(openWithFooter.getScene().getWindow()));

        VBox root = new VBox(
                20,
                directions,
                new HBox(16, open, openWithFooter)
        );
        root.setPadding(new Insets(24));

        return root;
    }

    private static VBox noTitleTest() {
        EleFXDrawer drawer = new EleFXDrawer(new Label("Hi there!"));
        drawer.setTitle("I am the title");
        drawer.setWithHeader(false);

        EleFXButton open = new EleFXButton("open", EleFXButtonType.PRIMARY);
        open.setOnAction(event -> drawer.show(open.getScene().getWindow()));

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(open);
        return vBox;
    }

    private static VBox customizedHeaderTest() {
        EleFXDrawer drawer = new EleFXDrawer(
                new Label("This is drawer content.")
        );
        drawer.setShowClose(false);

        Label title = new Label("This is a custom header!");
        title.getStyleClass().add("ele-drawer__title");

        EleFXButton close = new EleFXButton(
                "Close",
                new EleFXIcon(EleFXIconType.CIRCLE_CLOSE_FILLED, 16),
                EleFXButtonType.DANGER
        );
        close.setOnAction(event -> drawer.requestClose());

        HBox header = new HBox(12, title, close);
        header.setAlignment(Pos.CENTER_LEFT);
        drawer.setHeader(header);

        EleFXButton open = new EleFXButton(
                "Open Drawer with customized header"
        );
        open.setOnAction(event -> drawer.show(open.getScene().getWindow()));

        return new VBox(open);
    }

    private static VBox resizableDrawerTest() {
        EleFXDrawer drawer = new EleFXDrawer(
                new Label("This is drawer content.")
        );
        drawer.setResizable(true);

        EleFXRadioGroup<EleFXDrawerDirection> directions =
                new EleFXRadioGroup<>(
                        new EleFXRadioButton<>("top", EleFXDrawerDirection.TTB),
                        new EleFXRadioButton<>("right", EleFXDrawerDirection.RTL),
                        new EleFXRadioButton<>("bottom", EleFXDrawerDirection.BTT),
                        new EleFXRadioButton<>("left", EleFXDrawerDirection.LTR)
                );

        directions.valueProperty().addListener(
                (observable, oldValue, direction) -> {
                    if (direction != null) {
                        drawer.setDirection(direction);
                        drawer.show(directions.getScene().getWindow());
                    }
                }
        );

        VBox root = new VBox(directions);
        root.setPadding(new Insets(24));

        return root;
    }

    private static VBox nestedDrawerTest() {
        EleFXDrawer innerDrawer = new EleFXDrawer(
                new Label("_(:зゝ∠)_")
        );
        innerDrawer.setTitle("I'm inner Drawer");
        innerDrawer.setBeforeClose(done ->
                EleFXMessageBox.confirm(
                        "You still have unsaved data, proceed?",
                        "Confirm"
                ).thenAccept(result -> {
                    if (result.confirmed()) {
                        Platform.runLater(done);
                    }
                })
        );

        EleFXButton openInner = new EleFXButton("Click me!");
        openInner.setOnAction(event ->
                innerDrawer.show(openInner.getScene().getWindow())
        );

        EleFXDrawer outerDrawer = new EleFXDrawer(openInner);
        outerDrawer.setTitle("I'm outer Drawer");
        outerDrawer.setSize("50%");

        EleFXButton openOuter = new EleFXButton(
                "open", EleFXButtonType.PRIMARY
        );
        openOuter.setOnAction(event -> outerDrawer.show(openOuter.getScene().getWindow()));

        return new VBox(openOuter);
    }

    private static VBox modalTest() {
        EleFXDrawer drawer = new EleFXDrawer(
                new Label("It's a modal Drawer")
        );
        drawer.setModal(false);
        drawer.setModalPenetrable(true);

        EleFXButton cancel = new EleFXButton("Cancel");
        cancel.setOnAction(event -> drawer.close());

        EleFXButton confirm = new EleFXButton(
                "Confirm", EleFXButtonType.PRIMARY
        );
        confirm.setOnAction(event -> drawer.close());

        HBox footer = new HBox(12, cancel, confirm);
        footer.setAlignment(Pos.CENTER_RIGHT);
        drawer.setFooter(footer);

        EleFXButton open = new EleFXButton("Open the modal Drawer");
        open.setType(EleFXButtonType.DEFAULT);
        open.setOnAction(event -> drawer.show(open.getScene().getWindow()));

        return new VBox(open);
    }

    private EleFXDrawerFiller() {
    }
}
