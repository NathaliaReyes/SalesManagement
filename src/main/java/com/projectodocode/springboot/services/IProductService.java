package com.projectodocode.springboot.services;

import com.projectodocode.springboot.entities.Customer;
import com.projectodocode.springboot.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void deleteById(Long id_product);
    Product findProductById(Long id_product);

    void editProduct(Product product);

    List<Product> productOutOfStock();

    List<Product> getProductById_Sale(Long id_sale);





}
