package com.std.forum.dto.req;

/**
 * 修改大板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午5:11:56 
 * @history:
 */
public class XN610012Req {
    // 编号
    private String code;

    // 名称
    private String name;

    // 次序
    private String orderNo;

    // 修改人
    private String updater;

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

}
