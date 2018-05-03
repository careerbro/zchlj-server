package com.main.careerbro.modules.attention.service;

import com.main.careerbro.modules.attention.dao.AttentionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttentionService {
    @Autowired
    AttentionDao attentionDao;
}
