/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.webstore.controller;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import edu.mum.waa.webstore.service.ProductService;
import edu.mum.waa.webstore.validator.UnitsInStockValidator;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Rakesh Shrestha
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UnitsInStockValidator unitsInStockValidator;
    
    @InitBinder
    public void intialiseBinder(WebDataBinder binder){
        binder.setDisallowedFields("unitsInorder", "discontinued");
        //binder.setValidator(unitsInStockValidator);
        binder.addValidators(unitsInStockValidator);
    }
    
    @RequestMapping //annotation is necesssary for default one too.
    public String getAllProducts(Model model){ 
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    
    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model){
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model, Product newProduct){
        //Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result, HttpServletRequest request){
        String[] suppressedFields = result.getSuppressedFields();
        if (result.hasErrors()) {
            return "addProduct";
        }
        if(suppressedFields.length>0){
            throw new RuntimeException("Attempting to bind disallowed fields: " +
            StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        //unitsInStockValidator.validate(newProduct, result);
        productService.addProduct(newProduct);
        
        return "redirect:/products";
    }
}
