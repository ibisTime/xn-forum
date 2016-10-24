package com.std.forum.dto.req;

public class XN805301Req {
    // from用户(必填)
    private String fromUser;

    // to用户(必填)
    private String toUser;

    // 金额(必填)
    private String amount;

    // 备注(选填)
    private String remark;

    // 参考号(选填)
    private String refNo;

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
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
