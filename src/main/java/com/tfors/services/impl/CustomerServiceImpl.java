package com.tfors.services.impl;


import com.tfors.controllers.v1.CustomerController;
import com.tfors.domain.Customer;
import com.tfors.repositories.CustomerRepository;
import com.tfors.services.CustomerService;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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


    private String getCustomerUrl(Long id){

        return CustomerController.BASE_URL + "/" + id;
    }


}
