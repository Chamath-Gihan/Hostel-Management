package lk.ijse.hostel_management_system.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel_management_system.util.Navigation;
import lk.ijse.hostel_management_system.util.Routes;

import java.io.IOException;

public class DashBoardFormController {

    @FXML
    private ImageView btnHostel;

    @FXML
    private ImageView btnReservation;

    @FXML
    private ImageView btnRooms;

    @FXML
    private ImageView btnStudents;

    @FXML
    private AnchorPane root1;

    @FXML
    private AnchorPane root2;

    @FXML
    void btnHostelOnMouseClicked(MouseEvent event) throws IOException {
        setWindow(root2);
    }

    void setWindow(AnchorPane root) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/view/settings_form.fxml"));
        AnchorPane newContent = loader.load();

        root.getChildren().setAll(newContent);
    }

    @FXML
    void btnReservationOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.RESERVATION,root1);
    }

    @FXML
    void btnRoomsOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ROOMS,root1);
    }

    @FXML
    void btnStudentOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.STUDENT,root1);
    }
}
