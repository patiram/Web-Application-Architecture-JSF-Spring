/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository.impl;

import edu.mum.waa.webstore.domain.User;
import edu.mum.waa.webstore.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author patir
 */
@Repository
public class InMemoryUserRepository implements UserRepository{
    private final List<User> listOfUser;

    public InMemoryUserRepository() {
        listOfUser = new ArrayList<>();
        listOfUser.add(new User("patiram","patiram"));
        listOfUser.add(new User("admin","admin"));
    }

    @Override
    public User getUsertById(String userId) {
       for(User user: listOfUser){
           if(user.getUserId().equals(userId)){
               return user;
           }
       }
       return null;
    }
    
}
