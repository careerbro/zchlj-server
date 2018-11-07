package com.main.careerbro.modules.salary.dao;

import com.main.careerbro.modules.salary.entity.EvaSystem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface EvaSystemDao {

    public void saveEvaSystem(EvaSystem evaSystem);

    public void updateEvaSystem(EvaSystem evaSystem);

    public EvaSystem getEvaSystem(@Param("userId") String userId,@Param("salaryId") String salaryId);

    /**
     * 获取点赞,反对的薪资id
     * @param uid
     * @return
     */
    public List<String> getSalaryByEva(String uid);
}
