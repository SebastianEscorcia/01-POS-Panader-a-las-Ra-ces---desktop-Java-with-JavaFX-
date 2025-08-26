package presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Cambiar la ruta al archivo login.fxml
        Parent root = FXMLLoader.load(getClass().getResource("/presentation/login/login.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Panadería Las Raíces - Inicio de Sesión");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
