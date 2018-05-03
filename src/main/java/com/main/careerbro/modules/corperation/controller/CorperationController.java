package com.main.careerbro.modules.corperation.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.corperation.service.CorperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;

@RequestMapping("corperation")
@Controller
public class CorperationController {
    @Autowired
    CorperationService corperationService;

    @RequestMapping(method = RequestMethod.GET,value = "corperation")
    public AjaxJson getAllCorperation(){
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",corperationService.getAllCorperation());
        return Ajax.success(map);
    }
}
