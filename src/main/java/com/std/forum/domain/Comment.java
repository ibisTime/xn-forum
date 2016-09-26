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

import com.std.forum.dao.base.ABaseDO;

/** 
 * 评论
 * @author: xieyj 
 * @since: 2016年8月28日 下午8:27:47 
 * @history:
 */
public class Comment extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 内容
    private String content;

    // 上级编号
    private String parentCode;

    // 操作人
    private String commer;

    // 操作时间
    private Date commDatetime;

    // ****************db properties ***************
    private String parentCommer;

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

    public String getCommer() {
        return commer;
    }

    public void setCommer(String commer) {
        this.commer = commer;
    }

    public Date getCommDatetime() {
        return commDatetime;
    }

    public void setCommDatetime(Date commDatetime) {
        this.commDatetime = commDatetime;
    }

    public String getParentCommer() {
        return parentCommer;
    }

    public void setParentCommer(String parentCommer) {
        this.parentCommer = parentCommer;
    }
}
