package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.emitter.Emitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements ICompany {

    private List<Company> companyList = new ArrayList<>();


    @Autowired
    private EmployeeServiceImpl employeeService;

    @Override
    public List<Company> selectAllCompanys() {
        return companyList;
    }

    @Override
    public Company selectCompanyById(int companyId) {
        return companyList.stream().filter(company -> company.getCompanyId() == companyId).findFirst().get();
    }

    @Override
    public List<Employee> selectEmployeesByCompanyId(int companyId) {
        return companyList.stream().filter(company -> company.getCompanyId() == companyId).findFirst().get().getEmployeeList();
    }

    @Override
    public List<Company> selectCompanysByPage(int page, int pageSize) {

        return companyList.stream().skip((page - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    @Override
    public boolean addCompany(int companyId) {
        List<Employee> employees = employeeService.selectAllEmployees();
        List<Employee> newEmployees = employees.stream().filter(employee ->  employee.getCompanyId()  == companyId).collect(Collectors.toList());
        Company company = new Company(companyId , newEmployees);
        return companyList.add(company);
    }

    @Override
    public boolean updateCompany(int companyId) {
        List<Employee> employees = employeeService.selectAllEmployees();
        List<Employee> newEmployees = employees.stream().filter(employee ->  employee.getCompanyId()  == companyId).collect(Collectors.toList());
        Company company = companyList.stream().filter(c -> c.getCompanyId() == companyId).findFirst().get();
        company.setEmployeeList(newEmployees);
        return true;
    }

    @Override
    public boolean deleteEmployeesByCompanyId(int companyId) {
       companyList.stream().filter(c -> companyId == c.getCompanyId()).findFirst().get().getEmployeeList().clear();
        return true;
    }
}
