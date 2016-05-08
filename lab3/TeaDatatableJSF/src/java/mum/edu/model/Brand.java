/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.model;

import java.io.Serializable;
import java.util.List;
/**
 *
 * @author PatiRam
 */

public class Brand implements Serializable{
    private String category;
    private List<Tea> teaList;
  
    public Brand() {
    }

    public Brand(String category, List<Tea> teaList) {
        this.category = category;
        this.teaList = teaList;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public List<Tea> getTeaList() {
        return teaList;
    }

    public void setTeaList(List<Tea> teaList) {
        this.teaList = teaList;
    }
    
}
