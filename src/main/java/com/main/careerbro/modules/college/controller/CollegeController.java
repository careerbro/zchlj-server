package com.main.careerbro.modules.college.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.utils.LuceneUtils;
import com.main.careerbro.modules.college.service.CollegeService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;
    @RequestMapping(method = RequestMethod.GET,value = "college/{temp}")
    public AjaxJson getCollege(@PathVariable String temp) throws IOException, ParseException, InterruptedException {
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
//        Analyzer analyzer = new IKAnalyzer();
//        System.out.println(analyzer.tokenStream("cName","北京大学"));
        System.out.println(temp);
        System.out.println(LuceneUtils.search(temp));
        map.put("data", LuceneUtils.search(temp));
        return Ajax.success(map);
    }
}
