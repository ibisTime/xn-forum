/**
 * @Title PostTalk.java 
 * @Package com.std.forum.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年8月28日 下午8:26:17 
 * @version V1.0   
 */
package com.std.forum.domain;

import java.util.Date;

import com.std.forum.dao.base.ABaseDO;

/** 
 * 点赞/收藏/打赏
 * @author: xieyj 
 * @since: 2016年8月28日 下午8:26:17 
 * @history:
 */
public class PostTalk extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型(1 点赞 2 收藏 3 打赏 4 举报)
    private String type;

    // 帖子编号
    private String postCode;

    // 操作人
    private String talker;

    // 操作时间
    private Date talkDatetime;

    // 帖子信息
    private Post post;

    // 打赏的金额
    private int amount;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public Date getTalkDatetime() {
        return talkDatetime;
    }

    public void setTalkDatetime(Date talkDatetime) {
        this.talkDatetime = talkDatetime;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
