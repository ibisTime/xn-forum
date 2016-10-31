package com.std.forum.dto.req;

public class XN610900Req {
    // 用户编号(必填)
    private String userId;

    // 状态(选填)
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
