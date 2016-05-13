/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

//import domain.Product;
import domain.ProductEntity;
import repository.ProductRepository;
import service.ProductService;
import java.util.List;
import repository.impl.InMemoryProductRepository;
import repository.impl.JpaProductRepository;


/**
 *
 * @author Rakesh Shrestha
 */
public class ProductServiceImpl implements ProductService{
    
    ProductRepository productRepository;
    
    public ProductServiceImpl() {
        //productRepository = new InMemoryProductRepository();
    }
    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        //productRepository = new ();
    }    
    
//    @Override
//    public List<ProductEntity> retrieveAllProducts() {
//        return productRepository.retrieveAllProducts();
//    }

    @Override
    public ProductEntity findProductById(String productId) {
        return productRepository.findProductById(productId);
    }

    @Override
    public void addProduct(ProductEntity product) {
        productRepository.addProduct(product);
    }

    @Override
    public List<ProductEntity> retrieveAllProducts() {
        return productRepository.retrieveAllProducts();
    }

    @Override
    public void initRepository() {
        productRepository.initRepository();
    }
    
}
