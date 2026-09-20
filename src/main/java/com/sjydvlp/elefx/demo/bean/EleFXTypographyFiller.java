package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.space.EleFXSpace;
import com.sjydvlp.elefx.component.typography.EleFXTypography;
import com.sjydvlp.elefx.component.typography.EleFXTypographySize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXTypographyFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTypographyFiller {

    public static void fill(VBox vBox) {
        EleFXTypography eleFXTypography1 = new EleFXTypography("你好，世界", EleFXTypographySize.EXTRA_LARGE);
        EleFXTypography eleFXTypography2 = new EleFXTypography("你好，世界", EleFXTypographySize.BASE);
        EleFXSpace typographySpace = new EleFXSpace(eleFXTypography1, eleFXTypography2);
        typographySpace.setSpacing(100);
        HBox typographyHbox = new HBox(typographySpace);

        vBox.getChildren().addAll(typographyHbox);
    }

    private EleFXTypographyFiller() {}
}
