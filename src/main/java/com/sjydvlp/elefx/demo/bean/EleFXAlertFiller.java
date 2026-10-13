package com.sjydvlp.elefx.demo.bean;

import cn.hutool.core.thread.ThreadUtil;
import com.sjydvlp.elefx.component.alert.EleFXAlert;
import com.sjydvlp.elefx.component.alert.EleFXAlertEffect;
import com.sjydvlp.elefx.component.alert.EleFXAlertType;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import javafx.scene.layout.VBox;

/**
 * EleFXAlertFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXAlertFiller {

    public static void fill(VBox vBox) {
        VBox basisUsageTest = basisUsageTest();
        VBox themeTest = themeTest();
        VBox closeBtnTest = closeBtnTest();
        VBox showIconTest = showIconTest();
        VBox centeredTextTest = centeredTextTest();
        VBox withDescTest = withDescTest();

        vBox.getChildren().add(basisUsageTest);
//        vBox.getChildren().add(themeTest);
//        vBox.getChildren().add(closeBtnTest);
//        vBox.getChildren().add(showIconTest);
//        vBox.getChildren().add(centeredTextTest);
        vBox.getChildren().add(withDescTest);
        vBox.setSpacing(20);
    }

    private static VBox basisUsageTest() {
        EleFXAlert alert1 = new EleFXAlert("Primary alert", EleFXAlertType.PRIMARY);
        EleFXAlert alert2 = new EleFXAlert("Success alert", EleFXAlertType.SUCCESS);
        EleFXAlert alert3 = new EleFXAlert("Info alert", EleFXAlertType.INFO);
        EleFXAlert alert4 = new EleFXAlert("Warning alert", EleFXAlertType.WARNING);
        EleFXAlert alert5 = new EleFXAlert("Error alert", EleFXAlertType.ERROR);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(alert1, alert2, alert3, alert4, alert5);
//        vBox.setMaxWidth(600);
        return vBox;
    }

    private static VBox themeTest() {
        EleFXAlert alert1 = new EleFXAlert("Primary alert", EleFXAlertType.PRIMARY);
        alert1.setAlertEffect(EleFXAlertEffect.DARK);
        EleFXAlert alert2 = new EleFXAlert("Success alert", EleFXAlertType.SUCCESS);
        alert2.setAlertEffect(EleFXAlertEffect.DARK);
        EleFXAlert alert3 = new EleFXAlert("Info alert", EleFXAlertType.INFO);
        alert3.setAlertEffect(EleFXAlertEffect.DARK);
        EleFXAlert alert4 = new EleFXAlert("Warning alert", EleFXAlertType.WARNING);
        alert4.setAlertEffect(EleFXAlertEffect.DARK);
        EleFXAlert alert5 = new EleFXAlert("Error alert", EleFXAlertType.ERROR);
        alert5.setAlertEffect(EleFXAlertEffect.DARK);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(alert1, alert2, alert3, alert4, alert5);
        return vBox;
    }

    private static VBox closeBtnTest() {
        EleFXAlert alert1 = new EleFXAlert("Unclosable alert", EleFXAlertType.PRIMARY);
        alert1.setClosable(false);
        EleFXAlert alert2 = new EleFXAlert("Customized close text", EleFXAlertType.SUCCESS);
        alert2.setCloseText("Gotcha");
        EleFXAlert alert3 = new EleFXAlert("Alert with callback", EleFXAlertType.INFO);
        alert3.setOnClose(event -> {
            System.out.println("Hello World!");
            ThreadUtil.sleep(2000);
        });

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(alert1, alert2, alert3);
        return vBox;
    }

    private static VBox showIconTest() {
        EleFXAlert alert1 = new EleFXAlert("Primary alert", EleFXAlertType.PRIMARY);
        alert1.setShowIcon(true);
        EleFXAlert alert2 = new EleFXAlert("Success alert", EleFXAlertType.SUCCESS);
        alert2.setShowIcon(true);
        EleFXAlert alert3 = new EleFXAlert("Info alert", EleFXAlertType.INFO);
        alert3.setShowIcon(true);
        EleFXAlert alert4 = new EleFXAlert("Warning alert", EleFXAlertType.WARNING);
        alert4.setShowIcon(true);
        EleFXAlert alert5 = new EleFXAlert("Error alert", EleFXAlertType.ERROR);
        alert5.setShowIcon(true);
        EleFXAlert alert6 = new EleFXAlert("Error alert with custom icon", EleFXAlertType.ERROR);
        alert6.setShowIcon(true);
        alert6.setIconNode(EleFXIcons.of(EleFXIconType.APPLE));

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(alert1, alert2, alert3, alert4, alert5, alert6);
        return vBox;
    }

    private static VBox centeredTextTest() {
        EleFXAlert alert1 = new EleFXAlert("Primary alert", EleFXAlertType.PRIMARY);
        alert1.setShowIcon(true);
        alert1.setCenter(true);
        EleFXAlert alert2 = new EleFXAlert("Success alert", EleFXAlertType.SUCCESS);
        alert2.setShowIcon(true);
        alert2.setCenter(true);
        EleFXAlert alert3 = new EleFXAlert("Info alert", EleFXAlertType.INFO);
        alert3.setShowIcon(true);
        alert3.setCenter(true);
        EleFXAlert alert4 = new EleFXAlert("Warning alert", EleFXAlertType.WARNING);
        alert4.setShowIcon(true);
        alert4.setCenter(true);
        EleFXAlert alert5 = new EleFXAlert("Error alert", EleFXAlertType.ERROR);
        alert5.setShowIcon(true);
        alert5.setCenter(true);
        EleFXAlert alert6 = new EleFXAlert("Error alert with custom icon", EleFXAlertType.ERROR);
        alert6.setShowIcon(true);
        alert6.setCenter(true);
        alert6.setIconNode(EleFXIcons.of(EleFXIconType.APPLE));

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(alert1, alert2, alert3, alert4, alert5, alert6);
        return vBox;
    }

    private static VBox withDescTest() {
        EleFXAlert alert1 = new EleFXAlert("Primary alert", EleFXAlertType.PRIMARY);
        alert1.setShowIcon(true);
        alert1.setCenter(true);
        EleFXAlert alert2 = new EleFXAlert("Success alert", EleFXAlertType.SUCCESS);
        alert2.setShowIcon(false);
//        alert2.setCenter(true);
        alert2.setDescription("This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.");
        EleFXAlert alert3 = new EleFXAlert("Info alert", EleFXAlertType.INFO);
        alert3.setShowIcon(true);
//        alert3.setCenter(true);
        alert3.setDescription("This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.This is a description.");


        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(alert1, alert2, alert3);
        return vBox;
    }

    private EleFXAlertFiller() {}
}
