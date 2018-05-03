package com.main.careerbro.modules.corperation.dao;

import com.main.careerbro.modules.corperation.entity.Corperation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CorperationDao {
    public List<Corperation> getAllCorperation();
}
