package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.breadcrumb.EleFXBreadcrumb;
import com.sjydvlp.elefx.component.breadcrumb.EleFXBreadcrumbItem;
import javafx.scene.layout.VBox;

/**
 * EleFXBreadcrumbFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXBreadcrumbFiller {

    public static void fill(VBox vBox) {
        EleFXBreadcrumbItem breadcrumbItem1 = new EleFXBreadcrumbItem("homepage");
        breadcrumbItem1.setTo("http://www.baidu.com");
        EleFXBreadcrumbItem breadcrumbItem2 = new EleFXBreadcrumbItem("promotion management");
        breadcrumbItem2.setTo("http://www.baidu.com");
        EleFXBreadcrumbItem breadcrumbItem3 = new EleFXBreadcrumbItem("promotion list");
        EleFXBreadcrumbItem breadcrumbItem4 = new EleFXBreadcrumbItem("promotion detail");

        EleFXBreadcrumb breadcrumb = new EleFXBreadcrumb(breadcrumbItem1, breadcrumbItem2,
                breadcrumbItem3, breadcrumbItem4);
//        breadcrumb.setSeparatorIcon(EleFXIcons.of(EleFXIconType.ARROW_RIGHT, 14));
        breadcrumb.setOnNavigate(event ->
                System.out.println(event.getItem().getTo())
        );

        vBox.getChildren().addAll(breadcrumb);
    }

    private EleFXBreadcrumbFiller() {}
}
