package com.jpa.tutorial;

import com.jpa.tutorial.ManyToManyEntities.Actor;
import com.jpa.tutorial.ManyToManyEntities.Movie;
import com.jpa.tutorial.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class MovieActorEntityTest {
    @Autowired
    MovieRepository movieRepository;

    @Test
    void createMovieObjectGraph(){
        Movie movie1 = new Movie("American Hustle");
        Movie movie2 = new Movie("The Prestige");

        Actor actor1 = new Actor("Kyaw Kyaw");
        Actor actor2 = new Actor("Su Su");

        movie1.getActors().add(actor1);

        movie2.getActors().add(actor1);
        movie2.getActors().add(actor2);

        movieRepository.saveAll(Arrays.asList(movie1,movie2));
    }

}
