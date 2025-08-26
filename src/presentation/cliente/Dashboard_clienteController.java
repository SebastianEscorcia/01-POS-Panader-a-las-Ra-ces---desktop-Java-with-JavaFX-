package presentation.cliente;

import DAL.models.Singleton.SesionUsuario;
import DAL.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard_clienteController implements Initializable {

    @FXML
    private Label lblNombreCliente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usuario usuario = SesionUsuario.getInstancia().getUsuarioActivo();
        if (usuario != null) {
            lblNombreCliente.setText("Hola, " + usuario.getNombreUsuario());
        } else {
            lblNombreCliente.setText("Cliente no encontrado");
        }
    }
}
