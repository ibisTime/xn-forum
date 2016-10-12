package com.std.forum.dto.req;

public class XN805300Req {
    // 用户编号(必填)
    private String userId;

    // 方向(必填)
    private String direction;

    // 金额(必填)
    private String amount;

    // 备注(选填)
    private String remark;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

}
