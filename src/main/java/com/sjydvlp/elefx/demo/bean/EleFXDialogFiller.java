package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.dialog.EleFXDialog;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * EleFXAlertFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXDialogFiller {

    public static void fill(VBox vBox) {
        HBox basisUsageTest = basisUsageTest();
        HBox customizedContentTest = customizedContentTest();
        VBox customizedHeaderTest = customizedHeaderTest();
        VBox nestedDialogTest = nestedDialogTest();
        VBox centeredContentTest = centeredContentTest();
        VBox alignCenterDialogTest = alignCenterDialogTest();
        VBox draggableDialogTest = draggableDialogTest();
        VBox fullScreenTest = fullScreenTest();
        VBox modalTest = modalTest();

        vBox.getChildren().add(basisUsageTest);
        vBox.getChildren().add(customizedContentTest);
        vBox.getChildren().add(customizedHeaderTest);
        vBox.getChildren().add(nestedDialogTest);
        vBox.getChildren().add(centeredContentTest);
        vBox.getChildren().add(alignCenterDialogTest);
        vBox.getChildren().add(draggableDialogTest);
        vBox.getChildren().add(fullScreenTest);
        vBox.getChildren().add(modalTest);
        vBox.setSpacing(20);
    }

    private static HBox basisUsageTest() {
        EleFXDialog dialog = new EleFXDialog();

        EleFXButton cancel = new EleFXButton("Cancel");
        cancel.setOnAction(event -> {
            dialog.close();
        });
        EleFXButton confirm = new EleFXButton("Confirm", EleFXButtonType.PRIMARY);
        confirm.setOnAction(event -> {
            dialog.close();
        });
        HBox footer = new HBox(cancel, confirm);
        footer.setSpacing(8);

        dialog.setTitle("Tips");
        dialog.setBody(new Label("This is a message"));
        dialog.setWidth(600);
        dialog.setFooter(footer);
        dialog.setBeforeClose(Runnable::run);
        dialog.setTransition(EleFXDialog.Transition.BOUNCE);
        dialog.setTransitionDuration(500);

        EleFXButton btn = new EleFXButton("Click to open the Dialog");
        btn.setOnAction(event -> {
            dialog.show(btn.getScene().getWindow());
        });

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(btn);
        return hBox;
    }

    private static HBox customizedContentTest() {
        // dialog1


        EleFXDialog dialog1 = new EleFXDialog();
        dialog1.setTitle("Shipping address");
        dialog1.setBody(new Label("This is a message"));
        dialog1.setWidth(600);

        // dialog2
        EleFXDialog dialog2 = new EleFXDialog();

        EleFXButton cancel = new EleFXButton("Cancel");
        cancel.setOnAction(event -> {
            dialog2.close();
        });
        EleFXButton confirm = new EleFXButton("Confirm", EleFXButtonType.PRIMARY);
        confirm.setOnAction(event -> {
            dialog2.close();
        });
        HBox footer = new HBox(cancel, confirm);
        footer.setSpacing(8);

        dialog2.setTitle("Tips");
        dialog2.setBody(new Label("This is a message"));
        dialog2.setWidth(600);
        dialog2.setFooter(footer);

        EleFXButton btn1 = new EleFXButton("Open a Table nested Dialog");
        btn1.setOnAction(event -> {
            dialog2.show(btn1.getScene().getWindow());
        });

        EleFXButton btn2 = new EleFXButton("Open a Form nested Dialog");
        btn2.setOnAction(event -> {
            dialog2.show(btn2.getScene().getWindow());
        });

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(btn1, btn2);
        return hBox;
    }

    private static VBox customizedHeaderTest() {
        EleFXDialog dialog = new EleFXDialog();

        Label headerLabel = new Label("This is a custom header!");
        EleFXButton headerBtn = new EleFXButton("Close", EleFXIcons.of(EleFXIconType.CIRCLE_CLOSE_FILLED), EleFXButtonType.DANGER);
        headerBtn.setOnAction(event -> {
            dialog.requestClose();
        });
        Region gap = new Region();

        HBox header = new HBox();
        HBox.setHgrow(gap, Priority.ALWAYS);
        header.setAlignment(Pos.CENTER);
        header.getChildren().addAll(headerLabel, gap, headerBtn);

        dialog.setShowClose(false);
        dialog.setHeader(header);
        dialog.setBody(new Label("This is dialog content."));

        EleFXButton dialogShowBtn = new EleFXButton("Open Dialog with customized header");
        dialogShowBtn.setOnAction(event -> {
            dialog.show(dialogShowBtn.getScene().getWindow());
        });

        return new VBox(dialogShowBtn);
    }

    private static VBox nestedDialogTest() {
        EleFXDialog outer = new EleFXDialog();
        outer.setTitle("Outer Dialog");
        outer.setWidth(800);
        outer.setBody(new Label("This is the outer Dialog"));

        EleFXDialog inner = new EleFXDialog();
        inner.setTitle("Inner Dialog");
        inner.setWidth(500);
        inner.setBody(new Label("This is the inner Dialog"));

        EleFXButton cancel = new EleFXButton("Cancel");
        cancel.setOnAction(e -> outer.requestClose());

        EleFXButton openInner =
                new EleFXButton("Open the inner Dialog", EleFXButtonType.PRIMARY);
        openInner.setOnAction(e ->
                inner.show(openInner.getScene().getWindow())
        );

        outer.setFooter(new HBox(12, cancel, openInner));

        EleFXButton openOuter = new EleFXButton("Open the outer Dialog");
        openOuter.setType(EleFXButtonType.DEFAULT);
        openOuter.setOnAction(e ->
                outer.show(openOuter.getScene().getWindow())
        );

        return new VBox(openOuter);
    }

    private static VBox centeredContentTest() {
        EleFXDialog dialog = new EleFXDialog();
        dialog.setTitle("Warning");
        dialog.setWidth(500);
        dialog.setCenter(true); // 标题和底部区域居中

        dialog.setBody(new Label(
                "It should be noted that the content will not be aligned in center by default"
        ));

        EleFXButton cancel = new EleFXButton("Cancel");
        EleFXButton confirm = new EleFXButton("Confirm", EleFXButtonType.PRIMARY);

        cancel.setOnAction(e -> dialog.close());
        confirm.setOnAction(e -> dialog.close());

        dialog.setFooter(new HBox(12, cancel, confirm));

        EleFXButton openButton = new EleFXButton("Click to open the Dialog");
        openButton.setType(EleFXButtonType.DEFAULT);
        openButton.setOnAction(e ->
                dialog.show(openButton.getScene().getWindow())
        );

        return new VBox(openButton);
    }

    private static VBox alignCenterDialogTest() {
        EleFXDialog dialog = new EleFXDialog();
        dialog.setTitle("Warning");
        dialog.setWidth(500);
        dialog.setAlignCenter(true);
        dialog.setBody(new Label("Open the dialog from the center of the screen"));

        EleFXButton cancel = new EleFXButton("Cancel");
        EleFXButton confirm = new EleFXButton("Confirm", EleFXButtonType.PRIMARY);
        cancel.setOnAction(e -> dialog.close());
        confirm.setOnAction(e -> dialog.close());
        dialog.setFooter(new HBox(12, cancel, confirm));

        EleFXButton openButton = new EleFXButton("Click to open the Dialog");
        openButton.setType(EleFXButtonType.DEFAULT);
        openButton.setOnAction(e ->
                dialog.show(openButton.getScene().getWindow())
        );

        return new VBox(openButton);
    }

    private static VBox draggableDialogTest() {
        EleFXDialog normal = createDialog(
                "Tips", "It's a draggable Dialog");
        normal.setDraggable(true);

        EleFXDialog overflow = createDialog(
                "Tips", "It's an overflow draggable Dialog");
        overflow.setDraggable(true);
        overflow.setOverflow(true);

        EleFXDialog custom = createDialog(
                "Custom Dragging Style",
                "Try dragging the title bar to see the effect!");
        custom.setDraggable(true);
        installDraggingStyle(custom);

        EleFXButton openNormal =
                openButton("Open a draggable Dialog", normal);
        EleFXButton openOverflow =
                openButton("Open an overflow draggable Dialog", overflow);
        EleFXButton openCustom =
                openButton("Open a custom dragging style Dialog", custom);

        return new VBox(10, openNormal, openOverflow, openCustom);
    }

    private static VBox fullScreenTest() {
        EleFXDialog dialog = new EleFXDialog();
        dialog.setFullscreen(true);
        dialog.setBody(new Label("It's a fullscreen Dialog"));

        EleFXButton cancel = new EleFXButton("Cancel");
        EleFXButton confirm =
                new EleFXButton("Confirm", EleFXButtonType.PRIMARY);

        cancel.setOnAction(e -> dialog.close());
        confirm.setOnAction(e -> dialog.close());
        dialog.setFooter(new HBox(12, cancel, confirm));

        EleFXButton openButton =
                new EleFXButton("Open the fullscreen Dialog");
        openButton.setType(EleFXButtonType.DEFAULT);
        openButton.setOnAction(e ->
                dialog.show(openButton.getScene().getWindow())
        );

        return new VBox(openButton);
    }

    private static VBox modalTest() {
        EleFXDialog dialog = new EleFXDialog();
        dialog.setTitle("Non-modal Dialog");
        dialog.setWidth(360);
        dialog.setModal(false);
        dialog.setModalPenetrable(true);
        dialog.setBody(new Label("弹窗外的按钮仍然可以点击。"));
        dialog.setTransition(EleFXDialog.Transition.OBJECT_CONFIG);
        dialog.setTransitionDuration(500);

        EleFXButton closeButton = new EleFXButton("Close");
        closeButton.setOnAction(e -> dialog.close());
        dialog.setFooter(new HBox(closeButton));

        EleFXButton openButton = new EleFXButton("打开弹窗");
        openButton.setOnAction(e -> dialog.show(openButton.getScene().getWindow()));

        AtomicInteger clicks = new AtomicInteger();
        Label counter = new Label("背景点击次数：0");
        EleFXButton backgroundButton = new EleFXButton("背景按钮");
        backgroundButton.setOnAction(e ->
                counter.setText("背景点击次数：" + clicks.incrementAndGet())
        );

        return new VBox(16, openButton, backgroundButton, counter);
    }

    private static EleFXDialog createDialog(String title, String message) {
        EleFXDialog dialog = new EleFXDialog();
        dialog.setTitle(title);
        dialog.setWidth(500);
        dialog.setBody(new Label(message));

        EleFXButton cancel = new EleFXButton("Cancel");
        EleFXButton confirm =
                new EleFXButton("Confirm", EleFXButtonType.PRIMARY);

        cancel.setOnAction(e -> dialog.close());
        confirm.setOnAction(e -> dialog.close());

        dialog.setFooter(new HBox(12, cancel, confirm));
        return dialog;
    }

    private static EleFXButton openButton(
            String text, EleFXDialog dialog) {
        EleFXButton button = new EleFXButton(text);
        button.setType(EleFXButtonType.DEFAULT);
        button.setOnAction(e ->
                dialog.show(button.getScene().getWindow()));
        return button;
    }

    private static void installDraggingStyle(EleFXDialog dialog) {
        dialog.setDraggingStyle("""
                -fx-border-color: #409eff;
                -fx-border-style: dashed;
                -fx-border-width: 2px;
                -fx-border-radius: 4px;
                -fx-opacity: 0.65;
                """);
    }

    private EleFXDialogFiller() {
    }
}
