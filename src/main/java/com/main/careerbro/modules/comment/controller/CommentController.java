package com.main.careerbro.modules.comment.controller;

import com.main.careerbro.modules.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;


}
