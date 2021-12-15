package com.example.cs4420project.controllers;

import com.example.cs4420project.connect.Connect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    TextField username_tf;
    @FXML
    PasswordField password_pf;
    @FXML
    Hyperlink change_password_hpl;
    @FXML
    Button login_btn;

    private Stage thisStage;

    public Login() {
        thisStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cs4420project/scenes/login.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
            thisStage.setTitle("Library management system - Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        login_btn.setOnAction(actionEvent -> setLogin_btn());
    }

    public void show_stage() {
        thisStage.showAndWait();
    }

    private void setLogin_btn(){
        Connect.connect();
        if (Connect.login(username_tf.getText(), password_pf.getText())){
            MainFrame mainFrame = new MainFrame();
            mainFrame.show_stage();
            thisStage.close();
        }
        Connect.disconnect();
    }
}
