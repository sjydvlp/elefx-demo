package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.input.EleFXInput;
import com.sjydvlp.elefx.component.input.EleFXInputSize;
import com.sjydvlp.elefx.component.input.EleFXInputType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXInputFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXInputFiller {

    public static void fill(VBox vBox) {
        EleFXInput input1 = new EleFXInput();
        input1.setType(EleFXInputType.TEXTAREA);
        input1.setRows(2);
        input1.setAutoSize(true);
        input1.setAutoSizeMaxRows(5);
        input1.setMaxLength(100);
        input1.setShowWordLimit(true);

        EleFXInput input2 = new EleFXInput();
        input2.setDisable(true);
        input2.setSize(EleFXInputSize.SMALL);

        EleFXInput input3 = new EleFXInput();
        input3.setClearable(true);
        input3.setPrefix(new EleFXIcon(EleFXIconType.ADD_LOCATION));
        input3.setSuffix(new EleFXIcon(EleFXIconType.PLUS));
        input3.setSize(EleFXInputSize.LARGE);
        input3.setMaxLength(5);
        input3.setPrepend(new Label("Http://"));
        input3.setAppend(new Label(".com"));
        input3.setShowWordLimit(true);

        EleFXInput input4 = new EleFXInput();
        input4.setClearable(true);
        input4.setClearIcon(new EleFXIcon(EleFXIconType.ADD_LOCATION));
        input4.setFormatter(value ->
                ("$ " + value).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")
        );
        input4.setParser(value ->
                value.replaceAll("\\$\\s?|,+", "")
        );

        HBox inputHbox1 = new HBox();
        inputHbox1.getChildren().addAll(input1, input2);

        HBox inputHbox2 = new HBox();
        inputHbox2.getChildren().addAll(input3, input4);

        vBox.getChildren().addAll(inputHbox1, inputHbox2);
    }

    private EleFXInputFiller() {}
}
