package lk.ijse.hostel_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ReservationFormController {

    @FXML
    private ImageView btnBack;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> cmbRoom;

    @FXML
    private TableColumn<?, ?> colName2;

    @FXML
    private TableColumn<?, ?> colResDate;

    @FXML
    private TableColumn<?, ?> colResID;

    @FXML
    private TableColumn<?, ?> colRoomType;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colStudentName;

    @FXML
    private Label lbl0Price;

    @FXML
    private Label lbl1Price;

    @FXML
    private Label lbl5Price;

    @FXML
    private Label lbl7price;

    @FXML
    private Label lblQty0;

    @FXML
    private Label lblQty1;

    @FXML
    private Label lblQty5;

    @FXML
    private Label lblQty7;

    @FXML
    private RadioButton rbtnAll;

    @FXML
    private RadioButton rbtnLater;

    @FXML
    private RadioButton rbtnPaid;

    @FXML
    private RadioButton rbtnPaid2;

    @FXML
    private RadioButton rbtnPending;

    @FXML
    private TableColumn<?, ?> solStudentID2;

    @FXML
    private TableView<?> tblReservation;

    @FXML
    private TextField txtStudentId;

    @FXML
    void btnBackOnAction(MouseEvent event) {

    }

    @FXML
    void btnNewOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}
