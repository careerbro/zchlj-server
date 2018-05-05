package com.main.careerbro.modules.attention.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.attention.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RequestMapping("attention")
@RestController
public class AttentionController {
    @Autowired
    AttentionService attentionService;
    @RequestMapping(method = RequestMethod.GET,value = "attention")
    public AjaxJson attention(@PathVariable String uid){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",attentionService.getAllAttention(uid));
        return Ajax.success(map);
    }
}
