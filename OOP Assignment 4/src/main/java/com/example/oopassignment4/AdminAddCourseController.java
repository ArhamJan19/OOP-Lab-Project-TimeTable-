package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminAddCourseController {
    @FXML
    private TextField CourseIDTF;
    @FXML
    private TextField CourseNameTF;
    @FXML
    private Button AddCourseButton;

    final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
    final String username = "Arham";
    final String password = "zargham100504";
    @FXML
    protected void initialize (){
        AddCourseButton.setOnAction(e-> AddCourse());
    }

    @FXML
    protected void AddCourse(){
        String CourseID = CourseIDTF.getText();
        String CourseName = CourseNameTF.getText();
        if(CourseID.isEmpty() || CourseName.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Fill Out All Mandatory Fields");
            alert.setTitle("ERROR");
            alert.showAndWait();
            return;
        }
        try {
            Connection connection = DriverManager.getConnection(dburl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into Assignment4.Course (CourseID, CourseName) Values (?, ?)" );
            preparedStatement.setString(1, CourseID);
            preparedStatement.setString(2, CourseName);
            int AddedRows = preparedStatement.executeUpdate();
            if(AddedRows > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Course Was Successfully Added");
                alert.setTitle("Success");
                alert.showAndWait();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
