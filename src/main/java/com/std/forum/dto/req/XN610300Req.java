package com.std.forum.dto.req;

public class XN610300Req {

    // 名称（必填）
    private String name;

    // 类别（必填）
    private String kind;

    // 图片（必填）
    private String pic;

    // 描述（必填）
    private String description;

    // 库存量（必填）
    private String quantity;

    // 站点编号（必填）
    private String siteCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
