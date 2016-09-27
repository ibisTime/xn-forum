/**
 * @Title IPostAO.java 
 * @Package com.std.forum.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午7:46:59 
 * @version V1.0   
 */
package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Post;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午7:46:59 
 * @history:
 */
public interface IPostAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String publishPost(Post post);

    public int removePostByPU(String code, String userId);

    public int removePostByGL(String code);

    public int approvePost(Post data);

    public int reportPost(Post data);

    public int setUpPost(Post data);

    public int addReadTime(String code);

    public Paginable<Post> queryPostPage(int start, int limit, Post condition);

    public List<Post> queryPostList(Post condition);

    public Post getPost(String code);

    public Paginable<Post> querySCPostPage(int start, int limit, Post condition);

    public List<Post> querySCPostList(String userId);

}
