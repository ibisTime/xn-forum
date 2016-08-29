package com.std.forum.enums;

/** 
 * @author: xieyj 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum EPostStatus {
    todoAPPROVE("1", "待审批"), APPROVE_NO("2", "审批不通过"), APPROVE_YES("3",
            "已审批-待支付"), PUBLISHED("3", "已发布");

    EPostStatus(String code, String value) {
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
