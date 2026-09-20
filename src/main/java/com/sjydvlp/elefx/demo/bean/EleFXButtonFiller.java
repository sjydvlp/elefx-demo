package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXButtonFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXButtonFiller {

    public static void fill(VBox vBox) {
        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(20));
        hBox1.setSpacing(10);
        EleFXButton hBox1DefaultButton = new EleFXButton("Default", EleFXButtonType.DEFAULT, EleFXButtonSize.SMALL);
        hBox1DefaultButton.setLoading(true);
        hBox1.getChildren().addAll(
                hBox1DefaultButton,
                new EleFXButton("Primary", EleFXButtonType.PRIMARY, EleFXButtonSize.SMALL),
                new EleFXButton("Success", EleFXButtonType.SUCCESS, EleFXButtonSize.SMALL),
                new EleFXButton("Info", EleFXButtonType.INFO, EleFXButtonSize.SMALL),
                new EleFXButton("Warning", EleFXButtonType.WARNING, EleFXButtonSize.SMALL),
                new EleFXButton("Danger", EleFXButtonType.DANGER, EleFXButtonSize.SMALL));

        double iconSize = 18.0;

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(20));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(
                new EleFXButton(EleFXIcons.of(EleFXIconType.PLUS, iconSize), EleFXButtonType.DEFAULT, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.MINUS, iconSize), EleFXButtonType.PRIMARY, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CIRCLE_PLUS, iconSize), EleFXButtonType.SUCCESS, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.SEARCH, iconSize), EleFXButtonType.INFO, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CHAT_LINE_SQUARE, iconSize), EleFXButtonType.WARNING, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CIRCLE_CLOSE, iconSize), EleFXButtonType.DANGER, true));

        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(20));
        hBox3.setSpacing(10);
        EleFXIcon hBox3PlusIcon = EleFXIcons.of(EleFXIconType.PLUS, iconSize);
        hBox3PlusIcon.setLoading(true);
        hBox3.getChildren().addAll(
                hBox3PlusIcon,
                EleFXIcons.of(EleFXIconType.MINUS, iconSize),
                EleFXIcons.of(EleFXIconType.CIRCLE_PLUS, iconSize),
                EleFXIcons.of(EleFXIconType.SEARCH, iconSize),
                EleFXIcons.of(EleFXIconType.CHAT_LINE_SQUARE, iconSize),
                EleFXIcons.of(EleFXIconType.CIRCLE_CLOSE, iconSize));

        vBox.getChildren().addAll(hBox1, hBox2, hBox3);
    }

    private EleFXButtonFiller() {}
}
