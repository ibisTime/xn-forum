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
import com.std.forum.domain.Comment;
import com.std.forum.domain.Post;
import com.std.forum.domain.PostTalk;
import com.std.forum.enums.EPostStatus;
import com.std.forum.enums.EPostType;
import com.std.forum.enums.ETalkType;
import com.std.forum.exception.BizException;

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
    public void doPostTalk(String postCode, String userId, String type) {
        PostTalk postTalk = postTalkBO.getPostTalkByCondition(postCode, userId,
            type);
        if (null != postTalk) {
            postTalkBO.removePostTalk(postTalk.getCode());
        } else {
            postTalkBO.savePostTalk(postCode, userId, type, ETalkType
                .getTalkTypeMap().get(type).getValue());
        }
    }

    @Override
    @Transactional
    public void doPostTalk(String postCode, String userId, Long amount) {
        Post post = postBO.getPost(postCode);
        postTalkBO.savePostTalk(postCode, userId, ETalkType.DS.getCode(),
            String.valueOf(amount));
        userBO.doTransferAdd(userId, post.getPublisher(), amount, "打赏帖子",
            postCode);
    }

    @Override
    @Transactional
    public void reportPost(String code, String reporter, String reportNote,
            String type) {
        StringBuffer reportNoteBuffer = new StringBuffer(reportNote);
        // 判断是否达到举报条数，更新帖子或评论状态待审核
        if (EPostType.TZ.getCode().equals(type)) {
            type = ETalkType.TZJB.getCode();
            Post post = postBO.getPost(code);
            if (EPostStatus.APPROVE_YES.getCode().equals(post.getStatus())) {
                throw new BizException("xn000000", "该帖已审核通过，不能举报");
            }
            boolean result = this.isToMax(code, post.getPublisher(), type,
                reportNoteBuffer);
            if (result) {
                postBO.refreshPostReport(code, reportNoteBuffer.toString());
            }
        } else {
            type = ETalkType.PLJB.getCode();
            Comment comment = commentBO.getComment(code);
            if (EPostStatus.APPROVE_YES.getCode().equals(comment.getStatus())) {
                throw new BizException("xn000000", "该评论已审核通过，不能举报");
            }
            boolean result = this.isToMax(code, comment.getCommer(), type,
                reportNoteBuffer);
            if (result) {
                commentBO.refreshCommentReport(code,
                    reportNoteBuffer.toString());
            }
        }
        postTalkBO.savePostTalk(code, reporter, type, reportNote);
    }

    private boolean isToMax(String code, String talker, String type,
            StringBuffer reportNote) {
        boolean result = false;
        PostTalk condition = new PostTalk();
        condition.setPlateCode(code);
        condition.setTalker(talker);
        condition.setType(type);
        List<PostTalk> reportList = postTalkBO.queryPostTalkList(condition);
        int maxTimes = ruleBO.getJBTimesByUserId(talker).intValue();
        StringBuffer sb = new StringBuffer();
        if (reportList.size() + 1 >= maxTimes) {
            for (PostTalk postTalk : reportList) {
                sb.append(postTalk.getRemark()).append(";");
            }
            sb.append(reportNote).append(";");
            reportNote = sb;
            result = true;
        }
        return result;
    }
}
