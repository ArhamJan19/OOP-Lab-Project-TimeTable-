package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminSidebarController {

    @FXML
    private Button DashboardButton;
    @FXML
    private Button EditTTButton;
    @FXML
    private Button AddTeacherButton;
    @FXML
    private Button AddSectionButton;
    @FXML
    private Button AddCourseButton;
    @FXML
    private Button AddStudentButton;
    @FXML
    private Button AddRoomButton;
    @FXML
    private Button BackButton;

    @FXML
    protected void OpenAddTeacher() throws IOException {
        Stage primaryStage = (Stage) AddTeacherButton.getScene().getWindow();
        FXMLLoader firstLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Sidebar.fxml"));
        Parent firstView = firstLoader.load();

        FXMLLoader secondLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Add-Teacher.fxml"));
        Parent secondView = secondLoader.load();

        BorderPane root = new BorderPane();
        root.setLeft(firstView);
        root.setRight(secondView);

        primaryStage.setTitle("Bahria University Islamabad H-11 Campus");
        primaryStage.setScene(new Scene(root, 770, 435));
        primaryStage.setMinWidth(770);
        primaryStage.setMinHeight(435);
        primaryStage.setMaxHeight(435);
        primaryStage.setMaxWidth(770);
        primaryStage.show();
    }
    @FXML
    protected void OpenEditTT() throws IOException {
        Stage primaryStage = (Stage) EditTTButton.getScene().getWindow();
        FXMLLoader firstLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Sidebar.fxml"));
        Parent firstView = firstLoader.load();

        FXMLLoader secondLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Edit-Timetable.fxml"));
        Parent secondView = secondLoader.load();

        BorderPane root = new BorderPane();
        root.setLeft(firstView);
        root.setRight(secondView);

        primaryStage.setTitle("Bahria University Islamabad H-11 Campus");
        primaryStage.setScene(new Scene(root, 770, 435));
        primaryStage.setMinWidth(770);
        primaryStage.setMinHeight(435);
        primaryStage.setMaxHeight(435);
        primaryStage.setMaxWidth(770);
        primaryStage.show();
    }
    @FXML
    protected void OpenAddCourse() throws IOException {
        Stage primaryStage = (Stage) AddCourseButton.getScene().getWindow();
        FXMLLoader firstLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Sidebar.fxml"));
        Parent firstView = firstLoader.load();

        FXMLLoader secondLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Add-Course.fxml"));
        Parent secondView = secondLoader.load();

        BorderPane root = new BorderPane();
        root.setLeft(firstView);
        root.setRight(secondView);

        primaryStage.setTitle("Bahria University Islamabad H-11 Campus");
        primaryStage.setScene(new Scene(root, 770, 435));
        primaryStage.setMinWidth(770);
        primaryStage.setMinHeight(435);
        primaryStage.setMaxHeight(435);
        primaryStage.setMaxWidth(770);
        primaryStage.show();
    }
    @FXML
    protected void OpenAddSection() throws IOException {
        Stage primaryStage = (Stage) AddSectionButton.getScene().getWindow();
        FXMLLoader firstLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Sidebar.fxml"));
        Parent firstView = firstLoader.load();

        FXMLLoader secondLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Add-Section.fxml"));
        Parent secondView = secondLoader.load();

        BorderPane root = new BorderPane();
        root.setLeft(firstView);
        root.setRight(secondView);

        primaryStage.setTitle("Bahria University Islamabad H-11 Campus");
        primaryStage.setScene(new Scene(root, 770, 435));
        primaryStage.setMinWidth(770);
        primaryStage.setMinHeight(435);
        primaryStage.setMaxHeight(435);
        primaryStage.setMaxWidth(770);
        primaryStage.show();
    }
    @FXML
    protected void OpenDashboard() throws IOException {
        Stage primaryStage = (Stage) DashboardButton.getScene().getWindow();
        FXMLLoader firstLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Sidebar.fxml"));
        Parent firstView = firstLoader.load();

        FXMLLoader secondLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Dashboard.fxml"));
        Parent secondView = secondLoader.load();

        BorderPane root = new BorderPane();
        root.setLeft(firstView);
        root.setRight(secondView);

        primaryStage.setTitle("WELCOME!");
        primaryStage.setScene(new Scene(root, 770, 435));
        primaryStage.setMinWidth(770);
        primaryStage.setMinHeight(435);
        primaryStage.setMaxHeight(435);
        primaryStage.setMaxWidth(770);
        primaryStage.show();
    }
    @FXML
    protected void OpenAddRoom() throws IOException {
        Stage primaryStage = (Stage) AddRoomButton.getScene().getWindow();
        FXMLLoader firstLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Sidebar.fxml"));
        Parent firstView = firstLoader.load();

        FXMLLoader secondLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Add-Room.fxml"));
        Parent secondView = secondLoader.load();

        BorderPane root = new BorderPane();
        root.setLeft(firstView);
        root.setRight(secondView);

        primaryStage.setTitle("Bahria University Islamabad H-11 Campus");
        primaryStage.setScene(new Scene(root, 770, 435));
        primaryStage.setMinWidth(770);
        primaryStage.setMinHeight(435);
        primaryStage.setMaxHeight(435);
        primaryStage.setMaxWidth(770);
        primaryStage.show();
    }
    @FXML
    protected void OpenAddStudent() throws IOException {
        Stage primaryStage = (Stage) AddStudentButton.getScene().getWindow();
        FXMLLoader firstLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Sidebar.fxml"));
        Parent firstView = firstLoader.load();

        FXMLLoader secondLoader = new FXMLLoader(HelloApplication.class.getResource("Admin-Add-Student.fxml"));
        Parent secondView = secondLoader.load();

        BorderPane root = new BorderPane();
        root.setLeft(firstView);
        root.setRight(secondView);

        primaryStage.setTitle("Bahria University Islamabad H-11 Campus");
        primaryStage.setScene(new Scene(root, 770, 435));
        primaryStage.setMinWidth(770);
        primaryStage.setMinHeight(435);
        primaryStage.setMaxHeight(435);
        primaryStage.setMaxWidth(770);
        primaryStage.show();
    }
    @FXML
    protected void GoBack() throws IOException {
        Stage stage = (Stage) BackButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Admin-Login.fxml"));
        Scene scene = new Scene(loader.load(),600, 400);
        stage.setMaxHeight(400);
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.setMaxWidth(600);
        stage.setScene(scene);
        stage.show();
    }
}
