package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.tag.EleFXTag;
import com.sjydvlp.elefx.component.tag.EleFXTagEffect;
import com.sjydvlp.elefx.component.tag.EleFXTagSize;
import com.sjydvlp.elefx.component.tag.EleFXTagType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXTagFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTagFiller {

    public static void fill(VBox vBox) {
        EleFXTag tag1 = new EleFXTag("Tag 1", EleFXTagType.PRIMARY);
        tag1.setSize(EleFXTagSize.LARGE);
        tag1.setTagEffect(EleFXTagEffect.DARK);
        tag1.setRound(true);
        EleFXTag tag2 = new EleFXTag("Tag 2", EleFXTagType.SUCCESS);
        EleFXTag tag3 = new EleFXTag("Tag 3", EleFXTagType.INFO);
        tag3.setSize(EleFXTagSize.SMALL);
        EleFXTag tag4 = new EleFXTag("Tag 4", EleFXTagType.WARNING);
        tag4.setTagEffect(EleFXTagEffect.PLAIN);
        EleFXTag tag5 = new EleFXTag("Tag 5", EleFXTagType.DANGER);
        tag5.setClosable(true);
        tag5.setTagEffect(EleFXTagEffect.LIGHT);
        HBox tagHbox = new HBox(tag1, tag2, tag3, tag4, tag5);
        tagHbox.setSpacing(8);
        tagHbox.setFillHeight(false);

        tag5.setOnClose(event -> {
            tagHbox.getChildren().remove(tag5);
        });

        vBox.getChildren().addAll(tagHbox);
    }

    private EleFXTagFiller() {}
}
