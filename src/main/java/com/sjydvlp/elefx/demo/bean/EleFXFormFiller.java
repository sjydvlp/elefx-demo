package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.form.EleFXForm;
import com.sjydvlp.elefx.component.form.EleFXFormItem;
import com.sjydvlp.elefx.component.form.EleFXFormLabelPosition;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * EleFXFormFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXFormFiller {

    public static void fill(VBox vBox) {
        EleFXForm form = new EleFXForm();
        form.setLabelPosition(EleFXFormLabelPosition.LEFT);
        form.setStyle("-fx-border-color: #ff0000;");
        form.setLabelWidth(100); // 自动对齐到最长标签
        form.setInline(true);
//        form.setMaxWidth(600);

        TextField name = new TextField();
        EleFXFormItem nameItem = new EleFXFormItem("Name", name);
        nameItem.setProp("name");
        nameItem.setRequired(false);

        TextField age = new TextField();
        EleFXFormItem ageItem = new EleFXFormItem("Age", age);
        ageItem.setProp("age");
        ageItem.setRequired(true);

        form.getItems().addAll(nameItem, ageItem);

        if (form.validate()) {
            // submit
        }

        vBox.getChildren().addAll(form);
    }

    private EleFXFormFiller() {}
}
