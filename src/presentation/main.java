package presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Cargar el archivo FXML de la vista inicial (por ejemplo, el login o registro)
        Parent root = FXMLLoader.load(getClass().getResource("/presentation/registro_producto/registro_producto.fxml"));

        // Crear la escena y mostrarla
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Panadería Las Raíces - Registro de Producto");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Este método inicia JavaFX
    }
}
