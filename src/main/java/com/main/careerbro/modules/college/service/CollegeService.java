package com.main.careerbro.modules.college.service;

import com.main.careerbro.modules.college.dao.CollegeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CollegeService {
    @Autowired
    CollegeDao collegeDao;
    public List<HashMap<String,String>> getAllCollege(){
        return collegeDao.getAllCollege();
    }
}
