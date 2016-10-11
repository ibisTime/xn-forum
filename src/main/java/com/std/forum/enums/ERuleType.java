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
public enum ERuleType {
    ZC("A", "注册送积分"), QD("B", "每日签到"), ZLWS("C", "资料完善"), FT("D", "发帖"), PL(
            "E", "评论"), JH("F", "加精华"), JB("G", "举报");
    public static Map<String, ERuleType> getDirectionMap() {
        Map<String, ERuleType> map = new HashMap<String, ERuleType>();
        for (ERuleType direction : ERuleType.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    ERuleType(String code, String value) {
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
