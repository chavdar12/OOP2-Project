package tu.varna.ims.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Login view.
 */
public class LoginViewController {
    /**
     * The Email field.
     */
    @FXML
    public TextField emailField;
    /**
     * The Password field.
     */
    @FXML
    public TextField passwordField;
    /**
     * The Login button.
     */
    @FXML
    public Button loginButton;
    /**
     * The Register button.
     */
    @FXML
    public Button registerButton;

    @FXML
    private void initialize() {
        /*
          Checks if email field is not empty and if it contains only letters
         */
        emailField.textProperty().addListener((observable, oldValue, newValue) ->
                changeColors(newValue.matches("\\S+@\\S+\\.\\S+"), emailField));

        /*
          Checks if password field is not empty and if it contains only letters
         */
        passwordField.textProperty().addListener((observable, oldValue, newValue) ->
                changeColors(newValue.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"), passwordField));

        /*
          Disable login button if email or password fields are empty
         */
        loginButton.disableProperty().bind(
                emailField.textProperty().
                        isEmpty().
                        or(passwordField.textProperty().
                                isEmpty()).
                        or(emailField.styleProperty().
                                isEqualTo("-fx-border-color: red;")).
                        or(passwordField.styleProperty().
                                isEqualTo("-fx-border-color: red;"))
        );

        /*
         * If login button is clicked, call login method
         */
        loginButton.setOnAction(event -> login());

        /*
         * If register button is clicked, call register method
         */
        registerButton.setOnAction(event -> register());
    }

    private void register() {
    try {
                URL url = getClass().getResource("/tu/varna/ims/presentation/Registration/RegisterView.fxml");
                Parent root = FXMLLoader.load(url);
                Stage stage = (Stage) registerButton.getScene().getWindow();
                stage.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void login() {
        System.out.println("Login");
    }

    private void changeColors(boolean value, TextField field) {
        if (!value) {
            field.setStyle("-fx-border-color: red");
        } else {
            field.setStyle("-fx-border-color: green");
        }
    }
}
