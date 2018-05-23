package com.main.careerbro.modules.job.service;

import com.main.careerbro.modules.job.dao.JobDao;
import com.main.careerbro.modules.job.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobDao jobDao;
    public List<Job> getJob(String temp){
        return jobDao.getJob(temp);
    }
}
