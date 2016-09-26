/**
 * @Title PostBOImp.java 
 * @Package com.std.forum.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午4:24:47 
 * @version V1.0   
 */
package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IPostBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IPostDAO;
import com.std.forum.domain.Post;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.EPrefixCode;

/** 
 * 帖子BO
 * @author: xieyj 
 * @since: 2016年8月29日 下午4:24:47 
 * @history:
 */
@Component
public class PostBOImpl extends PaginableBOImpl<Post> implements IPostBO {

    @Autowired
    private IPostDAO postDAO;

    /** 
     * @see com.std.forum.bo.IPostBO#savePost(com.std.forum.domain.Post)
     */
    @Override
    public String savePost(Post data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EPrefixCode.POST.getCode());
            data.setCode(code);
            data.setIsReport(EBoolean.NO.getCode());
            data.setIsHeadline(EBoolean.NO.getCode());
            data.setIsTop(EBoolean.NO.getCode());
            data.setIsEssence(EBoolean.NO.getCode());
            data.setReadTime(0);
            data.setPublishDatetime(new Date());
            postDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.std.forum.bo.IPostBO#removePost(java.lang.String)
     */
    @Override
    public int removePost(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Post data = new Post();
            data.setCode(code);
            count = postDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IPostBO#refreshPostApprove(com.std.forum.domain.Post)
     */
    @Override
    public int refreshPostApprove(Post data) {
        int count = 0;
        if (data != null) {
            data.setApproveDatetime(new Date());
            count = postDAO.updateApprove(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IPostBO#refreshPostAttr(com.std.forum.domain.Post)
     */
    @Override
    public int refreshPostAttr(Post data) {
        int count = 0;
        if (data != null) {
            count = postDAO.updateAttr(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IPostBO#refreshPostReport(com.std.forum.domain.Post)
     */
    @Override
    public int refreshPostReport(Post data) {
        int count = 0;
        if (data != null) {
            data.setIsReport(EBoolean.YES.getCode());
            data.setReportDatetime(new Date());
            count = postDAO.updateApprove(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IPostBO#refreshPostReadTime(com.std.forum.domain.Post)
     */
    @Override
    public int refreshPostReadTime(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Post data = new Post();
            data.setCode(code);
            count = postDAO.updateReadTime(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IPostBO#getPost(java.lang.String)
     */
    @Override
    public Post getPost(String code) {
        Post result = null;
        if (StringUtils.isNotBlank(code)) {
            Post condition = new Post();
            condition.setCode(code);
            result = postDAO.select(condition);
        }
        return result;
    }

    /** 
     * @see com.std.forum.bo.IPostBO#queryPostList(com.std.forum.domain.Post)
     */
    @Override
    public List<Post> queryPostList(Post condition) {
        return postDAO.selectList(condition);
    }
}
