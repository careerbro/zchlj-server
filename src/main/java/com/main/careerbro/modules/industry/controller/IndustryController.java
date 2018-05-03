package com.main.careerbro.modules.industry.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.industry.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;

@RequestMapping("industry")
@Controller
public class IndustryController {
    @Autowired
    IndustryService industryService;

    @RequestMapping(method = RequestMethod.GET,value = "industry")
    public AjaxJson getAllIndustry(){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",industryService.getAllIndustry());
        return Ajax.success(map);
    }
}
