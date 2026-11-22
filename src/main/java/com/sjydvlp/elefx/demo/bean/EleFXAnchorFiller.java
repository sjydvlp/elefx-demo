package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.affix.EleFXAffix;
import com.sjydvlp.elefx.component.affix.EleFXAffixPosition;
import com.sjydvlp.elefx.component.anchor.EleFXAnchor;
import com.sjydvlp.elefx.component.anchor.EleFXAnchorDirection;
import com.sjydvlp.elefx.component.anchor.EleFXAnchorLink;
import com.sjydvlp.elefx.component.anchor.EleFXAnchorType;
import com.sjydvlp.elefx.component.container.*;
import com.sjydvlp.elefx.component.layout.EleFXCol;
import com.sjydvlp.elefx.component.layout.EleFXRow;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * EleFXAnchorFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXAnchorFiller {

    public static void fill(VBox vBox) {
//        vBox.getChildren().add(basicUsageTest());
//        vBox.getChildren().add(horizontalModeTest());
//        vBox.getChildren().add(scrollContainerTest());
//        vBox.getChildren().add(anchorLinkChangeTest());
//        vBox.getChildren().add(underlineTypeTest());
        vBox.getChildren().add(affixModeTest());
        vBox.setSpacing(10);
    }

    private static EleFXContainer basicUsageTest() {
        EleFXAnchorLink basic = new EleFXAnchorLink("Basic Usage", "#basic-usage");
        EleFXAnchorLink horizontal = new EleFXAnchorLink("Horizontal Mode", "#horizontal-mode");
        EleFXAnchorLink container = new EleFXAnchorLink("Scroll Container", "#scroll-container");
        EleFXAnchorLink api = new EleFXAnchorLink("Anchor API", "#anchor-api");
        EleFXAnchorLink attributes = new EleFXAnchorLink("Anchor Attributes", "#anchor-attributes");
        EleFXAnchorLink events = new EleFXAnchorLink("Anchor Events", "#anchor-events");

        api.getSubLinks().addAll(attributes, events);

        EleFXAnchor anchor = new EleFXAnchor(basic, horizontal, container, api);
        anchor.setOffset(70);

        VBox content = new VBox(16);
        content.setPadding(new Insets(20));

        EleFXAnchorLink[] links = {basic, horizontal, container, api, attributes, events};
        for (EleFXAnchorLink link : links) {
            VBox section = new VBox(new Label(link.getTitle()));
            section.setId(link.getHref().substring(1));
            section.setMinHeight(440);
            content.getChildren().add(section);
        }

        EleFXScrollbar scrollPane = new EleFXScrollbar(content);
        scrollPane.setFitToWidth(true);
        anchor.setContainer(scrollPane);

        EleFXMain main = new EleFXMain(scrollPane);
        main.setPadding(Insets.EMPTY);
        scrollPane.prefWidthProperty().bind(main.widthProperty());
        scrollPane.prefHeightProperty().bind(main.heightProperty());

        EleFXAside aside = new EleFXAside(anchor);
        aside.setPrefWidth(220);
        anchor.relocate(16, 20);

        EleFXContainer root = new EleFXContainer(main, aside);
        root.setDirection(EleFXContainerDirection.HORIZONTAL);
        return root;
    }

    private static EleFXContainer horizontalModeTest() {
        EleFXAnchorLink[] links = {
                new EleFXAnchorLink("Basic Usage", "#basic-usage"),
                new EleFXAnchorLink("Horizontal Mode", "#horizontal-mode"),
                new EleFXAnchorLink("Scroll Container", "#scroll-container")
        };

        EleFXAnchor anchor = new EleFXAnchor(links);
        anchor.setDirection(EleFXAnchorDirection.HORIZONTAL);
        anchor.setOffset(70);

        VBox content = new VBox(16);
        content.setPadding(new Insets(20));

        for (EleFXAnchorLink link : links) {
            VBox section = new VBox(new Label(link.getTitle()));
            section.setId(link.getHref().substring(1));
            section.setMinHeight(440);
            content.getChildren().add(section);
        }

        EleFXScrollbar scrollPane = new EleFXScrollbar(content);
        scrollPane.setFitToWidth(true);
        anchor.setContainer(scrollPane);

        EleFXHeader header = new EleFXHeader(anchor);
        header.setPrefHeight(56);
        anchor.relocate(20, 12);

        EleFXMain main = new EleFXMain(scrollPane);
        main.setPadding(Insets.EMPTY);
        scrollPane.prefWidthProperty().bind(main.widthProperty());
        scrollPane.prefHeightProperty().bind(main.heightProperty());

        return new EleFXContainer(header, main);
    }

    private static EleFXRow scrollContainerTest() {
        String[] backgroundColors = {
                "rgba(255, 0, 0, 0.02)",
                "rgba(0, 255, 0, 0.02)",
                "rgba(0, 0, 255, 0.02)"
        };

        VBox content = new VBox(30);
        content.setPadding(new Insets(30, 0, 0, 0));

        EleFXAnchor anchor = new EleFXAnchor();
        anchor.setDirection(EleFXAnchorDirection.VERTICAL);
        anchor.setType(EleFXAnchorType.DEFAULT);
        anchor.setOffset(30);

        for (int i = 0; i < backgroundColors.length; i++) {
            String id = "part" + (i + 1);

            VBox section = new VBox(new Label(id));
            section.setId(id);
            section.setMinHeight(300);
            section.setStyle("-fx-background-color: " + backgroundColors[i] + ";");

            content.getChildren().add(section);
            anchor.getLinks().add(new EleFXAnchorLink(id, "#" + id));
        }

        EleFXScrollbar scrollPane = new EleFXScrollbar(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setMinHeight(300);
        scrollPane.setPrefHeight(300);
        scrollPane.setMaxHeight(300);
        anchor.setContainer(scrollPane);

        Label fixedTop = new Label("Fixed Top Block");
        fixedTop.setMinHeight(30);
        fixedTop.setPrefHeight(30);
        fixedTop.setMaxHeight(30);
        fixedTop.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        StackPane scrollArea = new StackPane(scrollPane, fixedTop);
        StackPane.setAlignment(fixedTop, Pos.TOP_LEFT);
        fixedTop.maxWidthProperty().bind(scrollArea.widthProperty().multiply(0.7));

        EleFXCol anchorCol = new EleFXCol(6, anchor);
        anchorCol.setAlignment(Pos.TOP_LEFT);

        return new EleFXRow(
                new EleFXCol(18, scrollArea),
                anchorCol
        );
    }

    private static EleFXRow anchorLinkChangeTest() {
        EleFXAnchorLink basic = new EleFXAnchorLink("Basic Usage", "#basic-usage");
        EleFXAnchorLink horizontal = new EleFXAnchorLink("Horizontal Mode", "#horizontal-mode");
        EleFXAnchorLink container = new EleFXAnchorLink("Scroll Container", "#scroll-container");
        EleFXAnchorLink api = new EleFXAnchorLink("Anchor API", "#anchor-api");
        EleFXAnchorLink attributes = new EleFXAnchorLink("Anchor Attributes", "#anchor-attributes");
        EleFXAnchorLink events = new EleFXAnchorLink("Anchor Events", "#anchor-events");

        api.getSubLinks().addAll(attributes, events);

        EleFXAnchor anchor = new EleFXAnchor(basic, horizontal, container, api);
        anchor.setOffset(70);
        anchor.setOnChange(event ->
                System.out.println("anchor change: " + event.getHref())
        );

        VBox content = new VBox(16);
        content.setPadding(new Insets(20));

        EleFXAnchorLink[] sections = {basic, horizontal, container, api, attributes, events};
        for (EleFXAnchorLink link : sections) {
            VBox section = new VBox(new Label(link.getTitle()));
            section.setId(link.getHref().substring(1));
            section.setMinHeight(440);
            content.getChildren().add(section);
        }

        EleFXScrollbar scrollbar = new EleFXScrollbar(content);
        scrollbar.setFitToWidth(true);
        scrollbar.setHorizontalDisabled(true);
        scrollbar.setPrefHeight(400);
        scrollbar.setMaxHeight(400);
        anchor.setContainer(scrollbar);

        EleFXCol anchorCol = new EleFXCol(6, anchor);
        anchorCol.setAlignment(Pos.TOP_LEFT);

        return new EleFXRow(
                new EleFXCol(18, scrollbar),
                anchorCol
        );
    }

    private static EleFXRow underlineTypeTest() {
        EleFXAnchorLink basic = new EleFXAnchorLink("Basic Usage", "#basic-usage");
        EleFXAnchorLink horizontal = new EleFXAnchorLink("Horizontal Mode", "#horizontal-mode");
        EleFXAnchorLink container = new EleFXAnchorLink("Scroll Container", "#scroll-container");
        EleFXAnchorLink api = new EleFXAnchorLink("Anchor API", "#anchor-api");
        EleFXAnchorLink attributes = new EleFXAnchorLink("Anchor Attributes", "#anchor-attributes");
        EleFXAnchorLink events = new EleFXAnchorLink("Anchor Events", "#anchor-events");

        api.getSubLinks().addAll(attributes, events);

        EleFXAnchor anchor = new EleFXAnchor(basic, horizontal, container, api);
        anchor.setType(EleFXAnchorType.UNDERLINE);
        anchor.setOffset(70);

        VBox content = new VBox(16);
        content.setPadding(new Insets(70, 20, 20, 20));

        EleFXAnchorLink[] sections = {basic, horizontal, container, api, attributes, events};
        for (EleFXAnchorLink link : sections) {
            VBox section = new VBox(new Label(link.getTitle()));
            section.setId(link.getHref().substring(1));
            section.setMinHeight(440);
            content.getChildren().add(section);
        }

        EleFXScrollbar scrollbar = new EleFXScrollbar(content);
        scrollbar.setFitToWidth(true);
        scrollbar.setHorizontalDisabled(true);
        scrollbar.setPrefHeight(400);
        scrollbar.setMaxHeight(400);
        anchor.setContainer(scrollbar);

        EleFXCol anchorCol = new EleFXCol(6, anchor);
        anchorCol.setAlignment(Pos.TOP_LEFT);

        return new EleFXRow(
                new EleFXCol(18, scrollbar),
                anchorCol
        );
    }

    private static EleFXScrollbar affixModeTest() {
        EleFXAnchorLink basic = new EleFXAnchorLink("Basic Usage", "#basic-usage");
        EleFXAnchorLink horizontal = new EleFXAnchorLink("Horizontal Mode", "#horizontal-mode");
        EleFXAnchorLink container = new EleFXAnchorLink("Scroll Container", "#scroll-container");
        EleFXAnchorLink api = new EleFXAnchorLink("Anchor API", "#anchor-api");
        EleFXAnchorLink attributes = new EleFXAnchorLink("Anchor Attributes", "#anchor-attributes");
        EleFXAnchorLink events = new EleFXAnchorLink("Anchor Events", "#anchor-events");

        api.getSubLinks().addAll(attributes, events);

        EleFXAnchor anchor = new EleFXAnchor(basic, horizontal, container, api);
        anchor.setOffset(70);
        anchor.setMinWidth(Region.USE_PREF_SIZE);
        anchor.setPrefWidth(300);
        anchor.setMaxWidth(Region.USE_PREF_SIZE);

        EleFXAffix affix = new EleFXAffix(anchor);
        affix.setPosition(EleFXAffixPosition.TOP);
        affix.setOffset(60);
        affix.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        VBox content = new VBox(16);
        content.setPadding(new Insets(110, 20, 20, 20));

        EleFXAnchorLink[] sections = {basic, horizontal, container, api, attributes, events};
        for (EleFXAnchorLink link : sections) {
            VBox section = new VBox(new Label(link.getTitle()));
            section.setId(link.getHref().substring(1));
            section.setMinHeight(440);
            content.getChildren().add(section);
        }

        EleFXCol contentCol = new EleFXCol(16, content);
        contentCol.setAlignment(Pos.TOP_LEFT);

        EleFXCol anchorCol = new EleFXCol(8, affix);
        anchorCol.setAlignment(Pos.TOP_LEFT);
        anchorCol.setPadding(new Insets(110, 0, 0, 0));

        EleFXScrollbar scrollbar = new EleFXScrollbar(new EleFXRow(contentCol, anchorCol));
        scrollbar.setFitToWidth(true);
        scrollbar.setHorizontalDisabled(true);
        scrollbar.setPrefSize(960, 420);
        anchor.setContainer(scrollbar);

        return scrollbar;
    }

    private EleFXAnchorFiller() {
    }
}
