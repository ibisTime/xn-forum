package com.std.forum.dto.req;

public class XN805302Req {
    // 用户编号(必填)
    private String userId;

    // 方向(必填)
    private String direction;

    // 类型(必填)
    private String ruleType;

    // 参考号(选填)
    private String refNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }
}
