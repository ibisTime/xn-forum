package com.std.forum.dto.req;

public class XN610073Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 用户编号 （必填）
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
