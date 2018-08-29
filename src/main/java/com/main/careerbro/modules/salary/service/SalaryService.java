package com.main.careerbro.modules.salary.service;

import com.main.careerbro.modules.salary.dao.SalaryDao;
import com.main.careerbro.modules.salary.entity.EvaSystem;
import com.main.careerbro.modules.salary.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SalaryService {

    @Autowired
    SalaryDao salaryDao;

    /**
     * 根据用户id查询薪资
     * @param usrId
     * @return
     */
    public List<Salary> getSalaryByUser(String usrId){
        return salaryDao.getSalaryByUser(usrId);
    }

    /**
     * 根据学校id,公司id,岗位id,城市id或者没有条件查询薪资
     * @param params
     * @return
     */
    public List<Salary> getAllSalary(Map<String,String> params){
        return salaryDao.getAllSalary(params);
    }

    /**
     * 获取薪资详情根据薪资id
     * @param id
     * @return
     */
    public Salary getSalaryById(String id){
        return salaryDao.getSalaryById(id);
    }

    /**
     * 保存薪资
     * @param salary
     */
    @Transactional
    public void saveSalary(Salary salary){

        salary.setId(UUID.randomUUID().toString().replaceAll("-",""));
        salaryDao.saveSalary(salary);
    }

    /**
     * 更新薪资
     * @param salary
     */
    @Transactional
    public void updateSalary(Salary salary){
        salaryDao.updateSalary(salary);
    }

    /**
     * 根据用户获取用户点赞的薪资
     * @param uid
     * @return
     */
    public List<Salary> getEvaSystemReserve(String uid){

        return salaryDao.getEvaSystemReserve(uid);
    }

    /**
     * 更新salary的点赞等四个
     * @param evaSystem
     */
    @Transactional
    public void updateSalaryExtend(EvaSystem evaSystem){
        salaryDao.updateSalaryExtend(evaSystem);
    }

    /**
     * 更新阅读量
     * @param id
     */
    @Transactional
    public void addReadNum(String id){

        salaryDao.addReadNum(id);
    }

    /**
     * 获取热门公司
     * @param map
     * @return
     */
    public List<HashMap<String,String>> getMostCor(Map<String,Integer> map){

        return salaryDao.getMostCor(map);
    };

    /**
     * 获取热门city
     * @param map
     * @return
     */
    public List<HashMap<String,String>> getMostCity(Map<String,Integer> map){

        return salaryDao.getMostCity(map);
    };
}
