package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年10月16日 下午12:03:07 
 * @history:
 */
public enum EReaction {
    NORMAL("0", "正常"), SHIELD("1", "屏蔽"), APPROVE("2", "审核"), REFUSE("3", "拒绝");
    public static Map<String, EReaction> getBooleanResultMap() {
        Map<String, EReaction> map = new HashMap<String, EReaction>();
        for (EReaction status : EReaction.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EReaction(String code, String value) {
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
