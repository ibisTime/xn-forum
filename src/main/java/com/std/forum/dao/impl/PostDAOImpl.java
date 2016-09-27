/**
 * @Title PostDAOImpl.java 
 * @Package com.std.forum.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午9:46:01 
 * @version V1.0   
 */
package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.common.PropertiesUtil;
import com.std.forum.dao.IPostDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Post;

/** 
 * @author: xieyj 
 * @since: 2016年8月28日 下午9:46:01 
 * @history:
 */
@Repository("postDAOImpl")
public class PostDAOImpl extends AMybatisTemplate implements IPostDAO {

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Post data) {
        return super.insert(NAMESPACE.concat("insert_post"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Post data) {
        return super.delete(NAMESPACE.concat("delete_post"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Post select(Post condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return (Post) super.select(NAMESPACE.concat("select_post"), condition,
            Post.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(Post condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectTotalCount(NAMESPACE.concat("select_post_count"),
            condition);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Post> selectList(Post condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_post"), condition,
            Post.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Post> selectList(Post condition, int start, int count) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_post"), start, count,
            condition, Post.class);
    }

    /** 
     * @see com.std.forum.dao.IPostDAO#updateReport(com.std.forum.domain.Post)
     */
    @Override
    public int updateReport(Post data) {
        return super.update(NAMESPACE.concat("update_post_report"), data);
    }

    /** 
     * @see com.std.forum.dao.IPostDAO#updateApprove(com.std.forum.domain.Post)
     */
    @Override
    public int updateApprove(Post data) {
        return super.update(NAMESPACE.concat("update_post_approve"), data);
    }

    /** 
     * @see com.std.forum.dao.IPostDAO#updateAttr(com.std.forum.domain.Post)
     */
    @Override
    public int updateAttr(Post data) {
        return super.update(NAMESPACE.concat("update_post_attr"), data);
    }

    /** 
     * @see com.std.forum.dao.IPostDAO#updateReadTime(com.std.forum.domain.Post)
     */
    @Override
    public int updateReadTime(Post data) {
        return super.update(NAMESPACE.concat("update_post_readTime"), data);
    }

    @Override
    public long selectPostNum(Post condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_post1_count"),
            condition);
    }
}
