package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.tooltip.EleFXTooltip;
import com.sjydvlp.elefx.component.tooltip.EleFXTooltipEffect;
import com.sjydvlp.elefx.component.tooltip.EleFXTooltipPlacement;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * EleFXTooltipFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTooltipFiller {

    public static void fill(VBox vBox) {
        VBox basicUsageTest = basicUsageTest();
        HBox themeTest = themeTest();
        HBox moreContentTest = moreContentTest();
        HBox advancedUsageTest = advancedUsageTest();
        HBox controlledTest = controlledTest();
        HBox animationsTest = animationsTest();

        vBox.getChildren().add(basicUsageTest);
        vBox.getChildren().add(themeTest);
        vBox.getChildren().add(moreContentTest);
        vBox.getChildren().add(advancedUsageTest);
        vBox.getChildren().add(controlledTest);
        vBox.getChildren().add(animationsTest);
        vBox.setSpacing(10);
    }

    private static VBox basicUsageTest() {
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
                {"Left Top\nprompts info", "Right Top\nprompts info"},
                {"Left Center\nprompts info", "Right Center\nprompts info"},
                {"Left Bottom\nprompts info", "Right Bottom\nprompts info"},
                {"Bottom Left prompts info", "Bottom Center prompts info", "Bottom Right prompts info"}
        };

        EleFXTooltipPlacement[][] placements = {
                {
                        EleFXTooltipPlacement.TOP_START,
                        EleFXTooltipPlacement.TOP,
                        EleFXTooltipPlacement.TOP_END
                },
                {
                        EleFXTooltipPlacement.LEFT_START,
                        EleFXTooltipPlacement.RIGHT_START
                },
                {
                        EleFXTooltipPlacement.LEFT,
                        EleFXTooltipPlacement.RIGHT
                },
                {
                        EleFXTooltipPlacement.LEFT_END,
                        EleFXTooltipPlacement.RIGHT_END
                },
                {
                        EleFXTooltipPlacement.BOTTOM_START,
                        EleFXTooltipPlacement.BOTTOM,
                        EleFXTooltipPlacement.BOTTOM_END
                }
        };

        for (int i = 0; i < labels.length; i++) {
            boolean center = i == 0 || i == labels.length - 1;

            HBox row = new HBox(center ? 12 : 0);
            row.setAlignment(Pos.CENTER);

            for (int j = 0; j < labels[i].length; j++) {
                if (!center && j == 1) {
                    Region spacer = new Region();
                    HBox.setHgrow(spacer, Priority.ALWAYS);
                    row.getChildren().add(spacer);
                }

                EleFXButton button = new EleFXButton(labels[i][j]);

                // 对应 .box-item 的 margin-top: 10px
                HBox.setMargin(button, new Insets(10, 0, 0, 0));

                EleFXTooltip tooltip = new EleFXTooltip(button, contents[i][j]);
                tooltip.setEffect(EleFXTooltipEffect.DARK);
                tooltip.setPlacement(placements[i][j]);

                row.getChildren().add(button);
            }

            // 对应中间一行的 mt-3 / mb-3
            if (i == 2) {
                VBox.setMargin(row, new Insets(12, 0, 12, 0));
            }

            root.getChildren().add(row);
        }

        return root;
    }

    private static HBox themeTest() {
        EleFXButton darkButton = new EleFXButton("Dark");
        EleFXTooltip darkTooltip = new EleFXTooltip(darkButton, "Top center");
        darkTooltip.setPlacement(EleFXTooltipPlacement.TOP);
        darkTooltip.setEffect(EleFXTooltipEffect.DARK);

        EleFXButton lightButton = new EleFXButton("Light");
        EleFXTooltip lightTooltip = new EleFXTooltip(lightButton, "Bottom center");
        lightTooltip.setPlacement(EleFXTooltipPlacement.BOTTOM);
        lightTooltip.setEffect(EleFXTooltipEffect.LIGHT);

        EleFXButton customButton = new EleFXButton("Customized theme");

        EleFXTooltip customTooltip = new EleFXTooltip(customButton, "Bottom center");
        customTooltip.setPlacement(EleFXTooltipPlacement.BOTTOM);

        customTooltip.setPopperStyle("""
                -fx-padding: 6px 12px;
                -fx-background-color: linear-gradient(to right, #9fe597, #cce581);
                -fx-border-color: transparent;
                """);

        customTooltip.setArrowStyle("""
                -fx-background-color: linear-gradient(to top right, #b2e68d, #bce689);
                -fx-border-color: transparent;
                """);

        customTooltip.setContentStyle("""
                -fx-text-fill: #303133;
                -fx-padding: 0;
                -fx-min-height: 18px;
                """);

        HBox root = new HBox(darkButton, lightButton, customButton);
        root.setSpacing(10);

        return root;
    }

    private static HBox moreContentTest() {
        EleFXButton button = new EleFXButton("Top center");

        EleFXTooltip tooltip = new EleFXTooltip(button, "multiple lines\nsecond line");
        tooltip.setPlacement(EleFXTooltipPlacement.TOP);

        HBox root = new HBox(button);
        root.setSpacing(10);

        return root;
    }

    private static HBox advancedUsageTest() {
        BooleanProperty disabled = new SimpleBooleanProperty(false);

        EleFXButton button = new EleFXButton();
        button.textProperty().bind(
                Bindings.when(disabled)
                        .then("click to active tooltip function")
                        .otherwise("click to close tooltip function"));

        EleFXTooltip tooltip = new EleFXTooltip(
                button, "click to close tooltip function");
        tooltip.setPlacement(EleFXTooltipPlacement.BOTTOM);
        tooltip.setEffect(EleFXTooltipEffect.LIGHT);
        tooltip.disabledProperty().bind(disabled);

        button.setOnAction(event -> disabled.set(!disabled.get()));

        HBox root = new HBox(button);
        root.setSpacing(10);

        return root;
    }

    private static HBox controlledTest() {
        BooleanProperty visible = new SimpleBooleanProperty(false);

        EleFXButton button = new EleFXButton("Hover me");

        EleFXTooltip tooltip = new EleFXTooltip();
        tooltip.setReference(button);
        tooltip.setContentNode(new Label("Content"));
        tooltip.visibleProperty().bind(visible);

        button.setOnMouseEntered(event -> visible.set(true));
        button.setOnMouseExited(event -> visible.set(false));

        HBox root = new HBox(button);
        root.setSpacing(10);

        return root;
    }

    private static HBox animationsTest() {
        EleFXButton button = new EleFXButton("trigger me");
        EleFXTooltip tooltip = new EleFXTooltip(button, "I am an el-tooltip");
        tooltip.setTransition("slide-fade");

        HBox root = new HBox(button);
        root.setSpacing(10);
        return root;
    }

    private EleFXTooltipFiller() {
    }
}
