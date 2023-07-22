package com.jpa.tutorial;

import com.jpa.tutorial.selfjoin.Department;

/**
 * @author Hein Htet Aung
 * @created at 01/02/2022
 **/
public class Testing {
    public static void main(String[] args) {
        Department aDept = new Department("A","A department");
        Department bDept = new Department("B","B department");
        Department cDept = new Department("C","C department",aDept);
        Department dDept = new Department("C","C department",aDept);

        System.out.println(cDept.equals(dDept));

    }
}
