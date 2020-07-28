package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    private void setUpInfo() {
        Employee employee1 = new Employee(0, "xiaoming", 20, "male");
        Employee employee2 = new Employee(1, "xiaohong", 18, "Female");
        employeeList.add(employee1);
        employeeList.add(employee2);
    }

    @Test
    void should_return_employeeList_when_select_all_employees_given_employeeList() {
        //given
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeList);

        //when
        List<Employee> result = employeeService.selectAllEmployees();

        //then
        assertEquals(employeeList, result);
    }

    @Test
    void should_return_employee_when_select_employees_by_id_given_employeeList_and_id() {
        //given
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeList);

        //when
        Employee employee = employeeService.selectEmployeeById(1);

        //given
        assertEquals(employeeList.get(1) , employee);
    }

    @Test
    void addEmployee() {
    }

    @Test
    void deleteEmployeeById() {
    }

    @Test
    void updateEmployee() {
    }
}