package com.jpa.tutorial.OneToOneEntities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "passport_id",unique = true)
    private Passport passport;

    public Customer(){

    }
    public Customer(String name,Passport passport){
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
