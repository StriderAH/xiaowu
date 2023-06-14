package gpt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TriangleApp extends Application {

    private TextField sideATextField;
    private TextField sideBTextField;
    private TextField sideCTextField;
    private TextField resultTextField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Triangle App");

        // 创建输入框和按钮
        Text sideALabel = new Text("A:");
        sideATextField = new TextField();

        Text sideBLabel = new Text("B:");
        sideBTextField = new TextField();

        Text sideCLabel = new Text("C:");
        sideCTextField = new TextField();

        Button checkButton = new Button("判断形状");
        checkButton.setOnAction(e -> checkTriangle());

        Text resultLabel = new Text("结果:");
        resultTextField = new TextField();
        resultTextField.setEditable(false);

        // 创建布局
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(300, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(sideALabel, 0, 0);
        gridPane.add(sideATextField, 1, 0);
        gridPane.add(sideBLabel, 0, 1);
        gridPane.add(sideBTextField, 1, 1);
        gridPane.add(sideCLabel, 0, 2);
        gridPane.add(sideCTextField, 1, 2);
        gridPane.add(checkButton, 0, 3, 2, 1);
        gridPane.add(resultLabel, 0, 4);
        gridPane.add(resultTextField, 1, 4);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void checkTriangle() {
        String sideAInput = sideATextField.getText();
        String sideBInput = sideBTextField.getText();
        String sideCInput = sideCTextField.getText();

        if (!sideAInput.isEmpty() && !sideBInput.isEmpty() && !sideCInput.isEmpty()) {
            try {
                double sideA = Double.parseDouble(sideAInput);
                double sideB = Double.parseDouble(sideBInput);
                double sideC = Double.parseDouble(sideCInput);

                if (isTriangle(sideA, sideB, sideC)) {
                    String triangleType = getTriangleType(sideA, sideB, sideC);
                    resultTextField.setText(triangleType);
                } else {
                    resultTextField.setText("不能构成三角形");
                }
            } catch (NumberFormatException e) {
                resultTextField.setText("请输入有效的数字");
            }
        } else {
            resultTextField.setText("请输入A、B、C的值");
        }
    }

    private boolean isTriangle(double sideA, double sideB, double sideC) {
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
    }

    private String getTriangleType(double sideA, double sideB, double sideC) {
        if (sideA == sideB && sideB == sideC) {
            return "等边三角形";
        } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
            return "等腰三角形";
        } else {
            return "一般三角形";
        }
    }
}

