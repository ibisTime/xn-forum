package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年10月23日 下午6:58:18 
 * @history:
 */
public enum EPostType {
    TZ("1", "帖子"), PL("2", "评论");
    public static Map<String, EPostType> getEPostTypeResultMap() {
        Map<String, EPostType> map = new HashMap<String, EPostType>();
        for (EPostType status : EPostType.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EPostType(String code, String value) {
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
