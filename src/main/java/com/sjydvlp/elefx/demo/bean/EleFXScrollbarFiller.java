package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * EleFXScrollbarFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXScrollbarFiller {

    public static void fill(VBox vBox) {
        VBox scrollbarVbox = new VBox();
        scrollbarVbox.getChildren().addAll(
                new Text("a"), new Text("b"), new Text("c"), new Text("d"),
                new Text("e"), new Text("f"), new Text("g"), new Text("h")
        );
        EleFXScrollbar scrollbar = new EleFXScrollbar(scrollbarVbox);
        scrollbar.setPrefHeight(100);
        scrollbar.setScrollTop(120);

        vBox.getChildren().addAll(scrollbar);
    }

    private EleFXScrollbarFiller() {}
}
