package com.main.careerbro.modules.salary.dao;

import com.main.careerbro.modules.salary.entity.EvaSystem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public interface EvaSystemDao {

    public void saveEvaSystem(EvaSystem evaSystem);

    public void updateEvaSystem(EvaSystem evaSystem);

    public EvaSystem getEvaSystem(@Param("userId") String userId,@Param("salaryId") String salaryId);
}
