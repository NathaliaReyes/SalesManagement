package com.projectodocode.springboot.services;

import com.projectodocode.springboot.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void deleteById(Long id_customer);
    Customer findCustomerById(Long id_customer);

    void editCustomer(Customer customer);
}
