package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/{id}")
    public Employee selectEmployeeById(@PathVariable int id) {
        return employeeService.selectEmployeeById(id);
    }

    @GetMapping()
    public List<Employee> selectAllEmployees(){
        return employeeService.selectAllEmployees();
    }

    @GetMapping(params = "gender")
    public List<Employee> selectEmployeeByGender(@RequestParam(value="gender") String gender){
        return employeeService.selectEmployeeByGender(gender);
    }

    @GetMapping(params = {"page" , "pageSize"})
    public List<Employee> selectEmployeeByGender(@RequestParam(value="page") int page  , @RequestParam(value = "pageSize") int pageSize){
        return employeeService.selectEmployeeByPage(page, pageSize);
    }

    @PostMapping("")
    public boolean addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping
    public boolean updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}
