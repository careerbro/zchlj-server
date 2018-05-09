package com.main.careerbro.modules.nation.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.nation.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("nation")
public class NationController {

    @Autowired
    NationService nationService;

    @RequestMapping(method = RequestMethod.GET,value = "nation")
    public AjaxJson getAllNation(){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",nationService.getAllNation());
        return Ajax.success(map);
    }
}
