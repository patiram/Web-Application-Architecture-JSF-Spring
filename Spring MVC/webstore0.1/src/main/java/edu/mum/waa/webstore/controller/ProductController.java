/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.waa.webstore.controller;

import edu.mum.waa.webstore.domain.Product;
import edu.mum.waa.webstore.repository.ProductRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author patir
 */
@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @RequestMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products",productRepository.getAllProducts());
        return "products";
    }
    @RequestMapping("productdetails/{productId}")
    public String getProductDetails(Model model, @PathVariable String productId){
        model.addAttribute("product",productRepository.getProductById(productId));
        return "product_details";
    }
}
