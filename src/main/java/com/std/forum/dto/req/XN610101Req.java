package com.std.forum.dto.req;

/**
 * 地方修改banner
 * @author: asus 
 * @since: 2017年3月21日 下午8:41:36 
 * @history:
 */
public class XN610101Req {
    // 编号
    private String code;

    // 名称
    private String name;

    // 访问Url
    private String url;

    // 图片
    private String pic;

    // UI位置
    private String location;

    // ui顺序
    private String orderNo;

    // 属于
    private String belong;

    // 站点编号
    private String companyCode;

    // 备注
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
