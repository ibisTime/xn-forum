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
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;
import com.std.forum.domain.Keyword;
import com.std.forum.domain.Post;
import com.std.forum.domain.PostTalk;
import com.std.forum.dto.res.XN805901Res;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.ELocation;
import com.std.forum.enums.EPostStatus;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.enums.ETalkType;
import com.std.forum.enums.EUserLevel;
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

    @Autowired
    protected IUserBO userBO;

    /** 
     * @see com.std.forum.ao.IPostAO#draftPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String draftPost(String title, String content, String pic,
            String plateCode, String publisher) {
        return postBO.savePost(title, content, pic, plateCode, publisher,
            EPostStatus.DRAFT.getCode());
    }

    /** 
     * @see com.std.forum.ao.IPostAO#publishPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void editPost(String code, String title, String content, String pic,
            String plateCode, String publisher) {
        postBO.refreshPost(code, title, content, pic, plateCode, publisher,
            EPostStatus.DRAFT.getCode());
    }

    /**
     * @see com.std.forum.ao.IPostAO#publishPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String publishPost(String title, String content, String pic,
            String plateCode, String publisher) {
        // 分类别遍历关键词
        Keyword condition = new Keyword();
        List<Keyword> kwList = keywordBO.queryKeywordList(condition);
        // 遍历关键词
        for (Keyword keyword : kwList) {
            // 若帖子标题与帖子内容包含关键词则抛出异常
            if (title.contains(keyword.getWord())) {
                throw new BizException("xn000000", "标题包含非法词汇");
            }
            if (content.contains(keyword.getWord())) {
                throw new BizException("xn000000", "内容包含非法词汇");
            }
        }
        String status = EPostStatus.PUBLISHED.getCode();
        XN805901Res res = userBO.getRemoteUser(publisher, publisher);
        String userLevel = res.getLevel();
        if (EUserLevel.ZERO.getCode().equals(userLevel)) {
            status = EPostStatus.todoAPPROVE.getCode();
        }
        // 发帖加积分
        return postBO.savePost(title, content, pic, plateCode, publisher,
            status);
    }

    public void publishPost(String code, String title, String content,
            String pic, String plateCode, String publisher) {
        String status = EPostStatus.PUBLISHED.getCode();
        XN805901Res res = userBO.getRemoteUser(publisher, publisher);
        String userLevel = res.getLevel();
        if (EUserLevel.ZERO.getCode().equals(userLevel)) {
            status = EPostStatus.todoAPPROVE.getCode();
        }
        // 发帖加积分
        postBO.refreshPost(code, title, content, pic, plateCode, publisher,
            status);
    }

    @Override
    public int removePostBySelf(String code, String userId) {
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
    public int removePost(String code) {
        return postBO.removePost(code);
    }

    @Override
    public int setPostLocation(String code, String isAdd, String location,
            String orderNo) {
        Post post = postBO.getPost(code);
        if (EBoolean.YES.getCode().equals(isAdd)) {
            if (ELocation.ZD.getCode().equals(post.getLocation())
                    && !location.equals(post.getLocation())) {
                location = ELocation.ZDJH.getCode();
            }
            if (ELocation.JH.getCode().equals(post.getLocation())
                    && !location.equals(post.getLocation())) {
                location = ELocation.ZDJH.getCode();
            }
        } else {
            if (location.equals(post.getLocation())) {
                location = "";
            }
            if (ELocation.ZDJH.getCode().equals(post.getLocation())) {
                if (ELocation.ZD.getCode().equals(location)) {
                    location = ELocation.JH.getCode();
                }
                if (ELocation.JH.getCode().equals(location)) {
                    location = ELocation.ZD.getCode();
                }
            }
        }
        return postBO.refreshPostLocation(code, location, orderNo);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#approvePost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int approvePost(String code, String status, String approver,
            String approveNote) {
        return postBO.refreshPostApprove(code, status, approver, approveNote);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#setPostHeadlines(java.lang.String, java.lang.String)
     */
    @Override
    public int setPostHeadlines(String code, String isHeadlines) {
        return postBO.refreshPostHeadlines(code, isHeadlines);
    }

    @Override
    public Paginable<Post> queryPostPage(int start, int limit, Post condition) {
        Paginable<Post> postPage = postBO.getPaginable(start, limit, condition);
        List<Post> postList = postPage.getList();
        for (Post post : postList) {
            this.getAllInfo(post, condition.getUserId());
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
        getAllInfo(post, userId);
        return post;
    }

    private void getAllInfo(Post post, String userId) {
        String code = post.getCode();
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
        List<PostTalk> likeList = postTalkBO.queryPostTalkSingleList(code,
            ETalkType.DZ.getCode());
        post.setLikeList(likeList);
        post.setTotalLikeNum(new Long(likeList.size()));
        // 获取评论
        List<Comment> commentList = new ArrayList<Comment>();
        searchCycleComment(post.getCode(), commentList);
        // 排序
        orderCommentList(commentList);
        post.setCommentList(commentList);
        post.setTotalCommNum(new Long(commentList.size()));
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

    /** 
     * @see com.std.forum.ao.IPostAO#reportPost(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void reportPost(String code, String reporter, String reportNote) {
        postTalkBO.savePostTalk(code, reporter, ETalkType.JB.getCode(),
            reportNote);
    }

    /** 
     * @see com.std.forum.ao.IPostAO#readPost(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void readPost(String code, String reader) {
        postTalkBO.savePostTalk(code, reader, ETalkType.YD.getCode(),
            ETalkType.YD.getValue());
    }

    @Override
    public Post getPostByCommentCode(String commentCode, String userId) {
        Post post = null;
        Comment comment = commentBO.getComment(commentCode);
        while (true) {
            String parentCode = comment.getParentCode();
            if (EPrefixCode.POST.getCode().equals(parentCode.substring(0, 2))) {
                post = postBO.getPost(parentCode);
                getAllInfo(post, userId);
                break;
            } else {
                comment = commentBO.getComment(parentCode);
                commentCode = comment.getCode();
            }
        }
        return post;
    }
}
