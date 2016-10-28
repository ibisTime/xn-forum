package com.std.forum.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.ICommentAO;
import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.IKeywordBO;
import com.std.forum.bo.ILevelRuleBO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;
import com.std.forum.domain.Keyword;
import com.std.forum.domain.Post;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.EDirection;
import com.std.forum.enums.EPostStatus;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.enums.EReaction;
import com.std.forum.enums.ERuleType;
import com.std.forum.exception.BizException;

@Service
public class CommentAOImpl implements ICommentAO {

    @Autowired
    private ICommentBO commentBO;

    @Autowired
    private IPostBO postBO;

    @Autowired
    private IKeywordBO keywordBO;

    @Autowired
    protected IRuleBO ruleBO;

    @Autowired
    protected ILevelRuleBO levelRuleBO;

    @Autowired
    protected IUserBO userBO;

    @Override
    @Transactional
    public String doComment(String content, String parentCode, String commer) {
        // 判断是否锁帖
        Post post = getPostByParentCode(parentCode);
        if (EBoolean.YES.getCode().equals(post.getIsLock())) {
            throw new BizException("xn000000", "该帖已被锁定，无法评论");
        }
        // 判断非法词汇,无则正常发布
        String status = EPostStatus.PUBLISHED.getCode();
        List<Keyword> keywordContentList = keywordBO.checkContent(content,
            EBoolean.NO.getCode(), EReaction.REFUSE);
        if (!CollectionUtils.sizeIsEmpty(keywordContentList)) {
            status = EPostStatus.FILTERED.getCode();
        }
        Post parentPost = getPostByParentCode(parentCode);
        String code = commentBO.saveComment(content, parentCode, status,
            commer, parentPost.getCode());
        // 评论加积分
        if (EPostStatus.PUBLISHED.getCode().equals(status)) {
            userBO.doTransfer(commer, EDirection.PLUS.getCode(),
                ERuleType.PL.getCode(), code);
        } else {
            code = code + ";filter:true";
        }
        return code;
    }

    private Post getPostByParentCode(String code) {
        Post post = null;
        String parentCode = code;
        while (true) {
            if (EPrefixCode.POST.getCode().equals(parentCode.substring(0, 2))) {
                post = postBO.getPost(parentCode);
                break;
            } else {
                Comment comment = commentBO.getComment(parentCode);
                parentCode = comment.getParentCode();
            }
        }
        return post;
    }

    @Override
    public Comment getComment(String code) {
        Comment comment = commentBO.getComment(code);
        getParentComment(comment);
        return comment;
    }

    @Override
    public List<Comment> queryCommentList(Comment condition) {
        return commentBO.queryCommentList(condition);
    }

    @Override
    public Paginable<Comment> queryCommentPage(int start, int limit,
            Comment condition) {
        Paginable<Comment> page = commentBO.getPaginable(start, limit,
            condition);
        List<Comment> list = page.getList();
        for (Comment comment : list) {
            getParentComment(comment);
        }
        return page;
    }

    private void getParentComment(Comment comment) {
        String parentCode = comment.getParentCode();
        if (EPrefixCode.POST.getCode().equals(parentCode.substring(0, 2))) {
            Post post = postBO.getPost(parentCode);
            comment.setPost(post);
        } else {
            Comment data = commentBO.getComment(parentCode);
            comment.setParentComment(data);
        }
    }

    /** 
     * @see com.std.forum.ao.ICommentAO#queryCommentMyPage(int, int, com.std.forum.domain.Comment)
     */
    @Override
    public Paginable<Comment> queryCommentMyPage(int start, int limit,
            Comment condition) {
        Paginable<Comment> page = commentBO.getPaginable(start, limit,
            condition);
        List<Comment> list = page.getList();
        for (Comment comment : list) {
            Comment cCondition = new Comment();
            cCondition.setParentCode(comment.getCode());
            List<Comment> nextCommentList = commentBO
                .queryCommentList(cCondition);
            comment.setNextCommentList(nextCommentList);
        }
        return page;
    }
}
