package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.descriptions.EleFXDescriptions;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptionsDirection;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptionsItem;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptionsSize;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * EleFXDescriptionsFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXDescriptionsFiller {

    public static void fill(VBox vBox) {
        EleFXDescriptionsItem descriptionsItem11 = new EleFXDescriptionsItem("Username", new Label("kooriookami"));
        EleFXDescriptionsItem descriptionsItem12 = new EleFXDescriptionsItem("Telephone", new Label("18100000000"));
        EleFXDescriptionsItem descriptionsItem13 = new EleFXDescriptionsItem("Place", new Label("Suzhou"));
        EleFXDescriptionsItem descriptionsItem14 = new EleFXDescriptionsItem("Remarks", new Label("18100000000"));
        EleFXDescriptionsItem descriptionsItem15 = new EleFXDescriptionsItem("Address", new Label("No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province"));
        EleFXDescriptions descriptions1 = new EleFXDescriptions("User Info", descriptionsItem11, descriptionsItem12, descriptionsItem13, descriptionsItem14, descriptionsItem15);
        descriptions1.setColumn(3);
        descriptions1.setBorder(true);
        descriptions1.setSize(EleFXDescriptionsSize.DEFAULT);

        EleFXDescriptionsItem descriptionsItem21 = new EleFXDescriptionsItem("Username", new Label("kooriookami"));
        descriptionsItem21.setRowSpan(2);
        EleFXDescriptionsItem descriptionsItem22 = new EleFXDescriptionsItem("Telephone", new Label("18100000000"));
        EleFXDescriptionsItem descriptionsItem23 = new EleFXDescriptionsItem("Place", new Label("Suzhou"));
        EleFXDescriptionsItem descriptionsItem24 = new EleFXDescriptionsItem("Remarks", new Label("18100000000"));
        EleFXDescriptionsItem descriptionsItem25 = new EleFXDescriptionsItem("Address", new Label("No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province"));
        EleFXDescriptions descriptions2 = new EleFXDescriptions("User Info", descriptionsItem21, descriptionsItem22, descriptionsItem23, descriptionsItem24, descriptionsItem25);
        descriptions2.setColumn(3);
        descriptions2.setBorder(true);
        descriptions2.setSize(EleFXDescriptionsSize.SMALL);
//        descriptions2.setSize(EleFXDescriptionsSize.LARGE);
//        descriptions2.setSize(EleFXDescriptionsSize.DEFAULT);
        descriptions2.setDirection(EleFXDescriptionsDirection.HORIZONTAL);

        vBox.getChildren().addAll(descriptions1, descriptions2);
    }

    private EleFXDescriptionsFiller() {}
}
