package com.jpa.tutorial.selfjoin;

import com.jpa.tutorial.ManyToOneEntities.Student;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Hein Htet Aung
 * @created at 01/02/2022
 * Ref: https://thorben-janssen.com/self-referencing-associations/
 **/
@Entity
@Table(name = "DEPARTMENT")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private Long deptId;

    @Column(name = "DEPT_NAME")
    private String deptName;

    @Column(name = "DEPT_DESC")
    private String description;

    @Version
    private int version;

    public Department(){}

    public Department(String deptName,String description){
        this.deptName = deptName;
        this.description = description;
    }

    public Department(String deptName,String description,Department parentDepartment){
        this.deptName = deptName;
        this.description = description;
        this.parentDepartment = parentDepartment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID",referencedColumnName = "DEPT_ID")
    private Department parentDepartment;

    @OneToMany(mappedBy = "parentDepartment",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<Department> subDepartments   = new HashSet<>();

    public void addSubDepartment(Department sub) {
        if (this.subDepartments == null)
            this.subDepartments = new HashSet<>();
        this.subDepartments.add(sub);
        sub.setParentDepartment(this);
    }

    public void moveDepartment(Department newParent) {
        this.getParentDepartment().getSubDepartments().remove(this);
        this.setParentDepartment(newParent);
        newParent.getSubDepartments().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(deptId, that.deptId) && Objects.equals(deptName, that.deptName) && Objects.equals(description, that.description) && Objects.equals(parentDepartment, that.parentDepartment);
    }


    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", description='" + description ;
    }

}
