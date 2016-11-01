package com.std.forum.dto.req;

/** 
 * 版块列表查询
 * @author: xieyj 
 * @since: 2016年8月29日 下午2:38:43 
 * @history:
 */
public class XN610031Req {
    // 名称(选填)
    private String name;

    // 大类(选填)
    private String kind;

    // 位置(选填)
    private String location;

    // 状态(选填)
    private String status;

    // 版主(选填)
    private String userId;

    // 站点编号(选填)
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }
}
