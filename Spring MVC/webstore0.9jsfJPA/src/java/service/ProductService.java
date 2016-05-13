/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//import domain.Product;
import domain.ProductEntity;
import java.util.List;

/**
 *
 * @author Rakesh Shrestha
 */
public interface ProductService {
//    public List<ProductEntity> getAllProducts();
    public ProductEntity findProductById(String productId);

    public void addProduct(ProductEntity product);

    public List<ProductEntity> retrieveAllProducts();
    public void initRepository();
}
