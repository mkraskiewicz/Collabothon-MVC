package com.tfors.services.impl;


import com.tfors.controllers.v1.VendorController;
import com.tfors.domain.Vendor;
import com.tfors.repositories.VendorRepository;
import com.tfors.services.VendorService;
import org.springframework.stereotype.Service;


@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
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




    private String getCustomerUrl(Long id){

        return VendorController.BASE_URL + "/" + id;
    }
}
