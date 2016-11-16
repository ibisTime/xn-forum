package com.std.forum.dto.req;

public class XN610800Req {
    // 父编号(必填)
    private String parentCode;

    // 类型(1 板块，2商城)(必填)
    private String type;

    // 分类名称(必填)
    private String name;

    // 分类图片(必填)
    private String pic;

    // 顺序(选填)
    private String orderNo;

    // 所属公司编号(必填)
    private String companyCode;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
