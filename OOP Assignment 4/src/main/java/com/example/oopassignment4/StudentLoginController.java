package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentLoginController {
        @FXML
        private Button LoginButton;
        @FXML
        private TextField EmailTF;
        @FXML
        private PasswordField PasswordPF;
        @FXML
        private ImageView ReturnIV;

        final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
        final String username = "Arham";
        final String password = "zargham100504";

        @FXML
        protected void LoginStudent()
        {
            String Email = EmailTF.getText();
            String Password = PasswordPF.getText();
            if(Email.isEmpty() || Password.isEmpty() || Email.isBlank() || Password.isBlank())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Fill Out All Mandatory Fields");
                alert.setTitle("ERROR");
                alert.showAndWait();
                return;
            }
            try
            {
                Connection connection = DriverManager.getConnection(dburl, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("Select StudentPassword from Assignment4.Students where StudentEmail = ?");
                preparedStatement.setString(1, Email);
                ResultSet rs = preparedStatement.executeQuery();
                if(rs.next())
                {
                    String dbPassword = rs.getString("StudentPassword");
                    if(Password.equals(dbPassword))
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Student Was Successfully Logged In");
                        alert.setTitle("Success");
                        alert.showAndWait();
                        Stage stage=(Stage) LoginButton.getScene().getWindow();
                        FXMLLoader loader= new FXMLLoader(HelloApplication.class.getResource("Student-Home.fxml"));
                        Scene scene = new Scene(loader.load());
                        stage.setScene(scene);
                        StudentHomeController controller = loader.getController();
                        controller.setStudentEmail(Email);
                        controller.LoadStudentInfo(Email);
                        stage.show();
                    }
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        @FXML
        protected void Return() throws IOException
        {
            Stage stage=(Stage) ReturnIV.getScene().getWindow();
            FXMLLoader loader= new FXMLLoader(HelloApplication.class.getResource("Roles.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        }
}
