package com.std.forum.dto.req;

public class XN610047Reqt {

    // 帖子编号（必填）
    private String code;

    // 用户编号(必填)
    private String userId;

    // 类型(必填)
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
