package com.std.forum.dto.req;

/** 
 *  给自己喜欢的帖子点赞，收藏，取消已点赞，收藏的帖子
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:43:20 
 * @history:
 */
public class XN610056Req {

    // 类型（必填）
    private String type;

    // 帖子编号（必填）
    private String postCode;

    // 操作人编号（必填）
    private String talker;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTalker() {
        return talker;
    }

    public void setTalker(String talker) {
        this.talker = talker;
    }
}
