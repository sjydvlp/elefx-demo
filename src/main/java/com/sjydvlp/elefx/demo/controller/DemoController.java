package com.sjydvlp.elefx.demo.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Tuple;
import com.sjydvlp.elefx.component.affix.EleFXAffix;
import com.sjydvlp.elefx.component.affix.EleFXAffixPosition;
import com.sjydvlp.elefx.component.autocomplete.EleFXAutocomplete;
import com.sjydvlp.elefx.component.avatar.*;
import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.card.EleFXCard;
import com.sjydvlp.elefx.component.card.EleFXCardShadow;
import com.sjydvlp.elefx.component.carousel.*;
import com.sjydvlp.elefx.component.cascader.EleFXCascader;
import com.sjydvlp.elefx.component.cascader.EleFXCascaderOption;
import com.sjydvlp.elefx.component.checkbox.EleFXCheckbox;
import com.sjydvlp.elefx.component.checkbox.EleFXCheckboxButton;
import com.sjydvlp.elefx.component.checkbox.EleFXCheckboxGroup;
import com.sjydvlp.elefx.component.collapse.EleFXCollapse;
import com.sjydvlp.elefx.component.collapse.EleFXCollapseItem;
import com.sjydvlp.elefx.component.colorpicker.EleFXColorPicker;
import com.sjydvlp.elefx.component.colorpickerpanel.EleFXColorPickerPanel;
import com.sjydvlp.elefx.component.container.*;
import com.sjydvlp.elefx.component.datepicker.EleFXDatePicker;
import com.sjydvlp.elefx.component.datepicker.EleFXDatePickerType;
import com.sjydvlp.elefx.component.datepickerpanel.EleFXDatePickerPanel;
import com.sjydvlp.elefx.component.datepickerpanel.EleFXDatePickerPanelType;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptions;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptionsDirection;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptionsItem;
import com.sjydvlp.elefx.component.descriptions.EleFXDescriptionsSize;
import com.sjydvlp.elefx.component.empty.EleFXEmpty;
import com.sjydvlp.elefx.component.form.EleFXForm;
import com.sjydvlp.elefx.component.form.EleFXFormItem;
import com.sjydvlp.elefx.component.form.EleFXFormLabelPosition;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.image.EleFXImage;
import com.sjydvlp.elefx.component.image.EleFXImageFit;
import com.sjydvlp.elefx.component.image.EleFXImageViewer;
import com.sjydvlp.elefx.component.infinitescroll.EleFXInfiniteScroll;
import com.sjydvlp.elefx.component.input.EleFXInput;
import com.sjydvlp.elefx.component.input.EleFXInputSize;
import com.sjydvlp.elefx.component.input.EleFXInputType;
import com.sjydvlp.elefx.component.inputnumber.EleFXInputNumber;
import com.sjydvlp.elefx.component.inputnumber.EleFXInputNumberControlsPosition;
import com.sjydvlp.elefx.component.inputnumber.EleFXInputNumberSize;
import com.sjydvlp.elefx.component.layout.EleFXCol;
import com.sjydvlp.elefx.component.layout.EleFXRow;
import com.sjydvlp.elefx.component.layout.EleFXRowAlign;
import com.sjydvlp.elefx.component.layout.EleFXRowJustify;
import com.sjydvlp.elefx.component.link.EleFXLink;
import com.sjydvlp.elefx.component.link.EleFXLinkType;
import com.sjydvlp.elefx.component.link.EleFXLinkUnderline;
import com.sjydvlp.elefx.component.pagination.EleFXPagination;
import com.sjydvlp.elefx.component.pagination.EleFXPaginationLayout;
import com.sjydvlp.elefx.component.pagination.EleFXPaginationSize;
import com.sjydvlp.elefx.component.progress.EleFXProgress;
import com.sjydvlp.elefx.component.progress.EleFXProgressColorStop;
import com.sjydvlp.elefx.component.progress.EleFXProgressStatus;
import com.sjydvlp.elefx.component.progress.EleFXProgressType;
import com.sjydvlp.elefx.component.radio.EleFXRadio;
import com.sjydvlp.elefx.component.radio.EleFXRadioButton;
import com.sjydvlp.elefx.component.radio.EleFXRadioGroup;
import com.sjydvlp.elefx.component.radio.EleFXRadioSize;
import com.sjydvlp.elefx.component.rate.EleFXRate;
import com.sjydvlp.elefx.component.rate.EleFXRateSize;
import com.sjydvlp.elefx.component.result.EleFXResult;
import com.sjydvlp.elefx.component.result.EleFXResultIcon;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import com.sjydvlp.elefx.component.segmented.EleFXSegmented;
import com.sjydvlp.elefx.component.segmented.EleFXSegmentedDirection;
import com.sjydvlp.elefx.component.segmented.EleFXSegmentedItem;
import com.sjydvlp.elefx.component.select.EleFXSelect;
import com.sjydvlp.elefx.component.select.EleFXSelectOption;
import com.sjydvlp.elefx.component.select.EleFXSelectOptionGroup;
import com.sjydvlp.elefx.component.select.EleFXSelectSize;
import com.sjydvlp.elefx.component.skeleton.EleFXSkeleton;
import com.sjydvlp.elefx.component.skeleton.EleFXSkeletonItem;
import com.sjydvlp.elefx.component.skeleton.EleFXSkeletonItemVariant;
import com.sjydvlp.elefx.component.slider.EleFXSlider;
import com.sjydvlp.elefx.component.slider.EleFXSliderMark;
import com.sjydvlp.elefx.component.slider.EleFXSliderSize;
import com.sjydvlp.elefx.component.slider.EleFXSliderTooltipPlacement;
import com.sjydvlp.elefx.component.space.EleFXSpace;
import com.sjydvlp.elefx.component.splitter.EleFXSplitter;
import com.sjydvlp.elefx.component.splitter.EleFXSplitterPanel;
import com.sjydvlp.elefx.component.statistic.EleFXCountdown;
import com.sjydvlp.elefx.component.statistic.EleFXStatistic;
import com.sjydvlp.elefx.component.switcher.EleFXSwitch;
import com.sjydvlp.elefx.component.tag.EleFXTag;
import com.sjydvlp.elefx.component.tag.EleFXTagEffect;
import com.sjydvlp.elefx.component.tag.EleFXTagSize;
import com.sjydvlp.elefx.component.tag.EleFXTagType;
import com.sjydvlp.elefx.component.text.EleFXText;
import com.sjydvlp.elefx.component.text.EleFXTextSize;
import com.sjydvlp.elefx.component.text.EleFXTextTag;
import com.sjydvlp.elefx.component.text.EleFXTextType;
import com.sjydvlp.elefx.component.timeline.*;
import com.sjydvlp.elefx.component.transfer.EleFXTransfer;
import com.sjydvlp.elefx.component.transfer.EleFXTransferItem;
import com.sjydvlp.elefx.component.typography.EleFXTypography;
import com.sjydvlp.elefx.component.typography.EleFXTypographySize;
import com.sjydvlp.elefx.component.upload.EleFXUpload;
import com.sjydvlp.elefx.component.upload.EleFXUploadListType;
import javafx.animation.PauseTransition;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

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
        // --- EleFXButton
        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(20));
        hBox1.setSpacing(10);
        EleFXButton hBox1DefaultButton = new EleFXButton("Default", EleFXButtonType.DEFAULT, EleFXButtonSize.SMALL);
        hBox1DefaultButton.setLoading(true);
        hBox1.getChildren().addAll(
                hBox1DefaultButton,
                new EleFXButton("Primary", EleFXButtonType.PRIMARY, EleFXButtonSize.SMALL),
                new EleFXButton("Success", EleFXButtonType.SUCCESS, EleFXButtonSize.SMALL),
                new EleFXButton("Info", EleFXButtonType.INFO, EleFXButtonSize.SMALL),
                new EleFXButton("Warning", EleFXButtonType.WARNING, EleFXButtonSize.SMALL),
                new EleFXButton("Danger", EleFXButtonType.DANGER, EleFXButtonSize.SMALL));

        double iconSize = 18.0;
        
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(20));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(
                new EleFXButton(EleFXIcons.of(EleFXIconType.PLUS, iconSize), EleFXButtonType.DEFAULT, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.MINUS, iconSize), EleFXButtonType.PRIMARY, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CIRCLE_PLUS, iconSize), EleFXButtonType.SUCCESS, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.SEARCH, iconSize), EleFXButtonType.INFO, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CHAT_LINE_SQUARE, iconSize), EleFXButtonType.WARNING, true),
                new EleFXButton(EleFXIcons.of(EleFXIconType.CIRCLE_CLOSE, iconSize), EleFXButtonType.DANGER, true));

        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(20));
        hBox3.setSpacing(10);
        EleFXIcon hBox3PlusIcon = EleFXIcons.of(EleFXIconType.PLUS, iconSize);
        hBox3PlusIcon.setLoading(true);
        hBox3.getChildren().addAll(
                hBox3PlusIcon,
                EleFXIcons.of(EleFXIconType.MINUS, iconSize),
                EleFXIcons.of(EleFXIconType.CIRCLE_PLUS, iconSize),
                EleFXIcons.of(EleFXIconType.SEARCH, iconSize),
                EleFXIcons.of(EleFXIconType.CHAT_LINE_SQUARE, iconSize),
                EleFXIcons.of(EleFXIconType.CIRCLE_CLOSE, iconSize));

        // --- EleFXRow
        EleFXCol row1Left = new EleFXCol(12, new EleFXButton("左侧"));
        EleFXCol row1Right = new EleFXCol(12, new EleFXButton("右侧"));
        row1Left.setContentStyle("-fx-background-color: #2196F3;");
        row1Right.setContentStyle("-fx-background-color: #fffaaa;");
        EleFXRow row1 = new EleFXRow(20, row1Left, row1Right);

        EleFXCol sidebar = new EleFXCol(6, new EleFXButton("侧栏"));
        EleFXCol main = new EleFXCol(6, new EleFXButton("主内容"));
        sidebar.setContentStyle("-fx-border-color: #2196F3;");
        main.setContentStyle("-fx-border-color: #fffaaa;");
        main.setOffset(6);
        EleFXRow row2 = new EleFXRow(20, sidebar, main);

        EleFXCol row3Left = new EleFXCol(6, new EleFXButton("A"));
        EleFXCol row3Right = new EleFXCol(6, new EleFXButton("B"));
        row3Left.setContentStyle("-fx-background-color: #aaafff;");
        row3Right.setContentStyle("-fx-background-color: #cccccc;");
        EleFXRow row3 = new EleFXRow(row3Left, row3Right);
        row3.setJustify(EleFXRowJustify.SPACE_AROUND);
        row3.setAlign(EleFXRowAlign.MIDDLE);

        // --- EleFXContainer
        EleFXHeader eleFXHeader = new EleFXHeader();
        eleFXHeader.setStyle("-fx-background-color: #777777;");
        EleFXFooter eleFXFooter = new EleFXFooter();
        eleFXFooter.setStyle("-fx-background-color: #aaaeee;");
        EleFXAside eleFXAside = new EleFXAside();
        eleFXAside.setPrefWidth(200);
