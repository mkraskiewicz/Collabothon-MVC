package com.tfors.controllers.v1;


import com.tfors.domain.Customer;
import com.tfors.services.CustomerService;
import io.swagger.annotations.Api;
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

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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


}
