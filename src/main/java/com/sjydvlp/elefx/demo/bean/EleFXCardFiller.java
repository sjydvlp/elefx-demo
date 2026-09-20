package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.card.EleFXCard;
import com.sjydvlp.elefx.component.card.EleFXCardShadow;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * EleFXCardFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXCardFiller {

    public static void fill(VBox vBox) {
        EleFXCard card1 = new EleFXCard();
        card1.setHeaderText("Card name");
        card1.setFooterText("Footer content");
        card1.setShadow(EleFXCardShadow.HOVER);
        card1.getBodyChildren().addAll(
                new Label("List item 1"),
                new Label("List item 2")
        );
        card1.setMaxWidth(480);

        EleFXCard card2 = new EleFXCard();
        card2.setShadow(EleFXCardShadow.ALWAYS);
//        card2.getBodyChildren().addAll(
//                new Label("List item 1"),
//                new Label("List item 2")
//        );
        card2.getBodyChildren().addAll(new EleFXIcon(EleFXIconType.HANDBAG));
        card2.setMaxWidth(480);

        vBox.getChildren().addAll(card1, card2);
    }

    private EleFXCardFiller() {}
}
