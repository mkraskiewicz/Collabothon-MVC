package com.tfors.domain;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Vendor vendor;

}
