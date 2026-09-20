package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.colorpicker.EleFXColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * EleFXColorPickerFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXColorPickerFiller {

    public static void fill(VBox vBox) {
        EleFXColorPicker colorPicker = new EleFXColorPicker(Color.valueOf("#409EFF"));

        vBox.getChildren().addAll(colorPicker);
    }

    private EleFXColorPickerFiller() {}
}
