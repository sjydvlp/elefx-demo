package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.cascader.EleFXCascader;
import com.sjydvlp.elefx.component.cascader.EleFXCascaderOption;
import javafx.scene.layout.VBox;

/**
 * EleFXCascaderFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXCascaderFiller {

    public static void fill(VBox vBox) {
        EleFXCascaderOption<String> aaa = new EleFXCascaderOption<>("aaa", "l_aaa");
        EleFXCascaderOption<String> aba = new EleFXCascaderOption<>("aba", "l_aba");
        EleFXCascaderOption<String> aa = new EleFXCascaderOption<>("aa", "l_aa", aaa);
        EleFXCascaderOption<String> ab = new EleFXCascaderOption<>("ab", "l_ab", aba);
        EleFXCascaderOption<String> a = new EleFXCascaderOption<>("a", "l_a", aa, ab);

        EleFXCascaderOption<String> baa = new EleFXCascaderOption<>("baa", "l_baa");
        EleFXCascaderOption<String> bba = new EleFXCascaderOption<>("bba", "l_bba");
        EleFXCascaderOption<String> ba = new EleFXCascaderOption<>("ba", "l_ba", baa);
        EleFXCascaderOption<String> bb = new EleFXCascaderOption<>("bb", "l_bb", bba);
        EleFXCascaderOption<String> b = new EleFXCascaderOption<>("b", "l_b", ba, bb);

        EleFXCascader<String> cascader = new EleFXCascader<>(a, b);

        vBox.getChildren().addAll(cascader);
    }

    private EleFXCascaderFiller() {}
}
