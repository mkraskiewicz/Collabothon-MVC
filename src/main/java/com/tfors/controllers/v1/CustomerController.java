package com.tfors.controllers.v1;


import com.tfors.domain.ContactDTO;
import com.tfors.domain.Customer;
import com.tfors.services.CustomerService;
import com.tfors.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api(description = "This is my Customer controller")
@Controller
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";
    private final CustomerService customerService;
    private final VendorService vendorService;


    public CustomerController(CustomerService customerService, VendorService vendorService) {
        this.customerService = customerService;
        this.vendorService = vendorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable("id") Long id){

        return new ResponseEntity<Customer>(customerService.getCustomerById(id),
                HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customerDTO){
        return new ResponseEntity<Customer>(customerService.crateNewCustomer(customerDTO),
                HttpStatus.CREATED);
    }

    @PostMapping("/requestservice")
    public ResponseEntity<ContactDTO> createNewCustomer(@RequestBody ContactDTO contactDTO){


        Customer customer = customerService.getCustomerById(contactDTO.getCustomerId());
        customerService.addVendorRequest(customer, contactDTO.getVendorId());


        return new ResponseEntity<ContactDTO>(contactDTO,
                HttpStatus.CREATED);
    }
}
