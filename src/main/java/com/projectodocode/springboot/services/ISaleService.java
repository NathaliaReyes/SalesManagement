package com.projectodocode.springboot.services;

import com.projectodocode.springboot.entities.Customer;
import com.projectodocode.springboot.entities.Sale;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISaleService {
    List<Sale> findAll();
    void save(Sale sale);
    void deleteById(Long id_sale);
    Sale findSaleById(Long id_sale);
    void editSale(Sale sale);

    double dailySaleAmount(String date);
    int quantitySalesPerDay(String date);


}
