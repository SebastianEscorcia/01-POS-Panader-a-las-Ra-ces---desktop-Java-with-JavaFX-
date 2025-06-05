/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import BLL.ProductServices;
import DAL.models.Product;
import validators.ProductValidators;

/**
 *
 * @author GABRIEL POLO
 */
public class ProductController {

    private final ProductServices services;

    public ProductController() {
        this.services = new ProductServices();
    }

    public void crearProducto(String nombre, int cantidad, double precio, boolean inStock, String id) {

        Product producto = new Product();
        try {
            producto.setName(nombre);
            producto.setPrice(precio);
            producto.setQuantity(cantidad);
            producto.setInStock(inStock);
            producto.setId(id);
            if (!ProductValidators.validar(producto)) {
                System.out.println("No se pudo registrar el producto. Verifique los datos ingresados");
                return;
            }
            if (existeProducto(producto)) {
                System.out.println("No se puede registrar este producto, ya se encuentra registrado");
                return;
            }
            services.createProduct(producto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public boolean existeProducto(Product producto) {
        Product encontrar = services.searchProduct(producto.getName());
        return producto.equals(encontrar);
    }

    public Product buscarProducto(String nombre) {
        return services.searchProduct(nombre);
    }

    public void actualizarProducto(Product producto, String name, double price, int stock, boolean disponible) {
        try {
            boolean actualizado = services.updateProduct(producto, name, price, stock, disponible);
            if (actualizado) {
                System.out.println("Producto actualizado Correctamente");
            }
            System.out.println("No se pudo actualizar el producto");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
