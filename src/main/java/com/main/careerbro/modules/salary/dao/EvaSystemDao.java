package com.main.careerbro.modules.salary.dao;

import com.main.careerbro.modules.salary.entity.EvaSystem;
import org.springframework.stereotype.Component;

@Component
public interface EvaSystemDao {

    public void saveEvaSystem(EvaSystem evaSystem);

    public void updateEvaSystem(EvaSystem evaSystem);
}
