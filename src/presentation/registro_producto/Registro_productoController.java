package presentation.registro_producto;

import controllers.ProductController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.ResourceBundle;

public class Registro_productoController implements Initializable {

    @FXML private TextField txtNombre;
    @FXML private TextField txtCantidad;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtId;
    @FXML private CheckBox chkStock;

    private final ProductController productController;

    public Registro_productoController() {
        this.productController = new ProductController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Puedes dejar esto vacío o usarlo para inicializar datos
    }

    @FXML
    private void registrarProducto() {
        try {
            // Obtener valores desde los campos del formulario
            String nombre = txtNombre.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());
            String id = txtId.getText();
            boolean inStock = chkStock.isSelected();

            // Llamar al backend
            productController.crearProducto(nombre, cantidad, precio, inStock, id);
            
            // Mostrar confirmación
            mostrarAlerta("Éxito", "Producto registrado correctamente.", AlertType.INFORMATION);

            // Limpiar campos (opcional)
            limpiarFormulario();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "Verifica que los campos de cantidad y precio sean numéricos.", AlertType.ERROR);
        } catch (Exception e) {
            mostrarAlerta("Error", "Ocurrió un error al registrar el producto: " + e.getMessage(), AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarFormulario() {
        txtNombre.clear();
        txtCantidad.clear();
        txtPrecio.clear();
        txtId.clear();
        chkStock.setSelected(false);
    }
}
