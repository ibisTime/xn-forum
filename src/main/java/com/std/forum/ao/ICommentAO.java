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

    public String doComment(Comment data);

    public int doRemoveComment(String code);

    public Comment getComment(String code);

    public List<Comment> queryCommentList(Comment condition);

    public Paginable<Comment> querySitePage(int start, int limit,
            Comment condition);
}
