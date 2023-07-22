package com.jpa.tutorial.repositories;

import com.jpa.tutorial.ManyToOneEntities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    /*  This query was developed because many-to-one default EAGER initialization was changed to LAZY initialization .*/
    @Query("select student from Student student left join fetch student.guide ")
    public List<Student> findAllStudents2();

    @Query("select student from Student student")
    public List<Student> findStudents();
}
