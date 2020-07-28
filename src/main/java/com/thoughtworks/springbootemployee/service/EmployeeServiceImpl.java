package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public class EmployeeServiceImpl implements IEmployee{
    @Override
    public List<Employee> selectAllEmployees() {
        return null;
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }
}
