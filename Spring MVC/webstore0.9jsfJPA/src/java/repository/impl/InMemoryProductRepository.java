/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

//import domain.Product;
import domain.ProductEntity;
import repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Rakesh Shrestha
 */
public class InMemoryProductRepository implements ProductRepository {

    private List<ProductEntity> listOfProduct = null;

    public InMemoryProductRepository() {
        initRepository();
    }

    @Override
    public void initRepository() {
        listOfProduct = new ArrayList<>();

        ProductEntity iPhone = new ProductEntity("P1234", "iPhone", BigDecimal.valueOf(499));
        iPhone.setDescription("iPhone 7");
        iPhone.setCategory("Smart Phone");
        iPhone.setManufacturer("Apple");
        iPhone.setUnitsInStock(100);

        ProductEntity nexus7 = new ProductEntity("P1235", "Nexus 7", BigDecimal.valueOf(350));
        nexus7.setDescription("Nexus 7 tablet");
        nexus7.setCategory("Tablet");
        nexus7.setManufacturer("Asus");
        nexus7.setUnitsInStock(500);

        ProductEntity dellLatitude = new ProductEntity("P1236", "Dell Latitude", BigDecimal.valueOf(700));
        dellLatitude.setDescription("Dell latitude laptop");
        dellLatitude.setCategory("Laptop");
        dellLatitude.setManufacturer("Dell");
        dellLatitude.setUnitsInStock(50);

        listOfProduct.add(iPhone);
        listOfProduct.add(nexus7);
        listOfProduct.add(dellLatitude);

    }

    @Override
    public List<ProductEntity> retrieveAllProducts() {
        return listOfProduct;
    }

    @Override
    public ProductEntity findProductById(String productId) {
        for(ProductEntity product: listOfProduct){
            if(product.getProductId().equals(productId)) {
                return product;
            } 
        }
        throw new IllegalArgumentException(
                String.format("Product with id %s not found", productId));
    }

    @Override
    public void addProduct(ProductEntity product) {
        listOfProduct.add(product);
    }

}
