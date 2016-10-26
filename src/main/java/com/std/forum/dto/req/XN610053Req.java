package com.std.forum.dto.req;

public class XN610053Req {

    // 类型（必填）
    private String type;

    // 帖子编号（必填）
    private String postCode;

    // 操作人编号（必填）
    private String userId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
