/**
 * @Title IPostDAO.java 
 * @Package com.std.forum.dao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午9:41:35 
 * @version V1.0   
 */
package com.std.forum.dao;

import com.std.forum.dao.base.IBaseDAO;
import com.std.forum.domain.Post;

/** 
 * @author: xieyj 
 * @since: 2016年8月28日 下午9:41:35 
 * @history:
 */
public interface IPostDAO extends IBaseDAO<Post> {
    String NAMESPACE = IPostDAO.class.getName().concat(".");

    /**
     * 举报
     */
    public int updateReport(Post data);

    /**
     * 审核
     */
    public int updateApprove(Post data);

    /**
     * 设置精华，头条，置顶
     */
    public int updateAttr(Post data);

    /**
     * 递增阅读量
     */
    public int updateReadTime(Post data);
}
