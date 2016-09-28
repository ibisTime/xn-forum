package com.std.forum.dto.req;

/** 
 * 我收藏的帖子分页查询
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:46:16 
 * @history:
 */
public class XN610073Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 用户编号 （必填）
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
