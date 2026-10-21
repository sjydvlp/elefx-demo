package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.loading.EleFXLoading;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * EleFXLoadingFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXLoadingFiller {

    public static void fill(VBox vBox) {
        VBox basisUsageTest = basisUsageTest();

        vBox.getChildren().add(basisUsageTest);
        vBox.setSpacing(20);
    }

    private static VBox basisUsageTest() {
        Label content = new Label("这里是需要加载的数据");
        StackPane area = new StackPane(content);
        area.setPrefSize(360, 180);
        area.setStyle("-fx-background-color: #f5f7fa;");

        // 用法一：将遮罩作为 StackPane 的最上层子节点
        EleFXLoading inlineLoading = new EleFXLoading("正在加载…");
        inlineLoading.setLock(true);
        inlineLoading.setLoading(false);
        area.getChildren().add(inlineLoading);

        Button inlineButton = new Button("显示容器内遮罩");
        inlineButton.setOnAction(event -> {
            inlineLoading.setLoading(true);

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> inlineLoading.setLoading(false));
            delay.play();
        });

        // 用法二：创建覆盖指定节点的加载服务
        Button serviceButton = new Button("显示区域加载服务");
        serviceButton.setOnAction(event -> {
            EleFXLoading loading = EleFXLoading.service(
                    new EleFXLoading.Options()
                            .setFullscreen(false)
                            .setTarget(area)
                            .setText("正在获取数据…")
                            .setLock(true)
            );

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> loading.close());
            delay.play();
        });

        VBox root = new VBox(12, area, inlineButton, serviceButton);
        root.setPadding(new Insets(20));

        return root;
    }

    private EleFXLoadingFiller() {
    }
}
