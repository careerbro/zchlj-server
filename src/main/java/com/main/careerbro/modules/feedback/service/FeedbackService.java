package com.main.careerbro.modules.feedback.service;

import com.main.careerbro.modules.feedback.dao.FeedbackDao;
import com.main.careerbro.modules.feedback.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackService {
    @Autowired
    FeedbackDao feedbackDao;
    @Transactional
    public void saveFeedback(Feedback feedback){
        feedbackDao.saveFeedback(feedback);
    }
}
