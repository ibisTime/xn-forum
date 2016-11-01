/**
 * @Title Comment.java 
 * @Package com.std.forum.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午8:27:47 
 * @version V1.0   
 */
package com.std.forum.domain;

import java.util.Date;
import java.util.List;

import com.std.forum.dao.base.ABaseDO;

/** 
 * 评论
 * @author: xieyj 
 * @since: 2016年8月28日 下午8:27:47 
 * @history:
 */
public class Comment extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 内容
    private String content;

    // 上级编号
    private String parentCode;

    // 状态
    private String status;

    // 操作人
    private String commer;

    // 操作时间
    private Date commDatetime;

    // 审核人
    private String approver;

    // 审核时间
    private Date approveDatetime;

    // 审核说明
    private String approveNote;

    // 备注
    private String remark;

    // 帖子编号
    private String postCode;

    // ****************db properties ***************
    private String parentCommer;

    // 昵称
    private String nickname;

    // 登录名
    private String loginName;

    // 父级昵称
    private String parentNickname;

    // 评论帖子
    private Post post;

    // 针对评论
    private Comment parentComment;

    // 被评论
    private List<Comment> nextCommentList;

    // 所属站点
    private String siteCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCommer() {
        return commer;
    }

    public void setCommer(String commer) {
        this.commer = commer;
    }

    public Date getCommDatetime() {
        return commDatetime;
    }

    public void setCommDatetime(Date commDatetime) {
        this.commDatetime = commDatetime;
    }

    public String getParentCommer() {
        return parentCommer;
    }

    public void setParentCommer(String parentCommer) {
        this.parentCommer = parentCommer;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getParentNickname() {
        return parentNickname;
    }

    public void setParentNickname(String parentNickname) {
        this.parentNickname = parentNickname;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public List<Comment> getNextCommentList() {
        return nextCommentList;
    }

    public void setNextCommentList(List<Comment> nextCommentList) {
        this.nextCommentList = nextCommentList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
