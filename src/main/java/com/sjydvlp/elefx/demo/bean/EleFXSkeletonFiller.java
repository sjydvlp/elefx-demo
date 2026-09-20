package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.skeleton.EleFXSkeleton;
import com.sjydvlp.elefx.component.skeleton.EleFXSkeletonItem;
import com.sjydvlp.elefx.component.skeleton.EleFXSkeletonItemVariant;
import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * EleFXSkeletonFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXSkeletonFiller {

    public static void fill(VBox vBox) {
        EleFXSkeleton skeleton1 = new EleFXSkeleton();

        EleFXSkeletonItem skeletonItem1 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.CIRCLE);
        skeletonItem1.setPrefSize(100, 100);
        EleFXSkeleton skeleton2 = new EleFXSkeleton();
        skeleton2.getTemplateChildren().addAll(skeletonItem1);

        EleFXSkeleton skeleton3 = new EleFXSkeleton();
        skeleton3.setRows(2);
        skeleton3.setAnimated(true);

        // 自定义骨架
        EleFXSkeletonItem skeletonItem2 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.IMAGE);
        skeletonItem2.setPrefSize(240, 240);

        EleFXSkeletonItem skeletonItem3 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.P);
        skeletonItem3.setWidthPercent(50);

        EleFXSkeletonItem skeletonItem4 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.TEXT);
        EleFXSkeletonItem skeletonItem5 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.TEXT);
        skeletonItem5.setWidthPercent(30);
        HBox skeletonInnerHbox = new HBox(16, skeletonItem4, skeletonItem5);
        HBox.setHgrow(skeletonItem4, Priority.ALWAYS);

        VBox skeletonOuterVbox = new VBox(skeletonItem3, skeletonInnerHbox);
        skeletonOuterVbox.setSpacing(10);

        EleFXSkeleton skeleton4 = new EleFXSkeleton();
        skeleton4.getTemplateChildren().addAll(skeletonItem2, skeletonOuterVbox);
        skeleton4.setPrefWidth(240);
        skeleton4.setAnimated(true);
        skeleton4.getContentChildren().addAll(new Label("加载出的内容"));
//        skeleton4.setLoading(false);
        skeleton4.setThrottle(2000);

        EleFXButton skeletonButton = new EleFXButton("点击加载");
        skeletonButton.setOnAction(event -> {
            skeleton4.setLoading(true);

            PauseTransition delay = new PauseTransition(Duration.seconds(6));
            delay.setOnFinished(e -> skeleton4.setLoading(false));
            delay.play();
        });

        vBox.getChildren().addAll(skeleton1, skeleton2, skeleton3, skeleton4, skeletonButton);
    }

    private EleFXSkeletonFiller() {}
}
