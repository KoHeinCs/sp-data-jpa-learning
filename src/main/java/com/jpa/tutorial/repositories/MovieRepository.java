package com.jpa.tutorial.repositories;

import com.jpa.tutorial.ManyToManyEntities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
