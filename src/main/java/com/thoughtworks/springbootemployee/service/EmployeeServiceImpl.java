package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployee{

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return employeeList.stream().filter(employee -> employee.getId() == id) .findFirst().get();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeList.add(employee);
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        return employeeList.removeIf(employee -> employee.getId() == id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Employee oldEmployee = employeeList.stream().filter(e -> e.getId() == employee.getId()).findFirst().get();
        oldEmployee.setName(employee.getName());
        oldEmployee.setAge(employee.getAge());
        oldEmployee.setGender(employee.getGender());
        return true;
    }
}
