package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.rate.EleFXRate;
import com.sjydvlp.elefx.component.rate.EleFXRateSize;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.util.List;

/**
 * EleFXRateFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXRateFiller {

    public static void fill(VBox vBox) {
        EleFXRate rate1 = new EleFXRate();
        EleFXRate rate2 = new EleFXRate();
        rate2.setColors(List.of(Paint.valueOf("#eee111"), Paint.valueOf("#ff0000"), Paint.valueOf("#FF9900")));
        EleFXRate rate3 = new EleFXRate();
        rate3.setSize(EleFXRateSize.SMALL);
        rate3.setAllowHalf(true);
        rate3.setShowText(true);
        rate3.setClearable(true);
        rate3.setVoidIcon(new EleFXIcon(EleFXIconType.CALENDAR));
        rate3.setIcons(List.of(new EleFXIcon(EleFXIconType.AIM), new EleFXIcon(EleFXIconType.APPLE), new EleFXIcon(EleFXIconType.BICYCLE)));
//        rate3.setDisable(true);

        HBox rateHbox = new HBox(rate1, rate2, rate3);
        rateHbox.setPadding(new Insets(10));
        rateHbox.setSpacing(20);

        vBox.getChildren().addAll(rateHbox);
    }

    private EleFXRateFiller() {}
}
