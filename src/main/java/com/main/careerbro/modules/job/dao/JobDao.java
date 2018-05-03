package com.main.careerbro.modules.job.dao;

import com.main.careerbro.modules.job.entity.Job;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface JobDao {
    public List<Job> getAllJob();
}
