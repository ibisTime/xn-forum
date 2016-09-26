/**
 * @Title CommentBOImpl.java 
 * @Package com.std.forum.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午5:01:01 
 * @version V1.0   
 */
package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.ICommentDAO;
import com.std.forum.domain.Comment;
import com.std.forum.enums.EPrefixCode;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午5:01:01 
 * @history:
 */
@Component
public class CommentBOImpl extends PaginableBOImpl<Comment> implements
        ICommentBO {

    @Autowired
    private ICommentDAO commentDAO;

    /** 
     * @see com.std.forum.bo.ICommentBO#saveComment(com.std.forum.domain.Comment)
     */
    @Override
    public String saveComment(Comment data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EPrefixCode.COMMENT.getCode());
            data.setCode(code);
            data.setCommDatetime(new Date());
            commentDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.std.forum.bo.ICommentBO#getComment(java.lang.String)
     */
    @Override
    public Comment getComment(String code) {
        Comment result = null;
        if (StringUtils.isNotBlank(code)) {
            Comment condition = new Comment();
            condition.setCode(code);
            result = commentDAO.select(condition);
        }
        return result;
    }

    /** 
     * @see com.std.forum.bo.ICommentBO#queryCommentList(com.std.forum.domain.Comment)
     */
    @Override
    public List<Comment> queryCommentList(Comment condition) {
        List<Comment> resultList = commentDAO.selectList(condition);
        for (Comment comment : resultList) {
            Comment comCondition = new Comment();
            comCondition.setCode(comment.getParentCode());
            Comment result = commentDAO.select(comCondition);
            comment.setParentCommer(result.getCommer());
        }
        return resultList;
    }
}
