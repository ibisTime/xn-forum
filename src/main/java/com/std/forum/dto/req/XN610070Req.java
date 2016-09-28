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

    // 是否举报（选填）
    private String isReport;

    // 是否推荐 （选填）
    private String isHeadline;

    // 是否置顶（选填）
    private String isTop;

    // 是否精华（选填）
    private String isEssence;

    // 站点编号 （选填）
    private String plateCode;

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

    public String getIsReport() {
        return isReport;
    }

    public void setIsReport(String isReport) {
        this.isReport = isReport;
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
}
