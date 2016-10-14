package com.std.forum.dto.req;

/**
 * 设置/取消帖子头条
 * @author: xieyj 
 * @since: 2016年10月13日 下午3:28:37 
 * @history:
 */
public class XN610064Req {

    // 帖子编号（必填）
    private String code;

    // 是否头条(1 是 0 否)
    private String isHeadlines;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsHeadlines() {
        return isHeadlines;
    }

    public void setIsHeadlines(String isHeadlines) {
        this.isHeadlines = isHeadlines;
    }

}
