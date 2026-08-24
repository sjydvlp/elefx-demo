package com.sjydvlp.elefx.demo;

import cn.hutool.core.io.resource.ResourceUtil;
import com.sjydvlp.elefx.demo.controller.DemoController;
import com.sjydvlp.elefx.theme.EleFxTheme;
import com.sjydvlp.elefx.theme.JavaFXTheme;
import com.sjydvlp.elefx.theme.UserAgentBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Demo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        UserAgentBuilder.builder()
                .themes(JavaFXTheme.MODENA)
                .themes(EleFxTheme.forAssemble())
                .setDeploy(true)
                .setResolveAssets(true)
                .build()
                .setGlobal();

        FXMLLoader loader = new FXMLLoader(ResourceUtil.getResource("fxml/Demo.fxml"));
        loader.setControllerFactory(c -> new DemoController(primaryStage));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("EleFX Demo");
        primaryStage.show();
    }
}
