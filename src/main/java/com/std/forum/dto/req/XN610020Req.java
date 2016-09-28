package com.std.forum.dto.req;

/** 
 * 新增导航，根据userId来设置改导航的站点编号
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:37:25 
 * @history:
 */
public class XN610020Req {

    // 访问Url
    private String url;

    // 图片
    private String pic;

    // 标题
    private String title;

    // 状态(1 显示 0 不显示)
    private String status;

    // 类型(1 菜单 2 banner 3 模块 4 引流)
    private String type;

    // 是否全局(1 是 0 否)
    private String isGlobal;

    // 相对位置编号
    private String orderNo;

    // 父编号
    private String parentCode;

    // 站点编号
    private String userId;

    // 备注
    private String remark;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(String isGlobal) {
        this.isGlobal = isGlobal;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
