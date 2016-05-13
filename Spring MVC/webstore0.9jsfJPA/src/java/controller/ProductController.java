/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import domain.Product;
import domain.ProductEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import repository.ProductRepository;
import service.ProductService;
import javax.validation.Valid;
import repository.impl.JpaProductRepository;
import repository.impl.ProductEntityFacade;
import service.impl.ProductServiceImpl;


/**
 *
 * @author Rakesh Shrestha
 */
@Named("productsBean")
@SessionScoped
public class ProductController implements Serializable{
    private List<ProductEntity> prodList; 
    private ProductEntity detailsProduct;  //holds product for details page
    private String productid;  //holds a product id
    
//    @EJB
//    ProductEntityFacade prodFacade;
    @EJB        
    JpaProductRepository jpaProdRepository;  //Stateless EJB that must be created by some managed bean
    
    private ProductService productService;

    @PostConstruct  //this annotation causes this method to run after the constructor completes
public void initProductRepository() {        
        productService = new ProductServiceImpl(jpaProdRepository);
        productService.initRepository();
        prodList = productService.retrieveAllProducts();        
        System.out.println("created product list with first itemid: " + prodList.get(0).getProductId());
    }    

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }
    
    

    public List<ProductEntity> getProdList() {
        System.out.println("returned product list with first itemid: " + prodList.get(0).getProductId());
        return prodList;  //need to be sure to update this in any operations that change the list
    }

    public void setProdList(List<ProductEntity> prodList) {
        this.prodList = prodList;
    }

    public ProductEntity getDetailsProduct() {
        return detailsProduct;
    }

    public void setDetailsProduct(ProductEntity detailsProduct) {
        this.detailsProduct = detailsProduct;
    }
    
    
    
    //@InitBinder public void initializeBinder(WebDataBinder binder) {binder.setDisallowedFields("unitsInOrder", "discontinued");}
    
//    public String getAllProducts(){ 
//        prodList = productService.getAllProducts();
//        return "products";
//    }
    
    /** JSF view action method
     * Used on the product.xhtml page
     * precondition:  expects the productid to be set
     * SIDEEFFECTS  sets the detailsProduct field to product for the productid field
     * //@return nav string for the product detaile page
     */
    public void findProductById(){
        detailsProduct =  productService.findProductById(this.productid);
       // return "product?faces-redirect=true";
    }
//    }
    
//    public String getAddNewProductForm(Model model) {
//        Product newProduct = new Product();
//        model.addAttribute("newProduct", newProduct);
//        return "addProduct";
//    }

    //public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct){
    
//    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result) {
//        if(result.hasErrors()) {return "addProduct";}
//        productService.addProduct(productToBeAdded);
//
//        String[] suppressedFields = result.getSuppressedFields();
//        if (suppressedFields.length > 0) {
//            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
//        }
//
//        return "redirect:/products";
//    }
}