//        eleFXAside.setPrefHeight(200);
        eleFXAside.setStyle("-fx-background-color: blue;");
        EleFXContainer inContainer = new EleFXContainer(eleFXAside, new EleFXMain());
        EleFXContainer container = new EleFXContainer(
                eleFXHeader,
                inContainer,
                eleFXFooter
        );

        // --- EleFXLink
        EleFXLink link = new EleFXLink("Element Plus", EleFXLinkType.PRIMARY);
        link.setHref("https://element-plus.org");
        link.setUnderlineMode(EleFXLinkUnderline.ALWAYS);

        // --- EleFXText
        EleFXText text1 = new EleFXText("Important", EleFXTextType.WARNING);
        text1.setSize(EleFXTextSize.LARGE);
        text1.setTag(EleFXTextTag.BOLD);

        EleFXText text2 = new EleFXText("Important", EleFXTextType.WARNING);
        text2.setSize(EleFXTextSize.SMALL);
        text2.setTag(EleFXTextTag.ITALIC);

        // --- EleFXScrollbar
        VBox scrollbarVbox = new VBox();
        scrollbarVbox.getChildren().addAll(
                new Text("a"), new Text("b"), new Text("c"), new Text("d"),
                new Text("e"), new Text("f"), new Text("g"), new Text("h")
        );
        EleFXScrollbar scrollbar = new EleFXScrollbar(scrollbarVbox);
        scrollbar.setPrefHeight(100);
        scrollbar.setScrollTop(120);

        // --- EleFXSpace
        EleFXSpace eleFXSpace = new EleFXSpace(
                new Text("a"), new Text("b"), new Text("c"), new Text("d"),
                new Text("e"), new Text("f"), new Text("g"), new Text("h")
        );
        eleFXSpace.setSpacing(100);

        // --- EleFXSplitter
        EleFXSplitter eleFXSplitter = new EleFXSplitter(
                new EleFXSplitterPanel(new EleFXButton("a", EleFXButtonType.INFO, EleFXButtonSize.SMALL)),
                new EleFXSplitterPanel(new EleFXButton("b", EleFXButtonType.DANGER, EleFXButtonSize.SMALL))
        );

        // --- EleFXTypography
        EleFXTypography eleFXTypography1 = new EleFXTypography("你好，世界", EleFXTypographySize.EXTRA_LARGE);
        EleFXTypography eleFXTypography2 = new EleFXTypography("你好，世界", EleFXTypographySize.BASE);
        EleFXSpace typographySpace = new EleFXSpace(eleFXTypography1, eleFXTypography2);
        typographySpace.setSpacing(100);
        HBox typographyHbox = new HBox(typographySpace);

        // --- EleFXAutocomplete
        EleFXAutocomplete<Tuple> eleFXAutocomplete = new EleFXAutocomplete<>(value -> List.of(new Tuple("a")));

        // --- EleFXCascader
        EleFXCascaderOption<String> aaa = new EleFXCascaderOption<>("aaa", "l_aaa");
        EleFXCascaderOption<String> aba = new EleFXCascaderOption<>("aba", "l_aba");
        EleFXCascaderOption<String> aa = new EleFXCascaderOption<>("aa", "l_aa", aaa);
        EleFXCascaderOption<String> ab = new EleFXCascaderOption<>("ab", "l_ab", aba);
        EleFXCascaderOption<String> a = new EleFXCascaderOption<>("a", "l_a", aa, ab);

        EleFXCascaderOption<String> baa = new EleFXCascaderOption<>("baa", "l_baa");
        EleFXCascaderOption<String> bba = new EleFXCascaderOption<>("bba", "l_bba");
        EleFXCascaderOption<String> ba = new EleFXCascaderOption<>("ba", "l_ba", baa);
        EleFXCascaderOption<String> bb = new EleFXCascaderOption<>("bb", "l_bb", bba);
        EleFXCascaderOption<String> b = new EleFXCascaderOption<>("b", "l_b", ba, bb);

        EleFXCascader<String> eleFXCascader = new EleFXCascader<>(a, b);

        // --- EleFXCheckbox
        EleFXCheckbox<String> eleFXCheckbox1 = new EleFXCheckbox<>("a", "a");
        EleFXCheckbox<String> eleFXCheckbox2 = new EleFXCheckbox<>("b", "b");
        EleFXCheckbox<String> eleFXCheckbox3 = new EleFXCheckbox<>("c", "c");
        EleFXCheckbox<String> eleFXCheckbox4 = new EleFXCheckbox<>("d", "d");
        EleFXCheckboxButton<String> eleFXCheckboxButton5 = new EleFXCheckboxButton<>("你好，世界", "e");
        EleFXCheckboxGroup<String> eleFXCheckboxGroup =
                new EleFXCheckboxGroup<>(eleFXCheckbox3, eleFXCheckbox4, eleFXCheckboxButton5);
        EleFXSpace eleFxCheckBoxSpace = new EleFXSpace(eleFXCheckbox1, eleFXCheckbox2, eleFXCheckboxGroup);
        eleFxCheckBoxSpace.setSpacing(50);

        // --- EleFXColorPickerPanel
        EleFXColorPickerPanel colorPickerPanel = new EleFXColorPickerPanel(Color.web("#409EFF"));
        colorPickerPanel.setShowAlpha(true);
        colorPickerPanel.setBorder(Boolean.TRUE);
        VBox.setMargin(colorPickerPanel, new Insets(20));
        colorPickerPanel.getPredefinedColors().addAll(
                Color.web("#ff4500"),
                Color.web("#1e90ff"),
                Color.web("#c71585")
        );

        // --- EleFXColorPicker
        EleFXColorPicker colorPicker = new EleFXColorPicker(Color.valueOf("#409EFF"));

        // --- EleFXDatePickerPanel
        EleFXSpace datePickerPanelContainer = getDatePickerPanelContainer();
        // --- EleFXDatePicker
        EleFXSpace datePickerContainer = getDatePickerContainer();

        // --- EleFXForm
        EleFXForm eleFXForm = getEleFXForm();

        // --- EleFXSelect
        EleFXSelect<String> eleFXSelect = getEleFXSelect();
        EleFXSelect<String> eleFXSelect2 = getEleFXSelect2();
        EleFXSelect<String> eleFXSelect3 = getEleFXSelect3();

        // --- EleFXInput
        EleFXInput input1 = new EleFXInput();
        input1.setType(EleFXInputType.TEXTAREA);
        input1.setRows(2);
        input1.setAutoSize(true);
        input1.setAutoSizeMaxRows(5);
        input1.setMaxLength(100);
        input1.setShowWordLimit(true);

        EleFXInput input2 = new EleFXInput();
        input2.setDisable(true);
        input2.setSize(EleFXInputSize.SMALL);

        EleFXInput input3 = new EleFXInput();
        input3.setClearable(true);
        input3.setPrefix(new EleFXIcon(EleFXIconType.ADD_LOCATION));
        input3.setSuffix(new EleFXIcon(EleFXIconType.PLUS));
        input3.setSize(EleFXInputSize.LARGE);
        input3.setMaxLength(5);
        input3.setPrepend(new Label("Http://"));
        input3.setAppend(new Label(".com"));
        input3.setShowWordLimit(true);

        EleFXInput input4 = new EleFXInput();
        input4.setClearable(true);
        input4.setClearIcon(new EleFXIcon(EleFXIconType.ADD_LOCATION));
        input4.setFormatter(value ->
                ("$ " + value).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")
        );
        input4.setParser(value ->
                value.replaceAll("\\$\\s?|,+", "")
        );

        HBox inputHbox1 = new HBox();
        inputHbox1.getChildren().addAll(input1, input2);

        HBox inputHbox2 = new HBox();
        inputHbox2.getChildren().addAll(input3, input4);

        // EleFXInputNumber
        EleFXInputNumber inputNumber1 = new EleFXInputNumber();
