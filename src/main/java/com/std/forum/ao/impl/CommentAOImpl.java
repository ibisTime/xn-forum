package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.ICommentAO;
import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;

@Service
public class CommentAOImpl implements ICommentAO {

    @Autowired
    private ICommentBO commentBO;

    @Override
    public String doComment(Comment data) {
        return commentBO.saveComment(data);
    }

    @Override
    public int doRemoveComment(String code) {
        return commentBO.removeComment(code);
    }

    @Override
    public Comment getComment(String code) {
        return commentBO.getComment(code);
    }

    @Override
    public List<Comment> queryCommentList(Comment condition) {
        return commentBO.queryCommentList(condition);
    }

    @Override
    public Paginable<Comment> querySitePage(int start, int limit,
            Comment condition) {
        return commentBO.getPaginable(start, limit, condition);
    }

}
