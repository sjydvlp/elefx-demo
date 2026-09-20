package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.collapse.EleFXCollapse;
import com.sjydvlp.elefx.component.collapse.EleFXCollapseItem;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * EleFXCollapseFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXCollapseFiller {

    public static void fill(VBox vBox) {
        EleFXCollapseItem collapseItem11 = new EleFXCollapseItem("hello", new EleFXIcon(EleFXIconType.ADD_LOCATION));
        collapseItem11.setTitleNode(new EleFXIcon(EleFXIconType.BURGER));
        collapseItem11.setExpandIcon(new EleFXIcon(EleFXIconType.FOOTBALL));
        collapseItem11.setCollapseIcon(new EleFXIcon(EleFXIconType.NOTEBOOK));
        EleFXCollapseItem collapseItem12 = new EleFXCollapseItem("hi", new EleFXIcon(EleFXIconType.BASEBALL));
        EleFXCollapseItem collapseItem13 = new EleFXCollapseItem("good", new EleFXIcon(EleFXIconType.CHAT_LINE_SQUARE));
        EleFXCollapse collapse1 = new EleFXCollapse(collapseItem11, collapseItem12, collapseItem13);
//        collapse1.setAccordion(true);
        collapse1.setAnimationDuration(Duration.millis(300));
//        collapse1.setExpandIconPosition(EleFXCollapseIconPosition.LEFT);
        collapse1.setBeforeCollapse(param -> true);
        collapse1.setExpandIconFactory(() -> new EleFXIcon(EleFXIconType.CIRCLE_CHECK));
        collapse1.setCollapseIconFactory(() -> new EleFXIcon(EleFXIconType.DOCUMENT_ADD));

        vBox.getChildren().addAll(collapse1);
    }

    private EleFXCollapseFiller() {}
}
