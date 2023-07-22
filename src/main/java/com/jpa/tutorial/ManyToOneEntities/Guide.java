package com.jpa.tutorial.ManyToOneEntities;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@BatchSize(size = 4)
public class Guide implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "staff_id",nullable = false)
    private String staffId;

    private String name;
    private Integer salary;

    @Version
    private Integer version;

    @OneToMany(mappedBy = "guide",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<Student> students;

    public Guide(){}
    public Guide(String staffId,String name,Integer salary){
        this.staffId = staffId;
        this.name = name;
        this.salary =  salary;
    }


    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        if (students == null ){
            students = new HashSet<>();
        }
        students.add(student);
        student.setGuide(this);

    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}
