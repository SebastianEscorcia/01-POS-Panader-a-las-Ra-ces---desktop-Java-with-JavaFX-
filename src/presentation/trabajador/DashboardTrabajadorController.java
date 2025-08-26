package presentation.trabajador;

import DAL.models.Singleton.SesionUsuario;
import DAL.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardTrabajadorController implements Initializable {

    @FXML
    private Label lblNombreTrabajador;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usuario usuario = SesionUsuario.getInstancia().getUsuarioActivo();
        if (usuario != null) {
            lblNombreTrabajador.setText("Hola, " + usuario.getNombreUsuario());
        } else {
            lblNombreTrabajador.setText("Usuario no encontrado");
        }
    }
}
