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

public class FacultyLoginController
{
    @FXML
    private Button LoginButton;
    @FXML
    private TextField UsernameTF;
    @FXML
    private PasswordField PasswordPF;
    @FXML
    private ImageView ReturnIV;

    final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
    final String username = "Arham";
    final String password = "zargham100504";

    @FXML
    protected void LoginFaculty()
    {
        String Username = UsernameTF.getText();
        String Password = PasswordPF.getText();
        if(Username.isEmpty() || Password.isEmpty())
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
            PreparedStatement preparedStatement = connection.prepareStatement("Select Password from Assignment4.TeacherTable where Username = ?");
            preparedStatement.setString(1, Username);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                String dbPassword = rs.getString("Password");
                if(Password.equals(dbPassword))
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Administrator Was Successfully Logged In");
                    alert.setTitle("Success");
                    alert.showAndWait();
                    Stage stage=(Stage) LoginButton.getScene().getWindow();
                    FXMLLoader loader= new FXMLLoader(HelloApplication.class.getResource("Faculty-Home.fxml"));
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    FacultyHomeController controller = loader.getController();
                    controller.setTeacherUsername(Username);
                    controller.LoadTeacherInfo(Username);
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
