package com.main.careerbro.modules.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public interface TheTestDao {

	public List<Map<String, String>> getAllCompanys(); 
	public List<Map<String, String>> getCount(); 
	public List<Map<String, String>> getCountFromOffice();
}
