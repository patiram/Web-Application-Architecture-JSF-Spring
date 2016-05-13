/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository;

import edu.mum.waa.webstore.domain.Cart;

/**
 *
 * @author Rakesh Shrestha
 */
public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart updatedCart);
    void delete(String cartID);
}
