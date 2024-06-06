package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RolesController {
    @FXML
    private Button AdminButton;
    @FXML
    private Button FacultyButton;
    @FXML
    private Button StudentButton;

    @FXML
    public void initialize(){
        AdminButton.setOnAction(e-> {
            try {
                GoToAdminSignUp();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        FacultyButton.setOnAction(e-> {
            try {
                GoToFacultySignUp();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        StudentButton.setOnAction(e-> {
            try {
                GoToStudentSignUp();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void GoToStudentSignUp() throws IOException {
        Stage stage=(Stage) StudentButton.getScene().getWindow();
        FXMLLoader loader= new FXMLLoader(HelloApplication.class.getResource("Student-Login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    private void GoToFacultySignUp() throws IOException {
        Stage stage=(Stage) FacultyButton.getScene().getWindow();
        FXMLLoader loader= new FXMLLoader(HelloApplication.class.getResource("Faculty-Login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    protected void GoToAdminSignUp() throws IOException {
        Stage stage=(Stage) AdminButton.getScene().getWindow();
        FXMLLoader loader= new FXMLLoader(HelloApplication.class.getResource("Admin-Signup.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

}
