package com.main.careerbro.modules.district.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.district.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RequestMapping("district")
@RestController
public class DistrictController {
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET,value = "district")
    public AjaxJson getAllDistrict(){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",districtService.getAllDistrict());
        return Ajax.success(map);
    }
}
