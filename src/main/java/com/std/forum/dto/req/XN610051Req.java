package com.std.forum.dto.req;

public class XN610051Req {

    // 帖子编号（必填）
    private String code;

    // 用户ID（必填）
    private String userId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
