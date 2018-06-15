package com.main.careerbro.modules.salary.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxEnum;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.redis.RedisServiceImpl;
import com.main.careerbro.modules.comment.entity.Comment;
import com.main.careerbro.modules.comment.service.CommentService;
import com.main.careerbro.modules.salary.entity.EvaSystem;
import com.main.careerbro.modules.salary.entity.Salary;
import com.main.careerbro.modules.salary.service.EvaSystemService;
import com.main.careerbro.modules.salary.service.SalaryService;
import com.main.careerbro.modules.user.entity.User;
import com.main.careerbro.modules.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;
    @Autowired
    CommentService commentService;
    @Autowired
    EvaSystemService evaSystemService;
    @Autowired
    private UserService userService;

    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping(method = RequestMethod.GET,value = "user/{id}")
    public AjaxJson getByUserId(@PathVariable String id){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",salaryService.getSalaryByUser(id));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "salary")
    public AjaxJson getAllSalary(@RequestParam Map<String,String > params){

        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("data",salaryService.getAllSalary(params));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.GET,value = "salary/{id}")
    public AjaxJson getSalaryById(@PathVariable String id,HttpServletRequest httpServletRequest){

        User user = userService.getUser(redisService.get(httpServletRequest.getParameter("token")).toString());
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        Salary salary = salaryService.getSalaryById(id);
        map.put("data",salary);
        map.put("extendData",evaSystemService.getEvaSystem(user.getId(),salary.getId()));
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

        List<Salary> salaries = new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<Comment> comments = commentService.getByUserId(uid);
        if (comments.size()>0) {
            for (Comment c :
                    comments) {
                if (!set.contains(c.getSalaryId())) {
                    set.add(c.getSalaryId());
                    salaries.add(salaryService.getSalaryById(c.getSalaryId()));
                }
            }
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("data", salaries);
            return Ajax.success(map);
        }
        else return Ajax.error(AjaxEnum.NO_COMMENTS);
    }

    @RequestMapping(method = RequestMethod.GET,value = "eva_system/{uid}")
    public AjaxJson getEvaSystemReserve(@PathVariable String uid){

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("data", salaryService.getEvaSystemReserve(uid));
        return Ajax.success(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "eva_system")
    public AjaxJson saveEvaSystem(@RequestBody EvaSystem evaSystem){

        if (StringUtils.isBlank(evaSystem.getId())){
            evaSystemService.saveEvaSystem(evaSystem);
            salaryService.updateSalaryExtend(evaSystem);
        }
        else {
            evaSystemService.updateEvaSystem(evaSystem);
            salaryService.updateSalaryExtend(evaSystem);
        }
        return Ajax.success();
    }

}
