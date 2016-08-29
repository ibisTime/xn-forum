/**
 * @Title PostTalkDAOImpl.java 
 * @Package com.std.forum.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 上午10:32:38 
 * @version V1.0   
 */
package com.std.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.forum.dao.IPostTalkDAO;
import com.std.forum.dao.base.support.AMybatisTemplate;
import com.std.forum.domain.PostTalk;

/** 
 * 点赞/收藏/打赏记录DAO层
 * @author: xieyj 
 * @since: 2016年8月29日 上午10:32:38 
 * @history:
 */
@Repository("postTalkDAOImpl")
public class PostTalkDAOImpl extends AMybatisTemplate implements IPostTalkDAO {

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(PostTalk data) {
        return super.insert(NAMESPACE.concat("insert_postTalk"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(PostTalk data) {
        return super.delete(NAMESPACE.concat("delete_postTalk"), data);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public PostTalk select(PostTalk condition) {
        return (PostTalk) super.select(NAMESPACE.concat("select_postTalk"),
            condition, PostTalk.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(PostTalk condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_postTalk_count"), condition);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<PostTalk> selectList(PostTalk condition) {
        return super.selectList(NAMESPACE.concat("select_postTalk"), condition,
            PostTalk.class);
    }

    /** 
     * @see com.std.forum.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<PostTalk> selectList(PostTalk condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_postTalk"), start,
            count, condition, PostTalk.class);
    }

}
