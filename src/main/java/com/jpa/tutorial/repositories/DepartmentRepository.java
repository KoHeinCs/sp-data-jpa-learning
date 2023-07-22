package com.jpa.tutorial.repositories;

import com.jpa.tutorial.selfjoin.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Hein Htet Aung
 * @created at 01/02/2022
 **/
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query( "select c from Department c join fetch c.parentDepartment p  where c.deptId =:id")
    Optional<Department> findDeptById(Long id);

    List<Department> findDepartmentsByParentDepartmentIsNull();
}
