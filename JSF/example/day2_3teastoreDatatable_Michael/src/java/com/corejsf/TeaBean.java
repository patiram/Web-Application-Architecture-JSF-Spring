package com.corejsf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;


/**
 *
 * @author Michael
 */
@Named(value="teaBn")
@SessionScoped
public class TeaBean implements Serializable {
    
    private String selectedTeaType;        
    private Tea[] teaSelection = new Tea[] {};
    private List<Tea> teasToBuy = new ArrayList<>();
    private double totalPayDue;

    public TeaBean() {
        this.totalPayDue = 0;
    }

    
    public double getTotalPayDue() {
        return totalPayDue;
    }

    public void setTotalPayDue(double totalPayDue) {
        this.totalPayDue = totalPayDue;
    }

    public List<Tea> getTeaToBuy() {
        return teasToBuy;
    }

    /**
     * JSF action method
     * @return navigation string for next page to display
     */
    public String updateTeasToBuy() {
        //totalPayDue = 0.0;
        for (int i=0; i<teaSelection.length;++i) {
            if (teaSelection[i].isSelected()) {
                teasToBuy.add(teaSelection[i]);
                totalPayDue += teaSelection[i].getTotalPayDue();
            }                
        } 
        return "checkout";
    }

    public String getSelectedTeaType() {
        return selectedTeaType;
    }

    public void setSelectedTeaType(String selectedTeaType) {
        this.selectedTeaType = selectedTeaType;
        //updateTeaList();
    }

    public Tea[] getTeaSelection() {           
        return teaSelection;
    }
    
    /**
     * jsf action method
     * @return nav string
     */
    public String updateTeaList() {
        List<Tea> teaList = new ArrayList<> () ;
        switch(this.selectedTeaType) {
            case "class1":
                teaList = teaList1;
                break;
            case "class2":
                teaList = teaList2;
                break;            
            case "class3":
                teaList = teaList3;
                break;                           
        }
        teaSelection = new Tea[teaList.size()];
        for (int i=0; i<teaList.size(); ++i) {
            teaSelection[i] = teaList.get(i);
            teaSelection[i].setSelected(false);
            teaSelection[i].setItemsCount(0);
        }
        return "buytea";
    }

    
    private static List<Tea> teaList1 = new ArrayList<Tea> () {{
        add(new Tea("White Teas", "class1", 20.00, "White tea is the purest and least processed of all teas.  This loose leaf tea brews a light color and flavor."));
        add(new Tea("Green Teas", "class1", 25.00,  "Green tea is the most popular type of tea, mainly because it is the beverage of choice in Asia. Some loose green teas are scented with flowers or mixed with fruits to create scented or flavored teas."));
        add(new Tea("Oolong Teas", "class1",22.00,  "Oolong tea, also known as wu long tea, is full-bodied with a flavorful fragrance and sweet aroma.  Most people commonly recognize oolong tea as the Chinese tea served in Chinese restaurants."));
    }};
    private static List<Tea> teaList2 = new ArrayList<Tea> () {{
        add(new Tea("Black Teas", "class2", 30.00,  "Black tea is the tea most people know since you likely grew up dipping tea bags of black tea in your cup (or enjoyed this tea from an iced tea pitcher in the South)."));
        add(new Tea("Herbal Teas", "class2", 33.00,  "Herbal tea does not contain any leaves from the Camellia plant family, so it is sometimes referred to as a tisane. Herbal teas can be broken into three categories: rooibos teas, mate teas, and herbal infusions. Herbal infusions consist of pure herbs, flowers, and fruits. They can be delicious hot or iced."));
        add(new Tea("Rooibos Teas", "class2", 34.00,  "Rooibos tea, or red tea, is made from a South African red bush. Rooibos teas can be delicious hot or iced."));

    }};
    private static List<Tea> teaList3 = new ArrayList<Tea> () {{
        add(new Tea("Mate Teas", "class3", 23.00,  "Mate tea is considered the coffee lover's favorite tea. Made from the leaves and twigs of the yerba mate plant, our My Morning Mate is a particular favorite of coffee drinkers because it tastes like coffee."));
        add(new Tea("Blooming Teas", "class3", 24.00,  "Also called artisan or flowering teas, these teas actually 'bloom' as they steep. They are hand tied by tea artists and often include some type of flavor or scent along with the beautiful design. These romantic teas make a great gift for your significant other!"));   
    }};
    

    
}
