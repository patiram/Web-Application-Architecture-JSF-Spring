/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service;

/**
 *
 * @author patir
 */
public interface OrderService {
    void processOrder(String productId, int count);
}
