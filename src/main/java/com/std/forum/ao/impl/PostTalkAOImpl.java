package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.PostTalk;
import com.std.forum.enums.ETalkType;

@Service
public class PostTalkAOImpl implements IPostTalkAO {

    @Autowired
    protected IPostTalkBO postTalkBO;

    @Override
    public int doPostTalk(PostTalk data) {
        int count = 0;
        if (null != postTalkBO.getPostTalk(data)) {
            count = postTalkBO.removePostTalk(postTalkBO.getPostTalk(data)
                .getCode());
        } else {
            count = postTalkBO.savePostTalk(data);
        }
        return count;
    }

    @Override
    public int doPostTalkByAmount(PostTalk data) {
        data.setType(ETalkType.DS.getCode());
        return postTalkBO.savePostTalk(data);
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
