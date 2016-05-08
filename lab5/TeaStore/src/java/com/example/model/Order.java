/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author fadyyounan
 */
public class Order {
    
    private TeaBrand teaBrand;
    private int quantity;

    public Order(TeaBrand teaBrand) {
        this.teaBrand = teaBrand;
    }

    public Order(TeaBrand teaBrand, int quantity) {
        this.teaBrand = teaBrand;
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TeaBrand getTeaBrand() {
        return teaBrand;
    }

    public void setTeaBrand(TeaBrand teaBrand) {
        this.teaBrand = teaBrand;
    }
    
    public double getTotalPrice(){
        return teaBrand.getPrice()*getQuantity();
    }
}
