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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NextDayApp extends Application {

    private TextField yearTextField;
    private TextField monthTextField;
    private TextField dayTextField;
    private TextField nextDayTextField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Next Day App");

        // 创建输入框和按钮
        Text yearLabel = new Text("年:");
        yearTextField = new TextField();

        Text monthLabel = new Text("月:");
        monthTextField = new TextField();

        Text dayLabel = new Text("日:");
        dayTextField = new TextField();

        Button nextDayButton = new Button("计算下一天");
        nextDayButton.setOnAction(e -> calculateNextDay());

        Button resetButton = new Button("重新输入");
        resetButton.setOnAction(e -> resetInputs());

        Text nextDayLabel = new Text("下一天:");
        nextDayTextField = new TextField();
        nextDayTextField.setEditable(false);

        // 创建布局
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(300, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(yearLabel, 0, 0);
        gridPane.add(yearTextField, 1, 0);
        gridPane.add(monthLabel, 0, 1);
        gridPane.add(monthTextField, 1, 1);
        gridPane.add(dayLabel, 0, 2);
        gridPane.add(dayTextField, 1, 2);
        gridPane.add(nextDayButton, 0, 3);
        gridPane.add(resetButton, 1, 3);
        gridPane.add(nextDayLabel, 0, 4);
        gridPane.add(nextDayTextField, 1, 4);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateNextDay() {
        String yearInput = yearTextField.getText();
        String monthInput = monthTextField.getText();
        String dayInput = dayTextField.getText();

        if (!yearInput.isEmpty() && !monthInput.isEmpty() && !dayInput.isEmpty()) {
            try {
                int year = Integer.parseInt(yearInput);
                int month = Integer.parseInt(monthInput);
                int day = Integer.parseInt(dayInput);

                if (isValidDate(year, month, day)) {
                    LocalDate currentDate = LocalDate.of(year, month, day);
                    LocalDate nextDayDate = currentDate.plusDays(1);
                    String nextDay = nextDayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    nextDayTextField.setText(nextDay);
                } else {
                    nextDayTextField.setText("输入的日期无效");
                }
            } catch (NumberFormatException e) {
                nextDayTextField.setText("请输入有效的数字");
            }
        } else {
            nextDayTextField.setText("请输入年、月、日");
        }
    }

    private boolean isValidDate(int year, int month, int day) {
        if (year < 0 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int daysInMonth = getDaysInMonth(year, month);
        return day <= daysInMonth;
    }

    private int getDaysInMonth(int year, int month) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private void resetInputs() {
        yearTextField.clear();
        monthTextField.clear();
        dayTextField.clear();
        nextDayTextField.clear();
    }
}