//        inputNumber1.setDisable(true);
        inputNumber1.setStep(0.01);
        inputNumber1.setStepStrictly(true);
        inputNumber1.setPrecision(2);

        EleFXInputNumber inputNumber2 = new EleFXInputNumber();
        inputNumber2.setStep(0.01);
        inputNumber2.setPrecision(2);
        inputNumber2.setSize(EleFXInputNumberSize.LARGE);
        inputNumber2.setControlsPosition(EleFXInputNumberControlsPosition.RIGHT);
        inputNumber2.setIncreaseIcon(new EleFXIcon(EleFXIconType.AIM));
        inputNumber2.setIncreaseIcon(new EleFXIcon(EleFXIconType.APPLE));
        inputNumber2.setPrefix(new EleFXIcon(EleFXIconType.AIM));
        inputNumber2.setSuffix(new Label("RMB"));
        inputNumber2.setFormatter(value ->
                ("$ " + value).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")
        );
        inputNumber2.setParser(value ->
                value.replaceAll("\\$\\s?|,+", "")
        );

        HBox inputNumberHbox = new HBox(inputNumber1, inputNumber2);
        inputNumberHbox.setPadding(new Insets(10));
        inputNumberHbox.setSpacing(5);

        // EleFXRadio
        EleFXRadio<String> radioA = new EleFXRadio<>("r_a", "a");
        EleFXRadio<String> radioB = new EleFXRadio<>("r_b", "b");
        EleFXRadioButton<String> radioC = new EleFXRadioButton<>("r_c", "c");
        EleFXRadioButton<String> radioD = new EleFXRadioButton<>("r_d", "d");
        radioD.setSize(EleFXRadioSize.SMALL);
        EleFXRadioGroup<String> radioGroup1 = new EleFXRadioGroup<>(radioA, radioB, radioC, radioD);

        EleFXRadio<String> radioAA = new EleFXRadio<>("r_aa", "aa");
        radioAA.setBorder(true);
        EleFXRadio<String> radioBB = new EleFXRadio<>("r_bb", "bb");
        radioBB.setBorder(true);
        EleFXRadio<String> radioCC = new EleFXRadio<>("r_cc", "cc");
        radioCC.setBorder(true);
        radioCC.setDisable(true);
        EleFXRadioGroup<String> radioGroup2 = new EleFXRadioGroup<>(radioAA, radioBB, radioCC);
