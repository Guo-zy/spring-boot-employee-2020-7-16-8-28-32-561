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


    @GetMapping("")
    public List<Employee> selectEmployee(
            @RequestParam(value = "page", required = false, defaultValue = "-1") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "-1") int pageSize,
            @RequestParam(value = "gender", required = false, defaultValue = "null") String gender) {
        if(page >= 1 && pageSize >= 1){
            return employeeService.selectEmployeeByPage(page,pageSize);
        }
        if(!gender.equals("null")){
            return employeeService.selectEmployeeByGender(gender);
        }
        return employeeService.selectAllEmployees();
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
