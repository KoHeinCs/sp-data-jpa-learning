package com.jpa.tutorial.OneToOneEntities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Passport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "passwport_number")
    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    private Customer customer;

    public Passport(){}
    public Passport(String passportNumber){
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
