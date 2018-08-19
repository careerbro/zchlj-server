package com.main.careerbro.modules.salary.dao;

import com.main.careerbro.modules.salary.entity.EvaSystem;
import com.main.careerbro.modules.salary.entity.Salary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Salary> getAllSalary(Map<String,String> map);

    /**
     * 根据id返回薪资
     * @param id
     * @return
     */
    public Salary getSalaryById(String id);

    /**
     * 保存薪资
     * @param salary
     */
    public void saveSalary(Salary salary);

    /**
     * 更新薪资
     * @param salary
     */
    public void updateSalary(Salary salary);

    /**
     * 获取用户收藏
     * @param uid
     * @return
     */
    public List<Salary> getEvaSystemReserve(String uid);

    /**
     * 更新薪资的点赞等四个属性
     * @param evaSystem
     */
    public void updateSalaryExtend(EvaSystem evaSystem);

    /**
     * 更新阅读量
     * @param id
     */
    public void addReadNum(String id);

    /**
     * 获取热门公司
     * @param map
     * @return
     */
    public List<HashMap<String,String>> getMostCor(Map<String,String> map);

}
