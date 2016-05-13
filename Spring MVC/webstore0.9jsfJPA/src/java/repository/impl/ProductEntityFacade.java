/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import domain.ProductEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Keith Levi
 */
@Stateless
public class ProductEntityFacade extends AbstractFacade<ProductEntity> {

    @PersistenceContext(unitName = "webstore0.9jsfJPAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductEntityFacade() {
        super(ProductEntity.class);
    }
    
     //  @PostConstruct  //this annotation causes this method to run after the constructor completes
    public void init() {
        //listOfProduct = new ArrayList<>();

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

//        listOfProduct.add(iPhone);
//        listOfProduct.add(nexus7);
//        listOfProduct.add(dellLatitude);
        this.create(iPhone);
        this.create(nexus7);
        this.create(dellLatitude);

    }
}
