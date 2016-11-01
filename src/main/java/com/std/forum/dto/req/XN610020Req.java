package com.std.forum.dto.req;

/** 
 * 版块新增
 * @author: xieyj 
 * @since: 2016年8月29日 下午2:38:43 
 * @history:
 */
public class XN610020Req {

    // 名称(必填)
    private String name;

    // 类别(必填)
    private String kind;

    // 图片(必填)
    private String pic;

    // 位置(必填)
    private String location;

    // 序号(必填)
    private String orderNo;

    // 版主编号(必填)
    private String userId;

    // 站点编号
    private String siteCode;

    // 状态(必填)
    private String status;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }
}
