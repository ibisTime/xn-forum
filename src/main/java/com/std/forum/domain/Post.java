/**
 * @Title Post.java 
 * @Package com.std.forum.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午8:23:00 
 * @version V1.0   
 */
package com.std.forum.domain;

import java.util.Date;
import java.util.List;

import com.std.forum.dao.base.ABaseDO;

/** 
 * 帖子
 * @author: xieyj 
 * @since: 2016年8月28日 下午8:23:00 
 * @history:
 */
public class Post extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 标题
    private String title;

    // 内容
    private String content;

    // 图片
    private String pic;

    // 发布人
    private String publisher;

    // 发布时间
    private Date publishDatetime;

    // 审核人
    private String approver;

    // 审核时间
    private Date approveDatetime;

    // 审核说明
    private String approveNote;

    // 是否举报
    private String isReport;

    // 举报人
    private String reporter;

    // 举报时间
    private Date reportDatetime;

    // 举报说明
    private String reportNote;

    // 状态(0 待审核 1 审核通过 2 审核不通过 3 已发布)
    private String status;

    // 是否头条
    private String isHeadline;

    // 是否置顶
    private String isTop;

    // 是否精华
    private String isEssence;

    // 阅读次数
    private Integer readTime;

    // 板块编号
    private String plateCode;

    // *****************db properties ********************
    // 昵称
    private String nickname;

    // 照片
    private String photo;

    // 发布时间起
    private Date publishDatetimeStart;

    // 发布时间止
    private Date publishDatetimeEnd;

    // 用户编号
    private String userId;

    // 用户类型
    private String type;

    // 该帖子被点赞数
    private Long totalDzNum;

    // 该帖子被评论数
    private Long totalCommNum;

    // 点赞
    private List<PostTalk> postTalkList;

    // 评论
    private List<Comment> commentList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(Date publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getApproveDatetime() {
        return approveDatetime;
    }

    public void setApproveDatetime(Date approveDatetime) {
        this.approveDatetime = approveDatetime;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getIsReport() {
        return isReport;
    }

    public void setIsReport(String isReport) {
        this.isReport = isReport;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Date getReportDatetime() {
        return reportDatetime;
    }

    public void setReportDatetime(Date reportDatetime) {
        this.reportDatetime = reportDatetime;
    }

    public String getReportNote() {
        return reportNote;
    }

    public void setReportNote(String reportNote) {
        this.reportNote = reportNote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsHeadline() {
        return isHeadline;
    }

    public void setIsHeadline(String isHeadline) {
        this.isHeadline = isHeadline;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getIsEssence() {
        return isEssence;
    }

    public void setIsEssence(String isEssence) {
        this.isEssence = isEssence;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public Date getPublishDatetimeStart() {
        return publishDatetimeStart;
    }

    public void setPublishDatetimeStart(Date publishDatetimeStart) {
        this.publishDatetimeStart = publishDatetimeStart;
    }

    public Date getPublishDatetimeEnd() {
        return publishDatetimeEnd;
    }

    public void setPublishDatetimeEnd(Date publishDatetimeEnd) {
        this.publishDatetimeEnd = publishDatetimeEnd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getTotalDzNum() {
        return totalDzNum;
    }

    public void setTotalDzNum(Long totalDzNum) {
        this.totalDzNum = totalDzNum;
    }

    public Long getTotalCommNum() {
        return totalCommNum;
    }

    public void setTotalCommNum(Long totalCommNum) {
        this.totalCommNum = totalCommNum;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<PostTalk> getPostTalkList() {
        return postTalkList;
    }

    public void setPostTalkList(List<PostTalk> postTalkList) {
        this.postTalkList = postTalkList;
    }
}
