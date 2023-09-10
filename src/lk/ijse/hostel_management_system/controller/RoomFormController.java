package lk.ijse.hostel_management_system.controller;

import animatefx.animation.Shake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel_management_system.bo.BOFactory;
import lk.ijse.hostel_management_system.bo.custom.RoomsBO;
import lk.ijse.hostel_management_system.dto.RoomsDTO;
import lk.ijse.hostel_management_system.util.Navigation;
import lk.ijse.hostel_management_system.util.Routes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomFormController {

    RoomsBO roomsBO = (RoomsBO) BOFactory.getBoFactory().getBO(BOFactory.Type.ROOM);

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView btnBack;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colKeyMoney;

    @FXML
    private TableColumn<?, ?> colQTY;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<RoomsDTO> tblRooms;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtKeyMoney;

    @FXML
    private TextField txtQty;

    public void initialize() {
        cmbType.setItems(FXCollections.observableArrayList("Non AC","Non AC / Food","AC","AC / Food"));
        colID.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));

        btnSave.setDisable(true);

        tblRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
                btnSave.setDisable(true);
            }
        });
        loadRoomData("");
    }

    private void loadRoomData(String SearchID) {
        ObservableList<RoomsDTO> list = FXCollections.observableArrayList();

        ArrayList<RoomsDTO> roomsDTOS = roomsBO.getRoomsData();
        for (RoomsDTO std : roomsDTOS) {
            if (std.getRoom_type_id().contains(SearchID) ||
                    std.getKey_money().contains(SearchID) ||
                    std.getType().contains(SearchID)) {
                RoomsDTO roomsDTO = new RoomsDTO(
                        std.getRoom_type_id(),
                        std.getType(),
                        std.getKey_money(),
                        std.getQty());
                list.add(roomsDTO);
            }
        }
        tblRooms.setItems(list);
    }

    private void setData(RoomsDTO newValue) {
        txtID.setText(newValue.getRoom_type_id());
        txtKeyMoney.setText(newValue.getKey_money());
        txtQty.setText(String.valueOf(newValue.getQty()));
    }

    @FXML
    void btnBackOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, root);
    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        clearFields();

        btnSave.setDisable(false);
        btnSave.setText("Save");
        //String nextID = generateNextID(roomsBO.getCurrentID());
        //txtRoomTypeID.setText(nextID);
        txtID.requestFocus();
        txtID.setText("RM-");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (!txtID.getText().equals("") || cmbType.getValue().equals("") || txtKeyMoney.getText().equals("")) {
            String roomTypeIDText = txtID.getText();
            String typeText = (String) cmbType.getValue();
            String keyMoneyText = txtKeyMoney.getText();
            int qtyText = Integer.parseInt(txtQty.getText());

            if (isValidRoomTypeID() && isValidType() && isValidKeyMoney() && isValidQTY()) {
                if (btnSave.getText().equals("Save")) {
                    RoomsDTO roomsDTO = new RoomsDTO(roomTypeIDText, typeText, keyMoneyText, qtyText);
                    Boolean isAdded = roomsBO.addRoom(roomsDTO);

                    if (isAdded) {
                        new Alert(Alert.AlertType.INFORMATION, " Room Added ! ").show();
                    } else {
                        new Alert(Alert.AlertType.ERROR, " Error ! ").show();
                    }
                }

                if (btnSave.getText().equals("Update")) {
                    RoomsDTO roomsDTO = new RoomsDTO(roomTypeIDText, typeText, keyMoneyText, qtyText);
                    Boolean isUpdated = roomsBO.updateRoom(roomsDTO);

                    if (isUpdated) {
                        new Alert(Alert.AlertType.INFORMATION, " Room Updated ! ").show();
                        clearFields();
                    } else {
                        new Alert(Alert.AlertType.ERROR, " Error ! ").show();
                        clearFields();
                    }
                }
                loadRoomData("");

            } else {
                new Alert(Alert.AlertType.WARNING, "Fill data !").show();
            }
        }
    }

    private void clearFields() {
        txtID.clear();
        txtKeyMoney.clear();
        txtQty.clear();
    }

    private boolean isValidQTY() {
        Pattern pattern = Pattern.compile("^[0-9]{1,}$");
        Matcher matcher = pattern.matcher(txtQty.getText());

        boolean isMatches = matcher.matches();
        if (isMatches) {
            return true;
        } else {
            Shake shakeUserName = new Shake(txtQty);
            txtQty.requestFocus();
            shakeUserName.play();
            return false;
        }
    }

    private boolean isValidKeyMoney() {
        Pattern pattern = Pattern.compile("^[0-9]{3,}$");
        Matcher matcher = pattern.matcher(txtKeyMoney.getText());

        boolean isMatches = matcher.matches();
        if (isMatches) {
            return true;
        } else {
            Shake shakeUserName = new Shake(txtKeyMoney);
            txtKeyMoney.requestFocus();
            shakeUserName.play();
            return false;
        }
    }

    private boolean isValidType() {
        Pattern pattern = Pattern.compile("^(AC|Non AC|AC / Food|Non AC / Food)$");
        Matcher matcher = pattern.matcher((CharSequence) cmbType.getValue());

        boolean isMatches = matcher.matches();
        if (isMatches) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidRoomTypeID() {
        Pattern pattern = Pattern.compile("^(?:RM-)[0-9]{4}$");
        Matcher matcher = pattern.matcher(txtID.getText());

        boolean isMatches = matcher.matches();
        if (isMatches) {
            return true;
        } else {
            Shake shakeUserName = new Shake(txtID);
            txtID.requestFocus();
            shakeUserName.play();
            return false;
        }
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String roomTypeIDText = txtID.getText();
        String typeText = (String) cmbType.getValue();
        String keyMoneyText = txtKeyMoney.getText();
        int qtyText = Integer.parseInt(txtQty.getText());

        RoomsDTO roomsDTO = new RoomsDTO(roomTypeIDText, typeText, keyMoneyText, qtyText);
        Boolean isUpdated = roomsBO.updateRoom(roomsDTO);

        if (isUpdated) {
            loadRoomData("");
            new Alert(Alert.AlertType.INFORMATION, " Room Updated ! ").show();
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, " Error ! ").show();
            clearFields();
        }
    }

}
