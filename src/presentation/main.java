/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentation;


import java.util.Scanner;
import presentation.menu.PresentationMenu;

/**
 *
 * @author GABRIEL POLO
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        String nombre = null;
        boolean disponible = false;
        double price = 0;
        int stock = 0;
        String id = null;
        PresentationMenu menu = new PresentationMenu();
        try (Scanner sc = new Scanner(System.in)) {
            do {
                op = PresentationMenu.seleccionMenu(sc);
                if (op != 5) {
                    menu.seleccionarOpcion(op,nombre,disponible,price,stock,id);
                }
            } while (op != 5);
            System.out.println("Gracias por usar el sistema.");
        }
    }

}
