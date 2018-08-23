package com.tfors.services;


import com.tfors.domain.Vendor;


public interface VendorService {


    Vendor getVendorById(Long id);
    Vendor createNewVendor(Vendor vendorDTO);
    void informUser(Long id);


}
