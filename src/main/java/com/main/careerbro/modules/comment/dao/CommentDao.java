package com.main.careerbro.modules.comment.dao;

import com.main.careerbro.modules.comment.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentDao {
    /**
     * 获取评论BY salary
     * @param salaryId
     * @return
     */
    public List<Comment> getBySalaryId(String salaryId);

    /**
     * 获取评论BY user
     * @param userId
     * @return
     */
    public List<Comment> getByUserId(String userId);
}
