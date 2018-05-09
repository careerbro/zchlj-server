package com.main.careerbro.modules.attention.service;

import com.main.careerbro.modules.attention.dao.AttentionDao;
import com.main.careerbro.modules.attention.entity.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AttentionService {

    @Autowired
    AttentionDao attentionDao;

    public List<Attention> getAllAttention(String uid, Integer category){

        return attentionDao.getAllAttention(uid,category);
    }

    @Transactional
    public void saveAttention(Attention attention){

        attention.setId(UUID.randomUUID().toString());
        attentionDao.saveAttention(attention);
    }
}
