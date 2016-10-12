package com.std.forum.dto.req;

/** 
 * 设置帖子为头条，置顶，精华等属性
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:41:57 
 * @history:
 */
public class XN610053Req {

    // 帖子编号（必填）
    private String code;

    // 是否头条（必填）
    private String isHeadline;

    // UI位置（必填）
    private String location;

    // 序号（选填）
    private String orderNo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsHeadline() {
        return isHeadline;
    }

    public void setIsHeadline(String isHeadline) {
        this.isHeadline = isHeadline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
