package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

public enum ECategoryType {
    PLATE("1", "版块"), MALL("2", "商城");
    public static Map<String, ECategoryType> getBooleanResultMap() {
        Map<String, ECategoryType> map = new HashMap<String, ECategoryType>();
        for (ECategoryType status : ECategoryType.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ECategoryType(String code, String value) {
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
