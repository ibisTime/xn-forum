package com.std.forum.dto.req;

/**
 * 修改小板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午6:56:44 
 * @history:
 */
public class XN610032Req {
    // 编号
    private String code;

    // 名称
    private String name;

    // 大板块模板
    private String parentCode;

    // 图片
    private String pic;

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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
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

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
