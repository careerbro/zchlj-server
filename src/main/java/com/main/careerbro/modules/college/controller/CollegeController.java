package com.main.careerbro.modules.college.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.redis.RedisServiceImpl;
import com.main.careerbro.common.utils.LuceneUtils;
import com.main.careerbro.modules.college.service.CollegeService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("college")
public class CollegeController {

    @Value("${redis.time}")
    private int time;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private RedisServiceImpl redisService;


    @RequestMapping(method = RequestMethod.GET,value = "college/{temp}")
    public AjaxJson getCollege(@PathVariable String temp) throws IOException, ParseException, InterruptedException {
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data", LuceneUtils.search(temp,4));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "college")
    public AjaxJson getAllCollege(){

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (!redisService.isKeyExists("COLLEGE")){
            redisService.put("COLLEGE",collegeService.getAllCollege(),time);
        }
        map.put("data", redisService.get("COLLEGE"));
        return Ajax.success(map);
    }
}
