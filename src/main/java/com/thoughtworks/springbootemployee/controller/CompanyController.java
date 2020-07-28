package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;


    @GetMapping("/{companyId}")
    public Company selectCompanyById(@PathVariable int companyId) {
        return companyService.selectCompanyById(companyId);
    }

    @GetMapping("/{companyId}/employees")
    public List<Employee> selectEmployeesByCompanyId(@PathVariable int companyId) {
        return companyService.selectEmployeesByCompanyId(companyId);
    }


    @GetMapping()
    public List<Company> selectCompanys(
            @RequestParam(value = "page", required = false, defaultValue = "-1") int page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "-1") int pageSize) {
        if (page != -1) return companyService.selectCompanysByPage(page, pageSize);
        return companyService.selectAllCompanys();
    }

    @PostMapping("{companyId}")
    public boolean addCompany(@PathVariable int companyId) {
        return companyService.addCompany(companyId);
    }


    @PutMapping("{companyId}")
    public boolean updateCompany(@PathVariable int companyId) {
        return companyService.updateCompany(companyId);

    }


    @DeleteMapping("{companyId}")
    public boolean deleteCompanyByCompanyId(@PathVariable int companyId) {
        return companyService.deleteEmployeesByCompanyId(companyId);
    }
}
