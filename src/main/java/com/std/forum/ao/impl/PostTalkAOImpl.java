package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.PostTalk;
import com.std.forum.enums.EDirection;
import com.std.forum.enums.ETalkType;

@Service
public class PostTalkAOImpl implements IPostTalkAO {

    @Autowired
    protected IPostTalkBO postTalkBO;

    @Autowired
    protected IPostBO postBO;

    @Autowired
    protected IUserBO userBO;

    @Override
    public int doPostTalk(String postCode, String userId, String type) {
        int count = 0;
        PostTalk postTalk = postTalkBO.getPostTalkByCondition(postCode, userId,
            type);
        if (null != postTalk) {
            count = postTalkBO.removePostTalk(postTalk.getCode());
        } else {
            count = postTalkBO.savePostTalk(postCode, userId, type, null);
        }
        return count;
    }

    @Override
    @Transactional
    public int doPostTalk(String postCode, String userId, Long amount) {
        int id = postTalkBO.savePostTalk(postCode, userId,
            ETalkType.DS.getCode(), String.valueOf(amount));
        userBO.doTransfer(userId, EDirection.PLUS.getCode(), amount, "打赏帖子",
            postCode);
        return id;
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
