package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.backtop.EleFXBacktop;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * EleFXBacktopFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXBacktopFiller {

    public static void fill(VBox vBox) {
        VBox labelVbox = new VBox();
        for (int i = 0; i < 100; i++) {
            labelVbox.getChildren().add(new Label("label_" + i));
        }

        EleFXScrollbar scrollPane = new EleFXScrollbar(labelVbox);
        EleFXBacktop backtop = new EleFXBacktop(scrollPane);

        vBox.getChildren().addAll(scrollPane, backtop);
    }

    private EleFXBacktopFiller() {}
}
