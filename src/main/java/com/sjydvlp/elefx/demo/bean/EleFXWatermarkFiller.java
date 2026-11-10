package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.checkbox.EleFXCheckbox;
import com.sjydvlp.elefx.component.colorpicker.EleFXColorFormat;
import com.sjydvlp.elefx.component.colorpicker.EleFXColorPicker;
import com.sjydvlp.elefx.component.form.EleFXForm;
import com.sjydvlp.elefx.component.form.EleFXFormItem;
import com.sjydvlp.elefx.component.form.EleFXFormLabelPosition;
import com.sjydvlp.elefx.component.input.EleFXInput;
import com.sjydvlp.elefx.component.inputnumber.EleFXInputNumber;
import com.sjydvlp.elefx.component.inputnumber.EleFXInputNumberControlsPosition;
import com.sjydvlp.elefx.component.slider.EleFXSlider;
import com.sjydvlp.elefx.component.watermark.EleFXWatermark;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * EleFXWatermarkFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXWatermarkFiller {

    public static void fill(VBox vBox) {
        EleFXWatermark basicUsageTest = basicUsageTest();
        EleFXWatermark multiLineWatermarkTest = multiLineWatermarkTest();
        EleFXWatermark imageWatermarkTest = imageWatermarkTest();
        HBox customConfigurationTest = customConfigurationTest();

        // vBox.getChildren().add(basicUsageTest);
        // vBox.getChildren().add(multiLineWatermarkTest);
        // vBox.getChildren().add(imageWatermarkTest);
        vBox.getChildren().add(customConfigurationTest);
        vBox.setSpacing(10);
    }

    private static EleFXWatermark basicUsageTest() {
        BooleanProperty isDark = new SimpleBooleanProperty(false);

        Pane content = new Pane();
        content.setMinHeight(500);
        content.setPrefHeight(500);
        content.setMaxHeight(500);
        content.setStyle("-fx-border-color: yellow;");

        EleFXWatermark watermark = new EleFXWatermark(content);

        watermark.getFont().colorProperty().bind(
                Bindings.when(isDark)
                        .then("rgba(255, 255, 255, 0.15)")
                        .otherwise("rgba(0, 0, 0, 0.15)"));

        watermark.styleProperty().bind(
                Bindings.when(isDark)
                        .then("-fx-background-color: #141414;")
                        .otherwise("-fx-background-color: white;"));

        // 设置为 true 切换到深色模式
        isDark.set(false);

        return watermark;
    }

    private static EleFXWatermark multiLineWatermarkTest() {
        BooleanProperty isDark = new SimpleBooleanProperty(false);

        Pane content = new Pane();
        content.setMinHeight(500);
        content.setPrefHeight(500);
        content.setMaxHeight(500);
        content.setStyle("-fx-border-color: yellow;");

        EleFXWatermark watermark = new EleFXWatermark(content);
        watermark.setContent("Element+", "Element Plus");

        watermark.getFont().colorProperty().bind(
                Bindings.when(isDark)
                        .then("rgba(255, 255, 255, 0.15)")
                        .otherwise("rgba(0, 0, 0, 0.15)"));

        watermark.styleProperty().bind(
                Bindings.when(isDark)
                        .then("-fx-background-color: #141414;")
                        .otherwise("-fx-background-color: white;"));

        // 改为 true 可预览深色模式
        isDark.set(false);

        return watermark;
    }

    private static EleFXWatermark imageWatermarkTest() {
        Pane content = new Pane();
        content.setMinHeight(500);
        content.setPrefHeight(500);
        content.setMaxHeight(500);
        content.setStyle("-fx-border-color: yellow;");

        EleFXWatermark watermark = new EleFXWatermark(content);
        watermark.setImage(
                Objects.requireNonNull(
                        EleFXWatermarkFiller.class.getResource("/logo_alt.png"),
                        "找不到水印图片").toExternalForm());
        watermark.setStyle("-fx-background-color: white;");

        return watermark;
    }

    private static HBox customConfigurationTest() {
        // 正文
        Label title = new Label("Element Plus");
        title.setStyle("-fx-font-size: 32px; -fx-font-weight: bold;");

        Label subtitle = new Label(
                "A Vue 3 based component library for designers and developers");
        subtitle.setWrapText(true);
        subtitle.setMinWidth(0);
        subtitle.setMaxWidth(Double.MAX_VALUE);
        subtitle.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        ImageView image = new ImageView(new Image(
                Objects.requireNonNull(
                        EleFXWatermarkFiller.class.getResource("/img/hamburger.png"),
                        "找不到 /img/hamburger.png").toExternalForm()));
        image.setPreserveRatio(true);

        VBox content = new VBox(20, title, subtitle, image);
        content.setMinWidth(0);
        content.setMinHeight(500);
        image.fitWidthProperty().bind(
                Bindings.min(300, content.widthProperty()));

        // 水印
        EleFXWatermark watermark = new EleFXWatermark(content);
        watermark.setMinWidth(0);
        watermark.setContent("Element Plus");
        watermark.setWatermarkRotate(-22);

        // Content
        EleFXInput contentInput = new EleFXInput();
        contentInput.setText("Element Plus");
        watermark.getContent().setAll(contentInput.getText());
        contentInput.textProperty().addListener(
                (observable, oldValue, value) -> watermark.setContent(value));

        // Color，支持透明度
        EleFXColorPicker colorPicker = new EleFXColorPicker();
        colorPicker.setShowAlpha(true);
        colorPicker.setClearable(false);
        colorPicker.setColorFormat(EleFXColorFormat.RGBA);
        colorPicker.setValue("rgba(0, 0, 0, 0.15)");
        watermark.getFont().colorProperty().bind(colorPicker.valueProperty());

        // FontSize
        EleFXSlider fontSize = new EleFXSlider();
        fontSize.setMin(0);
        fontSize.setMax(100);
        fontSize.setValue(16);
        watermark.getFont().fontSizeProperty().bind(fontSize.valueProperty());

        // Rotate
        EleFXSlider rotate = new EleFXSlider();
        rotate.setMin(-180);
        rotate.setMax(180);
        rotate.setValue(-22);
        watermark.watermarkRotateProperty().bind(rotate.valueProperty());

        // Gap
        EleFXInputNumber gapX = new EleFXInputNumber(100);
        EleFXInputNumber gapY = new EleFXInputNumber(100);

        for (EleFXInputNumber input : new EleFXInputNumber[] {gapX, gapY}) {
            input.setControlsPosition(EleFXInputNumberControlsPosition.RIGHT);
            input.setStyle("-fx-min-width: 0; -fx-pref-width: 0;");
            HBox.setHgrow(input, Priority.ALWAYS);
        }

        watermark.gapXProperty().bind(
                Bindings.createDoubleBinding(
                        () -> gapX.getValue() == null ? 100 : gapX.getValue(),
                        gapX.valueProperty()));
        watermark.gapYProperty().bind(
                Bindings.createDoubleBinding(
                        () -> gapY.getValue() == null ? 100 : gapY.getValue(),
                        gapY.valueProperty()));

        HBox gapInputs = new HBox(8, gapX, gapY);
        gapInputs.setMinWidth(0);

        // Offset：留空时使用默认值，即对应 gap 的一半
        EleFXInputNumber offsetX = new EleFXInputNumber();
        EleFXInputNumber offsetY = new EleFXInputNumber();

        offsetX.setPlaceholder("offsetLeft");
        offsetY.setPlaceholder("offsetTop");

        for (EleFXInputNumber input : new EleFXInputNumber[] {offsetX, offsetY}) {
            input.setValue(null);
            input.setControlsPosition(EleFXInputNumberControlsPosition.RIGHT);
            input.setStyle("-fx-min-width: 0; -fx-pref-width: 0;");
            HBox.setHgrow(input, Priority.ALWAYS);
        }

        watermark.offsetXProperty().bind(
                Bindings.createDoubleBinding(
                        () -> offsetX.getValue() == null
                                ? Double.NaN
                                : offsetX.getValue(),
                        offsetX.valueProperty()));
        watermark.offsetYProperty().bind(
                Bindings.createDoubleBinding(
                        () -> offsetY.getValue() == null
                                ? Double.NaN
                                : offsetY.getValue(),
                        offsetY.valueProperty()));

        HBox offsetInputs = new HBox(8, offsetX, offsetY);
        offsetInputs.setMinWidth(0);

        // 用复选框模拟 isDark
        EleFXCheckbox<Boolean> darkMode = new EleFXCheckbox<>("深色模式");
        darkMode.selectedProperty().addListener((observable, oldValue, dark) -> colorPicker.setValue(
                dark
                        ? "rgba(255, 255, 255, 0.15)"
                        : "rgba(0, 0, 0, 0.15)"));

        title.textFillProperty().bind(
                Bindings.when(darkMode.selectedProperty())
                        .then(Color.web("#E5EAF3"))
                        .otherwise(Color.web("#303133")));
        subtitle.textFillProperty().bind(title.textFillProperty());

        // 表单
        EleFXForm form = new EleFXForm(
                new EleFXFormItem("Content", contentInput),
                new EleFXFormItem("Color", colorPicker),
                new EleFXFormItem("FontSize", fontSize),
                new EleFXFormItem("Rotate", rotate),
                new EleFXFormItem("Gap", gapInputs),
                new EleFXFormItem("Offset", offsetInputs),
                new EleFXFormItem("Theme", darkMode));
        form.setLabelPosition(EleFXFormLabelPosition.TOP);
        form.setLabelWidth(50);
        form.setMinWidth(360);
        form.setPrefWidth(360);
        form.setMaxWidth(360);
        form.setStyle(
                "-fx-border-color: #eeeeee;" +
                        "-fx-border-width: 0 0 0 1px;" +
                        "-fx-padding: 0 0 0 20px;");

        HBox root = new HBox(20, watermark, form);
        root.setAlignment(Pos.TOP_LEFT);
        root.setPadding(new Insets(20));
        HBox.setHgrow(watermark, Priority.ALWAYS);

        root.styleProperty().bind(
                Bindings.when(darkMode.selectedProperty())
                        .then("-fx-background-color: #141414;")
                        .otherwise("-fx-background-color: white;"));

        return root;
    }

    private EleFXWatermarkFiller() {
    }
}
