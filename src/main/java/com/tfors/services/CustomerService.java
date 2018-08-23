package com.tfors.services;


import com.tfors.domain.Customer;

import java.util.List;


public interface CustomerService {


    Customer getCustomerById(Long id);
    Customer crateNewCustomer(Customer customerDTO);
    Customer addVendorRequest(Customer customer, Long vendorId);
    List<Customer> getAllCustomers();

}
