package com.example.oopassignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class AdminEditTimetableController {

    @FXML
    private TableView<TimetableEntry> timetableTableView;

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

    @FXML
    private TableColumn<TimetableEntry, String> instructorColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    private ObservableList<TimetableEntry> timetableData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize the table columns
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
        instructorColumn.setCellValueFactory(new PropertyValueFactory<>("instructor"));

        // Load sample data (replace with actual data loading logic)
        loadSampleData();

        // Add data to the table
        timetableTableView.setItems(timetableData);

        // Set button actions
        addButton.setOnAction(event -> addTimetableEntry());
        editButton.setOnAction(event -> editTimetableEntry());
        deleteButton.setOnAction(event -> deleteTimetableEntry());
    }

    private void loadSampleData() {
        // Sample data (replace with actual data loading from database)
        timetableData.add(new TimetableEntry("Monday", "8:30 AM", "Object Oriented Programming", "Section A", "Room 4-19", "Dr. Tamim"));
        timetableData.add(new TimetableEntry("Tuesday", "9:30 AM", "Discrete", "Section A", "Room 4-18", "Engr. Sadaf"));
        // Add more sample data as needed
    }

    private void addTimetableEntry() {
        // Implement logic to add a new timetable entry
        TimetableEntry newEntry = getTimetableEntryFromUser();
        if (newEntry != null) {
            timetableData.add(newEntry);
        }
    }

    private void editTimetableEntry() {
        // Implement logic to edit the selected timetable entry
        TimetableEntry selectedEntry = timetableTableView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            TimetableEntry updatedEntry = getTimetableEntryFromUser(selectedEntry);
            if (updatedEntry != null) {
                timetableData.set(timetableData.indexOf(selectedEntry), updatedEntry);
            }
        } else {
            showAlert("No Selection", "Please select a timetable entry to edit.");
        }
    }

    private void deleteTimetableEntry() {
        // Implement logic to delete the selected timetable entry
        TimetableEntry selectedEntry = timetableTableView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null) {
            timetableData.remove(selectedEntry);
        } else {
            showAlert("No Selection", "Please select a timetable entry to delete.");
        }
    }

    private TimetableEntry getTimetableEntryFromUser() {
        return getTimetableEntryFromUser(null);
    }

    private TimetableEntry getTimetableEntryFromUser(TimetableEntry entry) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Timetable Entry");
        dialog.setHeaderText("Enter Timetable Entry Details");

        if (entry != null) {
            dialog.setContentText("Edit the details as needed.");
            dialog.getEditor().setText(entry.toString());
        } else {
            dialog.setContentText("Enter the details as: Day, Time, Course, Section, Room, Instructor");
        }

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String[] details = result.get().split(",");
            if (details.length == 6) {
                return new TimetableEntry(details[0].trim(), details[1].trim(), details[2].trim(), details[3].trim(), details[4].trim(), details[5].trim());
            } else {
                showAlert("Invalid Input", "Please enter all details correctly.");
            }
        }
        return null;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
