package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public interface ICompany {
    List<Company> selectAllCompanys();
    Company selectCompanyById(int companyId);
    List<Employee> selectEmployeesByCompanyId(int companyId);
    List<Company> selectCompanysByPage(int page, int pageSize);
    boolean addCompany(int companyId);
    boolean updateCompany(int companyId);
    boolean deleteEmployeesByCompanyId(int companyId);
}
