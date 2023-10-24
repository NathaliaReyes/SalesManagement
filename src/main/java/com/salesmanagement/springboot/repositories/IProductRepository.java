package com.projectodocode.springboot.repositories;

import com.projectodocode.springboot.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    @Transactional
    @Query("SELECT p FROM Product p WHERE p.availableQuantity < 5")
    List<Product> productOutOfStock();

    @Transactional
    @Query("SELECT p FROM Product p WHERE p.id IN (SELECT s.product.id FROM SaleDetail s WHERE s.sale.id = ?1)")
    List<Product> getProductById_Sale(Long id_sale);



}
