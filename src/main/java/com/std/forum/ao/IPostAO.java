/**
 * @Title IPostAO.java 
 * @Package com.std.forum.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午7:46:59 
 * @version V1.0   
 */
package com.std.forum.ao;

import java.util.Date;
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

    /*
     * 发帖
     */
    public String publishPost(String title, String content, String pic,
            String plateCode, String publisher, String isPublish);

    /*
     * 草稿发帖
     */
    public void draftPublishPost(String code, String title, String content,
            String pic, String plateCode, String publisher, String isPublish);

    /*
     * 删除帖子/评论
     */
    public void dropPost(String code, String userId, String type);

    /*
     * 批量删除帖子/评论
     */
    public void dropPostList(List<String> codeList, String userId, String type);

    /*
     * 审核帖子/评论
     */
    public void approvePost(String code, String approver,
            String approverResult, String approveNote, String type);

    /*
     * 批量审核帖子/评论
     */
    public void approvePostList(List<String> codeList, String approver,
            String approveResult, String approveNote, String type);

    /*
     * 还原帖子/评论
     */
    public void returnPost(String code, String type);

    /*
     * 阅读帖子
     */
    public void readPost(String code, String reader);

    /*
     * 锁帖
     */
    public void lockPost(String code);

    /*
     * 改版
     */
    public void editPostPlate(String code, String plateCode);

    /*
     * 设置置顶，精华和头条
     */
    public void setPostLocation(String code, String isAdd, String location,
            Date endDatetime);

    public Paginable<Post> queryPostPage(int start, int limit, Post condition);

    public List<Post> queryPostList(Post condition);

    public Post getPost(String code, String userId);

    public Paginable<Post> querySCPostPage(int start, int limit, Post condition);

    public List<Post> querySCPostList(String userId);

    public Post getPostByCommentCode(String commentCode, String userId);

    public XN610900Res totalPostNum(String userId);

    public void doChangePostLocation();
}
