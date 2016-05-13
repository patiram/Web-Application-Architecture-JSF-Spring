/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

//import domain.Product;
import domain.ProductEntity;
import java.util.List;

/**
 *
 * @author Rakesh Shrestha
 */
public interface ProductRepository {
//    List<ProductEntity> retrieveAllProducts();
//    ProductEntity findProductById(String productId);
    
    List<ProductEntity> retrieveAllProducts();
    ProductEntity findProductById(String productId);    
    
    void addProduct(ProductEntity product);
    void initRepository();
}
