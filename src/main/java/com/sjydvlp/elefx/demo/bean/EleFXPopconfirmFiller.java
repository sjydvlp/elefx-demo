package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.popconfirm.EleFXPopconfirm;
import com.sjydvlp.elefx.component.popconfirm.EleFXPopconfirmPlacement;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * EleFXPopconfirmFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXPopconfirmFiller {

    public static void fill(VBox vBox) {
        VBox placementTest = placementTest();
        HBox basicUsageTest = basicUsageTest();
        HBox customizeTest = customizeTest();

        vBox.getChildren().add(placementTest);
        vBox.getChildren().add(basicUsageTest);
        vBox.getChildren().add(customizeTest);
        vBox.setSpacing(10);
    }

    private static VBox placementTest() {
        VBox root = new VBox(8);
        root.setPadding(new Insets(10));

        String[][] labels = {
                {"top-start", "top", "top-end"},
                {"left-start", "right-start"},
                {"left", "right"},
                {"left-end", "right-end"},
                {"bottom-start", "bottom", "bottom-end"}
        };

        String[][] titles = {
                {
                        "Top Left prompts info",
                        "Top Center prompts info",
                        "Top Right prompts info"
                },
                {"Left Top prompts info", "Right Top prompts info"},
                {"Left Center prompts info", "Right Center prompts info"},
                {"Left Bottom prompts info", "Right Bottom prompts info"},
                {
                        "Bottom Left prompts info",
                        "Bottom Center prompts info",
                        "Bottom Right prompts info"
                }
        };

        EleFXPopconfirmPlacement[][] placements = {
                {
                        EleFXPopconfirmPlacement.TOP_START,
                        EleFXPopconfirmPlacement.TOP,
                        EleFXPopconfirmPlacement.TOP_END
                },
                {
                        EleFXPopconfirmPlacement.LEFT_START,
                        EleFXPopconfirmPlacement.RIGHT_START
                },
                {
                        EleFXPopconfirmPlacement.LEFT,
                        EleFXPopconfirmPlacement.RIGHT
                },
                {
                        EleFXPopconfirmPlacement.LEFT_END,
                        EleFXPopconfirmPlacement.RIGHT_END
                },
                {
                        EleFXPopconfirmPlacement.BOTTOM_START,
                        EleFXPopconfirmPlacement.BOTTOM,
                        EleFXPopconfirmPlacement.BOTTOM_END
                }
        };

        for (int rowIndex = 0; rowIndex < labels.length; rowIndex++) {
            boolean centered = rowIndex == 0 || rowIndex == 4;

            HBox row = new HBox();
            row.setAlignment(centered ? Pos.CENTER : Pos.CENTER_LEFT);

            if (rowIndex == 2) {
                row.setPadding(new Insets(12, 0, 12, 0));
            }

            for (int column = 0; column < labels[rowIndex].length; column++) {
                if (!centered && column == 1) {
                    Region spacer = new Region();
                    HBox.setHgrow(spacer, Priority.ALWAYS);
                    row.getChildren().add(spacer);
                }

                EleFXButton button = new EleFXButton(labels[rowIndex][column]);

                EleFXPopconfirm popconfirm = new EleFXPopconfirm(
                        button, titles[rowIndex][column]);
                popconfirm.setPlacement(placements[rowIndex][column]);

                row.getChildren().add(button);
            }

            root.getChildren().add(row);
        }

        return root;
    }

    private static HBox basicUsageTest() {
        EleFXButton button = new EleFXButton("Delete");

        new EleFXPopconfirm(button, "Are you sure to delete this?");

        HBox root = new HBox(8);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(button);

        return root;
    }

    private static HBox customizeTest() {
        EleFXButton button = new EleFXButton("Delete");

        EleFXPopconfirm popconfirm = new EleFXPopconfirm(
                button, "Are you sure to delete this?");
        popconfirm.setWidth(220);
        popconfirm.setIcon(new EleFXIcon(EleFXIconType.INFO_FILLED, 14));
        popconfirm.setIconColor(Color.web("#626AEF"));

        BooleanProperty clicked = new SimpleBooleanProperty(false);

        EleFXButton cancel = new EleFXButton(
                "No!", EleFXButtonType.DEFAULT, EleFXButtonSize.SMALL);
        cancel.setOnAction(event -> popconfirm.cancel());

        EleFXButton confirm = new EleFXButton(
                "Yes?", EleFXButtonType.DANGER, EleFXButtonSize.SMALL);
        confirm.disableProperty().bind(clicked.not());
        confirm.setOnAction(event -> popconfirm.confirm());

        HBox actions = new HBox(8, cancel, confirm);
        actions.setAlignment(Pos.CENTER_RIGHT);
        popconfirm.setActions(actions);

        popconfirm.setOnCancel(event -> clicked.set(true));

        HBox root = new HBox(8);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(button);

        return root;
    }

    private EleFXPopconfirmFiller() {
    }
}
