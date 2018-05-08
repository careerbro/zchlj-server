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
    public List<Salary> getSalaryByUser(String usrId);

    /**
     * 获取所有薪资
     * @return
     */
    public List<Salary> getAllSalary();

    /**
     * 根据id返回薪资
     * @param id
     * @return
     */
    public List<Salary> getSalaryById(String id);

    /**
     * 保存薪资
     * @param salary
     */
    public void saveSalary(Salary salary);
}
