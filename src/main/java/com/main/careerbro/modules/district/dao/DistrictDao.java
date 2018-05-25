package com.main.careerbro.modules.district.dao;

import com.main.careerbro.modules.district.entity.District;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DistrictDao {

    public List<District> getDistrict(String temp);

    public List<District> getAllDistrict();
}
