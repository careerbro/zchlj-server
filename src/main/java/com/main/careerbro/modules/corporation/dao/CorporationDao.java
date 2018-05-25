package com.main.careerbro.modules.corporation.dao;

import com.main.careerbro.modules.corporation.entity.Corporation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CorporationDao {
    public List<Corporation> getCorporation(String temp);

    public List<Corporation> getAllCorporation();
}
