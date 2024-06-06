package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginController {

    @FXML
    private ImageView ReturnIV;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField UsernameTF;
    @FXML
    private PasswordField PasswordPF;

    final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
    final String username = "Arham";
    final String password = "zargham100504";




    @FXML
    protected void Login(){
        String Username = UsernameTF.getText();
        String Password = PasswordPF.getText();
        if(Username.isEmpty() || Password.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Fill Out All Mandatory Fields");
            alert.setTitle("ERROR");
            alert.showAndWait();
            return;
        }
        try{
            Connection connection = DriverManager.getConnection(dburl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("Select Password from Assignment4.AdminTable where Username = ?");
            preparedStatement.setString(1, Username);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){

                String dbPassword = rs.getString("Password");
                if(Password.equals(dbPassword)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Administrator Was Successfully Logged In");
                    alert.setTitle("Success");
                    alert.showAndWait();
                    Stage primaryStage = (Stage) LoginButton.getScene().getWindow();
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
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
    @FXML
    protected void Return() throws IOException {
        Stage stage = (Stage) LoginButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Roles.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        stage.setScene(scene);
        stage.show();
    }
}
