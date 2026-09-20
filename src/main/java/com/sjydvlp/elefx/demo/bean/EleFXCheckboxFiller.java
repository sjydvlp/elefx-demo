package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.checkbox.EleFXCheckbox;
import com.sjydvlp.elefx.component.checkbox.EleFXCheckboxButton;
import com.sjydvlp.elefx.component.checkbox.EleFXCheckboxGroup;
import com.sjydvlp.elefx.component.space.EleFXSpace;
import javafx.scene.layout.VBox;

/**
 * EleFXCheckboxFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXCheckboxFiller {

    public static void fill(VBox vBox) {
        EleFXCheckbox<String> eleFXCheckbox1 = new EleFXCheckbox<>("a", "a");
        EleFXCheckbox<String> eleFXCheckbox2 = new EleFXCheckbox<>("b", "b");
        EleFXCheckbox<String> eleFXCheckbox3 = new EleFXCheckbox<>("c", "c");
        EleFXCheckbox<String> eleFXCheckbox4 = new EleFXCheckbox<>("d", "d");
        EleFXCheckboxButton<String> eleFXCheckboxButton5 = new EleFXCheckboxButton<>("你好，世界", "e");
        EleFXCheckboxGroup<String> eleFXCheckboxGroup =
                new EleFXCheckboxGroup<>(eleFXCheckbox3, eleFXCheckbox4, eleFXCheckboxButton5);
        EleFXSpace eleFxCheckBoxSpace = new EleFXSpace(eleFXCheckbox1, eleFXCheckbox2, eleFXCheckboxGroup);
        eleFxCheckBoxSpace.setSpacing(50);

        vBox.getChildren().addAll(eleFxCheckBoxSpace);
    }

    private EleFXCheckboxFiller() {}
}
