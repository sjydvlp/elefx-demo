package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonGroup;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.radio.EleFXRadio;
import com.sjydvlp.elefx.component.radio.EleFXRadioGroup;
import com.sjydvlp.elefx.theme.EleFXThemes;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

/**
 * EleFXButtonFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXButtonFiller {

    public static void fill(VBox vBox) {
        VBox basisUsageTest = basisUsageTest();
        VBox disabledButtonTest = disabledButtonTest();
        VBox linkButtonTest = linkButtonTest();
        VBox textButtonTest = textButtonTest();
        FlowPane iconButtonTest = iconButtonTest();
        VBox buttonGroupTest = buttonGroupTest();
        FlowPane loadingButtonTest = loadingButtonTest();
        VBox sizesTest = sizesTest();

        // vBox.getChildren().add(basisUsageTest);
        // vBox.getChildren().add(disabledButtonTest);
        // vBox.getChildren().add(linkButtonTest);
        // vBox.getChildren().add(textButtonTest);
        vBox.getChildren().add(iconButtonTest);
        vBox.getChildren().add(buttonGroupTest);
        vBox.getChildren().add(loadingButtonTest);
        vBox.getChildren().add(sizesTest);
        vBox.setSpacing(20);
    }

    private static VBox basisUsageTest() {
        // 普通按钮
        FlowPane normalRow = new FlowPane(16, 16);
        normalRow.setAlignment(Pos.CENTER_LEFT);
        normalRow.getChildren().addAll(
                new EleFXButton("Default"),
                new EleFXButton("Primary", EleFXButtonType.PRIMARY),
                new EleFXButton("Success", EleFXButtonType.SUCCESS),
                new EleFXButton("Info", EleFXButtonType.INFO),
                new EleFXButton("Warning", EleFXButtonType.WARNING),
                new EleFXButton("Danger", EleFXButtonType.DANGER));

        // 朴素按钮
        FlowPane plainRow = new FlowPane(16, 16);
        plainRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton plainDefault = new EleFXButton("Plain");
        plainDefault.setPlain(true);

        EleFXButton plainPrimary = new EleFXButton("Primary", EleFXButtonType.PRIMARY);
        plainPrimary.setPlain(true);

        EleFXButton plainSuccess = new EleFXButton("Success", EleFXButtonType.SUCCESS);
        plainSuccess.setPlain(true);

        EleFXButton plainInfo = new EleFXButton("Info", EleFXButtonType.INFO);
        plainInfo.setPlain(true);

        EleFXButton plainWarning = new EleFXButton("Warning", EleFXButtonType.WARNING);
        plainWarning.setPlain(true);

        EleFXButton plainDanger = new EleFXButton("Danger", EleFXButtonType.DANGER);
        plainDanger.setPlain(true);

        plainRow.getChildren().addAll(
                plainDefault, plainPrimary, plainSuccess,
                plainInfo, plainWarning, plainDanger);

        // 圆角按钮
        FlowPane roundRow = new FlowPane(16, 16);
        roundRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton roundDefault = new EleFXButton("Round");
        roundDefault.setRound(true);

        EleFXButton roundPrimary = new EleFXButton("Primary", EleFXButtonType.PRIMARY);
        roundPrimary.setRound(true);

        EleFXButton roundSuccess = new EleFXButton("Success", EleFXButtonType.SUCCESS);
        roundSuccess.setRound(true);

        EleFXButton roundInfo = new EleFXButton("Info", EleFXButtonType.INFO);
        roundInfo.setRound(true);

        EleFXButton roundWarning = new EleFXButton("Warning", EleFXButtonType.WARNING);
        roundWarning.setRound(true);

        EleFXButton roundDanger = new EleFXButton("Danger", EleFXButtonType.DANGER);
        roundDanger.setRound(true);

        roundRow.getChildren().addAll(
                roundDefault, roundPrimary, roundSuccess,
                roundInfo, roundWarning, roundDanger);

        // 虚线按钮
        FlowPane dashedRow = new FlowPane(16, 16);
        dashedRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton dashedDefault = new EleFXButton("Dashed");
        dashedDefault.setDashed(true);

        EleFXButton dashedPrimary = new EleFXButton("Primary", EleFXButtonType.PRIMARY);
        dashedPrimary.setDashed(true);

        EleFXButton dashedSuccess = new EleFXButton("Success", EleFXButtonType.SUCCESS);
        dashedSuccess.setDashed(true);

        EleFXButton dashedInfo = new EleFXButton("Info", EleFXButtonType.INFO);
        dashedInfo.setDashed(true);

        EleFXButton dashedWarning = new EleFXButton("Warning", EleFXButtonType.WARNING);
        dashedWarning.setDashed(true);

        EleFXButton dashedDanger = new EleFXButton("Danger", EleFXButtonType.DANGER);
        dashedDanger.setDashed(true);

        dashedRow.getChildren().addAll(
                dashedDefault, dashedPrimary, dashedSuccess,
                dashedInfo, dashedWarning, dashedDanger);

        // 圆形图标按钮
        FlowPane circleRow = new FlowPane(16, 16);
        circleRow.setAlignment(Pos.CENTER_LEFT);
        circleRow.getChildren().addAll(
                new EleFXButton(
                        new EleFXIcon(EleFXIconType.SEARCH),
                        EleFXButtonType.DEFAULT, true),
                new EleFXButton(
                        new EleFXIcon(EleFXIconType.EDIT),
                        EleFXButtonType.PRIMARY, true),
                new EleFXButton(
                        new EleFXIcon(EleFXIconType.CHECK),
                        EleFXButtonType.SUCCESS, true),
                new EleFXButton(
                        new EleFXIcon(EleFXIconType.MESSAGE),
                        EleFXButtonType.INFO, true),
                new EleFXButton(
                        new EleFXIcon(EleFXIconType.STAR),
                        EleFXButtonType.WARNING, true),
                new EleFXButton(
                        new EleFXIcon(EleFXIconType.DELETE),
                        EleFXButtonType.DANGER, true));

        VBox root = new VBox(16);
        root.setPadding(new Insets(24));
        root.getChildren().addAll(
                normalRow, plainRow, roundRow, dashedRow, circleRow);

        return root;
    }

    private static VBox disabledButtonTest() {
        // 普通禁用按钮
        FlowPane normalRow = new FlowPane(16, 16);
        normalRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton normalDefault = new EleFXButton("Default");
        normalDefault.setDisable(true);

        EleFXButton normalPrimary = new EleFXButton("Primary", EleFXButtonType.PRIMARY);
        normalPrimary.setDisable(true);

        EleFXButton normalSuccess = new EleFXButton("Success", EleFXButtonType.SUCCESS);
        normalSuccess.setDisable(true);

        EleFXButton normalInfo = new EleFXButton("Info", EleFXButtonType.INFO);
        normalInfo.setDisable(true);

        EleFXButton normalWarning = new EleFXButton("Warning", EleFXButtonType.WARNING);
        normalWarning.setDisable(true);

        EleFXButton normalDanger = new EleFXButton("Danger", EleFXButtonType.DANGER);
        normalDanger.setDisable(true);

        normalRow.getChildren().addAll(
                normalDefault, normalPrimary, normalSuccess,
                normalInfo, normalWarning, normalDanger);

        // 朴素禁用按钮
        FlowPane plainRow = new FlowPane(16, 16);
        plainRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton plainDefault = new EleFXButton("Plain");
        plainDefault.setPlain(true);
        plainDefault.setDisable(true);

        EleFXButton plainPrimary = new EleFXButton("Primary", EleFXButtonType.PRIMARY);
        plainPrimary.setPlain(true);
        plainPrimary.setDisable(true);

        EleFXButton plainSuccess = new EleFXButton("Success", EleFXButtonType.SUCCESS);
        plainSuccess.setPlain(true);
        plainSuccess.setDisable(true);

        EleFXButton plainInfo = new EleFXButton("Info", EleFXButtonType.INFO);
        plainInfo.setPlain(true);
        plainInfo.setDisable(true);

        EleFXButton plainWarning = new EleFXButton("Warning", EleFXButtonType.WARNING);
        plainWarning.setPlain(true);
        plainWarning.setDisable(true);

        EleFXButton plainDanger = new EleFXButton("Danger", EleFXButtonType.DANGER);
        plainDanger.setPlain(true);
        plainDanger.setDisable(true);

        plainRow.getChildren().addAll(
                plainDefault, plainPrimary, plainSuccess,
                plainInfo, plainWarning, plainDanger);

        VBox root = new VBox(16);
        root.getChildren().addAll(normalRow, plainRow);
        return root;
    }

    private static VBox linkButtonTest() {
        // 普通链接按钮
        Label basicLabel = new Label("Basic link button");

        FlowPane basicRow = new FlowPane(12, 16);
        basicRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton basicDefault = new EleFXButton("plain");
        basicDefault.setLink(true);

        EleFXButton basicPrimary = new EleFXButton("primary", EleFXButtonType.PRIMARY);
        basicPrimary.setLink(true);

        EleFXButton basicSuccess = new EleFXButton("success", EleFXButtonType.SUCCESS);
        basicSuccess.setLink(true);

        EleFXButton basicInfo = new EleFXButton("info", EleFXButtonType.INFO);
        basicInfo.setLink(true);

        EleFXButton basicWarning = new EleFXButton("warning", EleFXButtonType.WARNING);
        basicWarning.setLink(true);

        EleFXButton basicDanger = new EleFXButton("danger", EleFXButtonType.DANGER);
        basicDanger.setLink(true);

        basicRow.getChildren().addAll(
                basicDefault, basicPrimary, basicSuccess,
                basicInfo, basicWarning, basicDanger);

        // 禁用链接按钮
        Label disabledLabel = new Label("Disabled link button");

        FlowPane disabledRow = new FlowPane(12, 16);
        disabledRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton disabledDefault = new EleFXButton("plain");
        disabledDefault.setLink(true);
        disabledDefault.setDisable(true);

        EleFXButton disabledPrimary = new EleFXButton("primary", EleFXButtonType.PRIMARY);
        disabledPrimary.setLink(true);
        disabledPrimary.setDisable(true);

        EleFXButton disabledSuccess = new EleFXButton("success", EleFXButtonType.SUCCESS);
        disabledSuccess.setLink(true);
        disabledSuccess.setDisable(true);

        EleFXButton disabledInfo = new EleFXButton("info", EleFXButtonType.INFO);
        disabledInfo.setLink(true);
        disabledInfo.setDisable(true);

        EleFXButton disabledWarning = new EleFXButton("warning", EleFXButtonType.WARNING);
        disabledWarning.setLink(true);
        disabledWarning.setDisable(true);

        EleFXButton disabledDanger = new EleFXButton("danger", EleFXButtonType.DANGER);
        disabledDanger.setLink(true);
        disabledDanger.setDisable(true);

        disabledRow.getChildren().addAll(
                disabledDefault, disabledPrimary, disabledSuccess,
                disabledInfo, disabledWarning, disabledDanger);

        VBox root = new VBox(16);
        root.getChildren().addAll(
                basicLabel, basicRow,
                disabledLabel, disabledRow);

        return root;
    }

    private static VBox textButtonTest() {
        // 基础文字按钮
        Label basicLabel = new Label("Basic text button");
        FlowPane basicRow = new FlowPane(12, 16);
        basicRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton basicDefault = new EleFXButton("plain");
        basicDefault.setTextButton(true);

        EleFXButton basicPrimary = new EleFXButton("primary", EleFXButtonType.PRIMARY);
        basicPrimary.setTextButton(true);

        EleFXButton basicSuccess = new EleFXButton("success", EleFXButtonType.SUCCESS);
        basicSuccess.setTextButton(true);

        EleFXButton basicInfo = new EleFXButton("info", EleFXButtonType.INFO);
        basicInfo.setTextButton(true);

        EleFXButton basicWarning = new EleFXButton("warning", EleFXButtonType.WARNING);
        basicWarning.setTextButton(true);

        EleFXButton basicDanger = new EleFXButton("danger", EleFXButtonType.DANGER);
        basicDanger.setTextButton(true);

        basicRow.getChildren().addAll(
                basicDefault, basicPrimary, basicSuccess,
                basicInfo, basicWarning, basicDanger);

        // 始终显示背景的文字按钮
        Label backgroundLabel = new Label("Background color always on");
        FlowPane backgroundRow = new FlowPane(12, 16);
        backgroundRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton backgroundDefault = new EleFXButton("plain");
        backgroundDefault.setTextButton(true);
        backgroundDefault.setTextBackground(true);

        EleFXButton backgroundPrimary = new EleFXButton("primary", EleFXButtonType.PRIMARY);
        backgroundPrimary.setTextButton(true);
        backgroundPrimary.setTextBackground(true);

        EleFXButton backgroundSuccess = new EleFXButton("success", EleFXButtonType.SUCCESS);
        backgroundSuccess.setTextButton(true);
        backgroundSuccess.setTextBackground(true);

        EleFXButton backgroundInfo = new EleFXButton("info", EleFXButtonType.INFO);
        backgroundInfo.setTextButton(true);
        backgroundInfo.setTextBackground(true);

        EleFXButton backgroundWarning = new EleFXButton("warning", EleFXButtonType.WARNING);
        backgroundWarning.setTextButton(true);
        backgroundWarning.setTextBackground(true);

        EleFXButton backgroundDanger = new EleFXButton("danger", EleFXButtonType.DANGER);
        backgroundDanger.setTextButton(true);
        backgroundDanger.setTextBackground(true);

        backgroundRow.getChildren().addAll(
                backgroundDefault, backgroundPrimary, backgroundSuccess,
                backgroundInfo, backgroundWarning, backgroundDanger);

        // 禁用文字按钮
        Label disabledLabel = new Label("Disabled text button");
        FlowPane disabledRow = new FlowPane(12, 16);
        disabledRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton disabledDefault = new EleFXButton("plain");
        disabledDefault.setTextButton(true);
        disabledDefault.setDisable(true);

        EleFXButton disabledPrimary = new EleFXButton("primary", EleFXButtonType.PRIMARY);
        disabledPrimary.setTextButton(true);
        disabledPrimary.setDisable(true);

        EleFXButton disabledSuccess = new EleFXButton("success", EleFXButtonType.SUCCESS);
        disabledSuccess.setTextButton(true);
        disabledSuccess.setDisable(true);

        EleFXButton disabledInfo = new EleFXButton("info", EleFXButtonType.INFO);
        disabledInfo.setTextButton(true);
        disabledInfo.setDisable(true);

        EleFXButton disabledWarning = new EleFXButton("warning", EleFXButtonType.WARNING);
        disabledWarning.setTextButton(true);
        disabledWarning.setDisable(true);

        EleFXButton disabledDanger = new EleFXButton("danger", EleFXButtonType.DANGER);
        disabledDanger.setTextButton(true);
        disabledDanger.setDisable(true);

        disabledRow.getChildren().addAll(
                disabledDefault, disabledPrimary, disabledSuccess,
                disabledInfo, disabledWarning, disabledDanger);

        VBox root = new VBox(16);
        root.getChildren().addAll(
                basicLabel, basicRow,
                backgroundLabel, backgroundRow,
                disabledLabel, disabledRow);

        return root;
    }

    private static FlowPane iconButtonTest() {
        EleFXButton editButton = new EleFXButton(
                new EleFXIcon(EleFXIconType.EDIT),
                EleFXButtonType.PRIMARY);

        EleFXButton shareButton = new EleFXButton(
                new EleFXIcon(EleFXIconType.SHARE),
                EleFXButtonType.PRIMARY);

        EleFXButton deleteButton = new EleFXButton(
                new EleFXIcon(EleFXIconType.DELETE),
                EleFXButtonType.PRIMARY);

        EleFXButton searchButton = new EleFXButton(
                "Search",
                new EleFXIcon(EleFXIconType.SEARCH),
                EleFXButtonType.PRIMARY);

        EleFXButton uploadButton = new EleFXButton(
                "Upload",
                new EleFXIcon(EleFXIconType.UPLOAD),
                EleFXButtonType.PRIMARY);
        uploadButton.setContentDisplay(ContentDisplay.RIGHT);

        FlowPane root = new FlowPane(12, 16);
        root.setAlignment(Pos.CENTER_LEFT);
        root.setPadding(new Insets(24));
        root.getChildren().addAll(
                editButton, shareButton, deleteButton,
                searchButton, uploadButton);

        return root;
    }

    private static VBox buttonGroupTest() {
        // 上一页、下一页按钮组
        EleFXButton previousButton = new EleFXButton(
                "Previous Page",
                new EleFXIcon(EleFXIconType.ARROW_LEFT),
                EleFXButtonType.PRIMARY);

        EleFXButton nextButton = new EleFXButton(
                "Next Page",
                new EleFXIcon(EleFXIconType.ARROW_RIGHT),
                EleFXButtonType.PRIMARY);
        nextButton.setContentDisplay(ContentDisplay.RIGHT);

        EleFXButtonGroup pageGroup = new EleFXButtonGroup(
                previousButton, nextButton);

        // 方向选择
        EleFXRadio<Orientation> horizontalRadio = new EleFXRadio<>(
                "Horizontal", Orientation.HORIZONTAL);
        EleFXRadio<Orientation> verticalRadio = new EleFXRadio<>(
                "Vertical", Orientation.VERTICAL);

        EleFXRadioGroup<Orientation> directionGroup = new EleFXRadioGroup<>(
                horizontalRadio, verticalRadio);
        directionGroup.setValue(Orientation.HORIZONTAL);

        // 可切换方向的图标按钮组
        EleFXButton houseButton = new EleFXButton(
                new EleFXIcon(EleFXIconType.HOUSE),
                EleFXButtonType.PRIMARY);

        EleFXButton operationButton = new EleFXButton(
                new EleFXIcon(EleFXIconType.OPERATION),
                EleFXButtonType.PRIMARY);

        EleFXButton notificationButton = new EleFXButton(
                new EleFXIcon(EleFXIconType.NOTIFICATION),
                EleFXButtonType.PRIMARY);

        EleFXButtonGroup iconGroup = new EleFXButtonGroup(
                houseButton, operationButton, notificationButton);
        iconGroup.directionProperty().bind(directionGroup.valueProperty());

        VBox root = new VBox(16);
        root.setPadding(new Insets(24));
        root.setAlignment(Pos.TOP_LEFT);
        root.getChildren().addAll(pageGroup, directionGroup, iconGroup);

        return root;
    }

    private static FlowPane loadingButtonTest() {
        FlowPane root = new FlowPane(12, 16);
        root.setAlignment(Pos.CENTER_LEFT);
        root.setPadding(new Insets(24));
        root.getStylesheets().add(EleFXThemes.DEFAULT.toData());

        // 默认加载指示器
        EleFXButton defaultButton = new EleFXButton(
                "Loading", EleFXButtonType.PRIMARY);
        defaultButton.setLoading(true);

        // 自定义 Eleme 加载图标
        EleFXIcon elemeIcon = new EleFXIcon(EleFXIconType.ELEME, 14);
        elemeIcon.setLoading(true);

        EleFXButton elemeButton = new EleFXButton(
                "Loading", EleFXButtonType.PRIMARY);
        elemeButton.setLoadingGraphic(elemeIcon);
        elemeButton.setLoading(true);

        // 自定义 SVG 加载指示器
        SVGPath path = new SVGPath();
        path.setContent(
                "M 30 15 "
                        + "L 28 17 "
                        + "M 25.61 25.61 "
                        + "A 15 15 0 0 1 15 30 "
                        + "A 15 15 0 1 1 27.99 7.5 "
                        + "L 15 15");
        path.setFill(Color.TRANSPARENT);
        path.setStroke(Color.WHITE);
        path.setStrokeWidth(4);
        path.setStrokeLineCap(StrokeLineCap.ROUND);
        path.getStrokeDashArray().setAll(90.0, 150.0);

        // 对应 SVG 的 viewBox=\"-10 -10 50 50\"，缩放至 18 × 18。
        Group svg = new Group(path);
        svg.setClip(new Rectangle(-10, -10, 50, 50));

        Group viewport = new Group(svg);
        svg.setTranslateX(10);
        svg.setTranslateY(10);
        viewport.getTransforms().add(new Scale(18.0 / 50, 18.0 / 50));

        Pane customLoading = new Pane(viewport);
        customLoading.setMinSize(18, 18);
        customLoading.setPrefSize(18, 18);
        customLoading.setMaxSize(18, 18);
        customLoading.setMouseTransparent(true);

        RotateTransition rotation = new RotateTransition(
                Duration.seconds(2), customLoading);
        rotation.setAxis(Rotate.Z_AXIS);
        rotation.setByAngle(360);
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.setCycleCount(Animation.INDEFINITE);

        Timeline dash = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(path.strokeDashOffsetProperty(), 0)),
                new KeyFrame(
                        Duration.seconds(0.75),
                        new KeyValue(
                                path.strokeDashOffsetProperty(),
                                -60,
                                Interpolator.EASE_BOTH)),
                new KeyFrame(
                        Duration.seconds(1.5),
                        new KeyValue(
                                path.strokeDashOffsetProperty(),
                                -240,
                                Interpolator.EASE_BOTH)));
        dash.setCycleCount(Animation.INDEFINITE);

        EleFXButton customButton = new EleFXButton(
                "Loading", EleFXButtonType.PRIMARY);
        customButton.setLoadingGraphic(customLoading);
        customButton.setLoading(true);

        // 加入场景后播放，移出场景后停止。
        customLoading.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene == null) {
                rotation.stop();
                dash.stop();
            } else {
                rotation.play();
                dash.play();
            }
        });

        root.getChildren().addAll(defaultButton, elemeButton, customButton);
        return root;
    }

    private static VBox sizesTest() {
        VBox root = new VBox(16);
        root.setPadding(new Insets(24));
        root.getStylesheets().add(EleFXThemes.DEFAULT.toData());

        // 普通按钮
        FlowPane normalRow = new FlowPane(12, 16);
        normalRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton largeButton = new EleFXButton("Large");
        largeButton.setSize(EleFXButtonSize.LARGE);

        EleFXButton defaultButton = new EleFXButton("Default");

        EleFXButton smallButton = new EleFXButton("Small");
        smallButton.setSize(EleFXButtonSize.SMALL);

        EleFXButton largeSearch = new EleFXButton(
                "Search", new EleFXIcon(EleFXIconType.SEARCH, 14));
        largeSearch.setSize(EleFXButtonSize.LARGE);

        EleFXButton defaultSearch = new EleFXButton(
                "Search", new EleFXIcon(EleFXIconType.SEARCH, 14));

        EleFXButton smallSearch = new EleFXButton(
                "Search", new EleFXIcon(EleFXIconType.SEARCH, 12));
        smallSearch.setSize(EleFXButtonSize.SMALL);

        normalRow.getChildren().addAll(
                largeButton, defaultButton, smallButton,
                largeSearch, defaultSearch, smallSearch);

        // 圆角按钮
        FlowPane roundRow = new FlowPane(12, 16);
        roundRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton largeRound = new EleFXButton("Large");
        largeRound.setSize(EleFXButtonSize.LARGE);
        largeRound.setRound(true);

        EleFXButton defaultRound = new EleFXButton("Default");
        defaultRound.setRound(true);

        EleFXButton smallRound = new EleFXButton("Small");
        smallRound.setSize(EleFXButtonSize.SMALL);
        smallRound.setRound(true);

        EleFXButton largeRoundSearch = new EleFXButton(
                "Search", new EleFXIcon(EleFXIconType.SEARCH, 14));
        largeRoundSearch.setSize(EleFXButtonSize.LARGE);
        largeRoundSearch.setRound(true);

        EleFXButton defaultRoundSearch = new EleFXButton(
                "Search", new EleFXIcon(EleFXIconType.SEARCH, 14));
        defaultRoundSearch.setRound(true);

        EleFXButton smallRoundSearch = new EleFXButton(
                "Search", new EleFXIcon(EleFXIconType.SEARCH, 12));
        smallRoundSearch.setSize(EleFXButtonSize.SMALL);
        smallRoundSearch.setRound(true);

        roundRow.getChildren().addAll(
                largeRound, defaultRound, smallRound,
                largeRoundSearch, defaultRoundSearch, smallRoundSearch);

        // 圆形图标按钮
        FlowPane circleRow = new FlowPane(12, 16);
        circleRow.setAlignment(Pos.CENTER_LEFT);

        EleFXButton largeCircle = new EleFXButton(
                new EleFXIcon(EleFXIconType.SEARCH, 14),
                EleFXButtonType.DEFAULT,
                true);
        largeCircle.setSize(EleFXButtonSize.LARGE);

        EleFXButton defaultCircle = new EleFXButton(
                new EleFXIcon(EleFXIconType.SEARCH, 14),
                EleFXButtonType.DEFAULT,
                true);

        EleFXButton smallCircle = new EleFXButton(
                new EleFXIcon(EleFXIconType.SEARCH, 12),
                EleFXButtonType.DEFAULT,
                true);
        smallCircle.setSize(EleFXButtonSize.SMALL);

        circleRow.getChildren().addAll(
                largeCircle, defaultCircle, smallCircle);

        root.getChildren().addAll(normalRow, roundRow, circleRow);
        return root;
    }

    private EleFXButtonFiller() {
    }
}
