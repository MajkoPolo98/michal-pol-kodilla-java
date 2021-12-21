package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompany(String partOfName) throws SearchException {
        List<Company> companies = companyDao.retrieveCompaniesByPartOfName(partOfName);
        if(companies.size() == 0){
            throw new SearchException(SearchException.ERR_COMPANY_NOT_FOUND);
        }
        return companies;

    }

    public List<Employee> findEmployee(String partOfName) throws SearchException {
        List<Employee> employees = employeeDao.retrieveEmployeesByPartOfName(partOfName);
        if (employees.size() == 0){
            throw new SearchException(SearchException.ERR_USER_NOT_FOUND);
        }
        return employees;
    }
}
