/**
 * @Title PostAOImpl.java 
 * @Package com.std.forum.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午7:52:36 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IPostAO;
import com.std.forum.bo.IPostBO;
import com.std.forum.domain.Post;

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
        return postBO.savePost(data);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#approvePost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void approvePost(Post data) {

    }

    /** 
     * @see com.std.forum.ao.IPostAO#reportPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void reportPost(Post data) {
        // TODO Auto-generated method stub

    }

    /** 
     * @see com.std.forum.ao.IPostAO#setUpPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void setUpPost(Post data) {
        // TODO Auto-generated method stub

    }

    /** 
     * @see com.std.forum.ao.IPostAO#addReadTime(java.lang.String)
     */
    @Override
    public void addReadTime(String code) {
    }

}
