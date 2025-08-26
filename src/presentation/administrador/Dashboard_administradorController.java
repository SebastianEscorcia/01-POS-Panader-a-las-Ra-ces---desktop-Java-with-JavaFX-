package presentation.administrador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class Dashboard_administradorController {

    @FXML
    private AnchorPane contenedorContenido;

    @FXML
    private void abrirCrearProducto() {
        cargarVista("/presentation/registro_producto/registro_producto.fxml");
    }

    @FXML
    private void abrirCrearUsuario() {
        cargarVista("/presentation/Usuarios/registro_usuario.fxml");
    }

    private void cargarVista(String rutaFXML) {
        try {
            AnchorPane nuevaVista = FXMLLoader.load(getClass().getResource(rutaFXML));

            // Hacer que la vista cargada ocupe todo el espacio
            AnchorPane.setTopAnchor(nuevaVista, 0.0);
            AnchorPane.setBottomAnchor(nuevaVista, 0.0);
            AnchorPane.setLeftAnchor(nuevaVista, 0.0);
            AnchorPane.setRightAnchor(nuevaVista, 0.0);

            // Reemplazar contenido sin borrar el fondo (la imagen sigue abajo)
            contenedorContenido.getChildren().setAll(nuevaVista);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
