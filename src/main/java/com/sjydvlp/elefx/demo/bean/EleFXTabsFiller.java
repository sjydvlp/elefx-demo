package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.radio.EleFXRadioButton;
import com.sjydvlp.elefx.component.radio.EleFXRadioGroup;
import com.sjydvlp.elefx.component.tabs.EleFXTabPane;
import com.sjydvlp.elefx.component.tabs.EleFXTabs;
import com.sjydvlp.elefx.component.tabs.EleFXTabsPosition;
import com.sjydvlp.elefx.component.tabs.EleFXTabsType;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * EleFXMenuFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXTabsFiller {

    public static void fill(VBox vBox) {
        VBox tabs1 = getTabs1();
        VBox tabs2 = getTabs2();
        VBox tabs3 = getTabs3();
        VBox tabs4 = getTabs4();

        vBox.getChildren().addAll(tabs1, tabs2, tabs3, tabs4);
        vBox.setSpacing(20);
    }

    private static VBox getTabs1() {
        EleFXTabPane tabPane1 = new EleFXTabPane("User", "first", new Label("User"));
        EleFXTabPane tabPane2 = new EleFXTabPane("Config", "second", new Label("Config"));
        EleFXTabPane tabPane3 = new EleFXTabPane("Role", "third", new Label("Role"));
        EleFXTabPane tabPane4 = new EleFXTabPane("Task", "fourth", new Label("Task"));

        EleFXTabs tabs = new EleFXTabs(tabPane1, tabPane2, tabPane3, tabPane4);
        tabs.setCurrentName("second");
//        tabs.setType(EleFXTabsType.CARD);
        tabs.setType(EleFXTabsType.BORDER_CARD);
        tabs.setOnTabClick(event -> {
            System.out.println(event.getPane().getName());
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tabs);
        return vBox;
    }

    private static VBox getTabs2() {
        EleFXTabPane tabPane1 = new EleFXTabPane("User", "first", new Label("User"));
        EleFXTabPane tabPane2 = new EleFXTabPane("Config", "second", new Label("Config"));
        EleFXTabPane tabPane3 = new EleFXTabPane("Role", "third", new Label("Role"));
        EleFXTabPane tabPane4 = new EleFXTabPane("Task", "fourth", new Label("Task"));

        EleFXTabs tabs = new EleFXTabs(tabPane1, tabPane2, tabPane3, tabPane4);
        tabs.setCurrentName("second");
        tabs.setOnTabClick(event -> {
            System.out.println(event.getPane().getName());
        });

        EleFXRadioButton<EleFXTabsPosition> topRadioBtn = new EleFXRadioButton<>("top", EleFXTabsPosition.TOP);
        EleFXRadioButton<EleFXTabsPosition> rightRadioBtn = new EleFXRadioButton<>("right", EleFXTabsPosition.RIGHT);
        EleFXRadioButton<EleFXTabsPosition> bottomRadioBtn = new EleFXRadioButton<>("bottom", EleFXTabsPosition.BOTTOM);
        EleFXRadioButton<EleFXTabsPosition> leftRadioBtn = new EleFXRadioButton<>("left", EleFXTabsPosition.LEFT);
        EleFXRadioGroup<EleFXTabsPosition> radioGroup = new EleFXRadioGroup<>(topRadioBtn, rightRadioBtn, bottomRadioBtn, leftRadioBtn);
        radioGroup.setOnChange(event -> {
            tabs.setTabPosition(radioGroup.getSelectedValue());
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(radioGroup, tabs);
        vBox.setSpacing(8);
        return vBox;
    }

    private static VBox getTabs3() {
        HBox userLabel = new HBox();
        userLabel.getChildren().addAll(EleFXIcons.of(EleFXIconType.APPLE), new Label("User"));
        userLabel.setAlignment(Pos.CENTER);
        userLabel.setSpacing(8);

        EleFXTabPane tabPane1 = new EleFXTabPane();
        tabPane1.setLabelNode(userLabel);
        tabPane1.setName("first");
        tabPane1.setContent(new Label("User"));
        EleFXTabPane tabPane2 = new EleFXTabPane("Config", "second", new Label("Config"));
        EleFXTabPane tabPane3 = new EleFXTabPane("Role", "third", new Label("Role"));
        EleFXTabPane tabPane4 = new EleFXTabPane("Task", "fourth", new Label("Task"));

        EleFXTabs tabs = new EleFXTabs(tabPane1, tabPane2, tabPane3, tabPane4);
        tabs.setCurrentName("second");
//        tabs.setType(EleFXTabsType.CARD);
        tabs.setType(EleFXTabsType.BORDER_CARD);
        tabs.setOnTabClick(event -> {
            System.out.println(event.getPane().getName());
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tabs);
        return vBox;
    }

    private static VBox getTabs4() {
        AtomicInteger tabPaneNameSeq = new AtomicInteger(2);

        EleFXTabPane tabPane1 = new EleFXTabPane("Tab 1", 1, new Label("Tab 1 content"));
        EleFXTabPane tabPane2 = new EleFXTabPane("Tab 2", 2, new Label("Tab 2 content"));

        EleFXTabs tabs = new EleFXTabs(tabPane1, tabPane2);
        tabs.setType(EleFXTabsType.CARD);
        tabs.setEditable(true);
        tabs.setCurrentName(2);
        tabs.setOnTabAdd(event -> {
            int name = tabPaneNameSeq.incrementAndGet();
            EleFXTabPane tabPane = new EleFXTabPane(
                    "New Tab",
                    name,
                    new Label("New Tab Content")
            );
            tabs.getPanes().add(tabPane);
            tabs.setCurrentName(name);
        });
        tabs.setOnTabRemove(event -> {
            Object currentName = tabs.getCurrentName();

            Object waitRemoveName = event.getPane().getName();
            if (Objects.equals(currentName, waitRemoveName)) {

            }
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tabs);
        return vBox;
    }

    private EleFXTabsFiller() {}
}
