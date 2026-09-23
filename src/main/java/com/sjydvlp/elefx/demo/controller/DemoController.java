package com.sjydvlp.elefx.demo.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import com.sjydvlp.elefx.demo.bean.EleFXBacktopFiller;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DemoController implements Initializable {

    private final Stage stage;

    private double lastMouseX;

    private double lastMouseY;

    private boolean dragging;

    @FXML
    private HBox windowHeader;

    @FXML
    private VBox navBar;

    @FXML
    private StackPane contentPane;

    @FXML
    private StackPane logoContainer;

    public DemoController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        windowHeader.setOnMouseDragged(event -> {
            double mouseX = event.getScreenX();
            double mouseY = event.getScreenY();

            if (!dragging) {
                dragging = true;
                lastMouseX = mouseX;
                lastMouseY = mouseY;
                return;
            }

            stage.setX(stage.getX() + mouseX - lastMouseX);
            stage.setY(stage.getY() + mouseY - lastMouseY);

            lastMouseX = mouseX;
            lastMouseY = mouseY;
        });
        windowHeader.setOnMouseReleased(event -> {
            dragging = false;
        });

        initializeLoader();

        // The only way to get a fucking smooth image in this shitty framework
        Image image = new Image(ResourceUtil.getStream("logo_alt.png"), 64, 64, true, true);
        ImageView logo = new ImageView(image);
        Circle clip = new Circle(30);
        clip.centerXProperty().bind(
                Bindings.createDoubleBinding(
                        () -> logo.getLayoutBounds().getCenterX(),
                        logo.layoutBoundsProperty()));
        clip.centerYProperty().bind(
                Bindings.createDoubleBinding(
                        () -> logo.getLayoutBounds().getCenterY(),
                        logo.layoutBoundsProperty()));
        logo.setClip(clip);
        logoContainer.getChildren().add(logo);
    }

    private void initializeLoader() {
        // 添加
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.setStyle("-fx-border-color: #ff0000;");

//        EleFXButtonFiller.fill(vBox);
//        EleFXRowFiller.fill(vBox);
//        EleFXContainerFiller.fill(vBox);
//        EleFXLinkFiller.fill(vBox);
//        EleFXTextFiller.fill(vBox);
//        EleFXScrollbarFiller.fill(vBox);
//        EleFXSpaceFiller.fill(vBox);
//        EleFXSplitterFiller.fill(vBox);
//        EleFXTypographyFiller.fill(vBox);
//        EleFXAutocompleteFiller.fill(vBox);
//        EleFXCascaderFiller.fill(vBox);
//        EleFXCheckboxFiller.fill(vBox);
//        EleFXColorPickerPanelFiller.fill(vBox);
//        EleFXColorPickerFiller.fill(vBox);
//        EleFXDatePickerPanelFiller.fill(vBox);
//        EleFXDatePickerFiller.fill(vBox);
//        EleFXFormFiller.fill(vBox);
//        EleFXSelectFiller.fill(vBox);
//        EleFXInputFiller.fill(vBox);
//        EleFXInputNumberFiller.fill(vBox);
//        EleFXRadioFiller.fill(vBox);
//        EleFXRateFiller.fill(vBox);
//        EleFXSliderFiller.fill(vBox);
//        EleFXSwitchFiller.fill(vBox);
//        EleFXTransferFiller.fill(vBox);
//        EleFXUploadFiller.fill(vBox);
//        EleFXAvatarFiller.fill(vBox);
//        EleFXCardFiller.fill(vBox);
//        EleFXCarouselFiller.fill(vBox);
//        EleFXCollapseFiller.fill(vBox);
//        EleFXDescriptionsFiller.fill(vBox);
//        EleFXEmptyFiller.fill(vBox);
//        EleFXImageFiller.fill(vBox, stage);
//        EleFXPaginationFiller.fill(vBox);
//        EleFXProgressFiller.fill(vBox);
//        EleFXResultFiller.fill(vBox);
//        EleFXSkeletonFiller.fill(vBox);
//        EleFXTagFiller.fill(vBox);
//        EleFXTimelineFiller.fill(vBox);
//        EleFXStatisticFiller.fill(vBox);
//        EleFXSegmentedFiller.fill(vBox);
//        EleFXAffixFiller.fill(vBox);
//        EleFXAnchorFiller.fill(vBox);
        EleFXBacktopFiller.fill(vBox);

        contentPane.setPadding(new Insets(30));
        contentPane.getChildren().add(vBox);
    }
}
