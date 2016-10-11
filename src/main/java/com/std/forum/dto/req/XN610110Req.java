package com.std.forum.dto.req;

/**
 * 修改规则
 * @author: xieyj 
 * @since: 2016年10月11日 上午9:32:59 
 * @history:
 */
public class XN610110Req {

    // 关键词编号 （必填）
    private String code;

    // 大类(必填)
    private String kind;

    // 产生项(必填)
    private String type;

    // 作用等级(必填)
    private String level;

    // 值
    private String value;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
