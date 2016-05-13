/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import edu.mum.waa.webstore.service.OrderService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author patir
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private ProductRepository productRepository;
    private Product product = new Product();
    @Override
    public void processOrder(String productId, int count) {
        product = productRepository.getProductById(productId);
        if(product!=null){
            if(product.getUnitsInStock()>count){
                long newCount=product.getUnitsInStock()-count;
                product.setUnitsInStock(newCount);
            }
        }
        
    }
}
