package com.main.careerbro.modules.salary.service;

import com.main.careerbro.modules.salary.dao.SalaryDao;
import com.main.careerbro.modules.salary.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryDao salaryDao;

    public List<Salary> getByUserId(String usrId){
        return salaryDao.getByUserId(usrId);
    }

    public List<Salary> getAllSalary(){
        return salaryDao.getAllSalary();
    }
}
