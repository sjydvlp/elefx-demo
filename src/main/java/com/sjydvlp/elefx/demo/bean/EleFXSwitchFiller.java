package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.switcher.EleFXSwitch;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * EleFXSwitchFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXSwitchFiller {

    public static void fill(VBox vBox) {
        EleFXSwitch eleFXSwitch1 = new EleFXSwitch();
        eleFXSwitch1.setActiveColor(Color.RED);
        eleFXSwitch1.setInactiveColor(Color.GREEN);
        eleFXSwitch1.setDisable(true);

        EleFXSwitch eleFXSwitch2 = new EleFXSwitch();
//        eleFXSwitch2.setActiveColor(Color.RED);
//        eleFXSwitch2.setInactiveColor(Color.GREEN);
//        eleFXSwitch2.setSize(EleFXSwitchSize.SMALL);
        eleFXSwitch2.setActiveText("hello");
        eleFXSwitch2.setInactiveText("hi");
        eleFXSwitch2.setInlinePrompt(true);
        eleFXSwitch2.setSwitchWidth(300);
//        eleFXSwitch2.setActiveIcon(new EleFXIcon(EleFXIconType.CHECK, 12));
//        eleFXSwitch2.setInactiveIcon(new EleFXIcon(EleFXIconType.AIM, 12));
        eleFXSwitch2.setActiveValue(100);
        eleFXSwitch2.setInactiveValue(0);
        eleFXSwitch2.setOnChange(e -> {
            System.out.println(e.getValue());
        });
//        eleFXSwitch2.setLoading(true);
        eleFXSwitch2.setBeforeChange(() -> false);

        HBox switchHbox = new HBox(eleFXSwitch1, eleFXSwitch2);
        switchHbox.setPadding(new Insets(10));
        switchHbox.setSpacing(20);

        vBox.getChildren().addAll(switchHbox);
    }

    private EleFXSwitchFiller() {}
}
