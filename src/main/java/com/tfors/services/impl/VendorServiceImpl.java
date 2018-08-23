package com.tfors.services.impl;


import com.tfors.controllers.v1.VendorController;
import com.tfors.domain.Customer;
import com.tfors.domain.Vendor;
import com.tfors.repositories.CustomerRepository;
import com.tfors.repositories.VendorRepository;
import com.tfors.services.VendorService;
import org.springframework.stereotype.Service;


@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;
    private CustomerRepository customerRepository;


    public VendorServiceImpl(VendorRepository vendorRepository, CustomerRepository customerRepository) {
        this.vendorRepository = vendorRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Vendor getVendorById(Long id) {

        return  vendorRepository.findById(id).get();
    }

    @Override
    public Vendor createNewVendor(Vendor vendorDTO) {
        vendorRepository.save(vendorDTO);

        return vendorDTO;
    }

    @Override
    public void informUser(Long id){
        Customer customerFromDB = customerRepository.findById(id).get();
        customerFromDB.setVendorInterested(true);
        customerRepository.save(customerFromDB);
    }


    private String getCustomerUrl(Long id){

        return VendorController.BASE_URL + "/" + id;
    }
}
