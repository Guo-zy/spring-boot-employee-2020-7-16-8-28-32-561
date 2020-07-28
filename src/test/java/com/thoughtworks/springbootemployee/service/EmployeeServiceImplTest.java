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
    void should_return_true_when_add_employees_given_employee() {
        //given
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeList);
        Employee employee = new Employee(3 , "xiaogang" , 10 , "male");

        //when
        boolean res = employeeService.addEmployee(employee);

        //given
        assertEquals(true , res);
    }

    @Test
    void should_return_true_when_delete_employees_given_employeeId() {
        //given
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeList);
        int employeeId = 1;

        //when
        boolean res = employeeService.deleteEmployeeById(employeeId);

        //given
        assertEquals(true , res);
    }

    @Test
    void should_return_true_when_update_employees_given_employee() {
        //given
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeList);
        Employee employee = new Employee(1, "xiaogang" , 10 , "male");

        //when
        boolean res = employeeService.updateEmployee(employee);

        //given
        assertEquals(true , res);
    }

    @Test
    void selectEmployeeByPage() {
        //given
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeList);
        Employee employee = new Employee(1, "xiaogang" , 10 , "male");

        //when
        boolean res = employeeService.updateEmployee(employee);

        //given
        assertEquals(true , res);
    }
}