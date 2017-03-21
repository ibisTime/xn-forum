package com.std.forum.dto.req;

/**
 * 总部修改菜单
 * @author: asus 
 * @since: 2017年3月21日 下午1:35:24 
 * @history:
 */
public class XN610080Req {
    // 编号
    private String code;

    // 名称
    private String name;

    // 图片
    private String pic;

    // 相对位置编号
    private String orderNo;

    // 属于
    private String belong;

    // 站点
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
