package com.main.careerbro.modules.industry.service;

import com.main.careerbro.modules.industry.dao.IndustryDao;
import com.main.careerbro.modules.industry.entity.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryService {
    @Autowired
    IndustryDao industryDao;
    public List<Industry> getIndustry(String temp){
        return industryDao.getIndustry(temp);
    }
}
