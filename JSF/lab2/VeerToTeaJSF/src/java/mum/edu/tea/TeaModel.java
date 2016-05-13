/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.tea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named("model")
@SessionScoped
public class TeaModel implements Serializable
{
    private String brands;
    List LstItems;
    
    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getBrands() {
        return brands;
    }

    public List getLstItems() {
        return LstItems;
    }

    public void setLstItems(List LstItems) {
        this.LstItems = LstItems;
    }
}
