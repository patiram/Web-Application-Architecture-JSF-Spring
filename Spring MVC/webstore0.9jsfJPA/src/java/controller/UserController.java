/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.User;
import service.UserService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import service.impl.UserServiceImpl;


/**
 *
 * @author Rakesh Shrestha
 */
@Named("userBean")
@RequestScoped
//@SessionScoped
//@SessionAttributes("user")
public class UserController implements Serializable{

    private User  user;
    private String tagline ="Welcome to the one and only amazing webstore";
    
    private UserService userService = new UserServiceImpl();

    public UserController() {
        this.user = new User();
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }




    public String authenticate() {
        if (userService.authenticate(user)) {
            return "welcome?faces-redirect=true&amp;id=" + user.getUserId() + "&amp;tag=" + tagline;
        } else {
            throw new IllegalArgumentException("UserId and/or password invalid.");
        }
    }


    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }
}
