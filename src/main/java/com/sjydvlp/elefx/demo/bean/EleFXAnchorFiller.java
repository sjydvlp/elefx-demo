package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.anchor.EleFXAnchor;
import com.sjydvlp.elefx.component.anchor.EleFXAnchorLink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXAnchorFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXAnchorFiller {

    public static void fill(VBox vBox) {
        // 内容区：每个目标节点需要 id，与 href 对应
        VBox article = new VBox(24);

        Label introduction = new Label("Introduction\n\n...");
        introduction.setId("introduction");
        introduction.setMinHeight(360);

        Label installation = new Label("Installation\n\n...");
        installation.setId("installation");
        installation.setMinHeight(360);

        Label configuration = new Label("Configuration\n\n...");
        configuration.setId("configuration");
        configuration.setMinHeight(360);

        Label advanced = new Label("Advanced\n\n...");
        advanced.setId("advanced");
        advanced.setMinHeight(360);

        article.getChildren().addAll(introduction, installation, configuration, advanced);

        ScrollPane scrollPane = new ScrollPane(article);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefViewportHeight(360);

        // 锚点导航
        EleFXAnchorLink introLink = new EleFXAnchorLink("Introduction", "#introduction");
        EleFXAnchorLink installLink = new EleFXAnchorLink("Installation", "#installation");
        EleFXAnchorLink configLink = new EleFXAnchorLink("Configuration", "#configuration");
        EleFXAnchorLink advancedLink = new EleFXAnchorLink("Advanced", "#advanced");

        EleFXAnchor anchor = new EleFXAnchor(introLink, installLink, configLink, advancedLink);
        anchor.setContainer(scrollPane);
        anchor.setOffset(12);
        anchor.setBound(15);
        anchor.setDuration(300);

        anchor.setOnChange(event ->
                System.out.println("当前锚点：" + event.getHref())
        );

        anchor.setOnClick(event -> {
            System.out.println("点击：" + event.getHref());

            // 需要阻止组件自动滚动时：
            // event.consume();
        });

        // 放入布局
        HBox root = new HBox(32, scrollPane, anchor);

        vBox.getChildren().addAll(root);
    }

    private EleFXAnchorFiller() {}
}
