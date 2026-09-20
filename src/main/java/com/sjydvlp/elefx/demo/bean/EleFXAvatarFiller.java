package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.avatar.*;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import javafx.scene.layout.VBox;

/**
 * EleFXAvatarFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXAvatarFiller {

    public static void fill(VBox vBox) {
        EleFXAvatar avatar1 = new EleFXAvatar();
        avatar1.setSize(EleFXAvatarSize.SMALL);
        avatar1.setAvatarShape(EleFXAvatarShape.CIRCLE);
        avatar1.setSrc("https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png");

        EleFXAvatar avatar2 = new EleFXAvatar();
        avatar2.setSize(EleFXAvatarSize.LARGE);
        avatar2.setAvatarShape(EleFXAvatarShape.SQUARE);
        avatar2.setSrc("https://pics2.baidu.com/feed/94cad1c8a786c9175363dab84d7c3edd3ac757a6.jpeg@f_auto?token=a79f9176239f5e1360aa5c6b877afa93");
        avatar2.setFit(EleFXAvatarFit.SCALE_DOWN);

        EleFXAvatar avatar3 = new EleFXAvatar();
//        avatar3.setIcon(new EleFXIcon(EleFXIconType.AIM));
//        avatar3.setSrc("https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png");
//        avatar3.setText("hello");
        avatar3.setSrc("http://empty");
        avatar3.setErrorIcon(new EleFXIcon(EleFXIconType.ADD_LOCATION));

        EleFXAvatarGroup avatarGroup = new EleFXAvatarGroup(
                new EleFXAvatar("A"),
                new EleFXAvatar("B"),
                new EleFXAvatar("C"),
                new EleFXAvatar("D"),
                new EleFXAvatar("E")
        );
        avatarGroup.setCollapseAvatars(true);
        avatarGroup.setCollapseStyle("-fx-background-color: #ff0000;");
        avatarGroup.setMaxCollapseAvatars(3);
        avatarGroup.setSize(EleFXAvatarSize.LARGE);
        avatarGroup.setCollapseAvatarsTooltip(true);
//        avatarGroup.setCollapseStyle();

        vBox.getChildren().addAll(avatar1, avatar2, avatar3, avatarGroup);
    }

    private EleFXAvatarFiller() {}
}
