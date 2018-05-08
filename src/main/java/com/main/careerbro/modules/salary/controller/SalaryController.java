package com.main.careerbro.modules.salary.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @RequestMapping(method = RequestMethod.GET,value = "user/{id}")
    public AjaxJson getByUserId(@PathVariable String id){
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",salaryService.getSalaryByUser(id));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "salary")
    public AjaxJson getAllSalary(){
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",salaryService.getAllSalary());
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "salary/{id}")
    public AjaxJson getSalaryById(@PathVariable String id){
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",salaryService.getSalaryById(id));
        return Ajax.success(map);
    }
}
