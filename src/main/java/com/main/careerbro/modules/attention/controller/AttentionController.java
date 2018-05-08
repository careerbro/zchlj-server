package com.main.careerbro.modules.attention.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.attention.entity.Attention;
import com.main.careerbro.modules.attention.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RequestMapping("attention")
@RestController
public class AttentionController {
    @Autowired
    AttentionService attentionService;

    @RequestMapping(method = RequestMethod.GET,value = "attention/corperation/{uid}")
    public AjaxJson getAttentionCorperation(@PathVariable String uid){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",attentionService.getAllAttention(uid,1));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "attention/industry/{uid}")
    public AjaxJson getAttentionIndustry(@PathVariable String uid){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",attentionService.getAllAttention(uid,2));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "attention/corperation")
    public AjaxJson saveAttentionCorperation(@RequestBody Attention attention){

        attention.setCategory(1);
        attentionService.saveAttention(attention);
        return Ajax.success();
    }

    @RequestMapping(method = RequestMethod.GET,value = "attention/industry")
    public AjaxJson saveAttentionIndustry(@RequestBody Attention attention){

        attention.setCategory(2);
        attentionService.saveAttention(attention);
        return Ajax.success();
    }
}