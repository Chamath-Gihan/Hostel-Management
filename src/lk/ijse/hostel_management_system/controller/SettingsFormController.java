package lk.ijse.hostel_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel_management_system.util.Navigation;
import lk.ijse.hostel_management_system.util.Routes;

import java.io.IOException;

public class SettingsFormController {

    @FXML
    private ImageView btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnBackOnMouseClicked(MouseEvent event) throws IOException {
        // Load the "dashboard_form.fxml" into the current stage
        loadDashboardForm((Stage) btnBack.getScene().getWindow());
    }

    void loadDashboardForm(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/dashboard_form.fxml"))));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setY(0);
        primaryStage.setTitle("24D Hostel Management System | Login");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }
}
