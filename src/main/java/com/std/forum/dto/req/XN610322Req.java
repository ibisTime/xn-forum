package com.std.forum.dto.req;

public class XN610322Req {

    // 订单编号（必填）
    private String orderCode;

    // 提货说明（必填）
    private String takeNote;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getTakeNote() {
        return takeNote;
    }

    public void setTakeNote(String takeNote) {
        this.takeNote = takeNote;
    }
}
