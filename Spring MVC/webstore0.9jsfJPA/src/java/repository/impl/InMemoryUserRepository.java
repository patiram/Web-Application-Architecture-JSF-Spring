/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import domain.User;
import repository.UserRepository;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Rakesh Shrestha
 */
public class InMemoryUserRepository implements UserRepository{
    
    Map<String, User> users;

    public InMemoryUserRepository() {
        users = new HashMap<String, User>();
        
        User rakesh = new User("klevi", "p");
        users.put(rakesh.getUserId(), rakesh);
    }
    
    @Override
    public User getByUserId(String userId) {
        return users.get(userId);
    }
    
}
