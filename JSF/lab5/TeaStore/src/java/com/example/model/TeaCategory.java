/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fadyyounan
 */
public class TeaCategory {
    
    protected List<TeaBrand> brands = new ArrayList<TeaBrand>();

    protected String name;
    protected String description;
    protected String image;

    public TeaCategory(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    
    public TeaBrand findBrandByName(String name){
        for(TeaBrand brand:getBrands()){
            if(brand.getName().equals(name)){
                return brand;
            }
        }
        return null;
    }
    
    public void addBrand(TeaBrand brand){
        brands.add(brand);
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
    
    public List<TeaBrand> getBrands() {
        return brands;
    }
}
