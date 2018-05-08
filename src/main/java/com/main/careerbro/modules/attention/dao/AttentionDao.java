package com.main.careerbro.modules.attention.dao;

import com.main.careerbro.modules.attention.entity.Attention;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttentionDao {
    /**
     * 根据uid获取用户关注的公司和岗位
     * @param uid
     * @param category 公司:1岗位:2
     * @return
     */
    public List<Attention> getAllAttention(String uid,Integer category);

    /**
     * 关注
     * @param attention
     */
    public void saveAttention(Attention attention);
}