//        radioGroup2.setDisable(true);
//        radioGroup2.setStyle("-fx-border-color: #ff0000;");

        HBox radioHbox = new HBox(radioGroup1, radioGroup2);
        radioHbox.setPadding(new Insets(10));
        radioHbox.setSpacing(5);

        // EleFXRate
        EleFXRate rate1 = new EleFXRate();
        EleFXRate rate2 = new EleFXRate();
        rate2.setColors(List.of(Paint.valueOf("#eee111"), Paint.valueOf("#ff0000"), Paint.valueOf("#FF9900")));
        EleFXRate rate3 = new EleFXRate();
        rate3.setSize(EleFXRateSize.SMALL);
        rate3.setAllowHalf(true);
        rate3.setShowText(true);
        rate3.setClearable(true);
        rate3.setVoidIcon(new EleFXIcon(EleFXIconType.CALENDAR));
        rate3.setIcons(List.of(new EleFXIcon(EleFXIconType.AIM), new EleFXIcon(EleFXIconType.APPLE), new EleFXIcon(EleFXIconType.BICYCLE)));
//        rate3.setDisable(true);

        HBox rateHbox = new HBox(rate1, rate2, rate3);
        rateHbox.setPadding(new Insets(10));
        rateHbox.setSpacing(20);

        // --- EleFXSlider
        EleFXSlider slider1 = new EleFXSlider();
        slider1.setPrefWidth(300);
        slider1.setShowTooltip(true);
        slider1.setFormatTooltip(value -> value.toString() + "%");

        EleFXSlider slider2 = new EleFXSlider();
        slider2.setStep(10);
//        slider2.setShowStops(true);
        slider2.setShowInput(true);
        slider2.setPrecision(0);
        slider2.setTooltipPlacement(EleFXSliderTooltipPlacement.BOTTOM);
        slider2.setRange(true);
//        slider2.setVertical(true);

        EleFXSlider slider3 = new EleFXSlider();
        slider3.setSize(EleFXSliderSize.LARGE);
        slider3.setShowInput(true);

        VBox sliderVbox = new VBox(slider1, slider2, slider3);
        sliderVbox.setPadding(new Insets(10));
        sliderVbox.setSpacing(20);

        EleFXSlider slider4 = new EleFXSlider();
        slider4.setVertical(true);
        slider4.setMarks(Map.of(0.0, new EleFXSliderMark("0.0cm"), 30.0, new EleFXSliderMark("30.0cm")));
//        slider4.setStep(EleFXSliderStep.MARK);
        slider4.setShowTooltip(false);

        // EleFXSwitch
        EleFXSwitch eleFXSwitch1 = new EleFXSwitch();
        eleFXSwitch1.setActiveColor(Color.RED);
        eleFXSwitch1.setInactiveColor(Color.GREEN);
        eleFXSwitch1.setDisable(true);

        EleFXSwitch eleFXSwitch2 = new EleFXSwitch();
//        eleFXSwitch2.setActiveColor(Color.RED);
//        eleFXSwitch2.setInactiveColor(Color.GREEN);
//        eleFXSwitch2.setSize(EleFXSwitchSize.SMALL);
        eleFXSwitch2.setActiveText("hello");
        eleFXSwitch2.setInactiveText("hi");
        eleFXSwitch2.setInlinePrompt(true);
        eleFXSwitch2.setSwitchWidth(300);
//        eleFXSwitch2.setActiveIcon(new EleFXIcon(EleFXIconType.CHECK, 12));
//        eleFXSwitch2.setInactiveIcon(new EleFXIcon(EleFXIconType.AIM, 12));
        eleFXSwitch2.setActiveValue(100);
        eleFXSwitch2.setInactiveValue(0);
        eleFXSwitch2.setOnChange(e -> {
            System.out.println(e.getValue());
        });
//        eleFXSwitch2.setLoading(true);
        eleFXSwitch2.setBeforeChange(() -> false);

        HBox switchHbox = new HBox(eleFXSwitch1, eleFXSwitch2);
        switchHbox.setPadding(new Insets(10));
        switchHbox.setSpacing(20);

        // --- EleFXTransfer
        EleFXTransferItem<String> transferItem1 = new EleFXTransferItem<>("a", "t_a");
        EleFXTransferItem<String> transferItem2 = new EleFXTransferItem<>("b", "t_b");
        EleFXTransferItem<String> transferItem3 = new EleFXTransferItem<>("c", "t_c");
        EleFXTransfer<String> transfer = new EleFXTransfer<>(transferItem1, transferItem2, transferItem3);
        transfer.setFilterable(true);
        transfer.setToLeftIcon(new EleFXIcon(EleFXIconType.AIM));
        transfer.setToRightIcon(new EleFXIcon(EleFXIconType.CHECKED));

        // --- EleFXUpload
        EleFXUpload upload = new EleFXUpload();
        upload.setTipText("jpg/png files with a size less than 500KB.");
        upload.setLimit(2);
        upload.setListType(EleFXUploadListType.PICTURE);
        upload.setOnSuccess(e -> {
            System.out.println(e.getFiles().size());
        });
        upload.setDrag(true);

        // EleFXAvatar
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

        // --- EleFXCard
        EleFXCard card1 = new EleFXCard();
        card1.setHeaderText("Card name");
        card1.setFooterText("Footer content");
        card1.setShadow(EleFXCardShadow.HOVER);
        card1.getBodyChildren().addAll(
                new Label("List item 1"),
                new Label("List item 2")
        );
        card1.setMaxWidth(480);

        EleFXCard card2 = new EleFXCard();
        card2.setShadow(EleFXCardShadow.ALWAYS);
