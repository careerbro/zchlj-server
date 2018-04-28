package com.main.careerbro.modules.test.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.test.service.TheTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "stat")
public class TheTestController {
	@Autowired
	TheTestService theTestService;
	@Autowired
	private RedisTemplate<String,String> redisTemplate;
	//rest
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,value = "stat/{id}")
	public AjaxJson getActiveUsers(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		AjaxJson ajaxJson = new AjaxJson();
		System.out.println("====="+id);
        System.out.println(request.getSession().getAttributeNames().hasMoreElements());
		ajaxJson.getBody().put("name", "vinbratttany");
		return ajaxJson;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,value = "theTest")
	public AjaxJson theTest(HttpServletResponse response) {
        AjaxJson json  = new AjaxJson();
		System.out.println("getAllCompanys======"+theTestService.getAllCompanys());
		System.out.println("getCount======="+theTestService.getCount());
		System.out.println("getCountFromOffice========="+theTestService.getCountFromOffice());
		json.getBody().put("allCompanys", theTestService.getAllCompanys());
		json.getBody().put("count", theTestService.getCount());
		json.getBody().put("countOfOffice", theTestService.getCountFromOffice());
		return json;
	}
}
