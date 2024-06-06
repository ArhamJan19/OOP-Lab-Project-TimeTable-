package com.example.oopassignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FacultyHomeController {
    private String TeacherUsername;

    public void setTeacherUsername(String TeacherUsername) {
        this.TeacherUsername = TeacherUsername;
    }

    public String getTeacherUsername() {
        return this.TeacherUsername;
    }

    @FXML
    private Label NameLabel;
    @FXML
    private Label DepartmentLabel;
    @FXML
    private ImageView ReturnIV;

    @FXML
    private TableView<TimetableEntry> TimeTableGV;
    @FXML
    private TableColumn<TimetableEntry, String> dayColumn;
    @FXML
    private TableColumn<TimetableEntry, String> timeColumn;
    @FXML
    private TableColumn<TimetableEntry, String> courseColumn;
    @FXML
    private TableColumn<TimetableEntry, String> sectionColumn;
    @FXML
    private TableColumn<TimetableEntry, String> roomColumn;

    final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
    final String username = "Arham";
    final String password = "zargham100504";

    @FXML
    public void initialize() {
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
    }

    public void LoadTeacherInfo(String username) {
        try (Connection con = DriverManager.getConnection(dburl, this.username, this.password)) {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM teachertable WHERE Username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                NameLabel.setText(resultSet.getString("TeacherName"));
                DepartmentLabel.setText(resultSet.getString("Department"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    protected void GenerateTimeTable() {
        ObservableList<TimetableEntry> timetableData = FXCollections.observableArrayList();
        try (Connection con = DriverManager.getConnection(dburl, this.username, this.password)) {
            String sql = "SELECT Timetable.Day, Timetable.Time, course.CourseName, Sectiontable.SectionName, Rooms.RoomNumber, Teachertable.TeacherName " +
                    "FROM Timetable " +
                    "JOIN course ON Timetable.CourseID = course.CourseID " +
                    "JOIN Sectiontable ON Timetable.SectionID = Sectiontable.SectionID " +
                    "JOIN Rooms ON Timetable.RoomID = Rooms.RoomID " +
                    "JOIN Teachertable ON Timetable.TeacherID = Teachertable.TeacherID " +
                    "WHERE Teachertable.Username = ? " +
                    "ORDER BY FIELD(Day, 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'), Time";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, getTeacherUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                timetableData.add(new TimetableEntry(
                        resultSet.getString("Day"),
                        resultSet.getString("Time"),
                        resultSet.getString("CourseName"),
                        resultSet.getString("SectionName"),
                        resultSet.getString("RoomNumber"),
                        resultSet.getString("TeacherName")
                ));
            }
            TimeTableGV.setItems(timetableData);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    protected void Return() throws IOException
    {
        Stage stage=(Stage) ReturnIV.getScene().getWindow();
        FXMLLoader loader= new FXMLLoader(HelloApplication.class.getResource("Faculty-Login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}
