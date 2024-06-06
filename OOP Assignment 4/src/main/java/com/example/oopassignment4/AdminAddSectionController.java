package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminAddSectionController {
    @FXML
    private TextField SectionIDTF;
    @FXML
    private TextField DepartmentTF;
    @FXML
    private TextField SemesterTF;
    @FXML
    private Button AddSectionButton;

    final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
    final String username = "Arham";
    final String password = "zargham100504";
    @FXML
    protected void initialize (){
        AddSectionButton.setOnAction(e-> AddSection());
    }

    @FXML
    protected void AddSection(){
        String SectionID = SectionIDTF.getText();
        String Department = DepartmentTF.getText();
        String Semester = SemesterTF.getText();
        if(SectionID.isEmpty() || Department.isEmpty() || Semester.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Fill Out All Mandatory Fields");
            alert.setTitle("ERROR");
            alert.showAndWait();
            return;
        }
        try {
            Connection connection = DriverManager.getConnection(dburl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into Assignment4.SectionTable (SectionID, Department, Semester) Values (?, ?)" );
            preparedStatement.setString(1, SectionID);
            preparedStatement.setString(2, Department);
            preparedStatement.setString(3, Semester);
            int AddedRows = preparedStatement.executeUpdate();
            if(AddedRows > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Teacher Was Successfully Added");
                alert.setTitle("Success");
                alert.showAndWait();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
