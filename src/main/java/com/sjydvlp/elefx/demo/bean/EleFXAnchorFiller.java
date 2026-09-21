package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.affix.EleFXAffix;
import com.sjydvlp.elefx.component.anchor.EleFXAnchor;
import com.sjydvlp.elefx.component.anchor.EleFXAnchorDirection;
import com.sjydvlp.elefx.component.anchor.EleFXAnchorLink;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
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
        article.getChildren().addAll(
                new Label("a"), new Label("b"), new Label("c"),
                new Label("d"), new Label("e"));

        Label introduction = new Label("Introduction...");
        introduction.setAlignment(Pos.TOP_LEFT);
        introduction.setId("introduction");
        introduction.setMinHeight(360);

        Label installation = new Label("Installation...");
        installation.setAlignment(Pos.TOP_LEFT);
        installation.setId("installation");
        installation.setMinHeight(360);

        Label configuration = new Label("Configuration...");
        configuration.setAlignment(Pos.TOP_LEFT);
        configuration.setId("configuration");
        configuration.setMinHeight(360);

        Label advanced = new Label("Advanced...");
        advanced.setAlignment(Pos.TOP_LEFT);
        advanced.setId("advanced");
        advanced.setMinHeight(360);

        article.getChildren().addAll(introduction, installation, configuration, advanced);

        EleFXScrollbar scrollbar = new EleFXScrollbar(article);
        scrollbar.setStyle("-fx-border-color: blue;");
        scrollbar.setFitToWidth(true);
        scrollbar.setPrefViewportHeight(360);

        // 锚点导航
        EleFXAnchorLink parent = new EleFXAnchorLink("Introduction_二级", "#installation");
        EleFXAnchorLink child = new EleFXAnchorLink("Introduction_三级", "#configuration");
        EleFXAnchorLink grandchild = new EleFXAnchorLink("Introduction_四级", "#advanced");

        child.getSubLinks().add(grandchild);
        parent.getSubLinks().add(child);

        EleFXAnchorLink introLink = new EleFXAnchorLink("Introduction", "#introduction");
        introLink.getSubLinks().add(parent);
        EleFXAnchorLink installLink = new EleFXAnchorLink("Installation", "#installation");
        EleFXAnchorLink configLink = new EleFXAnchorLink("Configuration", "#configuration");
        EleFXAnchorLink advancedLink = new EleFXAnchorLink("Advanced", "#advanced");

        EleFXAnchor anchor = new EleFXAnchor(introLink, installLink, configLink, advancedLink);
        anchor.setContainer(scrollbar);
        anchor.setOffset(30);
        anchor.setBound(15);
        anchor.setDuration(300);
        anchor.setDirection(EleFXAnchorDirection.HORIZONTAL);
//        anchor.setType(EleFXAnchorType.UNDERLINE);

        anchor.setOnChange(event ->
                System.out.println("当前锚点：" + event.getHref())
        );

        anchor.setOnClick(event -> {
            System.out.println("点击：" + event.getHref());

            // 需要阻止组件自动滚动时：
            // event.consume();
        });

        VBox anchorVbox = new VBox();
        anchorVbox.getChildren().addAll(
                new Label("a"), new Label("a"), new Label("a"),
                new Label("a"), new Label("a"), new Label("a"),
                new Label("a"));

        EleFXAffix anchorAffix = new EleFXAffix(anchor);
        anchorAffix.setOffset(80);
        anchorVbox.getChildren().add(anchorAffix);

        anchorVbox.getChildren().addAll(
                new Label("a"), new Label("a"), new Label("a"),
                new Label("a"), new Label("a"), new Label("a"),
                new Label("a"), new Label("a"), new Label("a"),
                new Label("a"), new Label("a"), new Label("a"),
                new Label("a"), new Label("a"), new Label("a"),
                new Label("a"), new Label("a"), new Label("a"));

        EleFXScrollbar anchorScrollbar = new EleFXScrollbar(anchorVbox);
        anchorScrollbar.setPrefViewportHeight(100);

        // 放入布局
//        HBox root = new HBox(32, scrollbar, anchor);
        HBox root = new HBox(32, scrollbar, anchorScrollbar);

        vBox.getChildren().addAll(root);
    }

    private EleFXAnchorFiller() {}
}
