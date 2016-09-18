package com.std.forum.domain;

import com.std.forum.dao.base.ABaseDO;

/** 
 * 站点
 * @author: zuixian 
 * @since: 2016年9月13日 下午2:19:24 
 * @history: xieyj 2016年8月28日 下午8:12:39
 */
public class Site extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 站点名称
    private String name;

    // 经度区间
    private String longitude;

    // 纬度区间
    private String latitude;

    // 负责人编号
    private String userId;

    // 优先级( 0 不启用 1 正常 2 推荐）
    private String priority;

    // 是否默认
    private String isDefault;

    // 域名(预留)
    private String domain;

    // logo(预留)
    private String logo;

    // 地址(预留)
    private String address;

    // 电话(预留)
    private String telephone;

    // 简介(预留)
    private String description;

    // 邮箱(预留)
    private String email;

    // 二维码(预留)
    private String qrCode;

    // 备注
    private String remark;

    // ********** db properties ***********

    private String nameForQuery;

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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNameForQuery() {
        return nameForQuery;
    }

    public void setNameForQuery(String nameForQuery) {
        this.nameForQuery = nameForQuery;
    }
}
