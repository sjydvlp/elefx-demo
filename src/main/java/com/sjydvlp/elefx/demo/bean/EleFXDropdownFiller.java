package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.card.EleFXCard;
import com.sjydvlp.elefx.component.dropdown.*;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * EleFXDropdownFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXDropdownFiller {

    public static void fill(VBox vBox) {
        EleFXDropdownItem dropdownItem1 = new EleFXDropdownItem("Action 1");
        EleFXDropdownItem dropdownItem2 = new EleFXDropdownItem("Action 2");
        EleFXDropdownItem dropdownItem3 = new EleFXDropdownItem("Action 3");
        dropdownItem3.setCommand("c");
        EleFXDropdownItem dropdownItem4 = new EleFXDropdownItem("Action 4");
        dropdownItem4.setDisabled(true);
        EleFXDropdownItem dropdownItem5 = new EleFXDropdownItem("Action 5");
        dropdownItem5.setDivided(true);
        dropdownItem5.setIcon(EleFXIcons.of(EleFXIconType.APPLE));
        dropdownItem5.setCommand("e");

        EleFXDropdown dropdown = new EleFXDropdown(dropdownItem1, dropdownItem2,
                dropdownItem3, dropdownItem4, dropdownItem5);
//        dropdown.setPlacement(EleFXDropdownPlacement.TOP_END);
        dropdown.setPlacement(EleFXDropdownPlacement.BOTTOM_START);
//        dropdown.setTriggerIcon(EleFXIcons.of(EleFXIconType.ARROW_DOWN));

//        EleFXButton dropdownButton = new EleFXButton("Dropdown List", EleFXIcons.of(EleFXIconType.ARROW_DOWN), EleFXButtonType.PRIMARY);
//        dropdownButton.setContentDisplay(ContentDisplay.RIGHT);
//        dropdown.setTriggerNode(dropdownButton);

        dropdown.setSplitButton(true);
        dropdown.setType(EleFXButtonType.PRIMARY);
        dropdown.setOnClick(event -> {
            System.out.println("click");
        });
//        dropdown.setTrigger(EleFXDropdownTrigger.CLICK);
        dropdown.setTrigger(EleFXDropdownTrigger.CONTEXT_MENU);
//        dropdown.setHideOnClick(false);
        dropdown.setOnCommand(event -> {
            System.out.println(event.getItem().getCommand());
        });
        dropdown.setSize(EleFXDropdownSize.LARGE);
//        dropdown.setShowArrow(true);
        dropdown.setShowArrow(false);

        EleFXButton showBubbon = new EleFXButton("点击切换");
        final AtomicBoolean visible = new AtomicBoolean(false);
        showBubbon.setOnAction(event -> {
            if (dropdown.isShowing()) {
                dropdown.handleClose();
            } else {
                dropdown.handleOpen();
            }
        });

        EleFXCard card = new EleFXCard(new Label("Right CLick"));
        card.setPrefSize(100, 100);
        card.setOnContextMenuRequested(event -> {
            dropdown.handleOpen();
//            dropdown.handleOpenAt(event.getScreenX(), event.getScreenY());
        });
        card.setOnMouseClicked(event -> {
            dropdown.handleClose();
        });
        dropdown.setVirtualRef(card);

        vBox.getChildren().addAll(dropdown, showBubbon, card);
    }

    private EleFXDropdownFiller() {}
}
