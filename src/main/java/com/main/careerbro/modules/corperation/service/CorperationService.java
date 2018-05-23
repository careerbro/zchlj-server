package com.main.careerbro.modules.corperation.service;

import com.main.careerbro.modules.corperation.dao.CorperationDao;
import com.main.careerbro.modules.corperation.entity.Corperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorperationService {
    @Autowired
    CorperationDao corperationDao;

    public List<Corperation> getCorperation(String temp){
        return corperationDao.getCorperation(temp);
    }
}
