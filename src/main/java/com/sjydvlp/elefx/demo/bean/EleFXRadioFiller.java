package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.radio.EleFXRadio;
import com.sjydvlp.elefx.component.radio.EleFXRadioButton;
import com.sjydvlp.elefx.component.radio.EleFXRadioGroup;
import com.sjydvlp.elefx.component.radio.EleFXRadioSize;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXRadioFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXRadioFiller {

    public static void fill(VBox vBox) {
        EleFXRadio<String> radioA = new EleFXRadio<>("r_a", "a");
        EleFXRadio<String> radioB = new EleFXRadio<>("r_b", "b");
        EleFXRadioButton<String> radioC = new EleFXRadioButton<>("r_c", "c");
        EleFXRadioButton<String> radioD = new EleFXRadioButton<>("r_d", "d");
        radioD.setSize(EleFXRadioSize.SMALL);
        EleFXRadioGroup<String> radioGroup1 = new EleFXRadioGroup<>(radioA, radioB, radioC, radioD);

        EleFXRadio<String> radioAA = new EleFXRadio<>("r_aa", "aa");
        radioAA.setBorder(true);
        EleFXRadio<String> radioBB = new EleFXRadio<>("r_bb", "bb");
        radioBB.setBorder(true);
        EleFXRadio<String> radioCC = new EleFXRadio<>("r_cc", "cc");
        radioCC.setBorder(true);
        radioCC.setDisable(true);
        EleFXRadioGroup<String> radioGroup2 = new EleFXRadioGroup<>(radioAA, radioBB, radioCC);
//        radioGroup2.setDisable(true);
//        radioGroup2.setStyle("-fx-border-color: #ff0000;");

        HBox radioHbox = new HBox(radioGroup1, radioGroup2);
        radioHbox.setPadding(new Insets(10));
        radioHbox.setSpacing(5);

        vBox.getChildren().addAll(radioHbox);
    }

    private EleFXRadioFiller() {}
}
