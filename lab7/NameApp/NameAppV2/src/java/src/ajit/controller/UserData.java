/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.ajit.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author Ajit
 */

@Named("userData")
@SessionScoped
public class UserData implements Serializable{
    
    final private Map<String, String> userDataMap;
    
    private String fname;
    
    private String lname;
    
    public UserData(){
        userDataMap = new HashMap();
    }
    
    public String addUser(){
        getUserDataMap().put(fname, lname);
        fname="";
        lname="";
        return "nameappv2";
    }
    
    public void onFirstNameChanged(ValueChangeEvent event){
        
        lname=userDataMap.get(event.getNewValue()+"")==null?"":userDataMap.get(event.getNewValue()+"");
        System.out.println("firstName:"+ lname);
        
        FacesContext.getCurrentInstance().renderResponse();
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the userDataMap
     */
    public Map<String, String> getUserDataMap() {
        return userDataMap;
    }
}
