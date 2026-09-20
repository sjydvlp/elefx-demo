package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.infinitescroll.EleFXInfiniteScroll;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * EleFXInfiniteScrollFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXInfiniteScrollFiller {

    public static void fill(VBox vBox) {
        VBox infiniteScrollVbox = new VBox(new Label("a"), new Label("b"), new Label("c"), new Label("d"), new Label("e"));
        VBox infiniteScrollVbox2 = new VBox(new Label("a"), new Label("b"), new Label("c"), new Label("d"), new Label("e"), new Label("f"), new Label("g"), new Label("h"), new Label("i"));

        EleFXInfiniteScroll infiniteScroll = new EleFXInfiniteScroll(infiniteScrollVbox);
        infiniteScroll.setPrefHeight(50);
        infiniteScroll.setOnLoad(() -> infiniteScroll.setContent(infiniteScrollVbox2));

        vBox.getChildren().addAll(infiniteScroll);
    }

    private EleFXInfiniteScrollFiller() {}
}
