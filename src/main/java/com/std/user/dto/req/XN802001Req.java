package com.std.user.dto.req;

public class XN802001Req {

    // userid（必填）
    private String userId;

    // 真实姓名（必填）
    private String realName;

    // 币种（必填）
    private String currency;

    // 金额（必填）
    private String amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
