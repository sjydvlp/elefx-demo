package com.sjydvlp.elefx.demo.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Tuple;
import com.sjydvlp.elefx.component.autocomplete.EleFXAutocomplete;
import com.sjydvlp.elefx.component.avatar.*;
import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.card.EleFXCard;
import com.sjydvlp.elefx.component.card.EleFXCardShadow;
import com.sjydvlp.elefx.component.carousel.EleFXCarousel;
import com.sjydvlp.elefx.component.carousel.EleFXCarouselItem;
import com.sjydvlp.elefx.component.cascader.EleFXCascader;
import com.sjydvlp.elefx.component.cascader.EleFXCascaderOption;
import com.sjydvlp.elefx.component.checkbox.EleFXCheckbox;
import com.sjydvlp.elefx.component.checkbox.EleFXCheckboxButton;
import com.sjydvlp.elefx.component.checkbox.EleFXCheckboxGroup;
import com.sjydvlp.elefx.component.colorpicker.EleFXColorPicker;
import com.sjydvlp.elefx.component.colorpickerpanel.EleFXColorPickerPanel;
import com.sjydvlp.elefx.component.container.*;
import com.sjydvlp.elefx.component.datepicker.EleFXDatePicker;
import com.sjydvlp.elefx.component.datepicker.EleFXDatePickerType;
import com.sjydvlp.elefx.component.datepickerpanel.EleFXDatePickerPanel;
import com.sjydvlp.elefx.component.datepickerpanel.EleFXDatePickerPanelType;
import com.sjydvlp.elefx.component.form.EleFXForm;
import com.sjydvlp.elefx.component.form.EleFXFormItem;
import com.sjydvlp.elefx.component.form.EleFXFormLabelPosition;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
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
import com.sjydvlp.elefx.component.radio.EleFXRadio;
import com.sjydvlp.elefx.component.radio.EleFXRadioButton;
import com.sjydvlp.elefx.component.radio.EleFXRadioGroup;
import com.sjydvlp.elefx.component.radio.EleFXRadioSize;
import com.sjydvlp.elefx.component.rate.EleFXRate;
import com.sjydvlp.elefx.component.rate.EleFXRateSize;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import com.sjydvlp.elefx.component.select.EleFXSelect;
import com.sjydvlp.elefx.component.select.EleFXSelectOption;
import com.sjydvlp.elefx.component.select.EleFXSelectOptionGroup;
import com.sjydvlp.elefx.component.select.EleFXSelectSize;
import com.sjydvlp.elefx.component.slider.EleFXSlider;
import com.sjydvlp.elefx.component.slider.EleFXSliderMark;
import com.sjydvlp.elefx.component.slider.EleFXSliderSize;
import com.sjydvlp.elefx.component.slider.EleFXSliderTooltipPlacement;
import com.sjydvlp.elefx.component.space.EleFXSpace;
import com.sjydvlp.elefx.component.splitter.EleFXSplitter;
import com.sjydvlp.elefx.component.splitter.EleFXSplitterPanel;
import com.sjydvlp.elefx.component.switcher.EleFXSwitch;
import com.sjydvlp.elefx.component.text.EleFXText;
import com.sjydvlp.elefx.component.text.EleFXTextSize;
import com.sjydvlp.elefx.component.text.EleFXTextTag;
import com.sjydvlp.elefx.component.text.EleFXTextType;
import com.sjydvlp.elefx.component.transfer.EleFXTransfer;
import com.sjydvlp.elefx.component.transfer.EleFXTransferItem;
import com.sjydvlp.elefx.component.typography.EleFXTypography;
import com.sjydvlp.elefx.component.typography.EleFXTypographySize;
import com.sjydvlp.elefx.component.upload.EleFXUpload;
import com.sjydvlp.elefx.component.upload.EleFXUploadListType;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Map;
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
        EleFXCarouselItem carouselItem11 = new EleFXCarouselItem();
        carouselItem11.setStyle("-fx-background-color: #ff0000;");
        EleFXCarouselItem carouselItem12 = new EleFXCarouselItem();
        carouselItem12.setStyle("-fx-background-color: #00ff00;");
        EleFXCarouselItem carouselItem13 = new EleFXCarouselItem();
        carouselItem13.setStyle("-fx-background-color: #0000ff;");
        EleFXCarouselItem carouselItem14 = new EleFXCarouselItem();
        carouselItem14.setStyle("-fx-background-color: #ff00ff;");

        EleFXCarousel carousel1 = new EleFXCarousel(carouselItem11, carouselItem12, carouselItem13, carouselItem14);
        carousel1.setPrefHeight(150);
        carousel1.setPreviousIcon(new EleFXIcon(EleFXIconType.ARROW_LEFT, 18));
        carousel1.setNextIcon(new EleFXIcon(EleFXIconType.ARROW_RIGHT, 18));

        // 添加
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(5));
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
        vBox.getChildren().addAll(carousel1);

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
