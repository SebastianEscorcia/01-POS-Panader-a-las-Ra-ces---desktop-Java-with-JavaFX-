package presentation.login;

import DAL.models.Singleton.SesionUsuario;
import DAL.models.Usuario;
import controllers.login.LoginController1; // tu clase lógica
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField txtNombreUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnIniciar;

    private LoginController1 controladorLogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorLogin = new LoginController1(); // instanciar el controlador de lógica
    }

    @FXML
    private void iniciarSesion() {
        String nombreUsuario = txtNombreUsuario.getText();
        String password = txtPassword.getText();

        try {
            Usuario usuario = controladorLogin.iniciarSesion(nombreUsuario, password);
            SesionUsuario.getInstancia().setUsuarioActivo(usuario);

            switch (usuario.getPerfil().getRol()) {
                case ADMINISTRADOR:
                    mostrarAlerta("Acceso", "Bienvenido administrador", Alert.AlertType.INFORMATION);
                    cargarVista("/presentation/administrador/dashboard_administrador.fxml");
                    break;
                case CLIENTE:
                    mostrarAlerta("Acceso", "Bienvenido cliente", Alert.AlertType.INFORMATION);
                    cargarVista("/presentation/cliente/dashboard_cliente.fxml");
                    break;
                case TRABAJADOR:
                    mostrarAlerta("Acceso", "Bienvenido trabajador", Alert.AlertType.INFORMATION);
                    cargarVista("/presentation/trabajador/dashboard_trabajador.fxml");
                    break;
                default:
                    throw new IllegalStateException("Rol desconocido");
            }

        } catch (IllegalArgumentException e) {
            mostrarAlerta("Validación", e.getMessage(), Alert.AlertType.WARNING);
        } catch (Exception e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void cargarVista(String rutaFXML) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(rutaFXML));
            javafx.scene.Parent root = loader.load();

            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setScene(new javafx.scene.Scene(root));
            stage.setTitle("Panel de usuario");
            stage.show();

            // Cierra la ventana actual de login
            txtNombreUsuario.getScene().getWindow().hide();

        } catch (Exception e) {
            mostrarAlerta("Error al cargar vista", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
