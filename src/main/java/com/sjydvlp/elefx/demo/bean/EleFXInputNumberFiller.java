package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.inputnumber.EleFXInputNumber;
import com.sjydvlp.elefx.component.inputnumber.EleFXInputNumberControlsPosition;
import com.sjydvlp.elefx.component.inputnumber.EleFXInputNumberSize;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXInputNumberFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXInputNumberFiller {

    public static void fill(VBox vBox) {
        EleFXInputNumber inputNumber1 = new EleFXInputNumber();
//        inputNumber1.setDisable(true);
        inputNumber1.setStep(0.01);
        inputNumber1.setStepStrictly(true);
        inputNumber1.setPrecision(2);

        EleFXInputNumber inputNumber2 = new EleFXInputNumber();
        inputNumber2.setStep(0.01);
        inputNumber2.setPrecision(2);
        inputNumber2.setSize(EleFXInputNumberSize.LARGE);
        inputNumber2.setControlsPosition(EleFXInputNumberControlsPosition.RIGHT);
        inputNumber2.setIncreaseIcon(new EleFXIcon(EleFXIconType.AIM));
        inputNumber2.setIncreaseIcon(new EleFXIcon(EleFXIconType.APPLE));
        inputNumber2.setPrefix(new EleFXIcon(EleFXIconType.AIM));
        inputNumber2.setSuffix(new Label("RMB"));
        inputNumber2.setFormatter(value ->
                ("$ " + value).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")
        );
        inputNumber2.setParser(value ->
                value.replaceAll("\\$\\s?|,+", "")
        );

        HBox inputNumberHbox = new HBox(inputNumber1, inputNumber2);
        inputNumberHbox.setPadding(new Insets(10));
        inputNumberHbox.setSpacing(5);

        vBox.getChildren().addAll(inputNumberHbox);
    }

    private EleFXInputNumberFiller() {}
}
