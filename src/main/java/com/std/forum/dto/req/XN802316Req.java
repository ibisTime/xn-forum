package com.std.forum.dto.req;

public class XN802316Req {
    // 来方账号
    private String fromUserId;

    // 账号
    private String toUserId;

    // 方向：1=转入；0=转出
    private String direction;

    // 金额（精确到厘）
    private String amount;

    // 手续费（精确到厘）
    private String fee;

    // 备注
    private String remark;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
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

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
