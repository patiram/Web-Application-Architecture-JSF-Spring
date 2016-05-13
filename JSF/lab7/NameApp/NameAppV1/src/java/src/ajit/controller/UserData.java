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
    
    public String submit(){
        getUserDataMap().put(fname, lname);
        fname="";
        lname="";
        return "nameappv1";
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
