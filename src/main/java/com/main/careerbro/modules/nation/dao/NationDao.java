package com.main.careerbro.modules.nation.dao;

import com.main.careerbro.modules.nation.entity.Nation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NationDao {
    /**
     * 获取所有国家
     * @return
     */
    public List<Nation> getAllNation();
}
