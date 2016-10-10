package com.std.forum.dto.req;

/** 
 * 分页查询导航
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:39:04 
 * @history:
 */
public class XN610030Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 名称
    private String name;

    // 状态(1 显示 0 不显示)
    private String status;

    // 类型(1 菜单 2 banner 3 模块 4 引流)
    private String type;

    // 是否全局(1 是 0 否)
    private String isGlobal;

    // 父编号
    private String parentCode;

    // 站点编号
    private String siteCode;

    // 是否查询地区导航
    private String isDqNavigate;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(String isGlobal) {
        this.isGlobal = isGlobal;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getIsDqNavigate() {
        return isDqNavigate;
    }

    public void setIsDqNavigate(String isDqNavigate) {
        this.isDqNavigate = isDqNavigate;
    }
}
