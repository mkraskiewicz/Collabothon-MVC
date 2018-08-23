package com.tfors.services.impl;


import com.tfors.controllers.v1.CustomerController;
import com.tfors.domain.Customer;
import com.tfors.repositories.CustomerRepository;
import com.tfors.repositories.VendorRepository;
import com.tfors.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private VendorRepository vendorRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).get();

    }

    @Override
    public Customer crateNewCustomer(Customer customer) {
        customerRepository.save(customer);

        return customer;
    }

    @Override
    public Customer addVendorRequest(Customer customer, Long vendorId){
        Customer customerFromDB = customerRepository.findById(customer.getId()).get();
        customerFromDB.setVendor(vendorRepository.findById(vendorId).get());
        customerRepository.save(customerFromDB);
        return customerFromDB;
    }

    @Override
    public List<Customer> getAllCustomers(){

        return customerRepository.findAll();
    }


    private String getCustomerUrl(Long id){

        return CustomerController.BASE_URL + "/" + id;
    }


}
