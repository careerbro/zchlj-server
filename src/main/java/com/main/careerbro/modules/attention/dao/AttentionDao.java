package com.main.careerbro.modules.attention.dao;

import com.main.careerbro.modules.attention.entity.Attention;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface AttentionDao {
    /**
     * 根据uid获取用户关注的公司和岗位
     * @param uid
     * @param category 公司:1岗位:2
     * @return
     */
    public List<Attention> getAllAttention(@Param("uid") String uid,@Param("category") Integer category);

    /**
     * 关注
     * @param attention
     */
    public void saveAttention(Attention attention);

    /**
     * 取消关注
     * @param id
     */
    public void cancelAttend(String id);

    /**
     * 判断是否已关注 userId attendId
     * @param map
     * @return
     */
    public String getIsAttend(Map map);
}
