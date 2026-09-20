package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.pagination.EleFXPagination;
import com.sjydvlp.elefx.component.pagination.EleFXPaginationLayout;
import com.sjydvlp.elefx.component.pagination.EleFXPaginationSize;
import javafx.scene.layout.VBox;

/**
 * EleFXPaginationFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXPaginationFiller {

    public static void fill(VBox vBox) {
        EleFXPagination pagination1 = new EleFXPagination(50);
        pagination1.setLayout(EleFXPaginationLayout.SIZES, EleFXPaginationLayout.PREV, EleFXPaginationLayout.PAGER, EleFXPaginationLayout.NEXT, EleFXPaginationLayout.JUMPER, EleFXPaginationLayout.TOTAL);
        EleFXPagination pagination2 = new EleFXPagination(1000);
        pagination2.setLayout(EleFXPaginationLayout.PREV, EleFXPaginationLayout.PAGER, EleFXPaginationLayout.NEXT);
        pagination2.setPageSize(20);
        pagination2.setPagerCount(11);
        pagination2.setBackground(true);
        pagination2.setSize(EleFXPaginationSize.SMALL);
        EleFXPagination pagination3 = new EleFXPagination(3);
//        pagination3.setHideOnSinglePage(true);
        pagination3.setDisable(true);

        vBox.getChildren().addAll(pagination1, pagination2, pagination3);
    }

    private EleFXPaginationFiller() {}
}
