package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public interface IEmployee {
     List<Employee> selectAllEmployees();
     Employee selectEmployeeById(int id);
     List<Employee> selectEmployeeByPage(int page , int pageSize);
     boolean addEmployee(Employee employee);
     boolean deleteEmployeeById(int id);
     boolean updateEmployee(Employee employee);
     boolean deleteEmplyeeByCompanyId(int CompanyId);

}