//        card2.getBodyChildren().addAll(
//                new Label("List item 1"),
//                new Label("List item 2")
//        );
        card2.getBodyChildren().addAll(new EleFXIcon(EleFXIconType.HANDBAG));
        card2.setMaxWidth(480);

        // --- EleFXCarousel
        EleFXCarouselItem carouselItem11 = new EleFXCarouselItem(new Label("1"));
        carouselItem11.setStyle("-fx-background-color: #ff0000;");
        EleFXCarouselItem carouselItem12 = new EleFXCarouselItem(new Label("2"));
        carouselItem12.setStyle("-fx-background-color: #00ff00;");
        EleFXCarouselItem carouselItem13 = new EleFXCarouselItem(new Label("3"));
        carouselItem13.setStyle("-fx-background-color: #0000ff;");
        EleFXCarouselItem carouselItem14 = new EleFXCarouselItem(new Label("4"));
        carouselItem14.setStyle("-fx-background-color: #ff00ff;");
        EleFXCarouselItem carouselItem15 = new EleFXCarouselItem(new Label("5"));
        carouselItem15.setStyle("-fx-background-color: #ffff00;");

        EleFXCarousel carousel1 = new EleFXCarousel(carouselItem11, carouselItem12, carouselItem13, carouselItem14, carouselItem15);
        carousel1.setPrefHeight(360);
        carousel1.setPreviousIcon(new EleFXIcon(EleFXIconType.ARROW_LEFT, 18));
        carousel1.setNextIcon(new EleFXIcon(EleFXIconType.ARROW_RIGHT, 18));
        carousel1.setTrigger(EleFXCarouselTrigger.HOVER);
        carousel1.setAutoplay(true);
        carousel1.setMotionBlur(true);
        carousel1.setDirection(EleFXCarouselDirection.VERTICAL);
//        carousel1.setArrow(EleFXCarouselArrow.NEVER);
        carousel1.setIndicatorPosition(EleFXCarouselIndicatorPosition.INSIDE);
        carousel1.setType(EleFXCarouselType.CARD);
        carousel1.setInterval(800);

        // --- EleFXCollapse
        EleFXCollapseItem collapseItem11 = new EleFXCollapseItem("hello", new EleFXIcon(EleFXIconType.ADD_LOCATION));
        collapseItem11.setTitleNode(new EleFXIcon(EleFXIconType.BURGER));
        collapseItem11.setExpandIcon(new EleFXIcon(EleFXIconType.FOOTBALL));
        collapseItem11.setCollapseIcon(new EleFXIcon(EleFXIconType.NOTEBOOK));
        EleFXCollapseItem collapseItem12 = new EleFXCollapseItem("hi", new EleFXIcon(EleFXIconType.BASEBALL));
        EleFXCollapseItem collapseItem13 = new EleFXCollapseItem("good", new EleFXIcon(EleFXIconType.CHAT_LINE_SQUARE));
        EleFXCollapse collapse1 = new EleFXCollapse(collapseItem11, collapseItem12, collapseItem13);
//        collapse1.setAccordion(true);
        collapse1.setAnimationDuration(Duration.millis(300));
//        collapse1.setExpandIconPosition(EleFXCollapseIconPosition.LEFT);
        collapse1.setBeforeCollapse(param -> true);
        collapse1.setExpandIconFactory(() -> new EleFXIcon(EleFXIconType.CIRCLE_CHECK));
        collapse1.setCollapseIconFactory(() -> new EleFXIcon(EleFXIconType.DOCUMENT_ADD));

        // --- EleFXDescriptions
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

        // --- EleFXEmpty
        EleFXEmpty empty = new EleFXEmpty("description");
        empty.setImage("https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png");
        empty.setImageSize(100.0);
        empty.getBottomChildren().add(new EleFXButton("按钮"));

        // --- EleFXImage
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

        // --- EleFXInfiniteScroll
        VBox infiniteScrollVbox = new VBox(new Label("a"), new Label("b"), new Label("c"), new Label("d"), new Label("e"));
        VBox infiniteScrollVbox2 = new VBox(new Label("a"), new Label("b"), new Label("c"), new Label("d"), new Label("e"), new Label("f"), new Label("g"), new Label("h"), new Label("i"));

        EleFXInfiniteScroll infiniteScroll = new EleFXInfiniteScroll(infiniteScrollVbox);
        infiniteScroll.setPrefHeight(50);
        infiniteScroll.setOnLoad(() -> infiniteScroll.setContent(infiniteScrollVbox2));

        // --- EleFXPagination
        EleFXPagination pagination1 = new EleFXPagination(50);
        pagination1.setLayout(EleFXPaginationLayout.SIZES, EleFXPaginationLayout.PREV, EleFXPaginationLayout.PAGER, EleFXPaginationLayout.NEXT, EleFXPaginationLayout.JUMPER, EleFXPaginationLayout.TOTAL);
        EleFXPagination pagination2 = new EleFXPagination(1000);
        pagination2.setLayout(EleFXPaginationLayout.PREV, EleFXPaginationLayout.PAGER, EleFXPaginationLayout.NEXT);
        pagination2.setPageSize(20);
        pagination2.setPagerCount(11);
        pagination2.setBackground(true);
        pagination2.setSize(EleFXPaginationSize.SMALL);
        EleFXPagination pagination3 = new EleFXPagination(3);
//        pagination3.setHideOnSinglePage(true);
        pagination3.setDisable(true);

        // --- EleFXProgress
        EleFXProgress progress1 = new EleFXProgress();
        progress1.setPercentage(50);
        progress1.setIndeterminate(true);
        progress1.setDuration(3);

        EleFXProgress progress2 = new EleFXProgress();
        progress2.setPercentage(100);
        progress2.setFormat(percentage -> {
            if (Objects.equals(100.0, percentage)) {
                return "Full";
            } else {
                return percentage + "%";
            }
        });
        progress2.setIndeterminate(true);
        progress2.setDuration(5);

        EleFXProgress progress3 = new EleFXProgress();
        progress3.setPercentage(100);
        progress3.setStatus(EleFXProgressStatus.SUCCESS);
        progress3.setIndeterminate(true);
        progress3.setDuration(1);

        EleFXProgress progress4 = new EleFXProgress();
        progress4.setPercentage(60);
        progress4.setStatus(EleFXProgressStatus.WARNING);
        progress4.setStriped(true);
        progress4.setStripedFlow(true);
        progress4.setDuration(0.2);

        EleFXProgress progress5 = new EleFXProgress();
        progress5.setPercentage(30);
        progress5.setStatus(EleFXProgressStatus.EXCEPTION);

        EleFXProgress progress6 = new EleFXProgress();
        progress6.setPercentage(70);
        progress6.setStrokeWidth(26);
        progress6.setTextInside(true);

        EleFXProgress progress7 = new EleFXProgress();
        progress7.setPercentage(50);
//        progress7.setStrokeWidth(24);
        progress7.setTextInside(true);
