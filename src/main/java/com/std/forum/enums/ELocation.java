/**
 * @Title ECheckResult.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午2:58:54 
 * @version V1.0   
 */
package com.std.forum.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午2:58:54 
 * @history:
 */
public enum ELocation {
    ZD("1", "置顶"), JH("2", "精华"), ZDJH("3", "置顶+精华");
    public static Map<String, ELocation> getBooleanResultMap() {
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
