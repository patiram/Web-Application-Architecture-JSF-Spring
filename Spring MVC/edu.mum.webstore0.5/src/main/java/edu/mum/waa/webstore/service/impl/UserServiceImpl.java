/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service.impl;

import edu.mum.waa.webstore.domain.User;
import edu.mum.waa.webstore.repository.UserRepository;
import edu.mum.waa.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author patir
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    private User newUser;

    @Override
    public boolean authenticate(User user) {
      newUser = new User();
      newUser = userRepository.getUsertById(user.getUserId());
      if(newUser!=null && newUser.getPassword().equals(user.getPassword())){
          return  true;
      }else{
          return false;
      }
      
    }
    
}
