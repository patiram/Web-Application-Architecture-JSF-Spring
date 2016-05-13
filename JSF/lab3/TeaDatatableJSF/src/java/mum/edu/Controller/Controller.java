/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import mum.edu.model.Brand;
import mum.edu.model.Tea;

/**
 *
 * @author PatiRam
 */
@Named("control")
@SessionScoped
public class Controller implements Serializable {

    List<Tea> teaList;
    Tea tea;
    Brand brand;
    List<Tea> selectedTeaList = new ArrayList<>();
    Brand selectedBrand = new Brand();
    private Map<String, Brand> brandWithTea = new HashMap<>();
    String category;
    private boolean showTotal;
    private double totalPrice;
    private final SelectItem[] teaCategories = {
        new SelectItem("light", "Light"),
        new SelectItem("green", "Green"),
        new SelectItem("red", "Red"),
        new SelectItem("yellow", "Yellow")};

    public Controller() {
        teaList = new ArrayList<>();
        tea = new Tea("Tokala", 0, 15);
        teaList.add(tea);
        tea = new Tea("Munna", 0, 9);
        teaList.add(tea);
        brand = new Brand("Light", teaList);
        brandWithTea.put("light", brand);
        teaList = new ArrayList<>();
        tea = new Tea("Himalayan", 0, 12);
        teaList.add(tea);
        tea = new Tea("Uphara", 0, 10);
        teaList.add(tea);
        brand = new Brand("Green", teaList);
        brandWithTea.put("green", brand);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Map<String, Brand> getBrandWithTea() {
        return brandWithTea;
    }

    public void setBrandWithTea(Map<String, Brand> brandWithTea) {
        this.brandWithTea = brandWithTea;
    }

    public List<Tea> getTeaList() {
        return teaList;
    }

    public void setTeaList(List<Tea> teaList) {
        this.teaList = teaList;
    }

    public List<Tea> getSelectedTeaList() {
        selectedTeaList.clear();
        selectedBrand.getTeaList().stream().forEach((tea) -> {
            if (tea.isEditable()) {
                selectedTeaList.add(tea);
            }
        });
        return selectedTeaList;
    }

    public void setSelectedTeaList(List<Tea> selectedTeaList) {
        this.selectedTeaList = selectedTeaList;
    }

    public Brand getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(Brand selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public boolean isShowTotal() {
        return showTotal;
    }

    public void setShowTotal(boolean showTotal) {
        this.showTotal = showTotal;
    }

    public double getTotalPrice() {
        totalPrice = 0.0;
        selectedBrand.getTeaList().stream().forEach(tea->{totalPrice = totalPrice + tea.getPrice()*tea.getQuantity();});
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public SelectItem[] getTeaCategories() {
        return teaCategories;
    }

    public String onSubmitTeaCategories() {
        selectedBrand = brandWithTea.get(category);
        return "teadatatable";
    }
    public String submitTeaOrder(){
        showTotal = true;
        return "receipt?faces-redirect=true";
    }
}
