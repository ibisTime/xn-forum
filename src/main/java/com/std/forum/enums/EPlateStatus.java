package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

public enum EPlateStatus {
    ENABLE("1", "启用"), UNENABLE("0", "禁用");
    public static Map<String, EPlateStatus> getBooleanResultMap() {
        Map<String, EPlateStatus> map = new HashMap<String, EPlateStatus>();
        for (EPlateStatus status : EPlateStatus.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EPlateStatus(String code, String value) {
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
