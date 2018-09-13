package com.main.careerbro.modules.industry.dao;

import com.main.careerbro.modules.industry.entity.Industry;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IndustryDao {
    public List<Industry> getAllIndustry();
}
