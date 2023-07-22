package com.jpa.tutorial.repositories;

import com.jpa.tutorial.OneToOneEntities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
