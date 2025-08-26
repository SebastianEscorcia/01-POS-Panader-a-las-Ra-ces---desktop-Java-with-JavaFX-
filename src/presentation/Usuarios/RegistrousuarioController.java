package presentation.Usuarios;

import controllers.usuario.UsuarioController;
import DAL.models.Perfil;
import DAL.models.Rol;
import DAL.models.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class RegistrousuarioController implements Initializable {

    @FXML private TextField txtNombreUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private ComboBox<Rol> comboRol;
    @FXML private TableView<Usuario> tablaUsuarios;
    @FXML private TableColumn<Usuario, String> colNombreUsuario;
    @FXML private TableColumn<Usuario, Rol> colRol;
    @FXML private Button btnRegistrar;

    private final UsuarioController usuarioController;
    private final ObservableList<Usuario>  listaUsuarios;

    public RegistrousuarioController() {
        this.listaUsuarios = FXCollections.observableArrayList();
        this.usuarioController = new UsuarioController();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboRol.getItems().addAll(Rol.values());

        colNombreUsuario.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombreUsuario()));
        colRol.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPerfil().getRol()));

        tablaUsuarios.setItems(listaUsuarios);
        cargarUsuarios();

        // Listeners para activar/desactivar botón
        txtNombreUsuario.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        txtPassword.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        comboRol.valueProperty().addListener((obs, oldVal, newVal) -> validarCampos());

        validarCampos(); // Al iniciar
    }


    @FXML
    private void registrarUsuario() {
        try {
            String nombre = txtNombreUsuario.getText();
            String password = txtPassword.getText();
            Rol rol = comboRol.getValue();

            if (nombre.isEmpty() || password.isEmpty() || rol == null) {
                mostrarAlerta("Campos incompletos", "Por favor llena todos los campos", Alert.AlertType.WARNING);
                return;
            }

            Perfil perfil = new Perfil(UUID.randomUUID().toString(), rol);
            Usuario usuario = new Usuario(nombre, password, perfil);

            usuarioController.crearUsuario(usuario);
            listaUsuarios.add(usuario);

            mostrarAlerta("Éxito", "Usuario registrado correctamente", Alert.AlertType.INFORMATION);
            limpiarFormulario();

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

    private void limpiarFormulario() {
        txtNombreUsuario.clear();
        txtPassword.clear();
        comboRol.setValue(null);
    }
    private void cargarUsuarios (){
        try {
            listaUsuarios.setAll(usuarioController.mostrarUsuarios());
        } catch (Exception ignored) {

        }
    }
    private void validarCampos() {
        boolean camposLlenos = !txtNombreUsuario.getText().isEmpty()
                && !txtPassword.getText().isEmpty()
                && comboRol.getValue() != null;

        btnRegistrar.setDisable(!camposLlenos);
    }
}
