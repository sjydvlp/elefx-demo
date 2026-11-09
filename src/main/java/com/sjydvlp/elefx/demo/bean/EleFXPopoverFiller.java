package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.popover.EleFXPopover;
import com.sjydvlp.elefx.component.popover.EleFXPopoverPlacement;
import com.sjydvlp.elefx.component.popover.EleFXPopoverTrigger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * EleFXPopoverFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXPopoverFiller {

    public static void fill(VBox vBox) {
        VBox placementTest = placementTest();
        HBox basicUsageTest = basicUsageTest();
        HBox nestedOperationTest = nestedOperationTest();

        vBox.getChildren().add(placementTest);
        vBox.getChildren().add(basicUsageTest);
        vBox.getChildren().add(nestedOperationTest);
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

        String[][] contents = {
                {"Top Left prompts info", "Top Center prompts info", "Top Right prompts info"},
                {"Left Top prompts info", "Right Top prompts info"},
                {"Left Center prompts info", "Right Center prompts info"},
                {"Left Bottom prompts info", "Right Bottom prompts info"},
                {"Bottom Left prompts info", "Bottom Center prompts info", "Bottom Right prompts info"}
        };

        EleFXPopoverPlacement[][] placements = {
                {
                        EleFXPopoverPlacement.TOP_START,
                        EleFXPopoverPlacement.TOP,
                        EleFXPopoverPlacement.TOP_END
                },
                {
                        EleFXPopoverPlacement.LEFT_START,
                        EleFXPopoverPlacement.RIGHT_START
                },
                {
                        EleFXPopoverPlacement.LEFT,
                        EleFXPopoverPlacement.RIGHT
                },
                {
                        EleFXPopoverPlacement.LEFT_END,
                        EleFXPopoverPlacement.RIGHT_END
                },
                {
                        EleFXPopoverPlacement.BOTTOM_START,
                        EleFXPopoverPlacement.BOTTOM,
                        EleFXPopoverPlacement.BOTTOM_END
                }
        };

        for (int i = 0; i < labels.length; i++) {
            boolean center = i == 0 || i == labels.length - 1;

            HBox row = new HBox(center ? 12 : 0);
            row.setAlignment(Pos.CENTER);

            for (int j = 0; j < labels[i].length; j++) {
                // 左右两列之间使用弹性空间
                if (!center && j == 1) {
                    Region spacer = new Region();
                    HBox.setHgrow(spacer, Priority.ALWAYS);
                    row.getChildren().add(spacer);
                }

                EleFXButton button = new EleFXButton(labels[i][j]);

                EleFXPopover popover = new EleFXPopover(button, contents[i][j]);
                popover.setTitle("Title");
                popover.setPlacement(placements[i][j]);
                popover.setTrigger(EleFXPopoverTrigger.HOVER);

                row.getChildren().add(button);
            }

            if (i == 2) {
                VBox.setMargin(row, new Insets(12, 0, 12, 0));
            }

            root.getChildren().add(row);
        }

        return root;
    }

    private static HBox basicUsageTest() {
        HBox root = new HBox(8);
        root.setPadding(new Insets(10));

        String content = "this is content, this is content, this is content";

        String[] texts = {
                "Hover to activate",
                "Click to activate",
                "Focus to activate",
                "contextmenu to activate",
                "Manual to activate"
        };

        EleFXPopoverTrigger[] triggers = {
                EleFXPopoverTrigger.HOVER,
                EleFXPopoverTrigger.CLICK,
                EleFXPopoverTrigger.FOCUS,
                EleFXPopoverTrigger.CONTEXT_MENU
        };

        EleFXPopoverPlacement[] placements = {
                EleFXPopoverPlacement.TOP_START,
                EleFXPopoverPlacement.BOTTOM,
                EleFXPopoverPlacement.RIGHT,
                EleFXPopoverPlacement.BOTTOM,
                EleFXPopoverPlacement.BOTTOM
        };

        for (int i = 0; i < texts.length; i++) {
            EleFXButton button = new EleFXButton(texts[i]);

            EleFXPopover popover = new EleFXPopover(button, content);
            popover.setTitle("Title");
            popover.setWidth(200);
            popover.setPlacement(placements[i]);
            if (i < triggers.length) {
                popover.setTrigger(triggers[i]);
            } else {
                // 对应 :visible="visible"
                popover.setVisible(false);
                button.setOnAction(event -> popover.setVisible(!Boolean.TRUE.equals(popover.getVisible())));
            }

            root.getChildren().add(button);
        }

        return root;
    }

    private static HBox nestedOperationTest() {
        EleFXButton deleteButton = new EleFXButton("Delete");

        EleFXPopover popover = new EleFXPopover();
        popover.setReference(deleteButton);
        popover.setPlacement(EleFXPopoverPlacement.TOP);
        popover.setWidth(180);
        popover.setVisible(false);

        Label message = new Label("Are you sure to delete this?");
        message.setWrapText(true);

        EleFXButton cancelButton = new EleFXButton(
                "cancel", EleFXButtonType.DEFAULT, EleFXButtonSize.SMALL);
        cancelButton.setTextButton(true);

        EleFXButton confirmButton = new EleFXButton(
                "confirm", EleFXButtonType.PRIMARY, EleFXButtonSize.SMALL);

        HBox actions = new HBox(8, cancelButton, confirmButton);
        actions.setAlignment(Pos.CENTER_RIGHT);

        VBox content = new VBox(12, message, actions);
        popover.setContentNode(content);

        deleteButton.setOnAction(event -> popover.setVisible(true));
        cancelButton.setOnAction(event -> popover.setVisible(false));
        confirmButton.setOnAction(event -> popover.setVisible(false));

        HBox root = new HBox(deleteButton);
        root.setPadding(new Insets(8));

        return root;
    }

    private EleFXPopoverFiller() {
    }
}
