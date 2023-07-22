package com.jpa.tutorial;

import com.jpa.tutorial.OneToOneEntities.Customer;
import com.jpa.tutorial.OneToOneEntities.Passport;
import com.jpa.tutorial.repositories.CustomerRepository;
import com.jpa.tutorial.repositories.PassportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerPassportEntityTest {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PassportRepository passportRepository;

    //@Test
    void createCustomerObjectGraph(){
        Passport passport = new Passport("12345");
        Customer customer = new Customer("Smith",passport);
        customerRepository.save(customer);
    }

    @Test
    void findByPassport(){
        Passport passport1 = passportRepository.findById(31L).get();
        System.out.println(passport1);
        Passport passport2 = passportRepository.findById(31L).get();
        System.out.println(passport2);
    }
}
