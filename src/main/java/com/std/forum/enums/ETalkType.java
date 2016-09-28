package com.std.forum.enums;

/** 
 * @author: xieyj 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum ETalkType {
    DZ("1", "点赞"), SC("2", "收藏"), DS("3", "打赏"), JB("4", "举报");

    ETalkType(String code, String value) {
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
