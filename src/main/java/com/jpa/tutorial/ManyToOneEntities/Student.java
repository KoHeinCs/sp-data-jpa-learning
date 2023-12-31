package com.jpa.tutorial.ManyToOneEntities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "enrollment_id",nullable = false)
    private String enrollmentId;

    private String name;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guide_id",nullable = false)
    private Guide guide;

    public Student(){}

    public Student(String enrollmentId,String name){
        this.enrollmentId = enrollmentId;
        this.name = name;
    }

    public Student(String enrollmentId,String name,Guide guide){
        this.enrollmentId = enrollmentId;
        this.name = name;
        this.guide = guide;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", enrollmentId='" + enrollmentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
