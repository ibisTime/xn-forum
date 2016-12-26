package com.std.forum.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
            if (EPostStatus.toReportAPPROVE.getCode().equals(post.getStatus())) {
                throw new BizException("xn000000", "该帖已举报成功，正等待处理");
            }
            boolean result = this.isToMax(code, post.getPublisher(), reporter,
                type, reportNoteBuffer);
            if (result) {
                postBO.refreshPostReport(code, reportNoteBuffer.toString());
            }
        } else {
            type = ETalkType.PLJB.getCode();
            Comment comment = commentBO.getComment(code);
            if (comment == null) {
                throw new BizException("xn000000", "评论编号不存在");
            }
            if (EPostStatus.APPROVE_YES.getCode().equals(comment.getStatus())) {
                throw new BizException("xn000000", "该评论已审核通过，不能举报");
            }
            boolean result = this.isToMax(code, comment.getCommer(), reporter,
                type, reportNoteBuffer);
            if (result) {
                commentBO.refreshCommentReport(code,
                    reportNoteBuffer.toString());
            }
        }
        postTalkBO.savePostTalk(code, reporter, type, reportNote);
    }

    private boolean isToMax(String code, String publisher, String reporter,
            String type, StringBuffer reportNote) {
        boolean result = false;
        // 判断该用户是否已举报
        PostTalk condition = new PostTalk();
        condition.setPostCode(code);
        condition.setTalker(reporter);
        List<PostTalk> reporterList = postTalkBO.queryPostTalkList(condition);
        if (CollectionUtils.isNotEmpty(reporterList)) {
            throw new BizException("xn000000", "您已举报成功，无需再次举报");
        }
        List<PostTalk> reportList = postTalkBO.queryPostTalkSingleList(code,
            type);
        int maxTimes = ruleBO.getJBTimesByUserId(publisher).intValue();
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

    /** 
     * @see com.std.forum.ao.IPostTalkAO#queryPostTalkPage(int, int, com.std.forum.domain.PostTalk)
     */
    @Override
    public Paginable<PostTalk> queryPostTalkPage(int start, int limit,
            PostTalk condition) {
        return postTalkBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.std.forum.ao.IPostTalkAO#queryPostTalkList(com.std.forum.domain.Post)
     */
    @Override
    public List<PostTalk> queryPostTalkList(PostTalk condition) {
        return postTalkBO.queryPostTalkList(condition);
    }
}
