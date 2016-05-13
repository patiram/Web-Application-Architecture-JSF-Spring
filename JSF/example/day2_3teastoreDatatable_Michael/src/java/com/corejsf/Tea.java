/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

/**
 *
 * @author Michael
 */
public class Tea {
    private String name;
    private String type;
    private double price;
    private boolean selected;
    private int itemsCount;
    private double totalPayDue;

    public double getTotalPayDue() {
        totalPayDue = price * itemsCount;
        return totalPayDue;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    
   public boolean isSelected() { return selected; }
   public void setSelected(boolean newValue) { selected = newValue; }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String fullDesc;
    
    public Tea() {
        // Default constructor, keep alive.
    }
    
    public Tea(String name, String type, double price, String fullDesc) {
        this.name = name;
        this.type = type;
        this.fullDesc = fullDesc;
        this.price = price;
    } 
    
    
    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
}
