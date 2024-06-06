package com.example.oopassignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminAddRoomController {
    @FXML
    private TextField RoomNumberTF;
    @FXML
    private TextField CapacityTF;
    @FXML
    private TextField TypeTF;
    @FXML
    private Button AddRoomButton;

    final String dburl = "jdbc:mysql://localhost/Assignment4?serverTimezone=UTC";
    final String username = "Arham";
    final String password = "zargham100504";

    @FXML
    protected void initialize() {
        AddRoomButton.setOnAction(e -> AddRoom());
    }

    @FXML
    protected void AddRoom() {
        String roomNumber = RoomNumberTF.getText();
        String capacity = CapacityTF.getText();
        String type = TypeTF.getText();

        if (roomNumber.isEmpty() || capacity.isEmpty() || type.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "ERROR", "Please Fill Out All Mandatory Fields");
            return;
        }

        try (Connection connection = DriverManager.getConnection(dburl, username, password)) {
            String sql = "INSERT INTO Rooms (RoomNumber, Capacity, Type) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, roomNumber);
            preparedStatement.setInt(2, Integer.parseInt(capacity));
            preparedStatement.setString(3, type);
            int addedRows = preparedStatement.executeUpdate();

            if (addedRows > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Room Was Successfully Added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
