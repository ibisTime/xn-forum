/**
 * @Title PostTalkBOImpl.java 
 * @Package com.std.forum.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午5:07:00 
 * @version V1.0   
 */
package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IPostTalkDAO;
import com.std.forum.domain.PostTalk;
import com.std.forum.enums.EPrefixCode;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午5:07:00 
 * @history:
 */
@Component
public class PostTalkBOImpl extends PaginableBOImpl<PostTalk> implements
        IPostTalkBO {
    @Autowired
    private IPostTalkDAO postTalkDAO;

    /** 
     * @see com.std.forum.bo.IPostTalkBO#savePostTalk(com.std.forum.domain.PostTalk)
     */
    @Override
    public int savePostTalk(String postCode, String talker, String type,
            String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(postCode) && StringUtils.isNotBlank(talker)) {
            String code = OrderNoGenerater.generate(EPrefixCode.POSTTALK
                .getCode());
            PostTalk data = new PostTalk();
            data.setCode(code);
            data.setPostCode(postCode);
            data.setTalker(talker);
            data.setType(type);
            data.setTalkDatetime(new Date());
            data.setRemark(remark);
            count = postTalkDAO.insert(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IPostTalkBO#queryPostTalkList(com.std.forum.domain.PostTalk)
     */
    @Override
    public List<PostTalk> queryPostTalkSingleList(String postCode, String type) {
        List<PostTalk> resultList = null;
        if (StringUtils.isNotBlank(postCode) && StringUtils.isNotBlank(type)) {
            PostTalk condition = new PostTalk();
            condition.setPostCode(postCode);
            condition.setType(type);
            resultList = postTalkDAO.selectList(condition);
        }
        return resultList;
    }

    /** 
     * @see com.std.forum.bo.IPostTalkBO#queryPostTalkList(com.std.forum.domain.PostTalk)
     */
    @Override
    public List<PostTalk> queryPostTalkList(PostTalk condition) {
        return postTalkDAO.selectList(condition);
    }

    /** 
     * @see com.std.forum.bo.IPostTalkBO#getPostTalk(java.lang.String)
     */
    @Override
    public PostTalk getPostTalk(String code) {
        PostTalk result = null;
        if (StringUtils.isNotBlank(code)) {
            PostTalk condition = new PostTalk();
            condition.setCode(code);
            result = postTalkDAO.select(condition);
        }
        return result;
    }

    /** 
     * @see com.std.forum.bo.IPostTalkBO#getPostTalkByCondition(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public PostTalk getPostTalkByCondition(String postCode, String userId,
            String type) {
        PostTalk result = null;
        if (StringUtils.isNotBlank(postCode) && StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(type)) {
            PostTalk condition = new PostTalk();
            condition.setPostCode(postCode);
            condition.setTalker(userId);
            condition.setType(type);
            result = postTalkDAO.select(condition);
        }
        return result;
    }

    @Override
    public int removePostTalk(String code) {
        int count = 0;
        if (null != code) {
            PostTalk data = new PostTalk();
            data.setCode(code);
            count = postTalkDAO.delete(data);
        }
        return count;
    }
}
