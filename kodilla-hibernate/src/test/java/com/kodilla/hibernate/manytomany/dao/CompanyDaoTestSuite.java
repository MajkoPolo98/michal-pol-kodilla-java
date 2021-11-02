package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testCompaniesSearchBySequence(){
        //Given
        Company company1 = new Company("PolMost");
        Company company2 = new Company("PolPlast");
        Company company3 = new Company("PonPon");
        Company company4 = new Company("NoEyeDeer");

        //When
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);
        List<Company> companiesStartingWithSequence = companyDao.retrieveCompaniesStartingWithLetters("Pol");

        //THen
        Assertions.assertEquals(2, companiesStartingWithSequence.size());

        //Cleanup
        companyDao.deleteAll();
    }

    @Test
    void testSearchEmployeeByLastname() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee jackSmith = new Employee("Jack", "Smith");

        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(jackSmith);

        List<Employee> employeeListWithLastname = employeeDao.retrieveEmployeesWithLastname("Smith");

        //Then
        Assertions.assertEquals("Smith", employeeListWithLastname.get(0).getLastname());

        //CleanUp
        employeeDao.deleteAll();

    }
}