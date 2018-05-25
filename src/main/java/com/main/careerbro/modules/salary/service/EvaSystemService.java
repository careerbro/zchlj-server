package com.main.careerbro.modules.salary.service;

import com.main.careerbro.modules.salary.dao.EvaSystemDao;
import com.main.careerbro.modules.salary.entity.EvaSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
