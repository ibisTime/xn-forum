/**
 * @Title EOppositeSystem.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午4:41:13 
 * @version V1.0   
 */
package com.std.user.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午4:41:13 
 * @history:
 */
public enum EOppositeSystem {
    XN_P2P("1", "XN_P2P"), XN_CPZC("2", "XN_CPZC");
    public static Map<String, EOppositeSystem> getOppositeSystemMap() {
        Map<String, EOppositeSystem> map = new HashMap<String, EOppositeSystem>();
        for (EOppositeSystem os : EOppositeSystem.values()) {
            map.put(os.getCode(), os);
        }
        return map;
    }

    EOppositeSystem(String code, String value) {
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
