package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.colorpickerpanel.EleFXColorPickerPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * EleFXColorPickerPanelFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXColorPickerPanelFiller {

    public static void fill(VBox vBox) {
        EleFXColorPickerPanel colorPickerPanel = new EleFXColorPickerPanel(Color.web("#409EFF"));
        colorPickerPanel.setShowAlpha(true);
        colorPickerPanel.setBorder(Boolean.TRUE);
        VBox.setMargin(colorPickerPanel, new Insets(20));
        colorPickerPanel.getPredefinedColors().addAll(
                Color.web("#ff4500"),
                Color.web("#1e90ff"),
                Color.web("#c71585")
        );

        vBox.getChildren().addAll(colorPickerPanel);
    }

    private EleFXColorPickerPanelFiller() {}
}
