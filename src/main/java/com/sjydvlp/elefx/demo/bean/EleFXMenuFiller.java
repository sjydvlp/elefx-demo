package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.menu.*;
import javafx.scene.layout.VBox;

/**
 * EleFXMenuFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXMenuFiller {

    public static void fill(VBox vBox) {
        EleFXMenu menu1 = buildMenu1();
        EleFXMenu menu2 = buildMenu2();
        EleFXMenu menu3 = buildMenu3();
//        menu3.setPopperOffset(200);

        EleFXButton toggleCollapseBtn = new EleFXButton("切换Collapse");
        toggleCollapseBtn.setOnAction(event -> {
            menu3.setCollapse(!menu3.isCollapse());
        });
        vBox.getChildren().addAll(menu1, menu2, menu3, toggleCollapseBtn);
    }

    private static EleFXMenu buildMenu1() {
        EleFXMenuItem menuItem1 = new EleFXMenuItem("1", "Processing Center");

        EleFXMenuItem menuItem21 = new EleFXMenuItem("2-1", "item one");
        EleFXMenuItem menuItem22 = new EleFXMenuItem("2-2", "item two");
        EleFXMenuItem menuItem23 = new EleFXMenuItem("2-3", "item three");
        EleFXMenuItem menuItem241 = new EleFXMenuItem("2-4-1", "item one");
        EleFXMenuItem menuItem242 = new EleFXMenuItem("2-4-2", "item two");
        EleFXMenuItem menuItem243 = new EleFXMenuItem("2-4-3", "item three");
        EleFXSubMenu menuItem24 = new EleFXSubMenu("2-4", "item four", menuItem241, menuItem242, menuItem243);
        EleFXSubMenu menuItem2 = new EleFXSubMenu("2", "Workspace", menuItem21, menuItem22, menuItem23, menuItem24);

        EleFXMenuItem menuItem3 = new EleFXMenuItem("3", "Info");
        menuItem3.setDisable(true);

        EleFXMenuItem menuItem4 = new EleFXMenuItem("4", "Orders");

        EleFXMenu menu = new EleFXMenu(menuItem1, menuItem2, menuItem3, menuItem4);
        menu.setActiveIndex("2-4-1");
        menu.setMode(EleFXMenuMode.HORIZONTAL);
//        menu.setBackgroundColor("#545c64");
//        menu.setTextColor("#ffffff");
//        menu.setActiveTextColor("#ffd04b");
        menu.setEllipsis(true);

        return menu;
    }

    private static EleFXMenu buildMenu2() {
        EleFXMenuItem menuItem0 = new EleFXMenuItem("0", "Processing Center");
        menuItem0.setTitleNode(EleFXIcons.of(EleFXIconType.APPLE));

        EleFXMenuItem menuItem1 = new EleFXMenuItem("1", "Processing Center");

        EleFXMenuItem menuItem21 = new EleFXMenuItem("2-1", "item one");
        EleFXMenuItem menuItem22 = new EleFXMenuItem("2-2", "item two");
        EleFXMenuItem menuItem23 = new EleFXMenuItem("2-3", "item three");
        EleFXMenuItem menuItem241 = new EleFXMenuItem("2-4-1", "item one");
        EleFXMenuItem menuItem242 = new EleFXMenuItem("2-4-2", "item two");
        EleFXMenuItem menuItem243 = new EleFXMenuItem("2-4-3", "item three");
        EleFXSubMenu menuItem24 = new EleFXSubMenu("2-4", "item four", menuItem241, menuItem242, menuItem243);
        EleFXSubMenu menuItem2 = new EleFXSubMenu("2", "Workspace", menuItem21, menuItem22, menuItem23, menuItem24);

        EleFXMenu menu = new EleFXMenu(menuItem0, menuItem1, menuItem2);
        menu.setActiveIndex("2-4-1");
        menu.setMode(EleFXMenuMode.HORIZONTAL);
        menu.setEllipsis(true);
        menu.setRightAlignedAfterIndex("0");

        return menu;
    }

    private static EleFXMenu buildMenu3() {
        EleFXMenuItem menuItem11 = new EleFXMenuItem("1-1", "item one");
        EleFXMenuItem menuItem12 = new EleFXMenuItem("1-2", "item two");
        EleFXMenuItemGroup menuItemGroup1 = new EleFXMenuItemGroup("Group One", menuItem11, menuItem12);

        EleFXMenuItem menuItem13 = new EleFXMenuItem("1-3", "item one");
        EleFXMenuItemGroup menuItemGroup2 = new EleFXMenuItemGroup("Group Two", menuItem13);

        EleFXMenuItem menuItem141 = new EleFXMenuItem("1-4-1", "item one");
        EleFXSubMenu menuItem14 = new EleFXSubMenu("1-4", "item four", menuItem141);

        EleFXSubMenu menuItem1 = new EleFXSubMenu("1", "Navigator One", menuItemGroup1, menuItemGroup2, menuItem14);
        menuItem1.setIcon(EleFXIcons.of(EleFXIconType.LOCATION));

        EleFXMenuItem menuItem2 = new EleFXMenuItem("2", "Navigator Two");
        menuItem2.setIcon(EleFXIcons.of(EleFXIconType.MENU));

        EleFXMenuItem menuItem3 = new EleFXMenuItem("3", "Navigator Three");
        menuItem3.setIcon(EleFXIcons.of(EleFXIconType.DOCUMENT));
        menuItem3.setDisable(true);

        EleFXMenuItem menuItem4 = new EleFXMenuItem("4", "Navigator Four");
        menuItem4.setIcon(EleFXIcons.of(EleFXIconType.SETTING));

        EleFXMenu menu = new EleFXMenu(menuItem1, menuItem2, menuItem3, menuItem4);
        menu.setActiveIndex("2");
        menu.setMaxWidth(200);
//        menu.setBackgroundColor("#545c64");
//        menu.setTextColor("#ffffff");
//        menu.setActiveTextColor("#ffd04b");
        menu.setOnOpen(event -> {
            System.out.println(event.getIndex());
        });
        menu.setOnClose(event -> {
            System.out.println(event.getIndex());
        });
        menu.setOnSelect(event -> {
            System.out.println(event.getIndex());
        });

        return menu;
    }

    private EleFXMenuFiller() {}
}
