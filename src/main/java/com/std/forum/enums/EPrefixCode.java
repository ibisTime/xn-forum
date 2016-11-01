package com.std.forum.enums;

/** 
 * 编号前缀
 * @author: xieyj 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum EPrefixCode {
    SITE("ZD", "站点"), PLATE("BK", "版块"), POST("TZ", "帖子"), POSTTALK("JL", "交流"), COMMENT(
            "PL", "评论"), KEYWORD("GJ", "关键字"), NAVIGATE("DH", "导航"), RULE("GZ",
            "规则"), PRODUCT("CP", "产品"), PRODORDER("DD", "产品订单");

    EPrefixCode(String code, String value) {
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
