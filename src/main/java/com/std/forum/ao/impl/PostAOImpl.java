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
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.IPostAO;
import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.IKeywordBO;
import com.std.forum.bo.ILevelRuleBO;
import com.std.forum.bo.IPlateBO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;
import com.std.forum.domain.Keyword;
import com.std.forum.domain.LevelRule;
import com.std.forum.domain.Plate;
import com.std.forum.domain.Post;
import com.std.forum.domain.PostTalk;
import com.std.forum.dto.res.XN610900Res;
import com.std.forum.dto.res.XN805901Res;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.EDirection;
import com.std.forum.enums.ELocation;
import com.std.forum.enums.EPostStatus;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.enums.EReaction;
import com.std.forum.enums.EReportType;
import com.std.forum.enums.ERuleType;
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
    protected IPlateBO plateBO;

    @Autowired
    protected IPostTalkBO postTalkBO;

    @Autowired
    protected ICommentBO commentBO;

    @Autowired
    protected IKeywordBO keywordBO;

    @Autowired
    protected IUserBO userBO;

    @Autowired
    protected IRuleBO ruleBO;

    @Autowired
    protected ILevelRuleBO levelRuleBO;

    // 判断是否发帖
    // 1、发帖，内容过滤，等级判断是否审核
    // 2、草稿保存
    @Override
    @Transactional
    public String publishPost(String title, String content, String pic,
            String plateCode, String publisher, String isPublish) {
        String code = null;
        if (EBoolean.NO.getCode().equals(isPublish)) {
            code = postBO.savePost(title, content, pic, plateCode, publisher,
                EPostStatus.DRAFT.getCode());
        } else {
            String status = null;
            XN805901Res res = userBO.getRemoteUser(publisher, publisher);
            String userLevel = res.getLevel();
            // 对标题和内容进行关键字过滤
            List<Keyword> keywordTitleList = keywordBO.checkContent(title,
                userLevel, EReaction.REFUSE);
            List<Keyword> keywordContentList = keywordBO.checkContent(content,
                userLevel, EReaction.REFUSE);
            if (CollectionUtils.isNotEmpty(keywordTitleList)
                    || CollectionUtils.isNotEmpty(keywordContentList)) {
                status = EPostStatus.FILTERED.getCode();
                // 告知前端被过滤了
            } else {
                // 判断用户等级，是否审核
                LevelRule levelRule = levelRuleBO.getLevelRule(res.getLevel());
                if (EBoolean.YES.getCode().equals(levelRule.getEffect())) {
                    status = EPostStatus.todoAPPROVE.getCode();
                } else {
                    status = EPostStatus.PUBLISHED.getCode();
                }
                code = postBO.savePost(title, content, pic, plateCode,
                    publisher, status);
                // 发帖加积分
                if (EPostStatus.PUBLISHED.getCode().equals(status)) {
                    userBO.doTransfer(publisher, EDirection.PLUS.getCode(),
                        ERuleType.FT.getCode(), code);
                }
            }
        }
        return code;
    }

    @Override
    @Transactional
    public void draftPublishPost(String code, String title, String content,
            String pic, String plateCode, String publisher, String isPublish) {
        if (EBoolean.NO.getCode().equals(isPublish)) {
            postBO.refreshPost(code, title, content, pic, plateCode, publisher,
                EPostStatus.DRAFT.getCode());
        } else {
            String status = null;
            XN805901Res res = userBO.getRemoteUser(publisher, publisher);
            String userLevel = res.getLevel();
            // 对标题和内容进行关键字过滤
            List<Keyword> keywordTitleList = keywordBO.checkContent(title,
                userLevel, EReaction.REFUSE);
            List<Keyword> keywordContentList = keywordBO.checkContent(content,
                userLevel, EReaction.REFUSE);
            if (CollectionUtils.isNotEmpty(keywordTitleList)
                    || CollectionUtils.isNotEmpty(keywordContentList)) {
                status = EPostStatus.FILTERED.getCode();
                // 告知前端被过滤了
            } else {
                // 判断用户等级，是否审核
                LevelRule levelRule = levelRuleBO.getLevelRule(res.getLevel());
                if (EBoolean.YES.getCode().equals(levelRule.getEffect())) {
                    status = EPostStatus.todoAPPROVE.getCode();
                } else {
                    status = EPostStatus.PUBLISHED.getCode();
                    // 发帖加积分
                    userBO.doTransfer(publisher, EDirection.PLUS.getCode(),
                        ERuleType.FT.getCode(), code);
                }
            }
            postBO.refreshPost(code, title, content, pic, plateCode, publisher,
                status);
        }
    }

    @Override
    public void removePostBySelf(String code, String userId) {
        Post data = postBO.getPost(code);
        if (data.getPublisher().equals(userId)) {
            postBO.removePost(code);
        } else {
            throw new BizException("xn000000", "只能删除自己发布的帖子");
        }
    }

    @Override
    public void removePost(String code) {
        postBO.removePost(code);
    }

    @Override
    public void setPostLocation(String code, String isAdd, String location,
            Date endDatetime) {
        Post post = postBO.getPost(code);
        String postLocation = post.getLocation();
        if (EBoolean.YES.getCode().equals(isAdd)) {
            if (postLocation != null) {
                if (postLocation.contains(location)) {
                    throw new BizException("xn000000", "该帖子已是"
                            + ELocation.getLocationResultMap().get(location)
                                .getValue() + "帖子");
                }
                postLocation = postLocation + location;
            } else {
                postLocation = location;
            }
        } else {
            if (postLocation != null) {
                int indexLocation = postLocation.indexOf(location);
                if (indexLocation < 0) {
                    throw new BizException("xn000000", "该帖子不是"
                            + ELocation.getLocationResultMap().get(location)
                                .getValue() + "帖子，无法取消");
                }
                postLocation = postLocation.replaceAll(location, "");
            }
        }
        postBO.refreshPostLocation(code, postLocation, endDatetime);
        // 设置精华加积分
        if (EBoolean.YES.getCode().equals(isAdd)
                && ELocation.JH.getCode().equals(location)) {
            userBO.doTransfer(post.getPublisher(), EDirection.PLUS.getCode(),
                ERuleType.JH.getCode(), code);
        }
    }

    /** 
     * @see com.std.forum.ao.IPostAO#approvePost(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void approvePost(String code, String approver, String approveResult,
            String approveNote, String type) {
        if (EReportType.TZ.getCode().equals(type)) {
            Post post = postBO.getPost(code);
            if (!EPostStatus.todoAPPROVE.getCode().equals(post.getStatus())
                    && !EPostStatus.toReportAPPROVE.getCode().equals(
                        post.getStatus())) {
                throw new BizException("xn000000", "帖子状态不是待审核状态");
            }
            postBO.refreshPostApprove(code, approveResult, approver,
                approveNote);
            // 审核通过加积分
            if (EPostStatus.todoAPPROVE.getCode().equals(post.getStatus())
                    && EBoolean.YES.getCode().equals(approveResult)) {
                userBO.doTransfer(post.getPublisher(),
                    EDirection.PLUS.getCode(), ERuleType.FT.getCode(), code);
            }
        } else if (EReportType.PL.getCode().equals(type)) {
            type = ETalkType.PLJB.getCode();
        }
    }

    /** 
     * @see com.std.forum.ao.IPostAO#setPostHeadlines(java.lang.String, java.lang.String)
     */
    @Override
    public void setPostLock(String code) {
        Post post = postBO.getPost(code);
        if (EBoolean.YES.getCode().equals(post.getIsLock())) {
            postBO.refreshPostLock(code, EBoolean.NO.getCode());
        } else {
            postBO.refreshPostLock(code, EBoolean.YES.getCode());
        }
    }

    @Override
    public void editPostPlate(String code, String plateCode) {
        postBO.getPost(code);
        Plate plate = plateBO.getPlate(plateCode);
        if (EBoolean.NO.getCode().equals(plate.getStatus())) {
            throw new BizException("xn000000", "该版本状态为未启用");
        }
        postBO.refreshPostPlate(code, plateCode);
    }

    @Override
    public Paginable<Post> queryPostPage(int start, int limit, Post condition) {
        Paginable<Post> postPage = postBO.getPaginable(start, limit, condition);
        List<Post> postList = postPage.getList();
        for (Post post : postList) {
            cutPic(post);
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
        cutPic(post);
        getAllInfo(post, userId);
        return post;
    }

    private void cutPic(Post post) {
        String pic = post.getPic();
        if (StringUtils.isNotBlank(pic)) {
            String[] picArr = pic.split("\\|\\|");
            post.setPicArr(picArr);
            post.setPic(null);
        }
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
        Paginable<Post> postPage = postBO.getPaginable(start, limit, condition);
        List<Post> postList = postPage.getList();
        for (Post post : postList) {
            cutPic(post);
            this.getAllInfo(post, condition.getUserId());
        }
        return postPage;
    }

    @Override
    public List<Post> querySCPostList(String talker) {
        Post condition = new Post();
        condition.setType(ETalkType.SC.getCode());
        condition.setTalker(talker);
        List<Post> postList = postBO.queryPostList(condition);
        for (Post post : postList) {
            cutPic(post);
            this.getAllInfo(post, talker);
        }
        return postList;
    }

    /** 
     * @see com.std.forum.ao.IPostAO#reportPost(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void reportPost(String code, String reporter, String reportNote,
            String type) {
        // 判断是否达到举报条数，更新帖子或评论状态待审核
        if (EReportType.TZ.getCode().equals(type)) {
            type = ETalkType.TZJB.getCode();
        } else if (EReportType.PL.getCode().equals(type)) {
            type = ETalkType.PLJB.getCode();
        }
        postTalkBO.savePostTalk(code, reporter, type, reportNote);
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

    /** 
     * @see com.std.forum.ao.IPostAO#totalPostNum(java.lang.String)
     */
    @Override
    public XN610900Res totalPostNum(String userId) {
        XN610900Res res = new XN610900Res();
        Post condition = new Post();
        condition.setPublisher(userId);
        Long totalPostNum = postBO.getTotalCount(condition);
        res.setTotalPostNum(totalPostNum);
        return res;
    }
}
