/**
 * @Title PostAOImpl.java 
 * @Package com.std.forum.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午7:52:36 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IPostAO;
import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.IKeywordBO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;
import com.std.forum.domain.Keyword;
import com.std.forum.domain.Post;
import com.std.forum.domain.PostTalk;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.EPostStatus;
import com.std.forum.enums.ETalkType;
import com.std.forum.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午7:52:36 
 * @history:
 */
@Service
public class PostAOImpl implements IPostAO {
    @Autowired
    protected IPostBO postBO;

    @Autowired
    protected IPostTalkBO postTalkBO;

    @Autowired
    protected ICommentBO commentBO;

    @Autowired
    protected IKeywordBO keywordBO;

    /** 
     * @see com.std.forum.ao.IPostAO#publishPost(com.std.forum.domain.Post)
     */
    @Override
    public String publishPost(Post data) {
        // 关键词过滤
        // 先将关键词导出
        Keyword condition = new Keyword();
        List<Keyword> kwList = keywordBO.queryKeywordList(condition);
        // 遍历关键词
        for (Keyword keyword : kwList) {
            // 若帖子标题与帖子内容包含关键词则抛出异常
            if (data.getTitle().contains(keyword.getWord())) {
                throw new BizException("xn000000", "标题包含非法词汇");
            }
            if (data.getContent().contains(keyword.getWord())) {
                throw new BizException("xn000000", "内容包含非法词汇");
            }
        }
        // 将帖子状态默认为已发布
        data.setStatus(EPostStatus.PUBLISHED.getCode());
        return postBO.savePost(data);
    }

    @Override
    public int removePostByPU(String code, String userId) {
        int count = 0;
        Post data = postBO.getPost(code);
        if (data.getPublisher().equals(userId)) {
            count = postBO.removePost(code);
        } else {
            throw new BizException("xn000000", "只能删除自己发布的帖子");
        }
        return count;
    }

    @Override
    public int removePostByGL(String code) {
        return postBO.removePost(code);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#approvePost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int approvePost(Post data) {
        return postBO.refreshPostApprove(data);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#reportPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int reportPost(Post data) {
        return postBO.refreshPostReport(data);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#setUpPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int setUpPost(Post data) {
        return postBO.refreshPostAttr(data);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#addReadTime(java.lang.String)
     */
    @Override
    public int addReadTime(String code) {
        return postBO.refreshPostReadTime(code);
    }

    @Override
    public Paginable<Post> queryPostPage(int start, int limit, Post condition) {
        Paginable<Post> postPage = postBO.getPaginable(start, limit, condition);
        List<Post> postList = postPage.getList();
        for (Post post : postList) {
            // 设置查询点赞记录条件
            post.setIsDZ(EBoolean.NO.getCode());
            post.setIsSC(EBoolean.NO.getCode());
            if (StringUtils.isNotBlank(condition.getUserId())) {
                PostTalk dzPostTalk = postTalkBO.getPostTalkByCondition(
                    post.getCode(), condition.getUserId(),
                    ETalkType.DZ.getCode());
                if (null != dzPostTalk) {
                    post.setIsDZ(EBoolean.YES.getCode());
                }
                PostTalk scPostTalk = postTalkBO.getPostTalkByCondition(
                    post.getCode(), condition.getUserId(),
                    ETalkType.SC.getCode());
                if (null != scPostTalk) {
                    post.setIsSC(EBoolean.YES.getCode());
                }
            }
            // 获取评论数
            List<Comment> commentList = new ArrayList<Comment>();
            searchCycleComment(post.getCode(), commentList);
            post.setTotalCommNum(new Long(commentList.size()));
        }
        return postPage;
    }

    @Override
    public List<Post> queryPostList(Post condition) {
        return postBO.queryPostList(condition);
    }

    @Override
    public Post getPost(String code, String userId) {
        Post post = postBO.getPost(code);
        if (post != null) {
            // 设置查询点赞记录条件
            post.setIsDZ(EBoolean.NO.getCode());
            post.setIsSC(EBoolean.NO.getCode());
            if (StringUtils.isNotBlank(userId)) {
                PostTalk dzPostTalk = postTalkBO.getPostTalkByCondition(code,
                    userId, ETalkType.DZ.getCode());
                if (null != dzPostTalk) {
                    post.setIsDZ(EBoolean.YES.getCode());
                }
                PostTalk scPostTalk = postTalkBO.getPostTalkByCondition(code,
                    userId, ETalkType.SC.getCode());
                if (null != scPostTalk) {
                    post.setIsSC(EBoolean.YES.getCode());
                }
            }
            // 获取点赞
            List<PostTalk> postTalkList = postTalkBO.queryPostTalkSingleList(
                code, ETalkType.DZ.getCode());
            post.setPostTalkList(postTalkList);
            // 获取评论
            List<Comment> commentList = new ArrayList<Comment>();
            searchCycleComment(post.getCode(), commentList);
            // 排序
            orderCommentList(commentList);
            post.setCommentList(commentList);
            post.setTotalCommNum(new Long(commentList.size()));
        }
        return post;
    }

    private void searchCycleComment(String parentCode, List<Comment> list) {
        Comment condition = new Comment();
        condition.setParentCode(parentCode);
        List<Comment> nextList = commentBO.queryCommentList(condition);
        if (CollectionUtils.isNotEmpty(nextList)) {
            list.addAll(nextList);
            for (int i = 0; i < nextList.size(); i++) {
                searchCycleComment(nextList.get(i).getCode(), list);
            }
        }
    }

    private void orderCommentList(List<Comment> commentList) {
        for (int i = 0; i < commentList.size(); i++) {
            for (int j = i + 1; j < commentList.size(); j++) {
                if (commentList.get(i).getCommDatetime().getTime() > commentList
                    .get(j).getCommDatetime().getTime()) {
                    Comment temp = new Comment();
                    temp = commentList.get(i);
                    commentList.set(i, commentList.get(j));
                    commentList.set(j, temp);
                }
            }
        }
    }

    @Override
    public Paginable<Post> querySCPostPage(int start, int limit, Post condition) {
        condition.setType(ETalkType.SC.getCode());
        return postBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Post> querySCPostList(String talker) {
        Post condition = new Post();
        condition.setType(ETalkType.SC.getCode());
        condition.setTalker(talker);
        return postBO.queryPostList(condition);
    }
}
