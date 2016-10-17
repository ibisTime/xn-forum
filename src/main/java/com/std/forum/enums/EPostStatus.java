package com.std.forum.enums;

/** 
 * @author: xieyj 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum EPostStatus {
    DRAFT("-1", "草稿"), todoAPPROVE("0", "待审批"), APPROVE_NO("1", "审批通过"), APPROVE_YES(
            "2", "审批不通过"), PUBLISHED("3", "已发布");

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
