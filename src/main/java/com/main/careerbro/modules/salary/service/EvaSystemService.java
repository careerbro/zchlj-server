package com.main.careerbro.modules.salary.service;

import com.main.careerbro.modules.salary.dao.EvaSystemDao;
import com.main.careerbro.modules.salary.entity.EvaSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EvaSystemService {

    @Autowired
    EvaSystemDao evaSystemDao;

    @Transactional
    public void saveEvaSystem(EvaSystem evaSystem){

        evaSystem.setId(UUID.randomUUID().toString().replaceAll("-",""));
        evaSystemDao.saveEvaSystem(evaSystem);
    }

    @Transactional
    public void updateEvaSystem(EvaSystem evaSystem){

        evaSystemDao.updateEvaSystem(evaSystem);
    }

    public EvaSystem getEvaSystem(String userId,String salaryId){
        return evaSystemDao.getEvaSystem(userId,salaryId);
    }

    /**
     * 获取点赞,反对的薪资id
     * @param uid
     * @return
     */
    public List<String> getSalaryByEva(String uid){

        return evaSystemDao.getSalaryByEva(uid);
    }
}
