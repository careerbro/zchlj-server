package com.main.careerbro.modules.feedback.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.modules.feedback.entity.Feedback;
import com.main.careerbro.modules.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("feedback")
@RestController
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @RequestMapping("feedback")
    public AjaxJson saveFeedback(@RequestBody Feedback feedback){
        feedbackService.saveFeedback(feedback);
        return Ajax.success();
    }
}
