package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;

/** 
 * 评论
 * @author: zuixian 
 * @since: 2016年9月19日 下午2:52:00 
 * @history:
 */
public interface ICommentAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String doComment(String content, String parentCode, String commer);

    public int doRemoveComment(String code);

    public Comment getComment(String code);

    public List<Comment> queryCommentList(Comment condition);

    public Paginable<Comment> queryCommentPage(int start, int limit,
            Comment condition);

    public Paginable<Comment> queryMyCommentPage(int start, int limit,
            Comment condition);

    public Paginable<Comment> queryCommentMyPage(int start, int limit,
            Comment condition);
}
