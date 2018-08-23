package com.tfors.controllers.v1;


import com.tfors.domain.Vendor;
import com.tfors.services.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api(description = "Controller responsible for Vendors.")
@Controller
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

    public static final String BASE_URL = "/api/v1/vendors";
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }


    @ApiOperation(value = "Returns Vendor saved by ID provided in path.")
    @GetMapping("{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable("id") Long id){

        return new ResponseEntity<Vendor>(vendorService.getVendorById(id),
                HttpStatus.OK);
    }

    @ApiOperation(value = "Creates a new Vendor.")
    @PostMapping
    public ResponseEntity<Vendor> createNewVendor(@RequestBody Vendor vendorDTO){

        return new ResponseEntity<Vendor>(vendorService.createNewVendor(vendorDTO),
                HttpStatus.CREATED);
    }


}
