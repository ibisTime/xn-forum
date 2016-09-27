/**
 * @Title PostAOImpl.java 
 * @Package com.std.forum.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午7:52:36 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IPostAO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Post;
import com.std.forum.enums.EPostStatus;
import com.std.forum.enums.EPostType;
import com.std.forum.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午7:52:36 
 * @history:
 */
@Service
public class PostAOImpl implements IPostAO {
    @Autowired
    protected IPostBO postBO;

    /** 
     * @see com.std.forum.ao.IPostAO#publishPost(com.std.forum.domain.Post)
     */
    @Override
    public String publishPost(Post data) {
        // 将帖子状态默认为待审核
        data.setStatus(EPostStatus.todoAPPROVE.getCode());
        return postBO.savePost(data);
    }

    @Override
    public int removePostByPU(String code, String userId) {
        int count = 0;
        Post data = postBO.getPost(code);
        if (data.getPublisher().equals(userId)) {
            count = postBO.removePost(code);
        } else {
            throw new BizException("xn000000", "只能删除自己发布的帖子");
        }
        return count;
    }

    @Override
    public int removePostByGL(String code) {
        return postBO.removePost(code);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#approvePost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int approvePost(Post data) {
        return postBO.refreshPostApprove(data);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#reportPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int reportPost(Post data) {
        return postBO.refreshPostReport(data);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#setUpPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int setUpPost(Post data) {
        return postBO.refreshPostAttr(data);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#addReadTime(java.lang.String)
     */
    @Override
    public int addReadTime(String code) {
        return postBO.refreshPostReadTime(code);
    }

    @Override
    public Paginable<Post> queryPostPage(int start, int limit, Post condition) {
        return postBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Post> queryPostList(Post condition) {
        return postBO.queryPostList(condition);
    }

    @Override
    public Post getPost(String code) {
        return postBO.getPost(code);
    }

    @Override
    public Paginable<Post> querySCPostPage(int start, int limit, Post condition) {
        condition.setType(EPostType.SC.getCode());
        return postBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Post> querySCPostList(String userId) {
        Post condition = new Post();
        condition.setType(EPostType.SC.getCode());
        condition.setUserId(userId);
        return postBO.queryPostList(condition);
    }

}
