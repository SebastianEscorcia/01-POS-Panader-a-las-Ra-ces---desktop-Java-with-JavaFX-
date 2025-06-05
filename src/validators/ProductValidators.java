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

    public static boolean validar(Product producto) {
        return validarNombre(producto.getName())
                && validarPrecio(producto.getPrice())
                && validarStock(producto.getQuantity())
                && validarId(producto.getId());
    }

    public static boolean validarNombre(String nombre) {
        if (nombre == null || nombre.length() < 4 || nombre.length() > 100) {
            System.out.println("El nombre debe tener entre 4 y 100 caracteres");
            return false;
        } 
        return true;
    }

    public static boolean validarPrecio(double price) {
        if (price <= 0) {
            System.out.println("El precio debe ser mayor a 0");
            return false;
        }
        return true;
    }

    public static boolean validarStock(int stock) {

        if (stock <= 0) {
            System.out.println("La cantidad del producto debe ser mayor a 0");
            return false;
        }
        return true;
    }

    public static boolean validarId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("El identificador no puede estar vacio");
            return false;
        }
        return true;
    }
}
