package com.std.forum.dto.req;

/**
 * 新增大板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午5:10:17 
 * @history:
 */
public class XN610010Req {
    // 名称
    private String name;

    // 次序
    private String orderNo;

    // 修改人
    private String updater;

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
