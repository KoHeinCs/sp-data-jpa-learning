package com.jpa.tutorial.employee;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "employee_id")
    private String employeeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_status")
    private EmployeeStatus employeeStatus;

    public Employee(String name,String employeeId,EmployeeStatus employeeStatus){
        this.name = name;
        this.employeeId = employeeId;
        this.employeeStatus = employeeStatus;
    }


}
