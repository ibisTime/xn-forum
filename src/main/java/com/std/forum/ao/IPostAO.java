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
import com.std.forum.dto.res.XN610900Res;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午7:46:59 
 * @history:
 */
public interface IPostAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String draftPost(String title, String content, String pic,
            String plateCode, String publisher);

    public void editPost(String code, String title, String content, String pic,
            String plateCode, String publisher);

    public String publishPost(String code, String title, String content,
            String pic, String plateCode, String publisher);

    public int removePostBySelf(String code, String userId);

    public int removePost(String code);

    public int approvePost(String code, String status, String approver,
            String approveNote);

    public void reportPost(String code, String reporter, String reportNote);

    public void readPost(String code, String reader);

    public int setPostHeadlines(String code, String isHeadlines);

    public int setPostLocation(String code, String isAdd, String location,
            String orderNo);

    public Paginable<Post> queryPostPage(int start, int limit, Post condition);

    public List<Post> queryPostList(Post condition);

    public Post getPost(String code, String userId);

    public Paginable<Post> querySCPostPage(int start, int limit, Post condition);

    public List<Post> querySCPostList(String userId);

    public Post getPostByCommentCode(String commentCode, String userId);

    public XN610900Res totalPostNum(String userId);
}
