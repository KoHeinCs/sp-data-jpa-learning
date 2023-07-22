package com.jpa.tutorial.repositories;

import com.jpa.tutorial.OneToOneEntities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Long> {
}
