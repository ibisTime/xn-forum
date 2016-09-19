/**
 * @Title IPostAO.java 
 * @Package com.std.forum.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午7:46:59 
 * @version V1.0   
 */
package com.std.forum.ao;

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

    public void approvePost(Post data);

    public void reportPost(Post data);

    public int setUpPost(Post data);

    public void addReadTime(String code);

}
