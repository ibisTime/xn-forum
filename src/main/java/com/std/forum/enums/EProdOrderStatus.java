package com.std.forum.enums;

/** 
 * @author: xieyj 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum EProdOrderStatus {
    PAYED("1", "已支付"), TAKE_YES("2", "已取货"), TAKE_NO("3", "作废");

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
