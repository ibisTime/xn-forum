package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

public enum EBelong {
    GLOBAL("1", "全局"), LOCAL("2", "地方");
    public static Map<String, EBelong> getBelongMap() {
        Map<String, EBelong> map = new HashMap<String, EBelong>();
        for (EBelong status : EBelong.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EBelong(String code, String value) {
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
