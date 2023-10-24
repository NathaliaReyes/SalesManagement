package com.projectodocode.springboot.services;

import com.projectodocode.springboot.entities.Sale;
import com.projectodocode.springboot.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SaleService implements ISaleService{
    @Autowired
    ISaleRepository saleRepository;
    @Override
    public List<Sale> findAll() {
        List<Sale> sales = saleRepository.findAll();
        return sales;
    }

    @Override
    public void save(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public void deleteById(Long id_sale) {
        saleRepository.deleteById(id_sale);
    }

    @Override
    public Sale findSaleById(Long id_sale) {
        return saleRepository.findById(id_sale).orElse(null);
    }

    @Override
    public void editSale(Sale sale) {
        this.save(sale);
    }

    @Override
    public double dailySaleAmount(String date) {
        return saleRepository.dailySaleAmount(date);
    }

    @Override
    public int quantitySalesPerDay(String date) {
        return saleRepository.quantitySalesPerDay(date);
    }
}
