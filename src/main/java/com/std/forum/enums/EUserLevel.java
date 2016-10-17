package com.std.forum.enums;

/**
 * 用户等级
 * @author: xieyj 
 * @since: 2016年5月24日 上午9:11:47 
 * @history:
 */
public enum EUserLevel {
    ONE("1", "新手上路"), TWO("2", "初级会员"), THREE("3", "中级会员"), FOUR("4", "高级会员"), FIVE(
            "5", "金牌会员"), SIX("6", "论坛元老");

    EUserLevel(String code, String value) {
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
