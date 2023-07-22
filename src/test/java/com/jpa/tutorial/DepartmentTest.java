package com.jpa.tutorial;

import com.jpa.tutorial.repositories.DepartmentRepository;
import com.jpa.tutorial.selfjoin.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Hein Htet Aung
 * @created at 01/02/2022
 **/
@SpringBootTest
public class DepartmentTest {
    @Autowired
    private DepartmentRepository repository;

  //@Test
    void saveNewDept(){
        Department aDept = new Department("H","H department");
        repository.save(aDept);
    }

   @Test
    void saveNewSubDeptWithExistingParent(){
        Department parentDept = repository.findById(1L).get();
        Department subDept = new Department("D","D department");
        parentDept.addSubDepartment(subDept);
        repository.save(parentDept);
    }

   // @Test
    void findDeptById(){
        Department department = repository.findDeptById(2L).get();
        System.out.println(department.toString());
    }

    //@Test
    void findDepartmentsByParentDepartmentIsNull(){
        List<Department> departmentList = repository.findDepartmentsByParentDepartmentIsNull();
        System.out.println(departmentList.size());
    }

   //@Test
    void findParentWithChildGraph(){
        Department department = repository.findById(1L).get();
        System.out.println(department.toString());
    }

  // @Test
    void testEqualMethod(){
        Department cDept = repository.findById(4L).get();
        Department dDept = repository.findById(7L).get();
        System.out.println(cDept.equals(dDept));
    }

    private void saveWithDifferentDepartment(){
        Department aDept = new Department("A","A department");
        Department bDept = new Department("B","B department");

        Department cDept = new Department("C","C department",aDept);

        Department dDept = new Department("C","C department",bDept);

        repository.save(cDept);
        repository.save(dDept);
    }

    //@Test
    void findParentWithNoChildGraph(){
//        List<Department> departmentList = departmentRepository.findParentWithNoChildGraph(1L);
//        System.out.println(departmentList.size());
    }

    //@Test
    void delete(){
        repository.deleteById(2L);
    }

    //@Test
    void update(){
        Department department = repository.findById(1L).get();
        department.setDeptName("A");
        repository.save(department);
    }

}
