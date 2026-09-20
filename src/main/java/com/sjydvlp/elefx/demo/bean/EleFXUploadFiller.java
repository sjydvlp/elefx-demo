package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.upload.EleFXUpload;
import com.sjydvlp.elefx.component.upload.EleFXUploadListType;
import javafx.scene.layout.VBox;

/**
 * EleFXUploadFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXUploadFiller {

    public static void fill(VBox vBox) {
        EleFXUpload upload = new EleFXUpload();
        upload.setTipText("jpg/png files with a size less than 500KB.");
        upload.setLimit(2);
        upload.setListType(EleFXUploadListType.PICTURE);
        upload.setOnSuccess(e -> {
            System.out.println(e.getFiles().size());
        });
        upload.setDrag(true);

        vBox.getChildren().addAll(upload);
    }

    private EleFXUploadFiller() {}
}
