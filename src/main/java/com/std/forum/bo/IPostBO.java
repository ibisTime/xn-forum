/**
 * @Title IPostBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午4:18:41 
 * @version V1.0   
 */
package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Post;

/** 
 * 帖子BO
 * @author: xieyj 
 * @since: 2016年8月29日 下午4:18:41 
 * @history:
 */
public interface IPostBO extends IPaginableBO<Post> {

    public String savePost(Post data);

    public int removePost(String code);

    public int refreshPostApprove(Post data);

    public int refreshPostAttr(Post data);

    public int refreshPostReport(String code);

    public int refreshPostReadTime(String code);

    public Post getPost(String code);

    public List<Post> queryPostList(Post condition);

    public long getPostNum(Post condition);
}
