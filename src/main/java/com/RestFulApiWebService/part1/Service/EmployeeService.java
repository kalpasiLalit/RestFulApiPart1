package com.RestFulApiWebService.part1.Service;

import com.RestFulApiWebService.part1.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class EmployeeService {

    public static List<Employee> empList = new ArrayList<>();
    static private int userCount = 0;

    static {
        empList.add(new Employee(++userCount, "Amit", 24));
    }

    public List<Employee> getempList() {
        return empList;
    }

    public Employee getPartcularEmp(int id) {
        return empList.stream().filter(e -> e.getEmpId() == id).findFirst().orElse(null);
    }

    public void deleteParticularEmp(int id) {
        Predicate<? super Employee> emp = e -> e.getEmpId() == id;
        empList.removeIf(emp);

    }

    public Employee addEmp(Employee emp) {
        emp.setEmpId(++userCount);
        empList.add(emp);
        return emp;
    }

    public void updateEmp(Employee emp) {
        Optional<Employee> employee = empList.stream().filter(e -> e.getEmpId() == emp.getEmpId()).findFirst();
        if (employee.isPresent()) {
            employee.get().setEmpName(emp.getEmpName());
            employee.get().setAge(emp.getAge());

        }


    }
}
