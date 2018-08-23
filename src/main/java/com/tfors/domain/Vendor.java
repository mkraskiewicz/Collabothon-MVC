package com.tfors.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer stars;
    private String position;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customerList = new HashSet<>();
}
