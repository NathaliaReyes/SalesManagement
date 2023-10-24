package com.projectodocode.springboot.controllers;

import com.projectodocode.springboot.entities.Customer;
import com.projectodocode.springboot.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public List<Customer> findAll(){

        return customerService.findAll();
    }

    @PostMapping("/create")
    public String createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return "Customer created successfully";
    }

    @DeleteMapping("/delete/{id_customer}")
    public String deleteCustomer(@PathVariable Long id_customer){
        customerService.deleteById(id_customer);
        return "Customer deleted successfully";
    }

    @GetMapping("/{id_customer}")
    public Customer findCustomerById(@PathVariable Long id_customer){
        return customerService.findCustomerById(id_customer);
    }

    @PutMapping("/edit")
    public Customer editCustomer(@RequestBody Customer customer){
        customerService.editCustomer(customer);
        return customerService.findCustomerById(customer.getId());
    }

}
