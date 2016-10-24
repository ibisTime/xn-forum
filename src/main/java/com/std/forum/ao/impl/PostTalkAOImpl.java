package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.IPostTalkAO;
import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;
import com.std.forum.domain.Post;
import com.std.forum.domain.PostTalk;
import com.std.forum.enums.EDirection;
import com.std.forum.enums.EPostType;
import com.std.forum.enums.ETalkType;

@Service
public class PostTalkAOImpl implements IPostTalkAO {

    @Autowired
    protected IPostTalkBO postTalkBO;

    @Autowired
    protected IPostBO postBO;

    @Autowired
    protected IUserBO userBO;

    @Autowired
    protected ICommentBO commentBO;

    @Autowired
    protected IRuleBO ruleBO;

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
    @Transactional
    public void reportPost(String code, String reporter, String reportNote,
            String type) {
        // 判断是否达到举报条数，更新帖子或评论状态待审核
        if (EPostType.TZ.getCode().equals(type)) {
            type = ETalkType.TZJB.getCode();
            Post post = postBO.getPost(code);
            String publisher = post.getPublisher();
            PostTalk condition = new PostTalk();
            condition.setPlateCode(code);
            condition.setTalker(publisher);
            condition.setType(type);
            List<PostTalk> talkList = postTalkBO.queryPostTalkList(condition);
            int maxTimes = ruleBO.getJBTimesByUserId(publisher).intValue();
            if (maxTimes <= talkList.size() + 1) {
                postBO.refreshPostReport(code, reportNote);
            }
        } else if (EPostType.PL.getCode().equals(type)) {
            type = ETalkType.PLJB.getCode();
            Comment comment = commentBO.getComment(code);
            String commer = comment.getCommer();
            PostTalk condition = new PostTalk();
            condition.setPlateCode(code);
            condition.setTalker(commer);
            condition.setType(type);
            List<PostTalk> talkList = postTalkBO.queryPostTalkList(condition);
            int maxTimes = ruleBO.getJBTimesByUserId(commer).intValue();
            if (maxTimes <= talkList.size() + 1) {
                commentBO.refreshCommentReport(code, reportNote);
            }
        }
        postTalkBO.savePostTalk(code, reporter, type, reportNote);
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
