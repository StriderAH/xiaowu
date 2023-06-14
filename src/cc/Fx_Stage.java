package cc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


// 配置了 VM options： --module-path="D:\program files\java\javafx-sdk-11.0.2\lib"
// --add-modules=javafx.controls（,javafx.fxml 括号内容在创建FX项目时添加）
public class Fx_Stage extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // 按钮
        Button button0 = new Button("窗口0");
        Button button1 = new Button("窗口1");
        button0.setLayoutX(200);
        button0.setLayoutY(200);
        button1.setLayoutX(200);
        button1.setLayoutY(250);

        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(button0,button1);
        // 按钮事件
        button0.setOnAction(event ->{
            Stage stage1 = new Stage();
            stage1.initOwner(stage);
            stage1.setHeight(200);
            stage1.setWidth(300);
            stage1.initModality(Modality.WINDOW_MODAL);
            /**
             * Modality.APPLICATION_MODAL 应用模态，禁用其他所有窗口
             * Modality.WINDOW_MODAL   掉用子窗口的主窗口禁用，，其它子窗口可以使用
             */
            stage1.show();
        });
        button1.setOnAction(event ->{
            Stage stage2 = new Stage();
            stage2.initOwner(stage);
            stage2.setHeight(200);
            stage2.setWidth(300);
            stage2.show();
        });
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        // 场景放入stage窗口
        stage.setTitle("hello");
        stage.show();
    }
}
