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

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.ICommentDAO;
import com.std.forum.domain.Comment;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.EPostStatus;
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

    @Override
    public String saveComment(String content, String parentCode, String status,
            String commer, String postCode) {
        String code = null;
        if (StringUtils.isNotBlank(content)
                && StringUtils.isNotBlank(parentCode)
                && StringUtils.isNotBlank(commer)) {
            code = OrderNoGenerater.generate(EPrefixCode.COMMENT.getCode());
            Comment data = new Comment();
            data.setCode(code);
            data.setContent(content);
            data.setParentCode(parentCode);
            data.setStatus(status);
            data.setCommer(commer);
            data.setCommDatetime(new Date());
            data.setPostCode(postCode);
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
        if (CollectionUtils.isNotEmpty(resultList)) {
            for (Comment comment : resultList) {
                Comment result = getComment(comment.getParentCode());
                if (result != null) {
                    comment.setParentCommer(result.getCommer());
                    comment.setParentNickname(result.getNickname());
                }
            }
        }
        return resultList;
    }

    @Override
    public int removeComment(String code) {
        int count = 0;
        if (null != code) {
            Comment data = new Comment();
            data.setCode(code);
            count = commentDAO.delete(data);
        }
        return count;
    }

    /**
     * @see com.std.forum.bo.IPostBO#refreshPostApprove(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshCommentApprove(String code, String approveResult,
            String approver, String approveNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Comment data = new Comment();
            data.setCode(code);
            if (EBoolean.YES.getCode().equals(approveResult)) {
                data.setStatus(EPostStatus.APPROVE_YES.getCode());
            } else {
                data.setStatus(EPostStatus.APPROVE_NO.getCode());
            }
            data.setApprover(approver);
            data.setApproveDatetime(new Date());
            data.setApproveNote(approveNote);
            count = commentDAO.updateApprove(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.ICommentBO#refreshCommentReport(java.lang.String, java.lang.String)
     */
    @Override
    public int refreshCommentReport(String code, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Comment data = new Comment();
            data.setCode(code);
            data.setStatus(EPostStatus.toReportAPPROVE.getCode());
            data.setRemark(remark);
            count = commentDAO.updateStatus(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.ICommentBO#refreshCommentReturn(java.lang.String)
     */
    @Override
    public int refreshCommentReturn(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Comment data = new Comment();
            data.setCode(code);
            data.setStatus(EPostStatus.APPROVE_YES.getCode());
            count = commentDAO.updateStatus(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.ICommentBO#removeCommentByPost(java.lang.String)
     */
    @Override
    public int removeCommentByPost(String postCode) {
        int count = 0;
        if (StringUtils.isNotBlank(postCode)) {
            Comment data = new Comment();
            data.setPostCode(postCode);
            count = commentDAO.deleteCommentByPostCode(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.ICommentBO#queryCommentList(java.lang.String, java.lang.String)
     */
    @Override
    public List<Comment> queryCommentList(String postCode, String status,
            int limit) {
        Comment condition = new Comment();
        condition.setPostCode(postCode);
        condition.setStatus(status);
        List<Comment> resultList = null;
        if (limit != 0) {
            resultList = commentDAO.selectList(condition, 0, limit);
        } else {
            resultList = commentDAO.selectList(condition);
        }
        if (CollectionUtils.isNotEmpty(resultList)) {
            for (Comment comment : resultList) {
                Comment result = getComment(comment.getParentCode());
                if (result != null) {
                    comment.setParentCommer(result.getCommer());
                    comment.setParentNickname(result.getNickname());
                }
            }
        }
        return resultList;
    }

    /** 
     * @see com.std.forum.bo.ICommentBO#getCommentTotalCount(java.lang.String, java.lang.String)
     */
    @Override
    public long getCommentTotalCount(String postCode, String status) {
        Comment condition = new Comment();
        condition.setPostCode(postCode);
        condition.setStatus(status);
        return commentDAO.selectTotalCount(condition);
    }

}
