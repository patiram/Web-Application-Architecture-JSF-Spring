/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu;

import java.io.Serializable;

/**
 *
 * @author PatiRam
 */
public class User implements Serializable {

    private String name;
    private String password;
    private int age;
    private int noOfAttempts;

    public String getName() {
        return name;
    }

    public void setName(String user) {
        this.name = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNoOfAttempts() {
        return noOfAttempts;
    }

    public void setNoOfAttempts(int noOfAttempts) {
        this.noOfAttempts = noOfAttempts;
    }
}