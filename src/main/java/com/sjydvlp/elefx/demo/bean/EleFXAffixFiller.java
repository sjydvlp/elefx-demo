package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.affix.EleFXAffix;
import com.sjydvlp.elefx.component.affix.EleFXAffixPosition;
import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * EleFXAffixFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXAffixFiller {

    public static void fill(VBox vBox) {
        VBox affixVbox = new VBox();

        for (int i = 0; i < 100; i++) {
            affixVbox.getChildren().add(new Label("label_" + i));

            if (i == 50) {
                VBox vbox = new VBox();
                vbox.setPrefHeight(400);

                EleFXAffix affix = new EleFXAffix(new EleFXButton("Offset top 120px", EleFXButtonType.PRIMARY));
                affix.setPosition(EleFXAffixPosition.TOP);
                affix.setOffset(120);
                affix.setTarget(vbox);
                vbox.getChildren().add(affix);

                affixVbox.getChildren().add(vbox);

                EleFXAffix affix2 = new EleFXAffix(new EleFXButton("Offset bottom 120px", EleFXButtonType.DANGER));
                affix2.setPosition(EleFXAffixPosition.BOTTOM);
                affix2.setOffset(120);

                affixVbox.getChildren().add(affix2);
            }
        }

        EleFXScrollbar affixScrollbar = new EleFXScrollbar(affixVbox);

        vBox.getChildren().addAll(affixScrollbar);
    }

    private EleFXAffixFiller() {}
}
