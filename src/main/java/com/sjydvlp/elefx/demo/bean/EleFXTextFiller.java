package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.text.EleFXText;
import com.sjydvlp.elefx.component.text.EleFXTextSize;
import com.sjydvlp.elefx.component.text.EleFXTextTag;
import com.sjydvlp.elefx.component.text.EleFXTextType;
import javafx.scene.layout.VBox;

/**
 * EleFXTextFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTextFiller {

    public static void fill(VBox vBox) {
        EleFXText text1 = new EleFXText("Important", EleFXTextType.WARNING);
        text1.setSize(EleFXTextSize.LARGE);
        text1.setTag(EleFXTextTag.BOLD);

        EleFXText text2 = new EleFXText("Important", EleFXTextType.WARNING);
        text2.setSize(EleFXTextSize.SMALL);
        text2.setTag(EleFXTextTag.ITALIC);

        vBox.getChildren().addAll(text1, text2);
    }

    private EleFXTextFiller() {}
}
