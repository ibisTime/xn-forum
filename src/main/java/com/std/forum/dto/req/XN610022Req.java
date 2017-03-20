package com.std.forum.dto.req;

/**
 * 修改大板块
 * @author: asus 
 * @since: 2017年3月20日 下午5:48:41 
 * @history:
 */
public class XN610022Req {
    // 编号
    private String code;

    // 名称
    private String name;

    // 状态
    private String status;

    // 次序
    private String orderNo;

    // 修改人
    private String updater;

    // 站点编号
    private String companyCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
