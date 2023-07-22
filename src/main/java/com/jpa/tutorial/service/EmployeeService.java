package com.jpa.tutorial.service;

import com.jpa.tutorial.employee.Employee;
import com.jpa.tutorial.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public void findById(Long id){
        Employee employee  = employeeRepository.findById(id).get();
        employee.setName("Su Su");
    }
}
