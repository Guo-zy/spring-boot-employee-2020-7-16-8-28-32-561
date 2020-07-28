package com.thoughtworks.springbootemployee.entity;

import java.util.List;

public class Company {
    private int companyId;
    private List<Employee> employeeList;

    public Company() {

    }

    public Company(int companyId, List<Employee> employeeList) {
        this.companyId = companyId;
        this.employeeList = employeeList;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
