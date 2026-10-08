package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.avatar.EleFXAvatar;
import com.sjydvlp.elefx.component.avatar.EleFXAvatarShape;
import com.sjydvlp.elefx.component.avatar.EleFXAvatarSize;
import com.sjydvlp.elefx.component.breadcrumb.EleFXBreadcrumb;
import com.sjydvlp.elefx.component.breadcrumb.EleFXBreadcrumbItem;
import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptions;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptionsItem;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptionsSize;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.pageheader.EleFXPageHeader;
import com.sjydvlp.elefx.component.tag.EleFXTag;
import com.sjydvlp.elefx.component.tag.EleFXTagEffect;
import com.sjydvlp.elefx.component.tag.EleFXTagSize;
import com.sjydvlp.elefx.component.tag.EleFXTagType;
import com.sjydvlp.elefx.component.text.EleFXText;
import com.sjydvlp.elefx.component.text.EleFXTextSize;
import com.sjydvlp.elefx.component.text.EleFXTextTag;
import com.sjydvlp.elefx.component.text.EleFXTextType;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * EleFXMenuFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXPageHeaderFiller {

    public static void fill(VBox vBox) {
        // 1.breadcrumb
        EleFXBreadcrumbItem breadcrumbItem1 = new EleFXBreadcrumbItem("homepage");
        breadcrumbItem1.setTo("http://www.baidu.com");
        EleFXBreadcrumbItem breadcrumbItem2 = new EleFXBreadcrumbItem("promotion management");
        breadcrumbItem2.setTo("http://www.baidu.com");
        EleFXBreadcrumbItem breadcrumbItem3 = new EleFXBreadcrumbItem("promotion list");
        EleFXBreadcrumbItem breadcrumbItem4 = new EleFXBreadcrumbItem("promotion detail");

        EleFXBreadcrumb breadcrumb = new EleFXBreadcrumb(breadcrumbItem1, breadcrumbItem2,
                breadcrumbItem3, breadcrumbItem4);
        breadcrumb.setSeparatorIcon(EleFXIcons.of(EleFXIconType.ARROW_RIGHT, 14));
        breadcrumb.setOnNavigate(event ->
                System.out.println(event.getItem().getTo())
        );

        // 2.content
        EleFXAvatar avatar = new EleFXAvatar();
        avatar.setSize(EleFXAvatarSize.SMALL);
        avatar.setAvatarShape(EleFXAvatarShape.CIRCLE);
        avatar.setSrc("https://pics2.baidu.com/feed/94cad1c8a786c9175363dab84d7c3edd3ac757a6.jpeg@f_auto?token=a79f9176239f5e1360aa5c6b877afa93");

        Label title = new Label("Title");

        Label subTitle = new Label("Sub title");

        EleFXTag tag = new EleFXTag("Tag 1", EleFXTagType.PRIMARY);
        tag.setSize(EleFXTagSize.SMALL);
        tag.setTagEffect(EleFXTagEffect.DARK);
        tag.setRound(true);

        HBox content = new HBox(avatar, title, subTitle, tag);
        content.setAlignment(Pos.CENTER);
        content.setSpacing(10);

        // 3.extra
        EleFXButton printBtn = new EleFXButton("Print");
        printBtn.setSize(EleFXButtonSize.SMALL);

        EleFXButton editBtn = new EleFXButton("Edit");
        editBtn.setSize(EleFXButtonSize.SMALL);

        HBox extra = new HBox(printBtn, editBtn);
        extra.setAlignment(Pos.CENTER);
        extra.setSpacing(10);

        // 4.default
        EleFXDescriptionsItem descriptionsItem1 = new EleFXDescriptionsItem("Username", new Label("kooriookami"));
        EleFXDescriptionsItem descriptionsItem2 = new EleFXDescriptionsItem("Telephone", new Label("18100000000"));
        EleFXDescriptionsItem descriptionsItem3 = new EleFXDescriptionsItem("Place", new Label("Suzhou"));
        EleFXDescriptionsItem descriptionsItem4 = new EleFXDescriptionsItem("Remarks", new Label("18100000000"));
        EleFXDescriptionsItem descriptionsItem5 = new EleFXDescriptionsItem("Address", new Label("No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province"));
        EleFXDescriptions descriptions = new EleFXDescriptions("User Info", descriptionsItem1, descriptionsItem2, descriptionsItem3, descriptionsItem4, descriptionsItem5);
        descriptions.setColumn(3);
        descriptions.setBorder(true);
        descriptions.setSize(EleFXDescriptionsSize.DEFAULT);

        EleFXText text = new EleFXText("""
                Element Plus team uses <b>weekly</b> release strategy under normal circumstance, but critical bug fixes would require hotfix so the actual release number <b>could be</b> more than 1 per week.
                """, EleFXTextType.WARNING);
        text.setSize(EleFXTextSize.SMALL);
        text.setTag(EleFXTextTag.BOLD);
        text.setWrapText(true);

        VBox pageHeaderDefault = new VBox(descriptions, text);

        // 5.组织结果
        EleFXPageHeader pageHeader = new EleFXPageHeader();
        pageHeader.setBreadcrumb(breadcrumb);
        pageHeader.setContent(content);
        pageHeader.setExtra(extra);
        pageHeader.setDefault(pageHeaderDefault);
//        pageHeader.setIcon(EleFXIcons.of(EleFXIconType.APPLE));
        pageHeader.setIcon(null);

        pageHeader.setOnBack(event -> {
            System.out.println(event.getSource());
        });

        vBox.getChildren().addAll(pageHeader);
    }

    private EleFXPageHeaderFiller() {}
}
