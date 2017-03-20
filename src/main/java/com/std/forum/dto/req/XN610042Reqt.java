package com.std.forum.dto.req;

/** 
 *  浏览帖子，对帖子内容或其上级评论进行评论
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:43:45 
 * @history:
 */
public class XN610042Reqt {

    // 内容（必填）
    private String content;

    // 父级菜单 （必填）
    private String parentCode;

    // 操作人（必填）
    private String commer;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCommer() {
        return commer;
    }

    public void setCommer(String commer) {
        this.commer = commer;
    }
}
