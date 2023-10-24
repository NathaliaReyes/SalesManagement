package com.projectodocode.springboot.services;

import com.projectodocode.springboot.entities.SaleDetail;
import com.projectodocode.springboot.repositories.ISaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleDetailService implements ISaleDetailService{
    @Autowired
    ISaleDetailRepository saleDetailRepository;

    @Override
    public void save(SaleDetail saleDetail) {
        saleDetailRepository.save(saleDetail);
    }
}
