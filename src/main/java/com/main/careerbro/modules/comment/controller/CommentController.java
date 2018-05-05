package com.main.careerbro.modules.comment.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(method = RequestMethod.GET,value = "salary/{salary}")
    public AjaxJson getBySalaryId(@PathVariable String salary){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",commentService.getBySalaryId(salary));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "user/{user}")
    public AjaxJson getByUserId(@PathVariable String user){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",commentService.getByUserId(user));
        return Ajax.success(map);
    }
}
