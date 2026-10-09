package com.sjydvlp.elefx.demo.bean;

import com.sjydvlp.elefx.component.button.EleFXButton;
import com.sjydvlp.elefx.component.icon.EleFXIconType;
import com.sjydvlp.elefx.component.icon.EleFXIcons;
import com.sjydvlp.elefx.component.steps.EleFXStep;
import com.sjydvlp.elefx.component.steps.EleFXStepStatus;
import com.sjydvlp.elefx.component.steps.EleFXSteps;
import com.sjydvlp.elefx.component.steps.EleFXStepsDirection;
import javafx.scene.layout.VBox;

/**
 * EleFXMenuFiller
 *
 * @author sjydvlp@163.com
 * @date 2026/9/20 23:24
 */
public class EleFXStepsFiller {

    public static void fill(VBox vBox) {
        VBox step1 = getStep1();
        VBox step2 = getStep2();
        VBox step3 = getStep3();
        VBox step4 = getStep4();

        vBox.getChildren().addAll(step1, step2, step3, step4);
    }

    private static VBox getStep1() {
        EleFXStep step1 = new EleFXStep("Step 1");
        step1.setIcon(EleFXIcons.of(EleFXIconType.APPLE));
        EleFXStep step2 = new EleFXStep("Step 2");
        step2.setIcon(EleFXIcons.of(EleFXIconType.ALARM_CLOCK));
        EleFXStep step3 = new EleFXStep("Step 3");
        EleFXSteps steps = new EleFXSteps(step1, step2, step3);
        steps.setFinishStatus(EleFXStepStatus.SUCCESS);
        steps.setActive(0);
        steps.setDirection(EleFXStepsDirection.VERTICAL);
        steps.setSpace(80);

        EleFXButton stepBtn = new EleFXButton("Next step");
        stepBtn.setOnAction(event -> {
            int active;
            if (steps.getActive() > 2) {
                active = 0;
            } else {
                active = steps.getActive() + 1;
            }
            steps.setActive(active);
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(steps, stepBtn);

        return vBox;
    }

    private static VBox getStep2() {
        EleFXStep step1 = new EleFXStep("Done", "Some description");
        EleFXStep step2 = new EleFXStep("Processing", "Some description");
        EleFXStep step3 = new EleFXStep("Step 3", "Some description");
        EleFXSteps steps = new EleFXSteps(step1, step2, step3);
        steps.setFinishStatus(EleFXStepStatus.SUCCESS);
        steps.setActive(1);
        steps.setSpace(150);
//        steps.setAlignCenter(true);
        steps.setMaxWidth(100);

        EleFXButton stepBtn = new EleFXButton("Next step");
        stepBtn.setOnAction(event -> {
            int active;
            if (steps.getActive() > 2) {
                active = 0;
            } else {
                active = steps.getActive() + 1;
            }
            steps.setActive(active);
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(steps, stepBtn);

        return vBox;
    }

    private static VBox getStep3() {
        EleFXStep step1 = new EleFXStep("Done", "Some description");
        step1.setIcon(EleFXIcons.of(EleFXIconType.EDIT));
        EleFXStep step2 = new EleFXStep("Processing", "Some description");
        step2.setIcon(EleFXIcons.of(EleFXIconType.PICTURE));
        EleFXStep step3 = new EleFXStep("Step 3", "Some description");
        step3.setIcon(EleFXIcons.of(EleFXIconType.UPLOAD_FILLED));
        EleFXSteps steps = new EleFXSteps(step1, step2, step3);
        steps.setActive(1);
        steps.setSimple(true);
        steps.setMaxWidth(600);

        EleFXButton stepBtn = new EleFXButton("Next step");
        stepBtn.setOnAction(event -> {
            int active;
            if (steps.getActive() > 2) {
                active = 0;
            } else {
                active = steps.getActive() + 1;
            }
            steps.setActive(active);
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(steps, stepBtn);

        return vBox;
    }

    private static VBox getStep4() {
        EleFXStep step1 = new EleFXStep("Done", "Some description");
        EleFXStep step2 = new EleFXStep("Processing", "Some description");
        EleFXStep step3 = new EleFXStep("Step 3", "Some description");
        EleFXSteps steps = new EleFXSteps(step1, step2, step3);
        steps.setFinishStatus(EleFXStepStatus.SUCCESS);
        steps.setActive(1);
        steps.setSpace(100);
        steps.setSimple(true);
        steps.setMaxWidth(600);

        EleFXButton stepBtn = new EleFXButton("Next step");
        stepBtn.setOnAction(event -> {
            int active;
            if (steps.getActive() > 2) {
                active = 0;
            } else {
                active = steps.getActive() + 1;
            }
            steps.setActive(active);
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(steps, stepBtn);

        return vBox;
    }

    private EleFXStepsFiller() {}
}
