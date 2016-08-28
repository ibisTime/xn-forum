/**
 * @Title Comment.java 
 * @Package com.std.forum.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午8:27:47 
 * @version V1.0   
 */
package com.std.forum.domain;

import java.util.Date;

/** 
 * 评论
 * @author: xieyj 
 * @since: 2016年8月28日 下午8:27:47 
 * @history:
 */
public class Comment {
    // 编号
    private String code;

    // 内容
    private String content;

    // 上级编号
    private String parentCode;

    // 操作人
    private String updater;

    // 操作时间
    private Date updateDatetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}
