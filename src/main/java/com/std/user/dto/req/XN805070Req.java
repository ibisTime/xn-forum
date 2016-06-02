package com.std.user.dto.req;

public class XN805070Req {

    // 手机号（必填）
    private String mobile;

    // 真实姓名（必填）
    private String realName;

    // 推荐人（非必填）
    private String userReferee;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    // 六方(必填)
    private String kind;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
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
}
