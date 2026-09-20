package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.link.EleFXLink;
import com.sjydvlp.elefx.component.link.EleFXLinkType;
import com.sjydvlp.elefx.component.link.EleFXLinkUnderline;
import javafx.scene.layout.VBox;

/**
 * EleFXLinkFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXLinkFiller {

    public static void fill(VBox vBox) {
        EleFXLink link = new EleFXLink("Element Plus", EleFXLinkType.PRIMARY);
        link.setHref("https://element-plus.org");
        link.setUnderlineMode(EleFXLinkUnderline.ALWAYS);

        vBox.getChildren().addAll(link);
    }

    private EleFXLinkFiller() {}
}
