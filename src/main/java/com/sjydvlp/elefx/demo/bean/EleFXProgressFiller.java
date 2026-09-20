package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.progress.EleFXProgress;
import com.sjydvlp.elefx.component.progress.EleFXProgressColorStop;
import com.sjydvlp.elefx.component.progress.EleFXProgressStatus;
import com.sjydvlp.elefx.component.progress.EleFXProgressType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * EleFXProgressFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXProgressFiller {

    public static void fill(VBox vBox) {
        EleFXProgress progress1 = new EleFXProgress();
        progress1.setPercentage(50);
        progress1.setIndeterminate(true);
        progress1.setDuration(3);

        EleFXProgress progress2 = new EleFXProgress();
        progress2.setPercentage(100);
        progress2.setFormat(percentage -> {
            if (Objects.equals(100.0, percentage)) {
                return "Full";
            } else {
                return percentage + "%";
            }
        });
        progress2.setIndeterminate(true);
        progress2.setDuration(5);

        EleFXProgress progress3 = new EleFXProgress();
        progress3.setPercentage(100);
        progress3.setStatus(EleFXProgressStatus.SUCCESS);
        progress3.setIndeterminate(true);
        progress3.setDuration(1);

        EleFXProgress progress4 = new EleFXProgress();
        progress4.setPercentage(60);
        progress4.setStatus(EleFXProgressStatus.WARNING);
        progress4.setStriped(true);
        progress4.setStripedFlow(true);
        progress4.setDuration(0.2);

        EleFXProgress progress5 = new EleFXProgress();
        progress5.setPercentage(30);
        progress5.setStatus(EleFXProgressStatus.EXCEPTION);

        EleFXProgress progress6 = new EleFXProgress();
        progress6.setPercentage(70);
        progress6.setStrokeWidth(26);
        progress6.setTextInside(true);

        EleFXProgress progress7 = new EleFXProgress();
        progress7.setPercentage(50);
//        progress7.setStrokeWidth(24);
        progress7.setTextInside(true);
//        progress7.setStatus(EleFXProgressStatus.SUCCESS);
//        progress7.setStatus(EleFXProgressStatus.WARNING);
//        progress7.setStatus(EleFXProgressStatus.EXCEPTION);
        progress7.setType(EleFXProgressType.DASHBOARD);
        progress7.setContent(EleFXIcons.of(EleFXIconType.COFFEE));

        EleFXProgress progress8 = new EleFXProgress();
        progress8.setPercentage(50);
        progress8.setStrokeWidth(22);
        progress8.setTextInside(true);
        progress8.setStatus(EleFXProgressStatus.WARNING);
        progress8.setColorStops(
                new EleFXProgressColorStop(30, Color.web("#f56c6c")),
                new EleFXProgressColorStop(50, Color.web("#e6a23c")),
                new EleFXProgressColorStop(80, Color.web("#67c23a"))
        );

        EleFXProgress progress9 = new EleFXProgress();
        progress9.setPercentage(50);
        progress9.setStrokeWidth(20);
        progress9.setTextInside(true);
        progress9.setStatus(EleFXProgressStatus.EXCEPTION);
        // 根据当前百分比实时决定颜色
        progress9.setColorFunction(percent ->
                percent < 30 ? Color.web("#f56c6c")
                        : percent < 70 ? Color.web("#e6a23c")
                        : Color.web("#67c23a")
        );
        EleFXButton progressMinus = new EleFXButton(EleFXIcons.of(EleFXIconType.MINUS));
        EleFXButton progressPlus = new EleFXButton(EleFXIcons.of(EleFXIconType.PLUS));
        progressMinus.setOnAction(event -> {
            double percentage = progress9.getPercentage() - 10;
            if (percentage < 0) {
                percentage = 0;
            }
            progress9.setPercentage(percentage);
            progress8.setPercentage(percentage);
            progress7.setPercentage(percentage);
        });
        progressPlus.setOnAction(event -> {
            double percentage = progress9.getPercentage() + 10;
            if (percentage > 100) {
                percentage = 100;
            }
            progress9.setPercentage(percentage);
            progress8.setPercentage(percentage);
            progress7.setPercentage(percentage);
        });

        VBox progressVbox = new VBox(progress1, progress2, progress3, progress4,
                progress5, progress6, progress7, progress8, progress9, new HBox(progressMinus, progressPlus));
        progressVbox.setSpacing(8);

        vBox.getChildren().addAll(progressVbox);
    }

    private EleFXProgressFiller() {}
}
