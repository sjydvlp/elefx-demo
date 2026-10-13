package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.dialog.EleFXDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * EleFXAlertFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXDialogFiller {

    public static void fill(VBox vBox, Stage stage) {
        HBox basisUsageTest = basisUsageTest(stage);
        HBox customizedContentTest = customizedContentTest(stage);
        VBox closeBtnTest = closeBtnTest();
        VBox showIconTest = showIconTest();
        VBox centeredTextTest = centeredTextTest();
        VBox withDescTest = withDescTest();

        vBox.getChildren().add(basisUsageTest);
        vBox.getChildren().add(customizedContentTest);
//        vBox.getChildren().add(closeBtnTest);
//        vBox.getChildren().add(showIconTest);
//        vBox.getChildren().add(centeredTextTest);
//        vBox.getChildren().add(withDescTest);
        vBox.setSpacing(20);
    }

    private static HBox basisUsageTest(Stage stage) {
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

        EleFXButton btn = new EleFXButton("Click to open the Dialog");
        btn.setOnAction(event -> {
            dialog.show(stage);
        });

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(btn);
        return hBox;
    }

    private static HBox customizedContentTest(Stage stage) {
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
            dialog2.show(stage);
        });

        EleFXButton btn2 = new EleFXButton("Open a Form nested Dialog");
        btn2.setOnAction(event -> {
            dialog2.show(stage);
        });

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(btn1, btn2);
        return hBox;
    }

    private static VBox closeBtnTest() {
        return new VBox();
    }

    private static VBox showIconTest() {
        return new VBox();
    }

    private static VBox centeredTextTest() {
        return new VBox();
    }

    private static VBox withDescTest() {
        return new VBox();
    }

    private EleFXDialogFiller() {}
}
