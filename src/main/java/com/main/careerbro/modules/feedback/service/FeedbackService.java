package com.main.careerbro.modules.feedback.service;

import com.main.careerbro.modules.feedback.dao.FeedbackDao;
import com.main.careerbro.modules.feedback.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FeedbackService {
    @Autowired
    FeedbackDao feedbackDao;
    @Transactional
    public void saveFeedback(Feedback feedback){
        if(feedback.getId().isEmpty()) feedback.setId(UUID.randomUUID().toString().replaceAll("-",""));
        feedbackDao.saveFeedback(feedback);
    }
}
