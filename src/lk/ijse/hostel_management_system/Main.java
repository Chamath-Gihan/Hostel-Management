package lk.ijse.hostel_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/login_form.fxml"))));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setY(0);
        primaryStage.setTitle("24D Hostel Management System | Login");
    }
}
