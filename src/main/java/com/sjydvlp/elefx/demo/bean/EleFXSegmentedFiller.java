package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.segmented.EleFXSegmented;
import com.sjydvlp.elefx.component.segmented.EleFXSegmentedDirection;
import com.sjydvlp.elefx.component.segmented.EleFXSegmentedItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * EleFXSegmentedFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXSegmentedFiller {

    public static void fill(VBox vBox) {
        EleFXSegmented<EleFXIconType> fruits = new EleFXSegmented<>();

        EleFXSegmentedItem<EleFXIconType> watermelon =
                new EleFXSegmentedItem<>("Watermelon", EleFXIconType.WATERMELON);
        watermelon.setDisabled(true);

        fruits.getItems().setAll(
                new EleFXSegmentedItem<>("Apple", EleFXIconType.APPLE),
                new EleFXSegmentedItem<>("Cherry", EleFXIconType.CHERRY),
                new EleFXSegmentedItem<>("Grape", EleFXIconType.GRAPE),
                new EleFXSegmentedItem<>("Orange", EleFXIconType.ORANGE),
                new EleFXSegmentedItem<>("Pear", EleFXIconType.PEAR),
                watermelon
        );

        fruits.setItemRenderer(item -> {
            EleFXIcon icon = new EleFXIcon(item.getValue(), 20);
            Label label = new Label(item.getLabel());

            VBox content = new VBox(6, icon, label);
            content.setAlignment(Pos.CENTER);
            content.setPadding(new Insets(8, 0, 8, 0));
            return content;
        });

        fruits.setValue(EleFXIconType.ORANGE);
        fruits.setDirection(EleFXSegmentedDirection.VERTICAL);

        // 像截图一样让所有项目等宽
//        fruits.setBlock(true);
//        fruits.setPrefWidth(640);

        vBox.getChildren().addAll(fruits);
    }

    private EleFXSegmentedFiller() {}
}
