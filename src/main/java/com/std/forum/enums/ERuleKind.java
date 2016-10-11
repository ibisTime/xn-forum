/**
 * @Title EDirection.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午3:37:06 
 * @version V1.0   
 */
package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午3:37:06 
 * @history:
 */
public enum ERuleKind {
    JF("1", "积分项"), JB("2", "举报数");
    public static Map<String, ERuleKind> getDirectionMap() {
        Map<String, ERuleKind> map = new HashMap<String, ERuleKind>();
        for (ERuleKind direction : ERuleKind.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    ERuleKind(String code, String value) {
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
