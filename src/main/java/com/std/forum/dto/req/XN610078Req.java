package com.std.forum.dto.req;

public class XN610078Req {

    // 评论编号（必填）
    private String commentCode;

    // 用户编号（选填）
    private String userId;

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
