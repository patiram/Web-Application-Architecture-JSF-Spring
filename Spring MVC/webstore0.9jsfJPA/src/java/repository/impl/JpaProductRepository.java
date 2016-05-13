/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

//import domain.Product;
import domain.ProductEntity;
import repository.ProductRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class JpaProductRepository implements ProductRepository {

    @Inject //this annotation causes the container to inject this dependency
    private repository.impl.ProductEntityFacade productFacade;
    private List<ProductEntity> listOfProduct;

    public JpaProductRepository() {}
        
 

    @Override
    public List<ProductEntity> retrieveAllProducts() {
        listOfProduct = productFacade.findAll();
        return listOfProduct;
    }

    @Override
    public ProductEntity findProductById(String productId) {
        for(ProductEntity product: listOfProduct){
            
            if(product.getProductId().equals(productId)) {
                System.out.println("returning product: " + product.getProductId());
                return product;
            } 
        }
        throw new IllegalArgumentException(
                String.format("Product with id %s not found", productId));
    }

    @Override
    public void addProduct(ProductEntity product) {
        productFacade.create(product);
        listOfProduct.add(product);
    }

    @Override
    public void initRepository() {
        productFacade.init();
    }

}
