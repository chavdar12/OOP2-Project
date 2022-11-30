package tu.varna.ims.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


/**
 * Register view controller.
 */
public class RegisterViewController {
    /**
     * The Email field.
     */
    @FXML
    public TextField emailField;
    /**
     * The First name field.
     */
    @FXML
    public TextField firstNameField;
    /**
     * The Last name field.
     */
    @FXML
    public TextField lastNameField;
    /**
     * The Password field.
     */
    @FXML
    public PasswordField passwordField;
    /**
     * The Confirm password field.
     */
    @FXML
    public PasswordField confirmPasswordField;
    /**
     * The Register button.
     */
    @FXML
    public Button registerButton;
    /**
     * The Login button.
     */
    @FXML
    public Button loginButton;

    @FXML
    private void initialize() {
        /*
         * Checks if first name field is not empty and if it contains only letters
         */
        firstNameField.textProperty().addListener((observable, oldValue, newValue) ->
                switchColors(newValue.matches("^[a-zA-Z]+$"), firstNameField));
        /*
         * Checks if last name field is not empty and if it contains only letters
         */
        lastNameField.textProperty().addListener((observable, oldValue, newValue) ->
                switchColors(newValue.matches("^[a-zA-Z]+$"), lastNameField));
        /*
         * Checks if the email is valid using regex
         */
        emailField.textProperty().addListener((observable, oldValue, newValue) ->
                switchColors(newValue.matches("\\S+@\\S+\\.\\S+"), emailField));
        /*
         * Checks if the password is valid using regex
         * Password must contain at least one digit, one lowercase and one uppercase letter
         * Example of valid password: PASSword123$
         */
        passwordField.textProperty().addListener((observable, oldValue, newValue) ->
                switchColors(newValue.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"), passwordField));
        /*
         * Checks if password and confirm password fields are equal
         */
        confirmPasswordField.textProperty().addListener((observable, oldValue, newValue) ->
                switchColors(newValue.equals(passwordField.getText()), confirmPasswordField));
        /*
         * Disables register button if any of the fields are empty or invalid
         */
        registerButton.disableProperty().bind(
                firstNameField.styleProperty().
                        isEqualTo("-fx-border-color: red;").or(
                                lastNameField.styleProperty().isEqualTo("-fx-border-color: red;")).or(
                                emailField.styleProperty().isEqualTo("-fx-border-color: red;")).or(
                                passwordField.styleProperty().isEqualTo("-fx-border-color: red;")).or(
                                confirmPasswordField.styleProperty().isEqualTo("-fx-border-color: red;")).or(
                                firstNameField.textProperty().isEmpty().or(
                                        lastNameField.textProperty().isEmpty().or(
                                                emailField.textProperty().isEmpty().or(
                                                        passwordField.textProperty().isEmpty().or(
                                                                confirmPasswordField.textProperty().isEmpty()))))));

        registerButton.setOnAction(event -> register());

        loginButton.setOnAction(event -> login());
    }

    private void login() {
        //switch to LoginView
        try {
            URL url = getClass().getResource("/tu/varna/ims/presentation/Login/LoginView.fxml");
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.getScene().setRoot(root);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void register() {
        System.out.println("Register");
    }

    private void switchColors(boolean value, TextField field) {
        if (!value) {
            field.setStyle("-fx-border-color: red");
        } else {
            field.setStyle("-fx-border-color: green");
        }
    }
}
