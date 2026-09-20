package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.carousel.*;
import com.sjydvlp.elefx.component.icon.EleFXIcon;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * EleFXCarouselFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXCarouselFiller {

    public static void fill(VBox vBox) {
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

        vBox.getChildren().addAll(carousel1);
    }

    private EleFXCarouselFiller() {}
}
