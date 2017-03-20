package com.std.forum.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:29 
 * @history:
 */
public class XN809010Req {

    // key值（必填）
    private String ckey;

    // 值（必填）
    private String cvalue;

    // 配置说明（必填）
    private String note;

    // 更新人（必填）
    private String updater;

    // 备注（选填）
    private String remark;

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public String getCvalue() {
        return cvalue;
    }

    public void setCvalue(String cvalue) {
        this.cvalue = cvalue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
