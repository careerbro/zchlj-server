package com.main.careerbro.modules.industry.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.utils.LuceneUtils;
import com.main.careerbro.modules.industry.service.IndustryService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;

@RequestMapping("industry")
@RestController
public class IndustryController {
    @Autowired
    IndustryService industryService;

    @RequestMapping(method = RequestMethod.GET,value = "industry/{temp}")
    public AjaxJson getIndustry(@PathVariable String temp) throws IOException, ParseException {

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data", LuceneUtils.search(temp,1));
        return Ajax.success(map);
    }
}
