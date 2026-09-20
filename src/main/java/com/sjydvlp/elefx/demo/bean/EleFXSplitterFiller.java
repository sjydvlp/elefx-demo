package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.splitter.EleFXSplitter;
import com.sjydvlp.elefx.component.splitter.EleFXSplitterPanel;
import javafx.scene.layout.VBox;

/**
 * EleFXSplitterFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXSplitterFiller {

    public static void fill(VBox vBox) {
        EleFXSplitter eleFXSplitter = new EleFXSplitter(
                new EleFXSplitterPanel(new EleFXButton("a", EleFXButtonType.INFO, EleFXButtonSize.SMALL)),
                new EleFXSplitterPanel(new EleFXButton("b", EleFXButtonType.DANGER, EleFXButtonSize.SMALL))
        );

        vBox.getChildren().addAll(eleFXSplitter);
    }

    private EleFXSplitterFiller() {}
}
