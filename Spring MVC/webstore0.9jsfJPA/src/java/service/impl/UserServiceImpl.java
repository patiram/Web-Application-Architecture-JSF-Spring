/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.User;
import repository.UserRepository;
import repository.impl.InMemoryUserRepository;
import service.UserService;


/**
 *
 * @author Rakesh Shrestha
 */

public class UserServiceImpl implements UserService{
    
    UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new InMemoryUserRepository();
    }


    @Override
    public boolean authenticate(User user) {
        User userWithMatchingId = userRepository.getByUserId(user.getUserId());
        if(userWithMatchingId != null)
            return true;  //userWithMatchingId.getPassword().equals(user.getPassword());
        return false;
    }
    
}
