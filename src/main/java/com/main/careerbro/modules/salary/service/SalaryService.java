package com.main.careerbro.modules.salary.service;

import com.main.careerbro.modules.salary.dao.SalaryDao;
import com.main.careerbro.modules.salary.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalaryService {

    @Autowired
    SalaryDao salaryDao;

    public List<Salary> getSalaryByUser(String usrId){
        return salaryDao.getSalaryByUser(usrId);
    }

    public List<Salary> getAllSalary(){
        return salaryDao.getAllSalary();
    }

    public Salary getSalaryById(String id){
        return salaryDao.getSalaryById(id);
    }

    public void saveSalary(Salary salary){

        salary.setId(UUID.randomUUID().toString().replaceAll("-",""));
        salaryDao.saveSalary(salary);
    }

    public void updateSalary(Salary salary){
        salaryDao.updateSalary(salary);
    }

    public List<Salary> getEvaSystemReserve(String uid){

        return salaryDao.getEvaSystemReserve(uid);
    }
}
