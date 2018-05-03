package com.main.careerbro.modules.college.service;

import com.main.careerbro.modules.college.dao.CollegeDao;
import com.main.careerbro.modules.college.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    CollegeDao collegeDao;
    public List<College> getAllCollege(){
        return collegeDao.getAllCollege();
    }
}
