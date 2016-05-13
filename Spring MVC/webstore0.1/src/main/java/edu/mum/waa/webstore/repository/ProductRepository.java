/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.repository;

import java.util.List;
import edu.mum.waa.webstore.domain.Product;
/**
 *
 * @author patir
 */
public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(String productId);
}
