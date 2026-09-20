package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.slider.EleFXSlider;
import com.sjydvlp.elefx.component.slider.EleFXSliderMark;
import com.sjydvlp.elefx.component.slider.EleFXSliderSize;
import com.sjydvlp.elefx.component.slider.EleFXSliderTooltipPlacement;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.Map;

/**
 * EleFXSliderFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXSliderFiller {

    public static void fill(VBox vBox) {
        EleFXSlider slider1 = new EleFXSlider();
        slider1.setPrefWidth(300);
        slider1.setShowTooltip(true);
        slider1.setFormatTooltip(value -> value.toString() + "%");

        EleFXSlider slider2 = new EleFXSlider();
        slider2.setStep(10);
//        slider2.setShowStops(true);
        slider2.setShowInput(true);
        slider2.setPrecision(0);
        slider2.setTooltipPlacement(EleFXSliderTooltipPlacement.BOTTOM);
        slider2.setRange(true);
//        slider2.setVertical(true);

        EleFXSlider slider3 = new EleFXSlider();
        slider3.setSize(EleFXSliderSize.LARGE);
        slider3.setShowInput(true);

        VBox sliderVbox = new VBox(slider1, slider2, slider3);
        sliderVbox.setPadding(new Insets(10));
        sliderVbox.setSpacing(20);

        EleFXSlider slider4 = new EleFXSlider();
        slider4.setVertical(true);
        slider4.setMarks(Map.of(0.0, new EleFXSliderMark("0.0cm"), 30.0, new EleFXSliderMark("30.0cm")));
//        slider4.setStep(EleFXSliderStep.MARK);
        slider4.setShowTooltip(false);

        vBox.getChildren().addAll(sliderVbox, slider4);
    }

    private EleFXSliderFiller() {}
}
