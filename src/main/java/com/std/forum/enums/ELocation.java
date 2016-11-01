package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年10月23日 下午7:50:12 
 * @history:
 */
public enum ELocation {
    ZD("A", "置顶"), JH("B", "精华"), TT("C", "头条"), ALL("D", "所有");
    public static Map<String, ELocation> getLocationResultMap() {
        Map<String, ELocation> map = new HashMap<String, ELocation>();
        for (ELocation status : ELocation.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    ELocation(String code, String value) {
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
