package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.PostTalk;

@Service
public class PostTalkAOImpl implements IPostTalkAO {

    @Autowired
    protected IPostTalkBO postTalkBO;

    @Override
    public int doPostTalk(String postCode, String userId, String type) {
        int count = 0;
        PostTalk postTalk = postTalkBO.getPostTalkByCondition(postCode, userId,
            type);
        if (null != postTalk) {
            count = postTalkBO.removePostTalk(postTalk.getCode());
        } else {
            count = postTalkBO.savePostTalk(postCode, userId, type);
        }
        return count;
    }

    /** 
     * @see com.std.forum.ao.IPostTalkAO#doPostTalkByAmount(java.lang.String, java.lang.String, java.lang.Long)
     */
    @Override
    public int doPostTalkByAmount(String postCode, String userId, Long amount) {
        return postTalkBO.savePostTalk(postCode, userId, amount);
    }

    @Override
    public List<PostTalk> queryPostTalkSingleList(String postCode, String type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PostTalk> queryPostTalkList(PostTalk condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Paginable<PostTalk> queryPostTalkPage(int start, int limit,
            PostTalk condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PostTalk getPostTalk(String postCode, String talker) {
        // TODO Auto-generated method stub
        return null;
    }
}
