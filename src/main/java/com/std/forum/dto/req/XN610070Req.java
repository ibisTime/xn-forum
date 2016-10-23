package com.std.forum.dto.req;

/**
 *  分页查询帖子
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:45:05 
 * @history:
 */
public class XN610070Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 当前用户（选填）
    private String userId;

    // 标题（选填）
    private String title;

    // 发布人（选填）
    private String publisher;

    // 状态 （选填）
    private String status;

    // 是否锁帖 （选填）
    private String isLock;

    // 置顶 A/精华 B/ 头条 C（选填）
    private String location;

    // 板块编号 （选填）
    private String plateCode;

    // 站点编号（选填）
    private String siteCode;

    // 关键字搜索（选填）
    private String keyword;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