//        progress7.setStatus(EleFXProgressStatus.SUCCESS);
//        progress7.setStatus(EleFXProgressStatus.WARNING);
//        progress7.setStatus(EleFXProgressStatus.EXCEPTION);
        progress7.setType(EleFXProgressType.DASHBOARD);
        progress7.setContent(EleFXIcons.of(EleFXIconType.COFFEE));

        EleFXProgress progress8 = new EleFXProgress();
        progress8.setPercentage(50);
        progress8.setStrokeWidth(22);
        progress8.setTextInside(true);
        progress8.setStatus(EleFXProgressStatus.WARNING);
        progress8.setColorStops(
                new EleFXProgressColorStop(30, Color.web("#f56c6c")),
                new EleFXProgressColorStop(50, Color.web("#e6a23c")),
                new EleFXProgressColorStop(80, Color.web("#67c23a"))
        );

        EleFXProgress progress9 = new EleFXProgress();
        progress9.setPercentage(50);
        progress9.setStrokeWidth(20);
        progress9.setTextInside(true);
        progress9.setStatus(EleFXProgressStatus.EXCEPTION);
        // 根据当前百分比实时决定颜色
        progress9.setColorFunction(percent ->
                percent < 30 ? Color.web("#f56c6c")
                        : percent < 70 ? Color.web("#e6a23c")
                        : Color.web("#67c23a")
        );
        EleFXButton progressMinus = new EleFXButton(EleFXIcons.of(EleFXIconType.MINUS));
        EleFXButton progressPlus = new EleFXButton(EleFXIcons.of(EleFXIconType.PLUS));
        progressMinus.setOnAction(event -> {
            double percentage = progress9.getPercentage() - 10;
            if (percentage < 0) {
                percentage = 0;
            }
            progress9.setPercentage(percentage);
            progress8.setPercentage(percentage);
            progress7.setPercentage(percentage);
        });
        progressPlus.setOnAction(event -> {
            double percentage = progress9.getPercentage() + 10;
            if (percentage > 100) {
                percentage = 100;
            }
            progress9.setPercentage(percentage);
            progress8.setPercentage(percentage);
            progress7.setPercentage(percentage);
        });

        VBox progressVbox = new VBox(progress1, progress2, progress3, progress4,
                progress5, progress6, progress7, progress8, progress9, new HBox(progressMinus, progressPlus));
        progressVbox.setSpacing(8);

        // --- EleFXResult
        EleFXResult result1 = new EleFXResult(EleFXResultIcon.PRIMARY, "Primary Tip", "Please follow the instructions");
        result1.setExtra(new EleFXButton("Back"));
        EleFXResult result2 = new EleFXResult(EleFXResultIcon.SUCCESS, "Success Tip", "Please follow the instructions");
        result2.setExtra(new EleFXButton("Back"));
        EleFXResult result3 = new EleFXResult(EleFXResultIcon.WARNING, "Warning Tip", "Please follow the instructions");
        result3.setExtra(new EleFXButton("Back"));
        EleFXResult result4 = new EleFXResult(EleFXResultIcon.ERROR, "Error Tip", "Please follow the instructions");
        result4.setExtra(new EleFXButton("Back"));
        EleFXResult result5 = new EleFXResult(EleFXResultIcon.INFO, "Info Tip", "Please follow the instructions");
        result5.setExtra(new EleFXButton("Back"));
        EleFXResult result6 = new EleFXResult();
        result6.setIconNode(new EleFXImage("https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"));
        result6.setTitle("404");
        result6.setSubTitle("Sorry, request error");
        result6.setExtra(new EleFXButton("Back"));

//        HBox resultHbox = new HBox(result1, result2, result3, result4, result5);
        HBox resultHbox = new HBox(result6);

        // --- EleFXSkeleton
        EleFXSkeleton skeleton1 = new EleFXSkeleton();

        EleFXSkeletonItem skeletonItem1 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.CIRCLE);
        skeletonItem1.setPrefSize(100, 100);
        EleFXSkeleton skeleton2 = new EleFXSkeleton();
        skeleton2.getTemplateChildren().addAll(skeletonItem1);

        EleFXSkeleton skeleton3 = new EleFXSkeleton();
        skeleton3.setRows(2);
        skeleton3.setAnimated(true);

        // 自定义骨架
        EleFXSkeletonItem skeletonItem2 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.IMAGE);
        skeletonItem2.setPrefSize(240, 240);

        EleFXSkeletonItem skeletonItem3 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.P);
        skeletonItem3.setWidthPercent(50);

        EleFXSkeletonItem skeletonItem4 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.TEXT);
        EleFXSkeletonItem skeletonItem5 = new EleFXSkeletonItem(EleFXSkeletonItemVariant.TEXT);
        skeletonItem5.setWidthPercent(30);
        HBox skeletonInnerHbox = new HBox(16, skeletonItem4, skeletonItem5);
        HBox.setHgrow(skeletonItem4, Priority.ALWAYS);

        VBox skeletonOuterVbox = new VBox(skeletonItem3, skeletonInnerHbox);
        skeletonOuterVbox.setSpacing(10);

        EleFXSkeleton skeleton4 = new EleFXSkeleton();
        skeleton4.getTemplateChildren().addAll(skeletonItem2, skeletonOuterVbox);
        skeleton4.setPrefWidth(240);
        skeleton4.setAnimated(true);
        skeleton4.getContentChildren().addAll(new Label("加载出的内容"));
//        skeleton4.setLoading(false);
        skeleton4.setThrottle(2000);

        EleFXButton skeletonButton = new EleFXButton("点击加载");
        skeletonButton.setOnAction(event -> {
            skeleton4.setLoading(true);

            PauseTransition delay = new PauseTransition(Duration.seconds(6));
            delay.setOnFinished(e -> skeleton4.setLoading(false));
            delay.play();
        });

        // --- EleFXTag
        EleFXTag tag1 = new EleFXTag("Tag 1", EleFXTagType.PRIMARY);
        tag1.setSize(EleFXTagSize.LARGE);
        tag1.setTagEffect(EleFXTagEffect.DARK);
        tag1.setRound(true);
        EleFXTag tag2 = new EleFXTag("Tag 2", EleFXTagType.SUCCESS);
        EleFXTag tag3 = new EleFXTag("Tag 3", EleFXTagType.INFO);
        tag3.setSize(EleFXTagSize.SMALL);
        EleFXTag tag4 = new EleFXTag("Tag 4", EleFXTagType.WARNING);
        tag4.setTagEffect(EleFXTagEffect.PLAIN);
        EleFXTag tag5 = new EleFXTag("Tag 5", EleFXTagType.DANGER);
        tag5.setClosable(true);
        tag5.setTagEffect(EleFXTagEffect.LIGHT);
        HBox tagHbox = new HBox(tag1, tag2, tag3, tag4, tag5);
        tagHbox.setSpacing(8);
        tagHbox.setFillHeight(false);

        tag5.setOnClose(event -> {
            tagHbox.getChildren().remove(tag5);
        });

        // EleFXTimeline
        EleFXTimelineItem timelineItem11 = new EleFXTimelineItem("Event start", "2018-04-15");
        timelineItem11.setType(EleFXTimelineItemType.DANGER);
        timelineItem11.setIcon(EleFXIcons.of(EleFXIconType.FOOTBALL, 20));
