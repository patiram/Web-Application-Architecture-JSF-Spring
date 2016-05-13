/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

//import domain.Product;
import domain.ProductEntity;
import repository.ProductRepository;
import service.OrderService;


/**
 *
 * @author Rakesh Shrestha
 */
public class OrderServiceImpl implements OrderService {

    ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int quantity) {
        ProductEntity orderdProduct = productRepository.findProductById(productId);

        if (orderdProduct != null) {
            if (quantity < orderdProduct.getUnitsInStock()) {
                orderdProduct.setUnitsInStock(
                        orderdProduct.getUnitsInStock() - quantity);
            } else {
                throw new IllegalArgumentException(String.format("Order quantity "
                        + "is greater than or equal to availabe quantity %d", 
                        orderdProduct.getUnitsInStock()));
            }
        }
    }

}
