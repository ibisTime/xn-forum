package com.std.forum.dto.req;

/** 
 * 站点列表查询
 * @author: xieyj 
 * @since: 2016年8月29日 下午2:38:43 
 * @history:
 */
public class XN610011Req {

    // 编号(选填)
    private String code;

    // 名称(选填)
    private String name;

    // 负责人(选填)
    private String userId;

    // 优先级(选填)
    private String priority;

    // 是否默认(选填)
    private String isDefault;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
