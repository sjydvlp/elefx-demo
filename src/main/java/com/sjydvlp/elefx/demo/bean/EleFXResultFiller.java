package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.image.EleFXImage;
import com.sjydvlp.elefx.component.result.EleFXResult;
import com.sjydvlp.elefx.component.result.EleFXResultIcon;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXResultFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXResultFiller {

    public static void fill(VBox vBox) {
        EleFXResult result1 = new EleFXResult(EleFXResultIcon.PRIMARY, "Primary Tip", "Please follow the instructions");
        result1.setExtra(new EleFXButton("Back"));
        EleFXResult result2 = new EleFXResult(EleFXResultIcon.SUCCESS, "Success Tip", "Please follow the instructions");
        result2.setExtra(new EleFXButton("Back"));
        EleFXResult result3 = new EleFXResult(EleFXResultIcon.WARNING, "Warning Tip", "Please follow the instructions");
        result3.setExtra(new EleFXButton("Back"));
        EleFXResult result4 = new EleFXResult(EleFXResultIcon.ERROR, "Error Tip", "Please follow the instructions");
        result4.setExtra(new EleFXButton("Back"));
        EleFXResult result5 = new EleFXResult(EleFXResultIcon.INFO, "Info Tip", "Please follow the instructions");
        result5.setExtra(new EleFXButton("Back"));
        EleFXResult result6 = new EleFXResult();
        result6.setIconNode(new EleFXImage("https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"));
        result6.setTitle("404");
        result6.setSubTitle("Sorry, request error");
        result6.setExtra(new EleFXButton("Back"));

//        HBox resultHbox = new HBox(result1, result2, result3, result4, result5);
        HBox resultHbox = new HBox(result6);

        vBox.getChildren().addAll(resultHbox);
    }

    private EleFXResultFiller() {}
}
