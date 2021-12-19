package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
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
    private CompanyDao companyDao;

    @Autowired
    public SearchFacade(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> findCompany(String partOfName) {
        return companyDao.retrieveCompaniesByPartOfName(partOfName);
    }
}
