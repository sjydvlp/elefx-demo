package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.datepicker.EleFXDatePicker;
import com.sjydvlp.elefx.component.datepicker.EleFXDatePickerType;
import com.sjydvlp.elefx.component.space.EleFXSpace;
import javafx.geometry.Orientation;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * EleFXDatePickerFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXDatePickerFiller {

    public static void fill(VBox vBox) {
        EleFXDatePicker datePicker = new EleFXDatePicker();
        datePicker.setType(EleFXDatePickerType.DATE);
        datePicker.setShowConfirm(false);
//        datePicker.setSinglePanel(true);

        AtomicInteger datePickerIndex = new AtomicInteger();
        EleFXButton datePickerPreButton = new EleFXButton("切换成前一个");
        datePickerPreButton.setOnMouseClicked(event -> {
            if (datePickerIndex.get() <= 0) {
                datePicker.setType(EleFXDatePickerType.values()[0]);
            } else {
                datePicker.setType(EleFXDatePickerType.values()[datePickerIndex.decrementAndGet()]);
            }
        });
        EleFXButton datePickerNextButton = new EleFXButton("切换成后一个");
        datePickerNextButton.setOnMouseClicked(event -> {
            if (datePickerIndex.get() >= 14) {
                datePicker.setType(EleFXDatePickerType.values()[14]);
            } else {
                datePicker.setType(EleFXDatePickerType.values()[datePickerIndex.incrementAndGet()]);
            }
        });
        EleFXSpace datePickerButtonSpace = new EleFXSpace(datePickerPreButton, datePickerNextButton);
        datePickerButtonSpace.setSpacing(80);

        EleFXSpace datePickerPanelContainer = new EleFXSpace(datePickerButtonSpace, datePicker);
        datePickerPanelContainer.setDirection(Orientation.VERTICAL);

        vBox.getChildren().addAll(datePickerPanelContainer);
    }

    private EleFXDatePickerFiller() {}
}
