package com.projectodocode.springboot.controllers;

import com.projectodocode.springboot.entities.Sale;
import com.projectodocode.springboot.services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/sales")
public class SaleController {
    @Autowired
    ISaleService saleService;

    @GetMapping("")
    public List<Sale> findAll(){
        return saleService.findAll();
    }

    @PostMapping("/create")
    public String createSale(@RequestBody Sale sale){
        saleService.save(sale);
        return "Sale created successfully";
    }

    @DeleteMapping("/delete/{id_sale}")
    public String deleteSale(@PathVariable Long id_sale){
        saleService.deleteById(id_sale);
        return "Sale deleted successfully";
    }

    @GetMapping("/{id_sale}")
    public Sale findSaleById(@PathVariable Long id_sale){
        return saleService.findSaleById(id_sale);
    }

    @PutMapping("/edit")
    public Sale editSale(@RequestBody Sale sale){
        saleService.editSale(sale);
        return saleService.findSaleById(sale.getId());
    }

    /*@GetMapping("/dailyAmount")
    public double dailySaleAmount(@RequestParam String dateStr) {
        try {
            dateStr = dateStr.replace("'", ""); // Elimina las comillas simples
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateStr);
            System.err.println(date);


            double result = saleService.dailySaleAmount(date);
            return result;
        } catch (ParseException e) {
            System.err.println("Error al analizar la fecha: " + e.getMessage());
            return -1;
        }
    }*/

    @GetMapping("/dailyAmount")
    public double dailySaleAmount(@RequestParam String date) {
        System.out.println(date);
        return saleService.dailySaleAmount(date);

    }

    @GetMapping("/salesPerDay")
    public int quantitySalesPerDay(@RequestParam String date) {
        return saleService.quantitySalesPerDay(date);

    }


}