//        timelineItem11.setColor("#ff0000");
//        timelineItem11.setSize(EleFXTimelineItemSize.LARGE);
        EleFXTimelineItem timelineItem12 = new EleFXTimelineItem("Approved", "2018-04-13");
        timelineItem12.setHollow(true);
        timelineItem12.setType(EleFXTimelineItemType.PRIMARY);
        timelineItem12.setSize(EleFXTimelineItemSize.LARGE);
        EleFXTimelineItem timelineItem13 = new EleFXTimelineItem("Success", "2018-04-11");
        timelineItem13.setPlacement(EleFXTimelineItemPlacement.TOP);
//        timelineItem13.setCenter(true);
        EleFXTimeline timeline1 = new EleFXTimeline(timelineItem11, timelineItem12, timelineItem13);
        timeline1.setMode(EleFXTimelineMode.ALTERNATE_REVERSE);
//        timeline1.setReverse(true);

        // --- EleFXStatistic
        EleFXStatistic statistic1 = new EleFXStatistic("Daily active users", 268500);
        EleFXStatistic statistic2 = new EleFXStatistic(138);
//        statistic2.setTitleNode(EleFXIcons.of(EleFXIconType.APPLE));
        statistic2.setTitle("aaaa");
//        statistic2.setSuffix("/100");
        statistic2.setSuffixNode(EleFXIcons.of(EleFXIconType.COFFEE_CUP));
        EleFXCountdown countdown1 = new EleFXCountdown("Start to grab", System.currentTimeMillis() +  + 1000 * 60 * 60 * 7);
        EleFXCountdown countdown2 = new EleFXCountdown("Remaining VIP time", System.currentTimeMillis() +  + 1000 * 60 * 60 * 24 * 2);
        countdown2.setFormat("HH:mm:ss");

        HBox statisticHbox = new HBox(statistic1, statistic2, countdown1, countdown2);
        statisticHbox.setSpacing(10);

        // --- EleFXSegmented
        EleFXSegmented<EleFXIconType> fruits = new EleFXSegmented<>();

        EleFXSegmentedItem<EleFXIconType> watermelon =
                new EleFXSegmentedItem<>("Watermelon", EleFXIconType.WATERMELON);
        watermelon.setDisabled(true);

        fruits.getItems().setAll(
                new EleFXSegmentedItem<>("Apple", EleFXIconType.APPLE),
                new EleFXSegmentedItem<>("Cherry", EleFXIconType.CHERRY),
                new EleFXSegmentedItem<>("Grape", EleFXIconType.GRAPE),
                new EleFXSegmentedItem<>("Orange", EleFXIconType.ORANGE),
                new EleFXSegmentedItem<>("Pear", EleFXIconType.PEAR),
                watermelon
        );

        fruits.setItemRenderer(item -> {
            EleFXIcon icon = new EleFXIcon(item.getValue(), 20);
            Label label = new Label(item.getLabel());

            VBox content = new VBox(6, icon, label);
            content.setAlignment(Pos.CENTER);
            content.setPadding(new Insets(8, 0, 8, 0));
            return content;
        });

        fruits.setValue(EleFXIconType.ORANGE);
        fruits.setDirection(EleFXSegmentedDirection.VERTICAL);

        // 像截图一样让所有项目等宽
