package com.std.forum.dto.req;

import java.util.List;

public class XN610048Reqt {

    // 帖子编号（必填）
    private List<String> codeList;

    // 用户编号(必填)
    private String userId;

    // 类型(必填)
    private String type;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
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
