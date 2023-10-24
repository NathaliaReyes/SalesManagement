package com.projectodocode.springboot.controllers;

import com.projectodocode.springboot.entities.Product;
import com.projectodocode.springboot.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody Product product){
        productService.save(product);
        return "Product created successfully";
    }

    @DeleteMapping("/delete/{id_product}")
    public String deleteProduct(@PathVariable Long id_product){
        productService.deleteById(id_product);
        return "Product deleted successfully";
    }

    @GetMapping("/{id_product}")
    public Product findProductById(@PathVariable Long id_product){
        return productService.findProductById(id_product);
    }

    @PutMapping("/edit")
    public Product editProduct(@RequestBody Product product){
        productService.editProduct(product);
        return productService.findProductById(product.getId());
    }

    @GetMapping("/out_of_stock")
    public List<Product> findProductsOutOfStock() {
        return productService.productOutOfStock();
    }

    @GetMapping("sale/product/{id_sale}")
    public List<Product> getProductById_Sale(@PathVariable Long id_sale) {
        return productService.getProductById_Sale(id_sale);
    }

}
