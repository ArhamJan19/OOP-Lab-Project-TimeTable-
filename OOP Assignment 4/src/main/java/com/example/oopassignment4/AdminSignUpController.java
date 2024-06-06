package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminSignUpController {
    @FXML
    private ImageView BackButton;
    @FXML
    protected void GoBack() throws IOException {
        Stage stage = (Stage) BackButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Roles.fxml"));
        Scene scene = new Scene(loader.load(),600, 400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TextField FNameTB;
    @FXML
    private TextField LNameTB;
    @FXML
    private TextField UsernameTB;
    @FXML
    private PasswordField PasswordPF;
    @FXML
    private Button SignUpButton;
    @FXML
    private Hyperlink LoginHyperLink;
    @FXML
    protected void OpenLoginForm() throws IOException {
        Stage stage = (Stage) LoginHyperLink.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Admin-Login.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        stage.setScene(scene);
        stage.show();
    }

    final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
    final String username = "Arham";
    final String password = "zargham100504";
    @FXML
    protected void initialize (){
        SignUpButton.setOnAction(e-> RegisterAdmin());
    }

    private void RegisterAdmin() {
        String FirstName = FNameTB.getText();
        String LastName = LNameTB.getText();
        String Username = UsernameTB.getText();
        String Password = PasswordPF.getText();
        if(FirstName.isEmpty() || LastName.isEmpty() || Username.isEmpty() || Password.isEmpty() || FirstName.isBlank() || LastName.isBlank() || Username.isBlank() || Password.isBlank() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Fill Out All Mandatory Fields");
            alert.setTitle("ERROR");
            alert.showAndWait();
            return;
        }

        try {
            Connection connection = DriverManager.getConnection(dburl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into Assignment4.AdminTable (FirstName, LastName, UserName, Password) Values (?, ?, ?, ?)" );
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, LastName);
            preparedStatement.setString(3, Username);
            preparedStatement.setString(4, Password);
            int AddedRows = preparedStatement.executeUpdate();
            if(AddedRows > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Admin Registration Was A Success");
                alert.setTitle("Success");
                alert.showAndWait();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
