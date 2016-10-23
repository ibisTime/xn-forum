package com.std.forum.dto.req;

/**
 * 设置/取消帖子为置顶，精华，头条等属性
 * @author: xieyj 
 * @since: 2016年10月13日 下午3:28:37 
 * @history:
 */
public class XN610049Req {

    // 帖子编号（必填）
    private String code;

    // 是否增加(1 是 0 否) 否取消
    private String isAdd;

    // UI位置（必填）
    private String location;

    // 有效截止时间
    private String endDatetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(String isAdd) {
        this.isAdd = isAdd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }
}
