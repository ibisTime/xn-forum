package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.ICommentAO;
import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;
import com.std.forum.domain.Post;
import com.std.forum.enums.EPrefixCode;

@Service
public class CommentAOImpl implements ICommentAO {

    @Autowired
    private ICommentBO commentBO;

    @Autowired
    private IPostBO postBO;

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
    public Paginable<Comment> queryCommentPage(int start, int limit,
            Comment condition) {
        return commentBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.std.forum.ao.ICommentAO#queryMyCommentPage(int, int, com.std.forum.domain.Comment)
     */
    @Override
    public Paginable<Comment> queryMyCommentPage(int start, int limit,
            Comment condition) {
        Paginable<Comment> page = commentBO.getPaginable(start, limit,
            condition);
        List<Comment> list = page.getList();
        for (Comment comment : list) {
            String parentCode = comment.getParentCode();
            if (EPrefixCode.POST.getCode().equals(parentCode.substring(0, 2))) {
                Post post = postBO.getPost(parentCode);
                comment.setPost(post);
            } else {
                Comment data = commentBO.getComment(parentCode);
                comment.setParentComment(data);
            }
        }
        return page;
    }

    /** 
     * @see com.std.forum.ao.ICommentAO#queryCommentMyPage(int, int, com.std.forum.domain.Comment)
     */
    @Override
    public Paginable<Comment> queryCommentMyPage(int start, int limit,
            Comment condition) {
        Paginable<Comment> page = commentBO.getPaginable(start, limit,
            condition);
        List<Comment> list = page.getList();
        for (Comment comment : list) {
            Comment cCondition = new Comment();
            cCondition.setParentCode(comment.getCode());
            List<Comment> nextCommentList = commentBO
                .queryCommentList(cCondition);
            comment.setNextCommentList(nextCommentList);
        }
        return page;
    }
}
