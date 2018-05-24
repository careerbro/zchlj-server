package com.main.careerbro.modules.district.service;

import com.main.careerbro.modules.district.dao.DistrictDao;
import com.main.careerbro.modules.district.entity.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    DistrictDao districtDao;

    public List<District> getDistrict(String temp){
        return districtDao.getDistrict(temp);
    }
}
