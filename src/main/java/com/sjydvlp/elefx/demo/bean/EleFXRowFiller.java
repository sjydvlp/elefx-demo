package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.layout.EleFXCol;
import com.sjydvlp.elefx.component.layout.EleFXRow;
import com.sjydvlp.elefx.component.layout.EleFXRowAlign;
import com.sjydvlp.elefx.component.layout.EleFXRowJustify;
import javafx.scene.layout.VBox;

/**
 * EleFXRowFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXRowFiller {

    public static void fill(VBox vBox) {
        EleFXCol row1Left = new EleFXCol(12, new EleFXButton("左侧"));
        EleFXCol row1Right = new EleFXCol(12, new EleFXButton("右侧"));
        row1Left.setContentStyle("-fx-background-color: #2196F3;");
        row1Right.setContentStyle("-fx-background-color: #fffaaa;");
        EleFXRow row1 = new EleFXRow(20, row1Left, row1Right);

        EleFXCol sidebar = new EleFXCol(6, new EleFXButton("侧栏"));
        EleFXCol main = new EleFXCol(6, new EleFXButton("主内容"));
        sidebar.setContentStyle("-fx-border-color: #2196F3;");
        main.setContentStyle("-fx-border-color: #fffaaa;");
        main.setOffset(6);
        EleFXRow row2 = new EleFXRow(20, sidebar, main);

        EleFXCol row3Left = new EleFXCol(6, new EleFXButton("A"));
        EleFXCol row3Right = new EleFXCol(6, new EleFXButton("B"));
        row3Left.setContentStyle("-fx-background-color: #aaafff;");
        row3Right.setContentStyle("-fx-background-color: #cccccc;");
        EleFXRow row3 = new EleFXRow(row3Left, row3Right);
        row3.setJustify(EleFXRowJustify.SPACE_AROUND);
        row3.setAlign(EleFXRowAlign.MIDDLE);

        vBox.getChildren().addAll(row1, row2, row3);
    }

    private EleFXRowFiller() {}
}
