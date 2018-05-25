package com.main.careerbro.modules.corporation.service;

import com.main.careerbro.modules.corporation.dao.CorporationDao;
import com.main.careerbro.modules.corporation.entity.Corporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporationService {
    @Autowired
    CorporationDao corporationDao;

    public List<Corporation> getCorporation(String temp){
        return corporationDao.getCorporation(temp);
    }

    public List<Corporation> getAllCorporation(){

        return corporationDao.getAllCorporation();
    }
}
