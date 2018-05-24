package com.main.careerbro.modules.salary.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxEnum;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.comment.entity.Comment;
import com.main.careerbro.modules.comment.service.CommentService;
import com.main.careerbro.modules.salary.entity.Salary;
import com.main.careerbro.modules.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;
    @Autowired
    CommentService commentService;

    @RequestMapping(method = RequestMethod.GET,value = "user/{id}")
    public AjaxJson getByUserId(@PathVariable String id){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",salaryService.getSalaryByUser(id));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "salary")
    public AjaxJson getAllSalary(){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",salaryService.getAllSalary());
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "salary/{id}")
    public AjaxJson getSalaryById(@PathVariable String id){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",salaryService.getSalaryById(id));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "salary")
    public AjaxJson saveSalary(@RequestBody Salary salary){

        salaryService.saveSalary(salary);
        return Ajax.success();
    }

    @RequestMapping(method = RequestMethod.PUT,value = "salary")
    public AjaxJson updateSalary(@RequestBody Salary salary){

        salaryService.updateSalary(salary);
        return Ajax.success();
    }

    @RequestMapping(method = RequestMethod.GET,value = "comment/{uid}")
    public AjaxJson getSalaryByComment(@PathVariable String uid){

        List<Salary> salaries = null;
        List<Comment> comments = commentService.getByUserId(uid);
        if (comments.size()>0) {
            for (Comment c :
                    comments) {
                salaries.add(salaryService.getSalaryById(c.getSalaryId()));
            }
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("data", salaries);
            return Ajax.success(map);
        }
        else return Ajax.error(AjaxEnum.NO_COMMENTS);
    }

    @RequestMapping(method = RequestMethod.GET,value = "eva_systemReserve/{uid}")
    public AjaxJson getEvaSystemReserve(@PathVariable String uid){

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("data", salaryService.getEvaSystemReserve(uid));
        return Ajax.success(map);
    }
}
