package com.sjydvlp.elefx.demo.bean;

import cn.hutool.core.lang.Tuple;
import com.sjydvlp.elefx.component.autocomplete.EleFXAutocomplete;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * EleFXAutocompleteFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXAutocompleteFiller {

    public static void fill(VBox vBox) {
        EleFXAutocomplete<Tuple> autocomplete = new EleFXAutocomplete<>(value -> List.of(new Tuple("a")));

        vBox.getChildren().addAll(autocomplete);
    }

    private EleFXAutocompleteFiller() {}
}
