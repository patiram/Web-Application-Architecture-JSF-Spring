/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.service.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import edu.mum.waa.webstore.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rakesh Shrestha
 */
@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductRepository productRepository;
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }
    
}
