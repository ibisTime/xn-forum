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

    // 是否置顶（必填）
    private String isTop;

    // 是否精华（必填）
    private String isEssence;

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

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getIsEssence() {
        return isEssence;
    }

    public void setIsEssence(String isEssence) {
        this.isEssence = isEssence;
    }
}
