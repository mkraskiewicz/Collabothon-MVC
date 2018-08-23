package com.tfors.bootstrap;

import com.tfors.domain.Customer;
import com.tfors.domain.Vendor;
import com.tfors.repositories.CustomerRepository;
import com.tfors.repositories.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {


    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap( CustomerRepository customerRepository,
                     VendorRepository vendorRepository) {
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCustomers();
        loadVendors();

    }



    private void loadCustomers(){
        Customer fist = new Customer();
        fist.setFirstName("Name");
        fist.setLastName("Whose");

        Customer second = new Customer();
        second.setFirstName("Adam");
        second.setLastName("ABC");

        Customer anotherRandom = new Customer();
        anotherRandom.setFirstName("Eve");
        anotherRandom.setLastName("Lalala");

        customerRepository.save(fist);
        customerRepository.save(second);
        customerRepository.save(anotherRandom);

    }

    private void loadVendors(){

        Vendor barber = new Vendor();
        barber.setName("Bob and the Sons");
        barber.setId(1L);
        barber.setPosition("Barber");
        barber.setDescription("Best Barber in Berlin");
        barber.setStars(10);


        vendorRepository.save(barber);

    }
}
