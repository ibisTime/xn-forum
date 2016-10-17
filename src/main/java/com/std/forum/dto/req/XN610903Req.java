package com.std.forum.dto.req;

/**
 * 签到
 * @author: xieyj 
 * @since: 2016年10月14日 下午8:01:38 
 * @history:
 */
public class XN610903Req {
    // 用户编号(必填)
    private String userId;

    // 位置(必填)
    private String location;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
