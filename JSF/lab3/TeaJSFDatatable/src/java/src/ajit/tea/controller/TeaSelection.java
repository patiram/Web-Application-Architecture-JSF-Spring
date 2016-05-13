/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.ajit.tea.controller;

import src.ajit.tea.model.Tea;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Ajit
 */
@Named("teaselect")
@SessionScoped
public class TeaSelection implements Serializable {

    private String color;

    private Map<String, ArrayList<Tea>> teaColorMap;

    private ArrayList<Tea> teaList, selectedTeasList;

    private boolean showTotal;

    private int totalOrder;

    private final SelectItem[] teaColors = {
        new SelectItem("light", "Light"),
        new SelectItem("green", "Green"),
        new SelectItem("red", "Red"),
        new SelectItem("yellow", "Yellow")};

    public TeaSelection() {
        teaColorMap = new HashMap<>();
        ArrayList<Tea> teaList = new ArrayList<>();
        teaList.add(new Tea("Himalayan", 5));
        teaList.add(new Tea("Tokla", 10));
        teaList.add(new Tea("Uday", 15));
        teaColorMap.put("light", teaList);

        teaList = new ArrayList<>();
        teaList.add(new Tea("Mechi", 8));
        teaList.add(new Tea("Upahar", 9));
        teaList.add(new Tea("Uday", 13));
        teaColorMap.put("green", teaList);

        teaList = new ArrayList<>();
        teaList.add(new Tea("Everest", 15));
        teaList.add(new Tea("Upahar", 5));
        teaList.add(new Tea("Tokla", 9));
        teaColorMap.put("red", teaList);

        teaList = new ArrayList<>();
        teaList.add(new Tea("Red Label", 15));
        teaList.add(new Tea("DDC chiya", 5));
        teaList.add(new Tea("Tokla", 10));
        teaColorMap.put("yellow", teaList);
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the teaColors
     */
    public SelectItem[] getTeaColors() {
        return teaColors;
    }

    public String onSubmitTeaColor() {
        return "TeaOrder";
    }

    /**
     * @return the teaList
     */
    public ArrayList<Tea> getTeaList() {
        teaList = teaColorMap.get(color);
        return teaList;
    }

    public String submitTeaOrder() {
        showTotal = true;
        return "OrderDetail?faces-redirect=true";
    }

    /**
     * @return the showTotal
     */
    public boolean getShowTotal() {
        return showTotal;
    }

    public int getTotalOrder() {
        totalOrder = 0;
        selectedTeasList.stream().forEach((tea) -> {
            totalOrder += tea.getQty() * tea.getPrice();
        });
        return totalOrder;
    }

    public ArrayList<Tea> getSelectedTeasList() {
        selectedTeasList = new ArrayList<>();
        teaList.stream().forEach((tea) -> {
            if (tea.isEditable()) {
                selectedTeasList.add(tea);
            }
        });
        return selectedTeasList;
    }

}
