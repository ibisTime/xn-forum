package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: xieyj 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum ETalkType {
    DZ("1", "点赞"), SC("2", "收藏"), DS("3", "打赏"), YD("4", "阅读"), TZJB("5",
            "帖子举报"), PLJB("6", "评论举报");

    public static Map<String, ETalkType> getTalkTypeMap() {
        Map<String, ETalkType> map = new HashMap<String, ETalkType>();
        for (ETalkType talkType : ETalkType.values()) {
            map.put(talkType.getCode(), talkType);
        }
        return map;
    }

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
