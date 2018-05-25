package com.main.careerbro.modules.corporation.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.utils.LuceneUtils;
import com.main.careerbro.modules.corporation.service.CorporationService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;

@RequestMapping("corporation")
@RestController
public class CorporationController {
    @Autowired
    CorporationService corporationService;

    @RequestMapping(method = RequestMethod.GET,value = "corporation/{temp}")
    public AjaxJson getCorperation(@PathVariable String temp) throws IOException, ParseException {
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
//        map.put("data",corperationService.getCorperation(temp));
        map.put("data", LuceneUtils.search(temp,0));
        return Ajax.success(map);
    }
}
