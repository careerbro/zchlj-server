package com.main.careerbro.modules.comment.service;

import com.main.careerbro.modules.comment.dao.CommentDao;
import com.main.careerbro.modules.comment.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    public List<Comment> getBySalaryId(String salaryId){

        return commentDao.getBySalaryId(salaryId);
    }

    public List<Comment> getByUserId(String userId){

        return commentDao.getByUserId(userId);
    }
}
