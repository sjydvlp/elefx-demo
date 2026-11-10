package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.divider.EleFXDivider;
import com.sjydvlp.elefx.component.divider.EleFXDividerBorderStyle;
import com.sjydvlp.elefx.component.divider.EleFXDividerContentPosition;
import com.sjydvlp.elefx.component.divider.EleFXDividerDirection;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXDividerFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXDividerFiller {

    public static void fill(VBox vBox) {
        VBox basicUsageTest = basicUsageTest();
        VBox customContentTest = customContentTest();
        VBox dashedLineTest = dashedLineTest();
        HBox verticalDividerTest = verticalDividerTest();

//        vBox.getChildren().add(basicUsageTest);
//        vBox.getChildren().add(customContentTest);
        vBox.getChildren().add(dashedLineTest);
        vBox.getChildren().add(verticalDividerTest);
        vBox.setSpacing(10);
    }

    private static VBox basicUsageTest() {
        Label firstText = new Label(
                "I sit at my window this morning where the world like a passer-by " +
                        "stops for a moment, nods to me and goes."
        );
        firstText.setWrapText(true);

        // 对应 <el-divider />：默认水平、实线、不带文字
        EleFXDivider divider = new EleFXDivider();

        Label secondText = new Label(
                "There little thoughts are the rustle of leaves; they have their " +
                        "whisper of joy in my mind."
        );
        secondText.setWrapText(true);

        return new VBox(0, firstText, divider, secondText);
    }

    private static VBox customContentTest() {
        Label firstText = new Label(
                "What you are you do not see, what you see is your shadow."
        );
        firstText.setWrapText(true);

        EleFXDivider leftDivider = new EleFXDivider("Rabindranath Tagore");
        leftDivider.setContentPosition(EleFXDividerContentPosition.LEFT);

        Label secondText = new Label(
                "My wishes are fools, they shout across thy song, my Master. " +
                        "Let me but listen."
        );
        secondText.setWrapText(true);

        EleFXDivider iconDivider = new EleFXDivider(
                new EleFXIcon(EleFXIconType.STAR_FILLED, 14)
        );

        Label thirdText = new Label(
                "I cannot choose the best. The best chooses me."
        );
        thirdText.setWrapText(true);

        EleFXDivider rightDivider = new EleFXDivider("Rabindranath Tagore");
        rightDivider.setContentPosition(EleFXDividerContentPosition.RIGHT);

        for (Label label : new Label[]{firstText, secondText, thirdText}) {
            label.setStyle(
                    "-fx-font-size: 14px;" +
                            "-fx-text-fill: -elefx-ct-regular;"
            );
        }

        VBox root = new VBox(
                0,
                firstText,
                leftDivider,
                secondText,
                iconDivider,
                thirdText,
                rightDivider
        );
        root.setPadding(new Insets(24));

        return root;
    }

    private static VBox dashedLineTest() {
        Label firstText = new Label("What language is thine, O sea?");

        EleFXDivider dashedDivider = new EleFXDivider();
        dashedDivider.setBorderStyle(EleFXDividerBorderStyle.DASHED);

        Label secondText = new Label("The language of eternal question.");

        EleFXDivider dottedDivider = new EleFXDivider();
        dottedDivider.setBorderStyle(EleFXDividerBorderStyle.DOTTED);

        Label thirdText = new Label("What language is thy answer, O sky?");

        EleFXDivider doubleDivider = new EleFXDivider();
        doubleDivider.setBorderStyle(EleFXDividerBorderStyle.DOUBLE);

        Label fourthText = new Label("The language of eternal silence.");

        for (Label label : new Label[]{ firstText, secondText, thirdText, fourthText }) {
            label.setWrapText(true);
            label.setStyle(
                    "-fx-font-size: 14px;" +
                            "-fx-text-fill: -elefx-ct-regular;"
            );
        }

        VBox root = new VBox(
                0,
                firstText,
                dashedDivider,
                secondText,
                dottedDivider,
                thirdText,
                doubleDivider,
                fourthText
        );
        root.setPadding(new Insets(24));

        return root;
    }

    private static HBox verticalDividerTest() {
        Label rain = new Label("Rain");
        Label home = new Label("Home");
        Label grass = new Label("Grass");

        for (Label label : new Label[]{rain, home, grass}) {
            label.setStyle(
                    "-fx-font-size: 14px;" +
                            "-fx-text-fill: -elefx-ct-regular;"
            );
        }

        EleFXDivider solidDivider = new EleFXDivider();
        solidDivider.setDirection(EleFXDividerDirection.VERTICAL);

        EleFXDivider dashedDivider = new EleFXDivider();
        dashedDivider.setDirection(EleFXDividerDirection.VERTICAL);
        dashedDivider.setBorderStyle(EleFXDividerBorderStyle.DASHED);

        HBox root = new HBox(
                0, rain, solidDivider, home, dashedDivider, grass
        );
        root.setPadding(new Insets(24));
        root.setAlignment(Pos.CENTER_LEFT);

        return root;
    }

    private EleFXDividerFiller() {
    }
}
