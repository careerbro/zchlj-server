package com.main.careerbro.modules.job.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.redis.RedisServiceImpl;
import com.main.careerbro.common.utils.LuceneUtils;
import com.main.careerbro.modules.job.service.JobService;
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
@RequestMapping("job")
public class JobController {
    @Value("${redis.time}")
    private int time;
    @Autowired
    JobService jobService;
    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping(method = RequestMethod.GET,value = "job/{temp}")
    public AjaxJson getJob(@PathVariable String temp) throws IOException, ParseException {

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data", LuceneUtils.search(temp,2));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "job")
    public AjaxJson getAllJob(){

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (!redisService.isKeyExists("JOB")){
            redisService.put("JOB",jobService.getAllJob(),time);
        }
        map.put("data", redisService.get("JOB"));
        return Ajax.success(map);
    }
}
