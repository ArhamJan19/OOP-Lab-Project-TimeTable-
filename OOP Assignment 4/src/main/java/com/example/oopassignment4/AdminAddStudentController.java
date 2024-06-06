package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminAddStudentController {
    @FXML
    private TextField StudentIDTF;
    @FXML
    private TextField NameTF;
    @FXML
    private Button AddStudentButton;
    @FXML
    private TextField EmailTF;
    @FXML
    private PasswordField PasswordPF;

    final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
    final String username = "Arham";
    final String password = "zargham100504";

    @FXML
    protected void AddStudent() {
        String StudentID = StudentIDTF.getText();
        String StudentName = NameTF.getText();
        String StudentEmail = EmailTF.getText();
        String Password = PasswordPF.getText();
        if (StudentID.isEmpty() || StudentName.isEmpty() || StudentEmail.isEmpty() || Password.isEmpty() || StudentID.isBlank() || StudentName.isBlank() || StudentEmail.isBlank() || Password.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Fill Out All Mandatory Fields");
            alert.setTitle("ERROR");
            alert.showAndWait();
            return;
        }
        try {
            Connection connection = DriverManager.getConnection(dburl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into Assignment4.Students (StudentID, StudentName, StudentEmail, StudentPassword) Values (?, ?, ?, ?)");
            preparedStatement.setString(1, StudentID);
            preparedStatement.setString(2, StudentName);
            preparedStatement.setString(3, StudentEmail);
            preparedStatement.setString(4, Password);
            int AddedRows = preparedStatement.executeUpdate();
            if (AddedRows > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Student Was Successfully Added");
                alert.setTitle("Success");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
