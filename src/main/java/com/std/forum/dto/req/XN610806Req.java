package com.std.forum.dto.req;

public class XN610806Req {
    // 父编号(选填)
    private String parentCode;

    // 类型(1 板块，2商城)(选填)
    private String type;

    // 分类名称(选填)
    private String name;

    // 所属公司编号(必填)
    private String companyCode;

    private String orderColumn;// 分页字段

    private String orderDir;// 分页方向

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public void setOrderDir(String orderDir) {
        this.orderDir = orderDir;
    }

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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
