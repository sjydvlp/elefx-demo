package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.statistic.EleFXCountdown;
import com.sjydvlp.elefx.component.statistic.EleFXStatistic;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXStatisticFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXStatisticFiller {

    public static void fill(VBox vBox) {
        EleFXStatistic statistic1 = new EleFXStatistic("Daily active users", 268500);
        EleFXStatistic statistic2 = new EleFXStatistic(138);
//        statistic2.setTitleNode(EleFXIcons.of(EleFXIconType.APPLE));
        statistic2.setTitle("aaaa");
//        statistic2.setSuffix("/100");
        statistic2.setSuffixNode(EleFXIcons.of(EleFXIconType.COFFEE_CUP));
        EleFXCountdown countdown1 = new EleFXCountdown("Start to grab", System.currentTimeMillis() +  + 1000 * 60 * 60 * 7);
        EleFXCountdown countdown2 = new EleFXCountdown("Remaining VIP time", System.currentTimeMillis() +  + 1000 * 60 * 60 * 24 * 2);
        countdown2.setFormat("HH:mm:ss");

        HBox statisticHbox = new HBox(statistic1, statistic2, countdown1, countdown2);
        statisticHbox.setSpacing(10);

        vBox.getChildren().addAll(statisticHbox);
    }

    private EleFXStatisticFiller() {}
}
