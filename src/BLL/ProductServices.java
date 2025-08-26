/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.models.Product;
import java.util.ArrayList;

/**
 *
 * @author GABRIEL POLO
 */
public class ProductServices {

    private final ArrayList<Product> listProducts;

    public ProductServices() {
        this.listProducts = new ArrayList<>();
    }

    public void createProduct(Product producto) {
        try {
            for (Product product : listProducts) {
                if (product.equals(producto)) {
                    System.out.print("El producto ya existe");
                    throw new IllegalArgumentException("El producto ya existe");
                }
            }
            listProducts.add(producto);
            System.out.println("Producto Creado Correctamente ");
        } catch (ExceptionInInitializerError e) {
            e.getMessage();
        }
    }

    public String deleteProduct(Product producto) {
        String mensaje = "";
        try {
            if (listProducts.isEmpty()) {
                System.out.println("No hay productos para borrar, no existe ningun producto");
                mensaje = "No hay productos para borrar, no existe ningun producto";
            } else {
                listProducts.remove(producto);
                mensaje = "Producto eliminado correctamente";
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return mensaje;
    }

    public boolean updateProduct(Product producto, String name, double price, int stock, boolean disponible , String rutaImagen) {
        try {
            for (Product product : listProducts) {
                if (product.equals(producto)) {
                    product.setName(name);
                    product.setPrice(price);
                    product.setQuantity(stock);
                    product.setInStock(disponible);
                    product.setRutaImagen(rutaImagen);
                    return true; // éxito
                }
            }
            return false; // no se encontró
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public Product searchProduct(String nombre) {
        for (Product product : listProducts) {
            if (product.getName() != null && product.getName().equals(nombre)) {
                return product;
            }
            System.out.println("Producto no encontrado");

        }
        return null;
    }

}
