package com.main.careerbro.modules.nation.service;

import com.main.careerbro.modules.nation.dao.NationDao;
import com.main.careerbro.modules.nation.entity.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService {

    @Autowired
    NationDao nationDao;

    public List<Nation> getAllNation(){
        return nationDao.getAllNation();
    }
}
