package com.main.careerbro.modules.feedback.dao;

import com.main.careerbro.modules.feedback.entity.Feedback;
import org.springframework.stereotype.Component;

@Component
public interface FeedbackDao {
    public void saveFeedback(Feedback feedback);
}
