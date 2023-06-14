package cc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


// 配置了 VM options： --module-path="D:\program files\java\javafx-sdk-11.0.2\lib"
// --add-modules=javafx.controls（,javafx.fxml 括号内容在创建FX项目时添加）
public class Hello_Fx extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("hello,world!");
        // 布局
        BorderPane pane = new BorderPane(label);
        // 场景
        Scene scene = new Scene(pane, 300, 300);
        // 场景放入stage窗口
        stage.setScene(scene);
        stage.setTitle("窗口");
        stage.show();
    }
}
