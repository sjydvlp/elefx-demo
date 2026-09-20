package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.transfer.EleFXTransfer;
import com.sjydvlp.elefx.component.transfer.EleFXTransferItem;
import javafx.scene.layout.VBox;

/**
 * EleFXTransferFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTransferFiller {

    public static void fill(VBox vBox) {
        EleFXTransferItem<String> transferItem1 = new EleFXTransferItem<>("a", "t_a");
        EleFXTransferItem<String> transferItem2 = new EleFXTransferItem<>("b", "t_b");
        EleFXTransferItem<String> transferItem3 = new EleFXTransferItem<>("c", "t_c");
        EleFXTransfer<String> transfer = new EleFXTransfer<>(transferItem1, transferItem2, transferItem3);
        transfer.setFilterable(true);
        transfer.setToLeftIcon(new EleFXIcon(EleFXIconType.AIM));
        transfer.setToRightIcon(new EleFXIcon(EleFXIconType.CHECKED));

        vBox.getChildren().addAll(transfer);
    }

    private EleFXTransferFiller() {}
}
