package com.tfors.services;


import com.tfors.domain.Customer;


public interface CustomerService {


    Customer getCustomerById(Long id);
    Customer crateNewCustomer(Customer customerDTO);

}
