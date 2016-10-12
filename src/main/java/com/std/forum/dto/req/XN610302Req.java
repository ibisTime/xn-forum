package com.std.forum.dto.req;

public class XN610302Req {

    // 编号（必填）
    private String code;

    // 名称（必填）
    private String name;

    // 类别（必填）
    private String kind;

    // 图片（必填）
    private String pic;

    // 描述（必填）
    private String description;

    // 状态(0 未发布 1上架中 2 已下架)（必填）
    private String status;

    // 价格（必填）
    private String price;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
