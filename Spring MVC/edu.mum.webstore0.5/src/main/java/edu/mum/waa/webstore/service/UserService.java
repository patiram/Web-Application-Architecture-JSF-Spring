/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service;

import org.springframework.stereotype.Service;
import edu.mum.waa.webstore.domain.User;
/**
 *
 * @author patir
 */
public interface UserService {
    boolean authenticate (User user);
}
