package com.std.forum.domain;

import com.std.forum.dao.base.ABaseDO;

//CHECK ��鲢��ע�� 
public class Product extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 类别
    private String kind;

    // 图片
    private String pic;

    // 描述
    private String description;

    // 状态(0 未发布 1上架中 2 已下架)
    private String status;

    // 价格
    private Integer price;

    // 站点编号
    private String siteCode;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }
}
