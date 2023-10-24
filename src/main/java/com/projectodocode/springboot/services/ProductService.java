package com.projectodocode.springboot.services;

import com.projectodocode.springboot.entities.Customer;
import com.projectodocode.springboot.entities.Product;
import com.projectodocode.springboot.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id_product) {
        productRepository.deleteById(id_product);
    }

    @Override
    public Product findProductById(Long id_product) {

        return productRepository.findById(id_product).orElse(null);
    }

    @Override
    public void editProduct(Product product) {
        this.save(product);
    }

    @Override
    public List<Product> productOutOfStock() {
        return productRepository.productOutOfStock();
    }

    @Override
    public List<Product> getProductById_Sale(Long id_sale){
        return productRepository.getProductById_Sale(id_sale);
    }
}
