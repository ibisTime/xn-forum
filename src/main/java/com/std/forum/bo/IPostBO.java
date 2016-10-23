/**
 * @Title IPostBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午4:18:41 
 * @version V1.0   
 */
package com.std.forum.bo;

import java.util.Date;
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

    public String savePost(String title, String content, String pic,
            String plateCode, String publisher, String status);

    public void refreshPost(String code, String title, String content,
            String pic, String plateCode, String publisher, String status);

    public int removePost(String code);

    public int refreshPostApprove(String code, String approver,
            String approveResult, String approveNote);

    public int refreshPostReport(String code, String remark);

    public int refreshPostLocation(String code, String location,
            Date endDatetime);

    public int refreshPostLock(String code, String isLock);

    public int refreshPostPlate(String code, String plateCode);

    public Post getPost(String code);

    public List<Post> queryPostList(Post condition);

    public long getPostNum(Post condition);
}
