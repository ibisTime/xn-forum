package com.std.forum.dto.req;

public class XN610320Req {

    // 用户编号（必填）
    private String userId;

    // 商品编号（必填）
    private String productCode;

    // 数量（必填）
    private String quantity;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
