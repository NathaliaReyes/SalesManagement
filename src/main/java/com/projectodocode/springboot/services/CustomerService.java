package com.projectodocode.springboot.services;

import com.projectodocode.springboot.entities.Customer;
import com.projectodocode.springboot.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id_customer) {

        customerRepository.deleteById(id_customer);
    }

    @Override
    public Customer findCustomerById(Long id_customer) {
        return customerRepository.findById(id_customer).orElse(null);
    }

    @Override
    public void editCustomer(Customer customer) {
        this.save(customer);
    }


}
