/**
 * @Title EUser.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午3:08:34 
 * @version V1.0   
 */
package com.std.user.enums;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午3:08:34 
 * @history:
 */
public enum EUser {
    // li表示程序
    LI("li", "程序");

    EUser(String code, String value) {
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
