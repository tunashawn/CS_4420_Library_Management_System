module com.example.cs4420project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.cs4420project to javafx.fxml;
    opens com.example.cs4420project.controllers to javafx.fxml;
    exports com.example.cs4420project;
}