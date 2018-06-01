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

    @RequestMapping(method = RequestMethod.GET,value = "attention")
    public AjaxJson getAttentionCorperation(@RequestParam("uid") String uid,@RequestParam("category") Integer category){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",attentionService.getAllAttention(uid,category));
        return Ajax.success(map);
    }


    @RequestMapping(method = RequestMethod.POST,value = "attention")
    public AjaxJson saveAttentionCorperation(@RequestBody Attention attention){

        attentionService.saveAttention(attention);
        return Ajax.success();
    }

    @RequestMapping(method = RequestMethod.PUT,value = "cancelAttend")
    public AjaxJson cancelAttend(@RequestParam("id") String id){

        attentionService.cancelAttend(id);
        return Ajax.success();
    }
}