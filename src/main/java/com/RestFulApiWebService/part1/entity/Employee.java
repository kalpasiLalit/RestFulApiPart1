
package com.RestFulApiWebService.part1.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


public class Employee {
    private int empId;
    @Size(min = 2,message = "name should have at least 2 char")
    private String empName;
    @Min(value =18, message = "age should be greater then 18")
    private int age;

    public Employee(int empId, String empName, int age) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;

    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public int getAge() {
        return age;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
