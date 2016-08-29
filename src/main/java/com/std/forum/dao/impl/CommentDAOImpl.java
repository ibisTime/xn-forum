/**
 * @Title CommentDAOImpl.java 
 * @Package com.std.forum.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 上午10:32:38 
 * @version V1.0   
 */
package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.ICommentDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.Comment;

/** 
 * 评论记录DAO层
 * @author: xieyj 
 * @since: 2016年8月29日 上午10:32:38 
 * @history:
 */
@Repository("commentDAOImpl")
public class CommentDAOImpl extends AMybatisTemplate implements ICommentDAO {

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Comment data) {
        return super.insert(NAMESPACE.concat("insert_comment"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Comment data) {
        return super.delete(NAMESPACE.concat("delete_comment"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Comment select(Comment condition) {
        return (Comment) super.select(NAMESPACE.concat("select_comment"),
            condition, Comment.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(Comment condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_comment_count"),
            condition);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Comment> selectList(Comment condition) {
        return super.selectList(NAMESPACE.concat("select_comment"), condition,
            Comment.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Comment> selectList(Comment condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_comment"), start,
            count, condition, Comment.class);
    }

}
