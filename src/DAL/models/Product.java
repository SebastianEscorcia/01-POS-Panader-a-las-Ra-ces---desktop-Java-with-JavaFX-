/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.models;

import java.util.Objects;

/**
 *
 * @author GABRIEL POLO
 */
public class Product {
    private String name;
    private int quantity;
    private double price;
    private boolean inStock;
    private String id;

    public Product(String name, int quantity, double price, boolean inStock, String id) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.inStock = inStock;
        this.id = id;
    }
    public Product(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 4 || name.length()> 10000){
            System.out.println("Escribe un nombre mayor a 4 caracteres");
            return;
        }   
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("SOy un producto %s, y este es mi nombre", name);
    }
    
    /**
     *
     * @param obj
     * @return
     */
    @Override
     public boolean equals (Object obj){
         if(this==obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
         Product other  = (Product) obj;
         return this.name!= null && this.name.equals(other.name) && this.id != null && this.id.equals(other.id);     
     }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.quantity;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 67 * hash + (this.inStock ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
