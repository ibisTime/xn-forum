package com.std.forum.dto.req;

public class XN610072Req {

    // 帖子编号 （必填）
    private String code;

    // 当前用户编号 （必填）
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
