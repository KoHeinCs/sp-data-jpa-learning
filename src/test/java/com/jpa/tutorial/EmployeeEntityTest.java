package com.jpa.tutorial;

import com.jpa.tutorial.employee.Employee;
import com.jpa.tutorial.employee.EmployeeStatus;
import com.jpa.tutorial.repositories.EmployeeRepository;
import com.jpa.tutorial.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class EmployeeEntityTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    void findEmployee(){
       employeeService.findById(1L);
    }
}
