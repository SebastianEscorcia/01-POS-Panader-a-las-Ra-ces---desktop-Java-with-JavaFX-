/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.menu;

import DAL.models.Product;
import controllers.ProductController;
import java.util.Scanner;
import validators.ProductValidators;

/**
 *
 * @author GABRIEL POLO
 */
public class PresentationMenu {

    ProductController controller;
    private final Scanner sc = new Scanner(System.in);

    public PresentationMenu() {
        this.controller = new ProductController();
    }

    public static int seleccionMenu(Scanner escaner) {
        int op;
        do {
            menu();
            System.out.println("Escriba una opcion");
            op = escaner.nextInt();
        } while (op <= 0 || op > 5);
        return op;
    }

    public static void menu() {
        System.out.println("PANADERIA LAS RAICESS");
        System.out.println("1.Guardar Producto");
        System.out.println("2. Consultar Productos");
        System.out.println("3. Eliminar un producto");
        System.out.println("4. Actualizar un producto");
        System.out.println("5. Salir");

    }

    public void seleccionarOpcion(int op, String nombre, boolean disponible, double price, int stock, String id, String rutaImagen) {

        switch (op) {
            case 1:
                menuRegistrarProducto(nombre, disponible, price, stock, id,  rutaImagen);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

            case 5:
                op = 5;
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
                break;
        }

    }

    public void menuRegistrarProducto(String nombre, boolean disponible, double price, int stock, String id, String rutaImagen) {
        char op = 's';
        while (op == 's') {
            System.out.println("REGISTRO PRODUCTO");

            do {
                System.out.println("Nombre:");
                nombre = sc.nextLine();
            } while (!ProductValidators.validarNombre(nombre));

            do {
                System.out.println("Precio:");
                price = sc.nextDouble();
            } while (!ProductValidators.validarPrecio(price));
            do {
                System.out.println("Cantidad en almacen:");
                stock = sc.nextInt();
            } while (!ProductValidators.validarStock(stock));
            char respuesta;
            do {
                System.out.println(" ¿El producto esta disponible para vender? (s/n)");
                respuesta = sc.next().charAt(0);
                switch (respuesta) {
                    case 's', 'S' -> disponible = true;
                    case 'n', 'N' -> disponible = false;
                    default -> System.out.println("Respuesta invalida. Escriba solo 's' o 'n'.");
                }

            } while (respuesta != 's' && respuesta != 'S' && respuesta != 'n' && respuesta != 'N');
            sc.nextLine();
            do {
                System.out.print("Ingrese el ID del producto: ");
                id = sc.nextLine();
            } while (!ProductValidators.validarId(id));

            do {
                System.out.println("Ingre la imagen del producto (ruta) : ");
                rutaImagen = sc.nextLine();
            } while (ProductValidators.validarRutaImagen(rutaImagen));

            controller.crearProducto(nombre, stock, price, disponible, id, rutaImagen);
            do {
                System.out.println("¿Deseas registar otro producto (s/n)?");
                op = sc.next().charAt(0);
            } while (op != 's' && op != 'S' && op != 'n' && op != 'N');
        }

    }

    public void menuActualizarProducto() {
        System.out.println("ACTUALIZAR PRODUCTO");
        String nombre;
        System.out.println("Ingrese el nombre del producto");
        nombre = sc.nextLine();
        Product productoExistente = controller.buscarProducto(nombre);

        if (productoExistente != null) {
            System.out.println("Producto encontrado");
        }
        System.out.println("Producto encontrado : " + productoExistente.getName());

        String newNombre;
        boolean newDisponible = false;
        double newPrice;
        int newStock;
        String newRutaImagen;
        char respuesta;
        sc.nextLine();

        do {
            System.out.print("Nuevo nombre: ");
            newNombre = sc.nextLine();
        } while (!ProductValidators.validarNombre(newNombre));

        do {
            System.out.print("Nuevo precio: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Entrada inválida.");
                sc.next();
            }
            newPrice = sc.nextDouble();
        } while (!ProductValidators.validarPrecio(newPrice));

        do {
            System.out.print("Nueva cantidad: ");
            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida.");
                sc.next();
            }
            newStock = sc.nextInt();
        } while (!ProductValidators.validarStock(newStock));
        
        do {
                System.out.println(" ¿El producto esta disponible para vender? (s/n)");
                respuesta = sc.next().charAt(0);
                switch (respuesta) {
                    case 's', 'S' -> newDisponible = true;
                    case 'n', 'N' -> newDisponible = false;
                    default -> System.out.println("Respuesta invalida. Escriba solo 's' o 'n'.");
                }

            } while (respuesta != 's' && respuesta != 'S' && respuesta != 'n' && respuesta != 'N');

        do {
            System.out.println("Ingrese la imagen  del producto (ruta) : ");
            newRutaImagen = sc.nextLine();
        } while (!ProductValidators.validarRutaImagen(newRutaImagen));
        controller.actualizarProducto(productoExistente,nombre, newPrice, newStock, newDisponible,  newRutaImagen);
    }
}
