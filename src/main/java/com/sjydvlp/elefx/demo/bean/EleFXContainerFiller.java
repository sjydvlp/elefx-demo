package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.container.*;
import javafx.scene.layout.VBox;

/**
 * EleFXContainerFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXContainerFiller {

    public static void fill(VBox vBox) {
        EleFXHeader eleFXHeader = new EleFXHeader();
        eleFXHeader.setStyle("-fx-background-color: #777777;");
        EleFXFooter eleFXFooter = new EleFXFooter();
        eleFXFooter.setStyle("-fx-background-color: #aaaeee;");
        EleFXAside eleFXAside = new EleFXAside();
        eleFXAside.setPrefWidth(200);
//        eleFXAside.setPrefHeight(200);
        eleFXAside.setStyle("-fx-background-color: blue;");
        EleFXContainer inContainer = new EleFXContainer(eleFXAside, new EleFXMain());
        EleFXContainer container = new EleFXContainer(
                eleFXHeader,
                inContainer,
                eleFXFooter
        );

        vBox.getChildren().addAll(container);
    }

    private EleFXContainerFiller() {}
}
