package com.std.forum.dto.req;

/**
 * 地方修改子系统配置
 * @author: asus 
 * @since: 2017年3月21日 下午5:56:01 
 * @history:
 */
public class XN610091Req {
    // 编号（必填）
    private String code;

    // 名称（必填）
    private String name;

    // 访问Url（必填）
    private String url;

    // 图片（必填）
    private String pic;

    // UI位置（必填）
    private String location;

    // ui顺序（必填）
    private String orderNo;

    // 属于（必填）
    private String belong;

    // 站点（选填）
    private String companyCode;

    // 备注（选填）
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
