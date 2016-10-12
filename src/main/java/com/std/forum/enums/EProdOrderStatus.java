package com.std.forum.enums;

/** 
 * @author: xieyj 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum EProdOrderStatus {
    todoPAY("0", "待支付"), PAY_YES("1", "已支付"), todoPICK("2", "待取货"), PICK_YES(
            "3", "已取货");

    EProdOrderStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
