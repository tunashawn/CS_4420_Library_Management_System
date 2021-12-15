package com.example.cs4420project;

import com.example.cs4420project.controllers.Login;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Login login = new Login();
        login.show_stage();
    }
}
