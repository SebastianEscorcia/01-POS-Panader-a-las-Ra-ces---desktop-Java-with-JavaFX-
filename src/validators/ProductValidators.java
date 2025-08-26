/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import DAL.models.Product;

/**
 *
 * @author GABRIEL POLO
 */
public class ProductValidators {

    public static String validarYObtenerMensaje(Product producto) {
        if (!validarNombre(producto.getName()))
            return "El nombre debe tener entre 4 y 100 caracteres";
        if (!validarPrecio(producto.getPrice()))
            return "El precio debe ser mayor a 0";
        if (!validarStock(producto.getQuantity()))
            return "La cantidad del producto debe ser mayor a 0";
        if (!validarRutaImagen(producto.getRutaImagen()))
            return "Ingrese la imagen por favor";
        if (!validarId(producto.getId()))
            return "El identificador no puede estar vacío";

        return null; // Todo está bien
    }
    public static boolean validarRutaImagen(String rutaImagen) {
        return rutaImagen != null && !rutaImagen.isEmpty();
    }

    public static boolean validarNombre(String nombre) {
        return nombre != null && nombre.length() >= 4 && nombre.length() <= 100;
    }

    public static boolean validarPrecio(double price) {
        return price > 0;
    }

    public static boolean validarStock(int stock) {
        return stock > 0;
    }

    public static boolean validarId(String id) {
        return id != null && !id.trim().isEmpty();
    }
}
