package lk.ijse.hostel_management_system.controller;

import animatefx.animation.FadeIn;
import animatefx.animation.Shake;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

public class LoginFormController {

    UserBO userBO =(UserBO) BOFactory.getBoFactory().getBO(BOFactory.Type.USER);

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private AnchorPane root;

    @FXML
    private ToggleButton toggleButton;

    @FXML
    private Label lblShownPassword;

    public void initialize(){
        lblShownPassword.setVisible(false);
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        Shake shakeUserName = new Shake(txtUserName);
        Shake shakePassword = new Shake(txtPassword);

        if( isCorrectPassword() && isCorrectUserName()){
            txtUserName.setFocusColor(Paint.valueOf("BLUE"));
            Navigation.navigate(Routes.DASHBOARD, pane);
            new FadeIn(pane).setSpeed(3).play();

        }else if (isCorrectPassword() && !isCorrectUserName()) {
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("RED"));
            shakeUserName.play();
        } else if (!isCorrectPassword() && isCorrectUserName()) {
            txtPassword.requestFocus();
            txtPassword.setFocusColor(Paint.valueOf("RED"));
            shakePassword.play();
        } else{
            new Alert(Alert.AlertType.ERROR,"Try again !").show();
            txtPassword.clear();
            txtUserName.clear();
        }
    }

    @FXML
    void txtPasswordOnKeyPressed(KeyEvent event) {
        lblShownPassword.textProperty().bind(Bindings.concat(txtPassword.getText()));
    }

    public void toggleButton(ActionEvent actionEvent) {
        if (toggleButton.isSelected()) {
            lblShownPassword.setVisible(true);
            lblShownPassword.textProperty().bind(Bindings.concat(txtPassword.getText()));
            toggleButton.setText("Hide");

        }else{
            lblShownPassword.setVisible(false);
            txtPassword.setVisible(true);
            toggleButton.setText("Show");
        }
    }

    private boolean isCorrectUserName() {
        String user = userBO.getUser("1");
        if(user == null){
            new Alert(Alert.AlertType.ERROR," Database Error !").show();
            return false;
        }
        return txtUserName.getText().equals(user);
    }

    private boolean isCorrectPassword() {
        String password = userBO.getPassword("1");
        if(password == null){
            new Alert(Alert.AlertType.ERROR," Database Error !").show();
            return false;
        }
        return txtPassword.getText().equals(password);
    }
}
