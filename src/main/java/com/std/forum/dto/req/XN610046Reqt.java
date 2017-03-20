package com.std.forum.dto.req;

public class XN610046Reqt {

    // 帖子/评论编号（必填）
    private String code;

    // 类型(必填)
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
