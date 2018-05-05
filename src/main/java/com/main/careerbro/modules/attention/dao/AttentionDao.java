package com.main.careerbro.modules.attention.dao;

import com.main.careerbro.modules.attention.entity.Attention;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttentionDao {
    public List<Attention> getAllAttention(String uid);
}
