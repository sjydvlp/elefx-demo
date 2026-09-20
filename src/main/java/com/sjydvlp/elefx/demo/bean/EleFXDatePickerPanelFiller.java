package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.datepickerpanel.EleFXDatePickerPanel;
import com.sjydvlp.elefx.component.datepickerpanel.EleFXDatePickerPanelType;
import com.sjydvlp.elefx.component.space.EleFXSpace;
import javafx.geometry.Orientation;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * EleFXDatePickerPanelFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXDatePickerPanelFiller {

    public static void fill(VBox vBox) {
        EleFXDatePickerPanel datePickerPanel = new EleFXDatePickerPanel();
        datePickerPanel.setType(EleFXDatePickerPanelType.values()[0]);
//        datePickerPanel.setDisable(true);

        AtomicInteger dateIndex = new AtomicInteger();
        EleFXButton datePreButton = new EleFXButton("切换成前一个");
        datePreButton.setOnMouseClicked(event -> {
            System.out.println(dateIndex);
            if (dateIndex.get() <= 0) {
                datePickerPanel.setType(EleFXDatePickerPanelType.values()[0]);
            } else {
                datePickerPanel.setType(EleFXDatePickerPanelType.values()[dateIndex.decrementAndGet()]);
            }
        });
        EleFXButton dateNextButton = new EleFXButton("切换成后一个");
        dateNextButton.setOnMouseClicked(event -> {
            System.out.println(dateIndex);
            if (dateIndex.get() >= 14) {
                datePickerPanel.setType(EleFXDatePickerPanelType.values()[14]);
            } else {
                datePickerPanel.setType(EleFXDatePickerPanelType.values()[dateIndex.incrementAndGet()]);
            }
        });
        EleFXSpace dateButtonSpace = new EleFXSpace(datePreButton, dateNextButton);
        dateButtonSpace.setSpacing(80);

        EleFXSpace datePickerPanelContainer = new EleFXSpace(dateButtonSpace, datePickerPanel);
        datePickerPanelContainer.setDirection(Orientation.VERTICAL);

        vBox.getChildren().addAll(datePickerPanelContainer);
    }

    private EleFXDatePickerPanelFiller() {}
}
