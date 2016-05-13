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
import javax.inject.Inject;
import javax.inject.Named;

@Named("control")
@SessionScoped
public class TeaController implements Serializable
{
    @Inject
    private TeaModel model;
    
    private String TeaName;

    public String getTeaName() {
        return TeaName;
    }

    public void setTeaName(String TeaName) {
        this.TeaName = TeaName;
    }
    
    public List<SelectItem> getBrandValue()
    {
       List<SelectItem> brands = new ArrayList<SelectItem>();
       SelectItem item1 = new SelectItem("L", "Light");
       SelectItem  item2 = new SelectItem("A","Amber");
       SelectItem  item3 = new SelectItem("B","Brown");
       SelectItem  item4 = new SelectItem("D","Dark");
       brands.add(item1);
       brands.add(item2);
       brands.add(item3);
       brands.add(item4);
       return brands;
    }
    
    public List getBrands(String type) 
    {
        model.LstItems = new ArrayList();
        if (type.equals("A"))
        {       
            model.LstItems.add("Jack Amber");    
            model.LstItems.add("Red Moose");     
        }   
        else
        {   
            model.LstItems.add("Jail Pale Ale"); 
            model.LstItems.add("Gout Stout");    
        }   
        return(model.LstItems); 
    }
    
}
