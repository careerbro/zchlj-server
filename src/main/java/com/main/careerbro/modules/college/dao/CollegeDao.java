package com.main.careerbro.modules.college.dao;

import com.main.careerbro.modules.college.entity.College;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollegeDao {
    public List<College> getAllCollege();
}

