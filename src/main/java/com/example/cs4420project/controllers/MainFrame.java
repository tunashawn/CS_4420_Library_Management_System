package com.example.cs4420project.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFrame {

    private Stage thisStage;

    public MainFrame() {
        thisStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cs4420project/scenes/manager_main_frame.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
            thisStage.setTitle("Library management system");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
    }

    public void show_stage() {
        thisStage.showAndWait();
    }
}
