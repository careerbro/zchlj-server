package com.main.careerbro.modules.job.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("job")
public class JobController {
    @Autowired
    JobService jobService;
    @RequestMapping(method = RequestMethod.GET,value = "job/{temp}")
    public AjaxJson getAllJob(@PathVariable String temp){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",jobService.getJob(temp));
        return Ajax.success(map);
    }
}
