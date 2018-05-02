package com.main.careerbro.modules.college.dao;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface CollegeDao {
    public List<HashMap<String,String>> getAllCollege();
}

