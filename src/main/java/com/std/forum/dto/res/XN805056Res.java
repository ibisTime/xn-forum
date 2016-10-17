package com.std.forum.dto.res;

public class XN805056Res {
    // userId
    private String userId;

    // 登陆名称
    private String loginName;

    // 昵称
    private String nickname;

    // 用户等级
    private String level;

    // 手机号
    private String mobile;

    // 状态
    private String status;

    // 现有金额
    private String amount;

    // 累计金额
    private String ljAmount;

    // 公司编号
    private String companyCode;

    // 帖子数
    private Long totalPostNum;

    // 关注数
    private String totalFollowNum;

    // 粉丝数
    private String totalFansNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getLjAmount() {
        return ljAmount;
    }

    public void setLjAmount(String ljAmount) {
        this.ljAmount = ljAmount;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Long getTotalPostNum() {
        return totalPostNum;
    }

    public void setTotalPostNum(Long totalPostNum) {
        this.totalPostNum = totalPostNum;
    }

    public String getTotalFollowNum() {
        return totalFollowNum;
    }

    public void setTotalFollowNum(String totalFollowNum) {
        this.totalFollowNum = totalFollowNum;
    }

    public String getTotalFansNum() {
        return totalFansNum;
    }

    public void setTotalFansNum(String totalFansNum) {
        this.totalFansNum = totalFansNum;
    }
}
