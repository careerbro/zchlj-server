package com.main.careerbro.modules.college.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.college.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;
    @RequestMapping("college")
    public AjaxJson getAllCollege(){
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",collegeService.getAllCollege());
        return Ajax.success(map);
    }
}
