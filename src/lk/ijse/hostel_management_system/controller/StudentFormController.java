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
import lk.ijse.hostel_management_system.bo.custom.StudentBO;
import lk.ijse.hostel_management_system.dto.StudentDTO;
import lk.ijse.hostel_management_system.util.Navigation;
import lk.ijse.hostel_management_system.util.Routes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentFormController {

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.Type.STUDENT);

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDateOfBirth;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<StudentDTO> tblStudent;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private DatePicker txtDateOfBirth;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    public void initialize() {
        cmbGender.setItems(FXCollections.observableArrayList("Male","Female"));
        txtID.setEditable(false);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        txtID.setEditable(false);
        btnSave.setDisable(true);

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
                btnSave.setDisable(true);
            }
        });

        loadStudentData("");
    }

    private void loadStudentData(String SearchID) {
        ObservableList<StudentDTO> list = FXCollections.observableArrayList();

        ArrayList<StudentDTO> studentDTOS = studentBO.getStudentData();
        for (StudentDTO std : studentDTOS) {
            if (std.getId().contains(SearchID) ||
                    std.getName().contains(SearchID) ||
                    std.getAddress().contains(SearchID)) {
                StudentDTO studentDTO = new StudentDTO(std.getId(),
                        std.getName(), std.getAddress(),
                        std.getContact_no(),
                        std.getDob(),
                        std.getGender());
                list.add(studentDTO);
            }
        }
        tblStudent.setItems(list);
    }

    private void setData(StudentDTO newValue) {
        txtID.setText(newValue.getId());
        txtName.setText(newValue.getName());
        txtAddress.setText(newValue.getAddress());
        txtContact.setText(newValue.getContact_no());
        txtDateOfBirth.setValue(LocalDate.parse(newValue.getDob()));
    }

    private boolean isValidContact() {
        Pattern pattern = Pattern.compile("^(?:7|0|(?:\\+94))[0-9]{9,10}$");
        Matcher matcher = pattern.matcher(txtContact.getText());

        boolean isMatches = matcher.matches();
        if (isMatches) {
            return true;
        } else {
            Shake shakeUserName = new Shake(txtContact);
            txtContact.requestFocus();
            shakeUserName.play();
            return false;
        }
    }

    private boolean isValidAddress() {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{3,}$");
        Matcher matcher = pattern.matcher(txtAddress.getText());

        boolean isMatches = matcher.matches();
        if (isMatches) {
            return true;
        } else {
            Shake shakeUserName = new Shake(txtAddress);
            txtAddress.requestFocus();
            shakeUserName.play();
            return false;
        }
    }

    private boolean isValidName() {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{3,}$");
        Matcher matcher = pattern.matcher(txtName.getText());

        boolean isMatches = matcher.matches();
        if (isMatches) {
            return true;
        } else {
            Shake shakeUserName = new Shake(txtName);
            txtName.requestFocus();
            shakeUserName.play();
            return false;
        }
    }

    @FXML
    void btnBackOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, root);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Deleted Selected ?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {
            String idText = txtID.getText();

            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(idText);

            Boolean isAdded = studentBO.deleteStudent(studentDTO);

            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION, " Student Deleted ! ").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, " Error ! ").show();
            }
        }

        loadStudentData("");
    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        clearFields();

        btnSave.setDisable(false);
        btnSave.setText("Save");
        String nextID = generateNextID(studentBO.getCurrentID());
        txtID.setText(nextID);
        txtName.requestFocus();
    }

    private void clearFields() {
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtDateOfBirth.setValue(LocalDate.parse("2000-01-01"));
    }

    private String generateNextID(String currentID) {
        if (currentID != null) {
            int nextNumber = Integer.parseInt(currentID) + 1;
            return String.format("%02d", nextNumber); // Assuming you want a 2-digit format
        }
        return "01";
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (!txtName.getText().equals("") || txtID.getText().equals("") || txtContact.getText().equals("")) {
            String nameText = txtName.getText();
            String addressText = txtAddress.getText();
            String contactText = txtContact.getText();
            String idText = txtID.getText();
            System.out.println(idText);
            String dobText = txtDateOfBirth.getValue().toString();
            String genderText = cmbGender.getValue();

            // regex
            if (isValidName() && isValidAddress() && isValidContact()) {
                if (btnSave.getText().equals("Save")) {
                    StudentDTO studentDTO = new StudentDTO(idText, nameText, addressText, contactText, dobText, genderText);
                    Boolean isAdded = studentBO.addStudent(studentDTO);

                    if (isAdded) {
                        new Alert(Alert.AlertType.INFORMATION, " Student Added ! ").show();
                    } else {
                        new Alert(Alert.AlertType.ERROR, " Error ! ").show();
                    }
                }

                if (btnSave.getText().equals("Update")) {
                    StudentDTO studentDTO = new StudentDTO(idText, nameText, addressText, contactText, dobText, genderText);
                    Boolean isUpdated = studentBO.updateStudent(studentDTO);

                    if (isUpdated) {
                        new Alert(Alert.AlertType.INFORMATION, " Student Updated ! ").show();
                        clearFields();
                    } else {
                        new Alert(Alert.AlertType.ERROR, " Error ! ").show();
                        clearFields();
                    }
                }
                loadStudentData("");

            } else {
                new Alert(Alert.AlertType.WARNING, "Fill data !").show();
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String nameText = txtName.getText();
        String addressText = txtAddress.getText();
        String contactText = txtContact.getText();
        String idText = txtID.getText();
        String dobText = txtDateOfBirth.getValue().toString();
        String genderText = cmbGender.getValue();

        StudentDTO studentDTO = new StudentDTO(idText, nameText, addressText, contactText, dobText, genderText);
        System.out.println(studentDTO.getId());
        Boolean isUpdated = studentBO.updateStudent(studentDTO);

        if (isUpdated) {
            loadStudentData("");
            new Alert(Alert.AlertType.INFORMATION, " Student Updated ! ").show();
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, " Error ! ").show();
            clearFields();
        }
    }

    @FXML
    void cmbGenderOnAction(ActionEvent event) {

    }
}
