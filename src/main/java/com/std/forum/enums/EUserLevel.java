package com.std.forum.enums;

/**
 * 用户等级
 * @author: xieyj 
 * @since: 2016年5月24日 上午9:11:47 
 * @history:
 */
public enum EUserLevel {
    ZERO("0", "新手上路"), ONE("1", "小试牛刀"), TWO("2", "大牛"), THREE("3", "元老"), FOUR(
            "4", "骨灰级");

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
