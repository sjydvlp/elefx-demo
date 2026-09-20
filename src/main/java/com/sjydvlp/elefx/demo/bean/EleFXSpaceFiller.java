package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.space.EleFXSpace;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * EleFXSpaceFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXSpaceFiller {

    public static void fill(VBox vBox) {
        EleFXSpace eleFXSpace = new EleFXSpace(
                new Text("a"), new Text("b"), new Text("c"), new Text("d"),
                new Text("e"), new Text("f"), new Text("g"), new Text("h")
        );
        eleFXSpace.setSpacing(100);

        vBox.getChildren().addAll(eleFXSpace);
    }

    private EleFXSpaceFiller() {}
}
