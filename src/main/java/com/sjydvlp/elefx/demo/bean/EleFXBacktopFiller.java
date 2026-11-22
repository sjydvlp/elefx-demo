package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.backtop.EleFXBacktop;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * EleFXBacktopFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXBacktopFiller {

    public static void fill(VBox vBox) {
//        vBox.getChildren().add(basicUsageTest());
        vBox.getChildren().add(customizationsTest());
        vBox.setSpacing(10);
    }

    private static StackPane basicUsageTest() {
        VBox content = new VBox(12);
        content.setPadding(new Insets(20));
        content.getChildren().add(new Label("向下滚动，查看右下方的返回顶部按钮。"));

        for (int i = 1; i <= 50; i++) {
            content.getChildren().add(new Label("第 " + i + " 行"));
        }

        EleFXScrollbar scrollbar = new EleFXScrollbar(content);
        scrollbar.setFitToWidth(true);
        scrollbar.setPrefViewportHeight(400);

        EleFXBacktop backtop = new EleFXBacktop(scrollbar);
        backtop.setRight(100);
        backtop.setBottom(100);

        return new StackPane(scrollbar, backtop);
    }

    private static StackPane customizationsTest() {
        VBox content = new VBox(12);
        content.setPadding(new Insets(20));
        content.getChildren().add(new Label("向下滚动，查看右下方的 UP 按钮。"));

        for (int i = 1; i <= 50; i++) {
            content.getChildren().add(new Label("第 " + i + " 行"));
        }

        EleFXScrollbar scrollbar = new EleFXScrollbar(content);
        scrollbar.setFitToWidth(true);
        scrollbar.setPrefViewportHeight(400);

        Label up = new Label("UP");
        up.setPrefSize(40, 40);
        up.setAlignment(Pos.CENTER);
        up.setStyle("""
        -fx-background-color: -elefx-co-overlay-bg;
        -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.12), 12, 0, 0, 0);
        -fx-text-fill: #1989fa;
        """);

        EleFXBacktop backtop = new EleFXBacktop(scrollbar);
        backtop.setBottom(100);
        backtop.setContent(up);

        return new StackPane(scrollbar, backtop);
    }

    private EleFXBacktopFiller() {
    }
}
