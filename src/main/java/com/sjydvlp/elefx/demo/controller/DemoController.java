package com.sjydvlp.elefx.demo.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.button.EleFXButtonSize;
import com.sjydvlp.elefx.component.button.EleFXButtonType;
import com.sjydvlp.elefx.component.container.*;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.layout.EleFXCol;
import com.sjydvlp.elefx.component.layout.EleFXRow;
import com.sjydvlp.elefx.component.layout.EleFXRowAlign;
import com.sjydvlp.elefx.component.layout.EleFXRowJustify;
import com.sjydvlp.elefx.component.link.EleFXLink;
import com.sjydvlp.elefx.component.link.EleFXLinkType;
import com.sjydvlp.elefx.component.link.EleFXLinkUnderline;
import com.sjydvlp.elefx.component.scrollbar.EleFXScrollbar;
import com.sjydvlp.elefx.component.text.EleFXText;
import com.sjydvlp.elefx.component.text.EleFXTextSize;
import com.sjydvlp.elefx.component.text.EleFXTextTag;
import com.sjydvlp.elefx.component.text.EleFXTextType;
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
import javafx.scene.text.Text;
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
        // --- button
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

        // --- row
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

        // --- container
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

        // --- link
        EleFXLink link = new EleFXLink("Element Plus", EleFXLinkType.PRIMARY);
        link.setHref("https://element-plus.org");
        link.setUnderlineMode(EleFXLinkUnderline.ALWAYS);

        // --- text
        EleFXText text1 = new EleFXText("Important", EleFXTextType.WARNING);
        text1.setSize(EleFXTextSize.LARGE);
        text1.setTag(EleFXTextTag.BOLD);

        EleFXText text2 = new EleFXText("Important", EleFXTextType.WARNING);
        text2.setSize(EleFXTextSize.SMALL);
        text2.setTag(EleFXTextTag.ITALIC);

        // --- scrollbar
        VBox scrollbarVbox = new VBox();
        scrollbarVbox.getChildren().addAll(new Text("a"), new Text("b"), new Text("c"), new Text("d"), new Text("e"), new Text("f"), new Text("g"), new Text("h"));
        EleFXScrollbar scrollbar = new EleFXScrollbar(scrollbarVbox);
        scrollbar.setPrefHeight(100);
        scrollbar.setScrollTop(120);

        VBox vBox = new VBox();
        vBox.setStyle("-fx-border-color: #ff0000;");
//        vBox.getChildren().addAll(hBox1, hBox2, hBox3, row1, row2, row3, container);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, row1, row2, row3, link, text1, text2, scrollbar);

        contentPane.setPadding(new Insets(30));
        contentPane.getChildren().add(vBox);
    }
}
