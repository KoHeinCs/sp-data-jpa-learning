package com.jpa.tutorial.CollectionMappingEntities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipcode;
    private String street;
    private String city;

    public Address(){}
    public Address(String zipcode,String street,String city){
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
    }
}
