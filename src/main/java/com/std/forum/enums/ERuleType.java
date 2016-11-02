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
    ZC("A", "注册"), MRQD("B", "每日签到"), SCTX("C1", "上传头像"), ZLWS("C2", "资料完善"), FT(
            "D", "发布帖子"), PL("E", "发布评论"), JH("F", "设置精华帖"), TZWG("G", "帖子违规"), PLWG(
            "H", "评论违规");
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
