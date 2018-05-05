package com.main.careerbro.modules.salary.dao;

import com.main.careerbro.modules.salary.entity.Salary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SalaryDao {

    /**
     * 获取薪资BY userId
     * @param usrId
     * @return
     */
    public List<Salary> getByUserId(String usrId);

    /**
     * 获取所有薪资
     * @return
     */
    public List<Salary> getAllSalary();
}
