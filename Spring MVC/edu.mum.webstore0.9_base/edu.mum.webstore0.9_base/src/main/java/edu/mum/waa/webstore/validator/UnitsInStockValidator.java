/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.validator;

import edu.mum.waa.webstore.domain.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Rakesh Shrestha
 */
@Component
public class UnitsInStockValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        
        if(product.getUnitPrice() != null && 
                new BigDecimal(1000).compareTo(product.getUnitPrice())<=0 &&
                product.getUnitsInStock()>99){
            errors.rejectValue("unitsInStock", "validator.UnitsInStockValidator.message");
        }
    }
    
}
