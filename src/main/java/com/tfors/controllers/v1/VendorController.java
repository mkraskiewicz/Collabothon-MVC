package com.tfors.controllers.v1;


import com.tfors.domain.ContactDTO;
import com.tfors.domain.Customer;
import com.tfors.domain.Vendor;
import com.tfors.services.CustomerService;
import com.tfors.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Api(description = "Controller responsible for Vendors.")
@Controller
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

    public static final String BASE_URL = "/api/v1/vendors";
    private final VendorService vendorService;
    private final CustomerService customerService;

    public VendorController(VendorService vendorService, CustomerService customerService) {
        this.vendorService = vendorService;
        this.customerService = customerService;
    }

    @ApiOperation(value = "Returns Vendor saved by ID provided in path.")
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable("id") Long id){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Methods", "POST, GET"); // also added header to allow POST, GET method to be available
        responseHeaders.add("Access-Control-Allow-Origin", "*"); // also added header to allow cross domain request for any domain
        return new ResponseEntity<Customer>(customerService.getCustomerById(id),responseHeaders,
                HttpStatus.OK);
    }
    @ApiOperation(value = "Creates a new Vendor.")
    @PostMapping
    public ResponseEntity<Vendor> createNewVendor(@RequestBody Vendor vendorDTO){

        return new ResponseEntity<Vendor>(vendorService.createNewVendor(vendorDTO),
                HttpStatus.CREATED);
    }

    @ApiOperation(value = "Inform a customer that you are interested in making a deal with him")
    @PostMapping("/inform")
    public ResponseEntity<Vendor> informCustomer(@RequestBody ContactDTO contactDTO){
        Customer customer = customerService.getCustomerById(contactDTO.getCustomerId());
        if (customer.getVendor()!= null && customer.getVendor().getId().equals(contactDTO.getCustomerId())){
            vendorService.informUser(contactDTO.getCustomerId());
        }

        return new ResponseEntity<Vendor>(HttpStatus.OK);
    }

    @ApiOperation(value = "Returns all customers which are interested in particular Vendor")
    @GetMapping("{id}/interested")
    public ResponseEntity<List<Customer>> getInterestedCustomers(@PathVariable("id") Long id){

        List<Customer> customerList = customerService.getAllCustomers().stream()
                .filter(c -> c.getVendor() != null)
                .filter(customer -> customer.getVendor().getId().equals(id)).collect(Collectors.toList());

        return new ResponseEntity<List<Customer>>(customerList,
                HttpStatus.OK);

    }


}
