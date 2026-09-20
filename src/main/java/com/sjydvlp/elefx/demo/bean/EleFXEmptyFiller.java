package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.empty.EleFXEmpty;
import javafx.scene.layout.VBox;

/**
 * EleFXEmptyFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXEmptyFiller {

    public static void fill(VBox vBox) {
        EleFXEmpty empty = new EleFXEmpty("description");
        empty.setImage("https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png");
        empty.setImageSize(100.0);
        empty.getBottomChildren().add(new EleFXButton("按钮"));

        vBox.getChildren().addAll(empty);
    }

    private EleFXEmptyFiller() {}
}
