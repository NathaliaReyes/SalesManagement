package com.projectodocode.springboot.controllers;

import com.projectodocode.springboot.entities.SaleDetail;
import com.projectodocode.springboot.services.ISaleDetailService;
import com.projectodocode.springboot.services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/saleDetails")
public class SaleDetailController {
    @Autowired
    ISaleDetailService saleDetailService;

    @PostMapping("/create")
    public String createSaleDetail(@RequestBody SaleDetail saleDetail) {
        saleDetailService.save(saleDetail);
        return "SaleDetail created successfully";
    }
}
