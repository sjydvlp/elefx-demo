package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.image.EleFXImage;
import com.sjydvlp.elefx.component.image.EleFXImageFit;
import com.sjydvlp.elefx.component.image.EleFXImageViewer;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * EleFXImageFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXImageFiller {

    public static void fill(VBox vBox, Stage stage) {
        String imageUrl = "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg";
        EleFXImage imageA = new EleFXImage(imageUrl);
        imageA.setPrefSize(100, 100);
        imageA.setFit(EleFXImageFit.FILL);
        imageA.setPreviewEnabled(true);
        imageA.setLazy(true);
        EleFXImage imageB = new EleFXImage(imageUrl);
        imageB.setPrefSize(100, 100);
        imageB.setFit(EleFXImageFit.CONTAIN);
        imageB.setLazy(true);
        EleFXImage imageC = new EleFXImage(imageUrl);
        imageC.setPrefSize(100, 100);
        imageC.setFit(EleFXImageFit.COVER);
        imageC.setLazy(true);
        EleFXImage imageD = new EleFXImage(imageUrl);
        imageD.setPrefSize(100, 100);
        imageD.setFit(EleFXImageFit.NONE);
        imageD.setLazy(true);
        EleFXImage imageE = new EleFXImage(imageUrl);
        imageE.setPrefSize(100, 100);
        imageE.setFit(EleFXImageFit.SCALE_DOWN);
        imageE.setLazy(true);
        HBox imageHbox = new HBox(imageA, imageB, imageC, imageD, imageE);
        VBox imageVbox = new VBox(imageA, imageB, imageC, imageD, imageE);
        EleFXScrollbar imageScrollbar = new EleFXScrollbar(imageVbox);
        imageScrollbar.setPrefHeight(100);

        String imageUrl1 = "https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg";
        String imageUrl2 = "https://empty";
        String imageUrl3 = "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png";

        EleFXImage image = new EleFXImage(imageUrl2);
        image.setPlaceholderNode(new Label("加载中..."));
        image.setErrorNode(new Label("加载失败"));
        image.setPreviewEnabled(true);
        image.getImageViewer().setPreviewSrcList(List.of(imageUrl1, imageUrl2, imageUrl3));
        image.getImageViewer().setShowProgress(true);
        image.getImageViewer().setErrorNode(new Label("加载失败"));

        EleFXImageViewer imageViewer = new EleFXImageViewer();
        imageViewer.setPreviewSrcList(List.of(imageUrl1, imageUrl2, imageUrl3));
        imageViewer.setErrorNode(new EleFXIcon(EleFXIconType.DOCUMENT_DELETE));

        EleFXButton imageViewerButton = new EleFXButton("preview controlled");
        imageViewerButton.setOnAction(event -> imageViewer.show(stage));


        vBox.getChildren().addAll(imageHbox, image, imageViewerButton, imageScrollbar);
    }

    private EleFXImageFiller() {}
}