//        fruits.setBlock(true);
//        fruits.setPrefWidth(640);

        // --- EleFXAffix
        VBox affixVbox = new VBox();

        for (int i = 0; i < 100; i++) {
            affixVbox.getChildren().add(new Label("label_" + i));

            if (i == 50) {
                VBox vbox = new VBox();
                vbox.setPrefHeight(400);

                EleFXAffix affix = new EleFXAffix(new EleFXButton("Offset top 120px", EleFXButtonType.PRIMARY));
                affix.setPosition(EleFXAffixPosition.TOP);
                affix.setOffset(120);
                affix.setTarget(vbox);
                vbox.getChildren().add(affix);

                affixVbox.getChildren().add(vbox);

                EleFXAffix affix2 = new EleFXAffix(new EleFXButton("Offset bottom 120px", EleFXButtonType.DANGER));
                affix2.setPosition(EleFXAffixPosition.BOTTOM);
                affix2.setOffset(120);

                affixVbox.getChildren().add(affix2);
            }
        }

        EleFXScrollbar affixScrollbar = new EleFXScrollbar(affixVbox);

        // 添加
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.setStyle("-fx-border-color: #ff0000;");
//        vBox.getChildren().addAll(hBox1, hBox2, hBox3, row1, row2, row3, container);
//        vBox.getChildren().addAll(
//                hBox1, hBox2, hBox3, row1, row2, row3, link, text1, text2, scrollbar, eleFXSpace, eleFXSplitter,
//                typographyHbox, eleFXAutocomplete, eleFXCascader, eleFxCheckBoxSpace
//        );
//        vBox.getChildren().addAll(colorPickerPanel, colorPicker, datePickerPanel1, datePickerPanel2, datePickerPanel3);
//        vBox.getChildren().addAll(eleFXForm, eleFXSelect, eleFXSelect2,
//                eleFXSelect3, inputHbox1, inputHbox2, inputNumberHbox,
//                radioHbox, rateHbox, sliderVbox, slider4);
//        vBox.getChildren().addAll(sliderVbox, slider4, switchHbox, transfer);
//        vBox.getChildren().addAll(transfer, upload, avatar);
//        vBox.getChildren().addAll(avatar1, avatar2, avatar3, avatarGroup, card1, card2, carousel1);
//        vBox.getChildren().addAll(carousel1);
//        vBox.getChildren().addAll(collapse1, descriptions1, descriptions2, empty);
//        vBox.getChildren().addAll(imageHbox, image, imageViewerButton, imageScrollbar);
//        vBox.getChildren().addAll(infiniteScroll, pagination1, pagination2, pagination3, progressVbox);
//        vBox.getChildren().addAll(resultHbox);
//        vBox.getChildren().addAll(skeleton1, skeleton2, skeleton3, skeleton4);
//        vBox.getChildren().addAll(skeleton4, skeletonButton);
//        vBox.getChildren().addAll(tagHbox, timeline1, statisticHbox, segmented1);
//        vBox.getChildren().addAll(fruits);
        vBox.getChildren().addAll(affixScrollbar);

        contentPane.setPadding(new Insets(30));
        contentPane.getChildren().add(vBox);
    }

    private EleFXSpace getDatePickerPanelContainer() {
        EleFXDatePickerPanel datePickerPanel = new EleFXDatePickerPanel();
        datePickerPanel.setType(EleFXDatePickerPanelType.values()[0]);
//        datePickerPanel.setDisable(true);

        AtomicInteger dateIndex = new AtomicInteger();
        EleFXButton datePreButton = new EleFXButton("切换成前一个");
        datePreButton.setOnMouseClicked(event -> {
            System.out.println(dateIndex);
            if (dateIndex.get() <= 0) {
                datePickerPanel.setType(EleFXDatePickerPanelType.values()[0]);
            } else {
                datePickerPanel.setType(EleFXDatePickerPanelType.values()[dateIndex.decrementAndGet()]);
            }
        });
        EleFXButton dateNextButton = new EleFXButton("切换成后一个");
        dateNextButton.setOnMouseClicked(event -> {
            System.out.println(dateIndex);
            if (dateIndex.get() >= 14) {
                datePickerPanel.setType(EleFXDatePickerPanelType.values()[14]);
            } else {
                datePickerPanel.setType(EleFXDatePickerPanelType.values()[dateIndex.incrementAndGet()]);
            }
        });
        EleFXSpace dateButtonSpace = new EleFXSpace(datePreButton, dateNextButton);
        dateButtonSpace.setSpacing(80);

        EleFXSpace dateSpace = new EleFXSpace(dateButtonSpace, datePickerPanel);
        dateSpace.setDirection(Orientation.VERTICAL);

        return dateSpace;
    }

    private EleFXSpace getDatePickerContainer() {
        EleFXDatePicker datePicker = new EleFXDatePicker();
        datePicker.setType(EleFXDatePickerType.DATE);
        datePicker.setShowConfirm(false);
//        datePicker.setSinglePanel(true);

        AtomicInteger datePickerIndex = new AtomicInteger();
        EleFXButton datePickerPreButton = new EleFXButton("切换成前一个");
        datePickerPreButton.setOnMouseClicked(event -> {
            if (datePickerIndex.get() <= 0) {
                datePicker.setType(EleFXDatePickerType.values()[0]);
            } else {
                datePicker.setType(EleFXDatePickerType.values()[datePickerIndex.decrementAndGet()]);
            }
        });
        EleFXButton datePickerNextButton = new EleFXButton("切换成后一个");
        datePickerNextButton.setOnMouseClicked(event -> {
            if (datePickerIndex.get() >= 14) {
                datePicker.setType(EleFXDatePickerType.values()[14]);
            } else {
                datePicker.setType(EleFXDatePickerType.values()[datePickerIndex.incrementAndGet()]);
            }
        });
        EleFXSpace datePickerButtonSpace = new EleFXSpace(datePickerPreButton, datePickerNextButton);
        datePickerButtonSpace.setSpacing(80);

        EleFXSpace datePickerSpace = new EleFXSpace(datePickerButtonSpace, datePicker);
        datePickerSpace.setDirection(Orientation.VERTICAL);

        return datePickerSpace;
    }

    private EleFXForm getEleFXForm() {
        EleFXForm form = new EleFXForm();
        form.setLabelPosition(EleFXFormLabelPosition.LEFT);
        form.setStyle("-fx-border-color: #ff0000;");
        form.setLabelWidth(100); // 自动对齐到最长标签
        form.setInline(true);
//        form.setMaxWidth(600);

        TextField name = new TextField();
        EleFXFormItem nameItem = new EleFXFormItem("Name", name);
        nameItem.setProp("name");
        nameItem.setRequired(false);

        TextField age = new TextField();
        EleFXFormItem ageItem = new EleFXFormItem("Age", age);
        ageItem.setProp("age");
        ageItem.setRequired(true);

        form.getItems().addAll(nameItem, ageItem);

        if (form.validate()) {
            // submit
        }

        return form;
    }

    private EleFXSelect<String> getEleFXSelect() {
        EleFXSelectOption<String> option1 = new EleFXSelectOption<>("a", "l_a");
        EleFXSelectOption<String> option2 = new EleFXSelectOption<>("b", "l_b");
//        option2.setDisabled(true);
        EleFXSelectOption<String> option3 = new EleFXSelectOption<>("c", "l_c");
        EleFXSelectOption<String> option4 = new EleFXSelectOption<>("d", "l_d");
        EleFXSelectOption<String> option5 = new EleFXSelectOption<>("e", "l_e");
        EleFXSelectOption<String> option6 = new EleFXSelectOption<>("f", "l_f");
        EleFXSelectOption<String> option7 = new EleFXSelectOption<>("g", "l_g");
        EleFXSelectOption<String> option8 = new EleFXSelectOption<>("h", "l_h");

        EleFXSelect<String> select = new EleFXSelect<>(
                option1, option2, option3, option4,
                option5, option6, option7, option8
        );
        select.setSize(EleFXSelectSize.SMALL);
        select.setPrefWidth(200);
//        select.setStyle("-fx-border-color: #ff0000;");
//        select.setDisable(true);
        select.setClearable(true);
        select.setMultiple(true);
        select.setCollapseTags(true);
        select.setMaxCollapseTags(3);
        select.setCollapseTagsTooltip(true);
        return select;
    }

    private EleFXSelect<String> getEleFXSelect2() {
        EleFXSelectOption<String> option1 = new EleFXSelectOption<>("a", "l_a");
        EleFXSelectOption<String> option2 = new EleFXSelectOption<>("b", "l_b");
        EleFXSelectOptionGroup<String> group1 = new EleFXSelectOptionGroup<>("g1");
        group1.addOptions(option1, option2);

        EleFXSelectOption<String> option3 = new EleFXSelectOption<>("c", "l_c");
        EleFXSelectOption<String> option4 = new EleFXSelectOption<>("d", "l_d");
        EleFXSelectOption<String> option5 = new EleFXSelectOption<>("e", "l_e");
        EleFXSelectOptionGroup<String> group2 = new EleFXSelectOptionGroup<>("g2");
        group2.addOptions(option3, option4, option5);

        EleFXSelect<String> select = new EleFXSelect<>();
        select.addOptionGroups(group1, group2);
        select.setSize(EleFXSelectSize.SMALL);
        select.setPrefWidth(200);
        select.setClearable(true);
        select.setMultiple(true);

        return select;
    }

    private EleFXSelect<String> getEleFXSelect3() {
        EleFXSelectOption<String> option1 = new EleFXSelectOption<>("a", "l_a");
        EleFXSelectOption<String> option2 = new EleFXSelectOption<>("b", "l_b");
        EleFXSelectOption<String> option3 = new EleFXSelectOption<>("c", "l_c");
        EleFXSelectOption<String> option4 = new EleFXSelectOption<>("d", "l_d");
        EleFXSelectOption<String> option5 = new EleFXSelectOption<>("e", "l_e");

        EleFXSelect<String> select = new EleFXSelect<>(option1, option2, option3, option4, option5);
        select.setSize(EleFXSelectSize.SMALL);
        select.setPrefWidth(200);
        select.setClearable(true);
        select.setFilterable(true);
        select.setRemote(true);

        EleFXIcon eleFXIcon = new EleFXIcon(EleFXIconType.SEARCH);
        eleFXIcon.setLoading(true);
        select.setLoadingNode(eleFXIcon);

        select.setRemoteMethod(keyword -> {
            select.setLoading(true);

            // 异步请求……
            // Platform.runLater(() -> {
            //     select.getOptions().setAll(results);
            //     select.setLoading(false);
            // });
        });
        return select;
    }
}
