/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import com.example.model.Order;
import com.example.model.TeaBrand;
import com.example.model.TeaCategory;
import com.example.model.TeaStore;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("store")
@SessionScoped
public class TeaStoreBean implements Serializable {

    protected TeaStore store = new TeaStore();

    private String selectedTeaBrand = "MATCHA JAPANESE GREEN TEA";

    public TeaBrand getCurrentTeaBrand(){
        return store.findCategory(selectedTeaCategory).findBrandByName(selectedTeaBrand);
    }
    
    public String getSelectedTeaBrand() { 
        return selectedTeaBrand; 
    }

    public String changeTeaBrand(String newValue) {
        selectedTeaBrand = newValue;
        return "teaDetails";
    }
    
    private String selectedTeaCategory = "GREEN TEAS";

    public String getSelectedTeaCategory() { return selectedTeaCategory; }

    public String changeTeaCategory(String newValue) {
        selectedTeaCategory = newValue;
        selectedTeaBrand = store.findCategory(selectedTeaCategory).getBrands().get(0).getName();
        return "teaDetails";
    }
    
    public List<TeaCategory> getCategories(){
        return store.getCategories();
    }
    
    public List<TeaBrand> getCurrentBrands(){
        return store.findCategory(selectedTeaCategory).getBrands();
    }
    
    private int orderedQuantity = 0;
    
    public void setQuantity(int q){
        orderedQuantity = q;
    }
    
    public int getQuantity(){
        return orderedQuantity;
    }
    
    public String addToOrder(){
        store.addOrder(getCurrentTeaBrand(), orderedQuantity);  
        orderedQuantity = 0;
        return "shoppingCart";
    }
    
    public List<Order> getOrders(){
        return store.getOrders();
    }
    
    public double getTotalPrice(){
        return store.getTotalPrice();
    }
}
