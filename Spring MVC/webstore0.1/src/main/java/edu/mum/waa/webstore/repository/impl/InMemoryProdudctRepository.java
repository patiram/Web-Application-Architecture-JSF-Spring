/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository.impl;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author patir
 */
@Repository
public class InMemoryProdudctRepository implements ProductRepository {

    List<Product> listOfProducts;

    public InMemoryProdudctRepository() {
        listOfProducts = new ArrayList<>();
        Product p2 = new Product("iphone123", "iphone 6", BigDecimal.valueOf(600));
        p2.setDescription("This is best");
        p2.setCategory("iphone");
        p2.setManufacturer("apple");
        p2.setUnitsInStock(100);
        listOfProducts.add(p2);
        Product p1 = new Product("iphone123", "iphone 6s", BigDecimal.valueOf(770));
        p1.setDescription("This is best best best");
        p1.setCategory("iphone iphone");
        p1.setManufacturer("apple apple");
        p1.setUnitsInStock(120);
        listOfProducts.add(p1);
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productId) {
        for (Product p : listOfProducts) {
            if(p.getProductId().equals(productId)){
                return p;
            }
        }
        return null;
    }
}
