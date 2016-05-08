/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author fadyyounan
 */
public class TeaBrand {
    String name;
    String description;
    String image;
    double price;

    public TeaBrand(String name, String description, String image, double price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
