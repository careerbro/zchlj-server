package com.main.careerbro.modules.attention.service;

import com.main.careerbro.modules.attention.dao.AttentionDao;
import com.main.careerbro.modules.attention.entity.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionService {
    @Autowired
    AttentionDao attentionDao;
    public List<Attention> getAllAttention(String uid){
        return attentionDao.getAllAttention(uid);
    }
}
