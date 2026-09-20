package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.timeline.*;
import javafx.scene.layout.VBox;

/**
 * EleFXTimelineFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTimelineFiller {

    public static void fill(VBox vBox) {
        EleFXTimelineItem timelineItem11 = new EleFXTimelineItem("Event start", "2018-04-15");
        timelineItem11.setType(EleFXTimelineItemType.DANGER);
        timelineItem11.setIcon(EleFXIcons.of(EleFXIconType.FOOTBALL, 20));
//        timelineItem11.setColor("#ff0000");
//        timelineItem11.setSize(EleFXTimelineItemSize.LARGE);
        EleFXTimelineItem timelineItem12 = new EleFXTimelineItem("Approved", "2018-04-13");
        timelineItem12.setHollow(true);
        timelineItem12.setType(EleFXTimelineItemType.PRIMARY);
        timelineItem12.setSize(EleFXTimelineItemSize.LARGE);
        EleFXTimelineItem timelineItem13 = new EleFXTimelineItem("Success", "2018-04-11");
        timelineItem13.setPlacement(EleFXTimelineItemPlacement.TOP);
//        timelineItem13.setCenter(true);
        EleFXTimeline timeline1 = new EleFXTimeline(timelineItem11, timelineItem12, timelineItem13);
        timeline1.setMode(EleFXTimelineMode.ALTERNATE_REVERSE);
//        timeline1.setReverse(true);

        vBox.getChildren().addAll(timeline1);
    }

    private EleFXTimelineFiller() {}
}
