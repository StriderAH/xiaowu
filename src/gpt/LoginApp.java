package gpt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginApp extends Application {

    private TextField usernameTextField;
    private PasswordField passwordField;
    private Text messageText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login App");

        // 创建界面元素
        Label usernameLabel = new Label("用户名:");
        usernameTextField = new TextField();

        Label passwordLabel = new Label("密码:");
        passwordField = new PasswordField();

        Button loginButton = new Button("登录");
        loginButton.setOnAction(e -> validateCredentials());

        messageText = new Text();

        // 创建布局
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(300, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 0, 2, 2, 1);
        gridPane.add(messageText, 0, 3, 2, 1);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void validateCredentials() {
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        boolean validUsername = isValidUsername(username);
        boolean validPassword = isValidPassword(password);

        if (validUsername && validPassword) {
            messageText.setText("用户名和密码合法");
        } else {
            messageText.setText("用户名或密码不合法");
        }
    }

    private boolean isValidUsername(String username) {
        if (username.length() < 6 || username.length() > 10) {
            return false;
        }

        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }

        for (char c : username.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidPassword(String password) {
        if (password.length() != 6) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}

