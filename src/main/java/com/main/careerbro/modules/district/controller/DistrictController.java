package com.main.careerbro.modules.district.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.utils.LuceneUtils;
import com.main.careerbro.modules.district.service.DistrictService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;

@RequestMapping("district")
@RestController
public class DistrictController {
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET,value = "district/{temp}")
    public AjaxJson getDistrict(@PathVariable String temp) throws IOException, ParseException {

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data", LuceneUtils.search(temp,3));
        return Ajax.success(map);
    }
}
