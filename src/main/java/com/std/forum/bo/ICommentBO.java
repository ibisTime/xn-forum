/**
 * @Title ICommentBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:21:32 
 * @version V1.0   
 */
package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Comment;

/** 
 * 评论
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:21:32 
 * @history:
 */
public interface ICommentBO extends IPaginableBO<Comment> {

    public String saveComment(String content, String parentCode, String status,
            String commer);

    public int removeComment(String code);

    public int refreshCommentApprove(String code, String status,
            String approver, String approveNote);

    public int refreshCommentReport(String code, String remark);

    public int refreshCommentReturn(String code);

    public Comment getComment(String code);

    public List<Comment> queryCommentList(Comment condition);
}
