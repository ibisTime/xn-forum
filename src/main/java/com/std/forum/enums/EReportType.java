package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年10月23日 下午6:58:18 
 * @history:
 */
public enum EReportType {
    TZ("1", "帖子"), PL("2", "评论");
    public static Map<String, EReportType> getReportTypeResultMap() {
        Map<String, EReportType> map = new HashMap<String, EReportType>();
        for (EReportType status : EReportType.values()) {
            map.put(status.getCode(), status);
        }
        return map;
    }

    EReportType(String code, String value) {
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
