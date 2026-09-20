package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.select.EleFXSelect;
import com.sjydvlp.elefx.component.select.EleFXSelectOption;
import com.sjydvlp.elefx.component.select.EleFXSelectOptionGroup;
import com.sjydvlp.elefx.component.select.EleFXSelectSize;
import javafx.scene.layout.VBox;

/**
 * EleFXSelectFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXSelectFiller {

    public static void fill(VBox vBox) {
        EleFXSelect<String> eleFXSelect = getEleFXSelect();
        EleFXSelect<String> eleFXSelect2 = getEleFXSelect2();
        EleFXSelect<String> eleFXSelect3 = getEleFXSelect3();

        vBox.getChildren().addAll(eleFXSelect, eleFXSelect2, eleFXSelect3);
    }

    private static EleFXSelect<String> getEleFXSelect() {
        EleFXSelectOption<String> option1 = new EleFXSelectOption<>("a", "l_a");
        EleFXSelectOption<String> option2 = new EleFXSelectOption<>("b", "l_b");
//        option2.setDisabled(true);
        EleFXSelectOption<String> option3 = new EleFXSelectOption<>("c", "l_c");
        EleFXSelectOption<String> option4 = new EleFXSelectOption<>("d", "l_d");
        EleFXSelectOption<String> option5 = new EleFXSelectOption<>("e", "l_e");
        EleFXSelectOption<String> option6 = new EleFXSelectOption<>("f", "l_f");
        EleFXSelectOption<String> option7 = new EleFXSelectOption<>("g", "l_g");
        EleFXSelectOption<String> option8 = new EleFXSelectOption<>("h", "l_h");

        EleFXSelect<String> select = new EleFXSelect<>(
                option1, option2, option3, option4,
                option5, option6, option7, option8
        );
        select.setSize(EleFXSelectSize.SMALL);
        select.setPrefWidth(200);
//        select.setStyle("-fx-border-color: #ff0000;");
//        select.setDisable(true);
        select.setClearable(true);
        select.setMultiple(true);
        select.setCollapseTags(true);
        select.setMaxCollapseTags(3);
        select.setCollapseTagsTooltip(true);
        return select;
    }

    private static EleFXSelect<String> getEleFXSelect2() {
        EleFXSelectOption<String> option1 = new EleFXSelectOption<>("a", "l_a");
        EleFXSelectOption<String> option2 = new EleFXSelectOption<>("b", "l_b");
        EleFXSelectOptionGroup<String> group1 = new EleFXSelectOptionGroup<>("g1");
        group1.addOptions(option1, option2);

        EleFXSelectOption<String> option3 = new EleFXSelectOption<>("c", "l_c");
        EleFXSelectOption<String> option4 = new EleFXSelectOption<>("d", "l_d");
        EleFXSelectOption<String> option5 = new EleFXSelectOption<>("e", "l_e");
        EleFXSelectOptionGroup<String> group2 = new EleFXSelectOptionGroup<>("g2");
        group2.addOptions(option3, option4, option5);

        EleFXSelect<String> select = new EleFXSelect<>();
        select.addOptionGroups(group1, group2);
        select.setSize(EleFXSelectSize.SMALL);
        select.setPrefWidth(200);
        select.setClearable(true);
        select.setMultiple(true);

        return select;
    }

    private static EleFXSelect<String> getEleFXSelect3() {
        EleFXSelectOption<String> option1 = new EleFXSelectOption<>("a", "l_a");
        EleFXSelectOption<String> option2 = new EleFXSelectOption<>("b", "l_b");
        EleFXSelectOption<String> option3 = new EleFXSelectOption<>("c", "l_c");
        EleFXSelectOption<String> option4 = new EleFXSelectOption<>("d", "l_d");
        EleFXSelectOption<String> option5 = new EleFXSelectOption<>("e", "l_e");

        EleFXSelect<String> select = new EleFXSelect<>(option1, option2, option3, option4, option5);
        select.setSize(EleFXSelectSize.SMALL);
        select.setPrefWidth(200);
        select.setClearable(true);
        select.setFilterable(true);
        select.setRemote(true);

        EleFXIcon eleFXIcon = new EleFXIcon(EleFXIconType.SEARCH);
        eleFXIcon.setLoading(true);
        select.setLoadingNode(eleFXIcon);

        select.setRemoteMethod(keyword -> {
            select.setLoading(true);

            // 异步请求……
            // Platform.runLater(() -> {
            //     select.getOptions().setAll(results);
            //     select.setLoading(false);
            // });
        });
        return select;
    }

    private EleFXSelectFiller() {}
}
