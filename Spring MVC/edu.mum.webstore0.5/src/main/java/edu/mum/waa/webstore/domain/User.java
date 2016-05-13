/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.domain;

import java.io.Serializable;

/**
 *
 * @author patir
 */
public class User implements Serializable{
    private String userId;
    private String password;
    private boolean rememberUserId;

    public User() {
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberUserId() {
        return rememberUserId;
    }

    public void setRememberUserId(boolean rememberUserId) {
        this.rememberUserId = rememberUserId;
    }

    
}
